package com.perdi.frontend.uipkg;

import org.w3c.dom.Text;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPage {
    private JPanel MainPagePanel;
    private JPanel UserBarPanel;
    private JPanel FeedBarPanel;
    private JPanel NavBarPanel;
    private JPanel UserBoxPanel;
    private JLabel UserNameLabel;
    private JLabel NickNameLabel;
    private JPanel ImagePanel;
    private JRadioButton recommendedPostsRadioButton;
    private JRadioButton friendsPostsRadioButton;
    private JRadioButton groupsPostsRadioButton;
    private JButton friendsButton;
    private JButton groupsButton;
    private JButton settingsButton;
    private JScrollPane FeedPanel;
    private JPanel PostPanel;
    private JList PostList;
    private JLabel PostTitleLabel;
    private JScrollPane CommentSectionPanel;
    private JList CommentList;
    private JTextArea TextPost;
    private JTextField LinkPost;

    public MainPage() {
        UserBarPanel.setVisible(true);
        FeedBarPanel.setVisible(true);
        NavBarPanel.setVisible(true);
        UserBoxPanel.setVisible(true);
        PostPanel.setVisible(false);

        FeedPanel = new JScrollPane();
        DefaultListModel<String> listModel = new DefaultListModel<>();
        PostList = new JList<>(listModel);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Perdi Social");
        frame.setContentPane(new MainPage().MainPagePanel);
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
