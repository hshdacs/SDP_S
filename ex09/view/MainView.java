package ex09.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

public class MainView extends JFrame implements MainViewInterface{

    private JTextField accountNumberText = new JTextField();
    private JTextField accountOwnerText = new JTextField();
    private JTextField accountBalanceText = new JTextField();
    private JTextField amountInputText = new JTextField();

    private JButton readButton = new JButton("Read");
    private JButton writeButton = new JButton("Write");
    private JButton depositButton = new JButton("Deposit");
    private JButton withdrawButton = new JButton("Withdraw");
    private JButton deleteButton = new JButton("Delete");
    private JButton listButton = new JButton("List All");
    private JButton okButton = new JButton("Okay");

    public MainView() {
        setTitle("Main");
        setSize(400, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        JPanel topPanel = new JPanel(new FlowLayout());
        JPanel outerPanel = new JPanel();
        outerPanel.setBorder(new EmptyBorder(5,5,5,5));
        JPanel centerPanel = new JPanel( new GridLayout(3, 2) );
        outerPanel.add(centerPanel);
        JPanel bottomPanel = new JPanel( new GridLayout(3, 2) );
        addCenterComponent(centerPanel);
        addButtons(bottomPanel);
        add(topPanel, BorderLayout.NORTH);
        add(outerPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
        pack();
        setVisible(true);
    }

    private void addButtons(JPanel bottomPanel) {
        bottomPanel.setBorder(new EmptyBorder(10,10,10,10));
        bottomPanel.add(readButton);
        bottomPanel.add(writeButton);
        bottomPanel.add(depositButton);
        bottomPanel.add(withdrawButton);
        JPanel selectioPanel = new JPanel();
        selectioPanel.add(deleteButton);
        amountInputText.setColumns(6);
        selectioPanel.add(amountInputText);
        bottomPanel.add(selectioPanel);
        JPanel buttonSelectionPanel = new JPanel();
        buttonSelectionPanel.add(listButton);
        buttonSelectionPanel.add(okButton);
        bottomPanel.add(buttonSelectionPanel);
        toggleAmountInput(false);
        toggleButtonEnabled(false);
    }

    public void toggleAmountInput(boolean selector) {
        deleteButton.setVisible(!selector);
        listButton.setVisible(!selector);
        amountInputText.setVisible(selector);
        okButton.setVisible(selector);
    }

    private void addCenterComponent(JPanel centerPanel) {
        centerPanel.setBorder(new EtchedBorder(EtchedBorder.RAISED));
        
        centerPanel.add(new JLabel("Account Number "));
        centerPanel.add(accountNumberText);

        centerPanel.add(new JLabel("Account Owner "));
        centerPanel.add(accountOwnerText);

        centerPanel.add(new JLabel("Account Balance "));
        accountBalanceText.setEditable(false);
        centerPanel.add(accountBalanceText);        
    }

    @Override
    public void setReadButtonListener(ActionListener listener) {
        readButton.addActionListener(listener);
    }

    @Override
    public int getAccountNumber() {
        String number = accountNumberText.getText();
        try {
            return Integer.parseInt(number);
        }
        catch (NumberFormatException e) {
            showMessage("Please enter a correct account number");
        }
        return 0;
    }
 
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Error Report",
            JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void setAccountNumber(int accountNumber) {
        accountNumberText.setText( Integer.toString(accountNumber) );
    }

    @Override
    public void setAccountOwner(String accountOwner) {
        accountOwnerText.setText(accountOwner);
    }

    @Override
    public void setAccountBalance(double accountBalance) {
        DecimalFormat df = new DecimalFormat("#,##0.00 Euro");
        accountBalanceText.setText(df.format(accountBalance));
    }

    @Override
    public void clearAccountInfo() {
        accountOwnerText.setText("");
        accountBalanceText.setText("");
    }

    @Override
    public void toggleButtonEnabled(boolean enabled) {
        writeButton.setEnabled(enabled);
        depositButton.setEnabled(enabled);
        withdrawButton.setEnabled(enabled);
        deleteButton.setEnabled(enabled);
    }

    @Override
    public void setWithdrawButtonListener(ActionListener listener) {
        withdrawButton.addActionListener(listener);
    }

    @Override
    public void setDepositButtonListener(ActionListener listener) {
        depositButton.addActionListener(listener);
    }

    @Override
    public void setOkayButtonListener(ActionListener listener) {
        okButton.addActionListener(listener);
    }

    @Override
    public double getAmount() {
        String amountText = amountInputText.getText();
        try {
            return Double.parseDouble(amountText);
        }
        catch (Exception NumberFormatException) {
            showMessage("Please enter a correct amount");
        }
        return 0.0;
    }

    @Override
    public void setListAllButtonListener(ActionListener listener) {
        listButton.addActionListener(listener);
    }
}
