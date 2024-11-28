package ex09.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ex09.model.Account;

public class AccountDBbySQL implements AccountDAO {

    private static final String SQL_DRIVER = "org.mariadb.jdbc.Driver";
    private static final String SQL_SERVER = "127.0.0.1";
    private static final String SQL_SERVER_PORT = "3306";
    private static final String SQL_DATABASE = "dbaccount";
    private static final String SQL_USERNAME = "dbaccount";
    private static final String SQL_PASSWORD = "secret123";

    private Connection sqlConnection = null;

    public AccountDBbySQL() {
        // ensure, the SQL connector is loaded proberly
        try {
            Class.forName(SQL_DRIVER);
        }
        catch (ClassNotFoundException e) {
            System.err.println("Oops, SQL connector not installed!");
            System.exit(-1);
        }
        openSQLConnection();
    }

    private void openSQLConnection() {    
        try {
            sqlConnection = DriverManager.getConnection("jdbc:mariadb://" +
                                    SQL_SERVER + ":" + SQL_SERVER_PORT + "/" +
                                    SQL_DATABASE, SQL_USERNAME, SQL_PASSWORD);
            //sqlConnection.setAutoCommit(false);
        } catch (SQLException e) {
            System.err.println("Got some problem when establishing SQL connection");
            e.printStackTrace();
            System.exit(-2);
        }
    }

    @Override
    public boolean insertAccount(Account account) {
        // INSERT INTO account (number, owner, balance) VALUES (?, ?, ?);
        try {
            PreparedStatement sqlQuery = sqlConnection.prepareStatement(
                "INSERT INTO account (number, owner, balance) VALUES (?, ?, ?)"
            );
            sqlQuery.setInt(1, account.getNumber() );
            sqlQuery.setString(2, account.getOwner() );
            sqlQuery.setDouble(3, account.getBalance() );
            return sqlQuery.executeUpdate()==1;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Account getAccountByID(int accountNumber) {
        try {
            PreparedStatement sqlQuery = sqlConnection.prepareStatement(
                "SELECT number,owner,balance FROM account WHERE number=?"
            );
            sqlQuery.setInt(1, accountNumber);
            ResultSet sqlTable = sqlQuery.executeQuery();
            if ( ! sqlTable.next() ) return null;

            int number = sqlTable.getInt("number");
            String owner = sqlTable.getString("owner");
            double balance = sqlTable.getDouble("balance");
            return new Account(number, owner, balance);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Account getAccountByName(String accountOwner) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAccountByName'");
    }

    @Override
    public List<Account> getAllAccounts() {
        // SELECT number,owner,balance FROM account;
        List<Account> accountList = new ArrayList<>();
        try {
            Statement sqlQuery = sqlConnection.createStatement();
            ResultSet sqlTable = 
                sqlQuery.executeQuery("SELECT number,owner,balance FROM account");
            while ( sqlTable.next() ) {
                int number = sqlTable.getInt("number");
                String owner = sqlTable.getString("owner");
                double balance = sqlTable.getDouble("balance");
                accountList.add(new Account(number, owner, balance));
            }
        }
        catch (SQLException e) {
            // maybe some method later to report all errors...
            e.printStackTrace();
        }
        return accountList;
    }

    @Override
    public boolean changeAccount(int accountNumber, Account account) {
        removeAccount(accountNumber);
        return insertAccount(account);
    }

    @Override
    public boolean removeAccount(int accountNumber) {
        // DELETE FROM account WHERE number = ?
        try {
            PreparedStatement sqlQuery = sqlConnection.prepareStatement(
                "DELETE FROM account WHERE number = ?"
            );
            sqlQuery.setInt(1, accountNumber);
            return sqlQuery.executeUpdate() == 1;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
