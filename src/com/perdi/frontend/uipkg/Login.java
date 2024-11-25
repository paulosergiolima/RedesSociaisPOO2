package com.perdi.frontend.uipkg;

import com.perdi.backend.userpkg.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.Arrays;

public class Login {
    private JPanel LoginPanel;
    private JPanel UserInfo;
    private JPanel UserShow;
    private JLabel EmailLabel;
    private JTextField EmailTextField;
    private JLabel PasswordLabel;
    private JPasswordField PasswordField;
    private JButton RegisterButton;
    private JButton LoginButton;
    private JPanel PhotoPanel;
    private JLabel WelcomeLabel;
    private JTextField UserNameField;
    private JLabel UserNameLabel;
    private JPanel WarningPanel;
    private JTextField WarningField;

    public Login() {
        LoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Pesquisar o Usuário com o email e senha, e fazer animaçãozinha de login
                UserShow.setVisible(true);
                // Se não existir, abrir tela de registro
            }
        });
        RegisterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!EmailTextField.isVisible()) {
                    EmailLabel.setVisible(true);
                    EmailTextField.setVisible(true);
                }
                String email = EmailTextField.getText();
                String userName = UserNameField.getText();
                String password = Arrays.toString(PasswordField.getPassword());

                if (email.contains("@") && !userName.isEmpty() && !password.isEmpty()) {
                    User newUser = new User(userName, userName, email, null, null, false);
                } else {
                    if (!email.contains("@")) {
                        WarningField.setText("Invalid email");
                        WarningField.setVisible(true);
                    }
                    if (userName.isEmpty()) {
                        System.out.println(true);
                        WarningField.setText("Missing UserName");
                        WarningField.setVisible(true);
                    }
                    if (password.isEmpty()) {
                        WarningField.setText("Missing Password");
                        WarningField.setVisible(true);
                    }
                }
            }
        });
        RegisterButton.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                WarningField.setVisible(false);
            }
        });
        LoginButton.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                WarningField.setVisible(false);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Perdi Social");
        frame.setContentPane(new Login().LoginPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();

        // ScreenUser Size
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        System.out.println(screenSize);
        // Frame Location
        int x = (screenSize.width - frame.getWidth())/2;
        int y = (screenSize.height - frame.getHeight())/2;
        // Set Location
        frame.setLocation(x,y);
        // Set Visible
        frame.setVisible(true);
    }
}
