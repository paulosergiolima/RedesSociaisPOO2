package com.perdi.frontend.uipkg;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PostCreatorGUI gui = new PostCreatorGUI();
            gui.setVisible(true);
        });
    }
}