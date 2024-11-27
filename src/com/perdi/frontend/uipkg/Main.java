package com.perdi.frontend.uipkg;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainPage gui = new MainPage();
            gui.setVisible(true);
        });
    }
}