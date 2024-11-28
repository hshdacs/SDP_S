package ex08;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.*;

public class MyFirstWindow extends JFrame {

    private JTextField someTextField = new JTextField();
    private JCheckBox someQuestionCheckBox = new JCheckBox();

    public class ExitButtonClass implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.err.println("Closing App with Designated Class");
            dispose();
        }
        
    }

    public MyFirstWindow() {
        setTitle("First Window");
        setSize(400, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        setLayout( new BorderLayout() );

        add(new JLabel("Hello World"), BorderLayout.NORTH );

        JPanel centerPanel = new JPanel(new GridLayout(2, 2));
        centerPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        add( centerPanel, BorderLayout.CENTER );

        // first element to be placed at row 0, col 0
        centerPanel.add( new JLabel("Some Text") );
        centerPanel.add( someTextField );
        centerPanel.add( new JLabel("Some Question") );
        centerPanel.add( someQuestionCheckBox );

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton clickMeButton = new JButton("Click me");
        bottomPanel.add( clickMeButton );
        clickMeButton.addActionListener(this::clickMeButtonOnClick);

        JButton exitButton = new JButton("Exit");
        bottomPanel.add( exitButton );

        // Method 1 (Classical way: Instantiate an anonymous class)
        // exitButton.addActionListener(new ActionListener() {

        //     @Override
        //     public void actionPerformed(ActionEvent e) {
        //         System.err.println("Closing App with Anonymous Class");
        //         dispose();
        //     }
            
        // });

        // Method 2 (Using an designated class)
        // exitButton.addActionListener(new ExitButtonClass());

        // Method 3 (Using lambdas)
        // exitButton.addActionListener( e -> {
        //     System.err.println("Closing App with Lambda");
        //     dispose();
        // });

        // Method 4 (Using reference of functional interface)
        exitButton.addActionListener( this::buttonExitOnClick );

        add(bottomPanel, BorderLayout.SOUTH);
        //add( new JButton("Click me"), BorderLayout.SOUTH );

        pack();
        setVisible(true);
    }

    private void clickMeButtonOnClick(ActionEvent e) {
        String someText = someTextField.getText();
        boolean someQuestion = someQuestionCheckBox.isSelected();

        JOptionPane.showMessageDialog(this, someText, "Let me tell you",
            someQuestion ? JOptionPane.WARNING_MESSAGE : JOptionPane.INFORMATION_MESSAGE
            );
    }

    private void buttonExitOnClick(ActionEvent e) {
        System.err.println("Closing App with functional interface");
        dispose();
    }

    public static void main(String[] args) {
        new MyFirstWindow();
    }

}
