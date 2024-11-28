package ex08;

import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.*;

public class MyFirstWindow extends JFrame {

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

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottomPanel.add( new JButton("Click me") );

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

        setVisible(true);
    }

    private void buttonExitOnClick(ActionEvent e) {
        System.err.println("Closing App with functional interface");
        dispose();
    }

    public static void main(String[] args) {
        new MyFirstWindow();
    }

}
