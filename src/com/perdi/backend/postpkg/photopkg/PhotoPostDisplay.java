package com.perdi.backend.postpkg.photopkg;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.List;

public class PhotoPostDisplay extends JFrame{
    private List<String> imageUrls;

    public PhotoPostDisplay(List<String> imageUrls) {
        this.imageUrls = imageUrls;
        initUI();
    }

    private void initUI() {
        setTitle("PhotoPost Viewer");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        for (String urlString : imageUrls) {
            try {
                URL url = new URL(urlString);
                ImageIcon imageIcon = new ImageIcon(url);
                JLabel label = new JLabel(imageIcon);
                add(label);
            } catch (Exception e) {
                System.out.println("Erro ao carregar a image: " +urlString);
            }
        }

        setVisible(true);
    }
}

