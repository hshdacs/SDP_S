package ex09.control;

import ex09.dao.AccountDAO;
import ex09.dao.AccountDBinMemory;
import ex09.view.MainViewInterface;
import ex09.view.MainView;

public class MainController {
    private AccountDAO accountDB;
    private MainViewInterface mainView;

    public MainController(AccountDAO accountDB,
        MainViewInterface mainView) {
            this.accountDB = accountDB;
            this.mainView = mainView;
    }

    public static void main(String[] args) {
        new MainController(
            new AccountDBinMemory(),
            new MainView()
        );
    }
}
