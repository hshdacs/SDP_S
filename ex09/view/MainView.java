package ex09.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainView extends JFrame implements MainViewInterface{

    public MainView() {
        setTitle("Main");
        setSize(400, 200);
        pack();
        setVisible(true);
    }
}
