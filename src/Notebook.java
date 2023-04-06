import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Console;
import java.util.TreeSet;

import javax.swing.*;

public class Notebook extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField nameField;
    private JTextField phoneField;
    private JLabel countLabel;
    private TreeSet<String> entries;

    public Notebook() {
        super("Notebook");

        entries = new TreeSet<>();

        //створюємо верхню панель з трьома рядками
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(3, 1));

        //створюємо мітки
        JLabel nameLabel = new JLabel("Name:");
        JLabel phoneLabel = new JLabel("Phone:");
        countLabel = new JLabel("Entries: 0");

        //створюємо текстові поля
        nameField = new JTextField(20);
        phoneField = new JTextField(20);

        //створюємо кнопку "Add"
        JButton addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String phone = phoneField.getText();
                if (!name.isEmpty() && !phone.isEmpty()) {
                    entries.add(name + ": " + phone);
                    countLabel.setText("Entries: " + entries.size());
                    nameField.setText("");
                    phoneField.setText("");
                }
            }
        });

        //додаємо мітки та поля в верхню панель
        topPanel.add(nameLabel);
        topPanel.add(nameField);
        topPanel.add(phoneLabel);
        topPanel.add(phoneField);
        topPanel.add(addButton);
        topPanel.add(countLabel);

        //створюємо кнопку "Print"
        JButton printButton = new JButton("Print");
        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (String entry : entries) {

                    System.out.println(entry);
                }
            }
        });

        //створюємо нижню панель з кнопкою "Print"
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(printButton);

        //додаємо верхню та нижню панелі в вікно
        add(topPanel, BorderLayout.NORTH);
        add(bottomPanel, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Notebook();
    }

}