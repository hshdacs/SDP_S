package ex09.view;

import java.awt.event.ActionListener;

public interface MainViewInterface {

    void showMessage(String message);
    void setReadButtonListener(ActionListener listener);
    void setWithdrawButtonListener(ActionListener listener);
    void setDepositButtonListener(ActionListener listener);
    void setOkayButtonListener(ActionListener listener);
    void setListAllButtonListener(ActionListener listener);

    void toggleButtonEnabled(boolean enabled);
    void toggleAmountInput(boolean selector);
    void setEnabled(boolean enabled);
    void requestFocus();

    int getAccountNumber();
    double getAmount();

    void setAccountNumber(int accountNumber);
    void setAccountOwner(String accountOwner);
    void setAccountBalance(double accountBalance);

    void clearAccountInfo();
}
