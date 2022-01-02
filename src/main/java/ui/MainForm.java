package ui;

import javax.swing.*;
import javax.swing.text.View;

public class MainForm extends JFrame {
    private JPanel batatinha123;
    private JButton novoContato;
    private JButton removerContato;
    private JTable contatos;

    public  MainForm(){
        JFrame frame =  new JFrame();
        frame.setContentPane(batatinha123);
        setSize(500,250);
        setVisible(true);
    }

}
