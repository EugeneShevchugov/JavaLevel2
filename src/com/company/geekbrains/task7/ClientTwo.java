package com.company.geekbrains.task7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientTwo extends JFrame {
    private JTextField msgInputField;
    private JTextArea chatArea;
    private JPanel bottomPanel = new JPanel(new BorderLayout());
    private JButton btnSendMsg = new JButton("Отправить");
    private volatile boolean flag = false;

    public ClientTwo() throws IOException {
        Socket socket = new Socket("localhost", Server.PORT);
        System.out.println("Connected to server: " + socket);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        prepareGUI();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        while (true) {
                            if (flag) {
                                String msg = getText(msgInputField);
                                out.writeUTF(msg);
                                flag = false;
                                break;
                            }
                        }
                        String message = in.readUTF();
                        if (message.startsWith("/authok")) {
                            chatArea.append("Authorized");
                            chatArea.append("\n");
                            break;
                        }
                    }

                    while (true) {
                        String message = in.readUTF();
                        if (message.equals("/end")) {
                            chatArea.append("Session closed. Cau!");
                            chatArea.append("\n");
                            break;
                        }
                        while (true) {
                            if (flag) {
                                String msg = getText(msgInputField);
                                out.writeUTF(msg);
                                flag = false;
                                break;
                            }
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
        thread.start();
    }

    private String getText(JTextField msgInputField) {
        String text = msgInputField.getText();
        msgInputField.setText("");
        msgInputField.grabFocus();
        return text;
    }

    private void prepareGUI() {
        setBounds(600, 300, 500, 500);
        setTitle("Клиент");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);
        add(new JScrollPane(chatArea), BorderLayout.CENTER);
        bottomPanel.add(btnSendMsg, BorderLayout.EAST);
        msgInputField = new JTextField();
        add(bottomPanel, BorderLayout.SOUTH);
        bottomPanel.add(msgInputField, BorderLayout.CENTER);
        btnSendMsg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flag = true;
            }
        });
        setVisible(true);
    }

    public static void main(String[] args) throws IOException {
        new ClientTwo();
    }
}
