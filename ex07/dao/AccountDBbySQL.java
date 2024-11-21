package ex07.dao;

import java.util.List;

import ex07.model.Account;

public class AccountDBbySQL implements AccountDAO {

    public AccountDBbySQL() {
        // ensure, the SQL connector is loaded proberly
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            System.err.println("Oops, SQL connector not installed!");
            System.exit(-1);
        }
        // continue ...
    }

    @Override
    public boolean insertAccount(Account account) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertAccount'");
    }

    @Override
    public Account getAccountByID(int accountNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAccountByID'");
    }

    @Override
    public Account getAccountByName(String accountOwner) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAccountByName'");
    }

    @Override
    public List<Account> getAllAccounts() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllAccounts'");
    }

    @Override
    public boolean changeAccount(int accountNumber, Account account) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'changeAccount'");
    }

    @Override
    public boolean removeAccount(int accountNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeAccount'");
    }

}
