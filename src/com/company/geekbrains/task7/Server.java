package com.company.geekbrains.task7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class Server extends JFrame {
    private JTextArea chatArea;
    private JPanel bottomPanel = new JPanel(new BorderLayout());
    private JButton btnSendMsg = new JButton("Отправить");
    private JTextField msgInputField;
    public static final int PORT = 8082;
    private AuthService authService;
    private Set<ClientHandler> clientHandlers;

    public Server() {
        this(PORT);
    }

    public Server(int port) {
        prepareGUI();
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            authService = new BasicAuthService();
            System.out.println("Auth is started up");

            clientHandlers = new HashSet<>();

            while (true) {
                Socket socket = serverSocket.accept();
//                System.out.println("Client connected: " + socket);
                setTextToChatArea("Client connected: " + socket);
                new ClientHandler(this, socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public AuthService getAuthService() {
        return authService;
    }

    public synchronized boolean isOccupied(AuthService.Record record) {
        for (ClientHandler ch : clientHandlers) {
            if (ch.getRecord().equals(record)) {
                return true;
            }
        }
        return false;
    }

    public synchronized void subscribe(ClientHandler ch) {
        clientHandlers.add(ch);
    }

    public synchronized void unsubscribe(ClientHandler ch) {
        clientHandlers.remove(ch);
    }

    public synchronized void broadcastMessage(String message) {
        for (ClientHandler ch : clientHandlers) {
            ch.sendMessage(message);
        }
    }

    public synchronized void setTextToChatArea(String message) {
        chatArea.append(message);
        chatArea.append("\n");
    }

    private void prepareGUI() {
        setBounds(600, 300, 500, 500);
        setTitle("Сервер");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);
        add(new JScrollPane(chatArea), BorderLayout.CENTER);
        bottomPanel.add(btnSendMsg, BorderLayout.EAST);
        msgInputField = new JTextField();
        add(bottomPanel, BorderLayout.SOUTH);
        bottomPanel.add(msgInputField, BorderLayout.CENTER);
        setVisible(true);
    }
}
