package ex09.dao;

import java.util.List;
import ex09.model.Account;

// this is the Account Data Access Object
public interface AccountDAO {

    // create aka insert
    public boolean insertAccount(Account account);

    // read
    public Account getAccountByID(int accountNumber);
    public Account getAccountByName(String accountOwner);

    public List<Account> getAllAccounts();

    // update
    public boolean changeAccount(int accountNumber, Account account);
    
    // delete
    public boolean removeAccount(int accountNumber);
}
