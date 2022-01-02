package main.java.view;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MainForm extends JFrame {
    private JPanel batatinha123;
    private JButton novoContato;
    private JButton removerContato;
    private JTable contatos;
    private JLabel lblContaContatos;
    private main.java.controller.contato mContatosController;


    private String mNome = "";
    private String mTelefone = "";


    public MainForm() {

        setContentPane(batatinha123);
        setSize(500, 250);
        setVisible(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - getSize().width / 2, dim.height / 2 - getSize().height / 2);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        mContatosController = new main.java.controller.contato();

        setListeners();

        listandoContato();

    }

    private void listandoContato() {
        List<main.java.entity.contato> listaContato = mContatosController.listaContatos();
        String[] columNames = {"Nome", "Telefone"};

        DefaultTableModel model = new DefaultTableModel(new Object[0][0], columNames);
        for (main.java.entity.contato i : listaContato) {
            Object[] obj = new Object[2];
            obj[0] = i.getNome();
            obj[1] = i.getTelefone();

            model.addRow(obj);
        }
        contatos.clearSelection();
        contatos.setModel(model);
        lblContaContatos.setText(mContatosController.getContador());

    }

    private void setListeners() {
        novoContato.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new contatoForm();
                dispose();
            }
        });

        contatos.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                    if(contatos.getSelectedRow() != -1){
                        mNome = contatos.getValueAt(contatos.getSelectedRow(), 0).toString();
                        mTelefone = contatos.getValueAt(contatos.getSelectedRow(), 1).toString();
                    }

                }
            }
        });
        removerContato.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    mContatosController.deletarContato(mNome,mTelefone);
                    listandoContato();

                    mNome = "";
                    mTelefone = "";
                }catch (Exception exc){
                    JOptionPane.showMessageDialog(new JFrame(), exc.getMessage());
                }

            }
        });
    }

}
