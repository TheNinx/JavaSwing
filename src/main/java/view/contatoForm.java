package main.java.view;

import main.java.controller.contato;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class contatoForm extends JFrame {


    private JPanel batatinha123;
    private JTextField textFieldNome;
    private JButton buttonSave;
    private JButton buttonCancel;
    private JTextField textFieldTelefone;
    private main.java.controller.contato mcontatoController;

    public contatoForm() {

        setContentPane(batatinha123);
        setSize(500, 250);
        setVisible(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - getSize().width / 2, dim.height / 2 - getSize().height / 2);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mcontatoController = new contato();
        setListeners();
    }

    private void setListeners() {
        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                try {
                    String nome = textFieldNome.getText();
                    String telefone = textFieldTelefone.getText();
                    mcontatoController.salvarContato(nome, telefone);

                    new MainForm();
                    dispose();
                }catch (Exception exc){
                    JOptionPane.showMessageDialog(new JFrame(), exc.getMessage());
                }

            }
        });
        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainForm();
                dispose();
            }
        });
    }


}
