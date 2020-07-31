package com.company.geekbrains.task4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Chat extends JFrame {
    public Chat(String title) {
        setTitle(title);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(0,0, 450, 700);
        JPanel chatPanel = new JPanel(new BorderLayout());
        JTextArea chatTextArea = new JTextArea();
        chatTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatTextArea);
        chatPanel.add(scrollPane);

        add(chatPanel);

        JPanel controlPanel = new JPanel(new BorderLayout());

        JTextField inputField = new JTextField();
        inputField.addActionListener(new ActionListener() {
            private StringBuilder sb = new StringBuilder(chatTextArea.getText());

            @Override
            public void actionPerformed(ActionEvent e) {
                if (inputField.getText().isBlank()) {
                    return;
                }

                sb.append("\n")
                        .append(inputField.getText());
                chatTextArea.setText(chatTextArea.getText() + sb.toString());
                inputField.setText("");
                sb.setLength(0);
            }
        });
        controlPanel.add(inputField);

        JButton submitBtn = new JButton("Submit");
        submitBtn.addActionListener(new EnterButtonListener(inputField, chatTextArea));
        controlPanel.add(submitBtn, BorderLayout.EAST);

        add(controlPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}
