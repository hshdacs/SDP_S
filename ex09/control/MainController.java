package ex09.control;

import java.awt.Dialog.ModalExclusionType;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.DefaultListModel;

import ex09.dao.AccountDAO;
import ex09.dao.AccountDBbySQL;
import ex09.dao.AccountDBinMemory;
import ex09.model.Account;
import ex09.view.MainViewInterface;
import ex09.view.ListAllView;
import ex09.view.MainView;

public class MainController {
    private AccountDAO accountDB;
    private MainViewInterface mainView;
    private boolean isWithdrawActive;

    public MainController(AccountDAO accountDB, MainViewInterface mainView) {
        this.accountDB = accountDB;
        this.mainView = mainView;

        mainView.setReadButtonListener(this::readButtonOnClick);
        mainView.setWithdrawButtonListener(this::withdrawButtonOnClick);
        mainView.setDepositButtonListener(this::depositButtonOnClick);
        mainView.setOkayButtonListener(this::okayButtonOnClick);
        mainView.setListAllButtonListener(this::listAllButtonOnClick);
    }

    private void listAllButtonOnClick(ActionEvent e) {
        ListAllView listAllView = new ListAllView();
        DefaultListModel<String> defaultListModel = new DefaultListModel<>();
        for (Account account : accountDB.getAllAccounts()) {
            defaultListModel.addElement( account.toString() );
        }
        listAllView.setAllAccountListDefaultModel(defaultListModel);
        mainView.setEnabled(false);

        listAllView.addWindowListener(new WindowListener() {

            @Override
            public void windowOpened(WindowEvent e) { }

            @Override
            public void windowClosing(WindowEvent e) { }

            @Override
            public void windowClosed(WindowEvent e) {
                mainView.setEnabled(true);
                mainView.requestFocus();
            }

            @Override
            public void windowIconified(WindowEvent e) { }

            @Override
            public void windowDeiconified(WindowEvent e) { }

            @Override
            public void windowActivated(WindowEvent e) { }

            @Override
            public void windowDeactivated(WindowEvent e) { }
        });
    }

    private void okayButtonOnClick(ActionEvent e) {
        Account account = accountDB.getAccountByID( mainView.getAccountNumber() );
        if (account != null) {
            double amount = mainView.getAmount();
            if (isWithdrawActive) {
                account.withdraw(amount);
            }
            else {
                account.deposit(amount);
            }
            accountDB.changeAccount(account.getNumber(), account);
            mainView.setAccountBalance(account.getBalance());
        }
        mainView.toggleAmountInput(false);
    }

    private void withdrawButtonOnClick(ActionEvent e) {
        isWithdrawActive = true;
        mainView.toggleAmountInput(true);
    }

    private void depositButtonOnClick(ActionEvent e) {
        isWithdrawActive = false;
        mainView.toggleAmountInput(true);
    }

    private void readButtonOnClick(ActionEvent e) {
        int accountNumber = mainView.getAccountNumber();
        Account account = accountDB.getAccountByID(accountNumber);
        if (account != null) {
            mainView.setAccountNumber(account.getNumber());
            mainView.setAccountOwner(account.getOwner());
            mainView.setAccountBalance(account.getBalance());
            mainView.toggleButtonEnabled(true);
        }
        else {
            mainView.clearAccountInfo();
            mainView.toggleButtonEnabled(false);
        }
    }

    public static void main(String[] args) {
        new MainController(
//            new AccountDBinMemory(),
            new AccountDBbySQL(),
            new MainView()
        );
    }
}
