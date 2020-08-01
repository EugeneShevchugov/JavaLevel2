package com.company.geekbrains.task4;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnterButtonListener implements ActionListener {
    private final StringBuilder stringBuilder = new StringBuilder();
    private final JTextField jTextField;
    private final JTextArea jTextArea;

    public EnterButtonListener(JTextField jTextField, JTextArea jTextArea) {
        this.jTextField = jTextField;
        this.jTextArea = jTextArea;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (jTextField.getText().isBlank()) {
            return;
        }
        stringBuilder
                .append(jTextArea.getText())
                .append("\n")
                .append(jTextField.getText());
        jTextArea.setText(stringBuilder.toString());
        jTextField.setText("");
        stringBuilder.setLength(0);
    }
}
