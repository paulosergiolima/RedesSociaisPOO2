package com.perdi.frontend.uipkg;

import com.perdi.backend.feed.postpkg.*;
import com.perdi.backend.feed.postpkg.TextPost;
import com.perdi.backend.storage.datapkg.DataCenter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.UUID;

public class PostCreatorGUI extends JFrame {
    private JPanel PostPanel;
    private JTextField titleTextField;
    private JLabel TitleLabel;
    private JRadioButton TextRadioButton;
    private JRadioButton ImageRadioButton;
    private JRadioButton VideoRadioButton;
    private JTextField ImageInput;
    private JButton AddImageButton;
    private JList<String> ImageList;
    private JPanel ImagePanel;
    private JPanel TextPanel;
    private JTextArea textInput;
    private JPanel VideoPanel;
    private JButton AddVideoButton;
    private JList<String> VideoList;
    private JTextField VideoInput;
    private JPanel currentPanel;
    private JButton SaveTextButton;
    private JButton SaveImageButton;
    private JButton SaveVideoButton;

    private DataCenter instancia = DataCenter.getInstance();

    public PostCreatorGUI() {
        setupFrame();
        initComponents();
        setupLayouts();
        addActions();

        currentPanel = null;
    }

    private void setupFrame() {
        setTitle("Post Creator");
        setSize(600,400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void initComponents() {
        PostPanel = new JPanel(new BorderLayout());
        PostPanel.setBorder(new EmptyBorder(10,10,10,10));

        TitleLabel = new JLabel("Title:  ");
        titleTextField = new JTextField(20);

        TextRadioButton = new JRadioButton("Text");
        ImageRadioButton = new JRadioButton("Image");
        VideoRadioButton = new JRadioButton("Video");
        ButtonGroup group = new ButtonGroup();
        group.add(TextRadioButton);
        group.add(ImageRadioButton);
        group.add(VideoRadioButton);

        initTextPanel();
        initImagePanel();
        initVideoPanel();
    }

    private void initTextPanel() {
        TextPanel = new JPanel();
        SaveTextButton = new JButton("Post");
        textInput = new JTextArea(15, 40);
        TextPanel.add(new JLabel("Text:"));
        TextPanel.add(new JScrollPane(textInput));
        TextPanel.add(SaveTextButton);
    }

    private void initImagePanel() {
        ImagePanel = new JPanel();
        ImageInput = new JTextField(20);
        ImageList = new JList<>(new DefaultListModel<>());
        ImageList.setVisibleRowCount(10);  // Ajusta a quantidade de linhas visíveis
        ImageList.setFixedCellWidth(300); // Define a largura fixa para as células
        ImageList.setFixedCellHeight(20); // Define a altura fixa para as células
        AddImageButton = new JButton("Add Image");
        SaveImageButton = new JButton("Post");
        ImagePanel.add(new JLabel("Image URL:"));
        ImagePanel.add(ImageInput);
        ImagePanel.add(AddImageButton);
        ImagePanel.add(new JScrollPane(ImageList));
        ImagePanel.add(SaveImageButton);
    }

    private void initVideoPanel() {
        VideoPanel = new JPanel();
        VideoInput = new JTextField(20);
        AddVideoButton = new JButton("Add Video");
        SaveVideoButton = new JButton("Post");
        VideoList = new JList<>(new DefaultListModel<>());
        VideoList.setVisibleRowCount(10);  // Ajusta a quantidade de linhas visíveis
        VideoList.setFixedCellWidth(300); // Define a largura fixa para as células
        VideoList.setFixedCellHeight(20); // Define a altura fixa para as células
        VideoPanel.add(new JLabel("Video URL:"));
        VideoPanel.add(VideoInput);
        VideoPanel.add(AddVideoButton);
        VideoPanel.add(new JScrollPane(VideoList));
        VideoPanel.add(SaveVideoButton);
    }

    private void setupLayouts() {
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(TitleLabel, BorderLayout.WEST);
        topPanel.add(titleTextField, BorderLayout.CENTER);
        PostPanel.add(topPanel, BorderLayout.NORTH);

        JLabel chooseLabel = new JLabel("Choose type:");
        JPanel choosePanel = new JPanel();
        choosePanel.add(chooseLabel);
        choosePanel.add(TextRadioButton);
        choosePanel.add(ImageRadioButton);
        choosePanel.add(VideoRadioButton);
        PostPanel.add(choosePanel, BorderLayout.CENTER);

        add(PostPanel);
    }

    private void addActions() {
        TextRadioButton.addActionListener(e -> switchPanel(TextPanel));
        ImageRadioButton.addActionListener(e -> switchPanel(ImagePanel));
        VideoRadioButton.addActionListener(e -> switchPanel(VideoPanel));

        AddImageButton.addActionListener(e -> addToList((DefaultListModel<String>) ImageList.getModel(), ImageInput.getText()));
        AddVideoButton.addActionListener(e -> addToList((DefaultListModel<String>) VideoList.getModel(), VideoInput.getText()));

        SaveTextButton.addActionListener(e -> {
            Post newPost = new TextPost(UUID.randomUUID(),textInput.getText());
            instancia.addPost(newPost);
            System.out.println(newPost.getContent());
        });
        SaveImageButton.addActionListener(e -> {
            Post newPost = new PhotoPost(UUID.randomUUID());
            for (int i = 0; i < ImageList.getModel().getSize(); i++) {
                ((PhotoPost)newPost).addImage(ImageList.getModel().getElementAt(i));
            }
            instancia.addPost(newPost);
            System.out.println(newPost.getContent());
        });
        SaveVideoButton.addActionListener(e -> {
            Post newPost = new VideoPost(UUID.randomUUID(),titleTextField.getText(),VideoList.getModel().getElementAt(0));
            for (int i = 0; i < VideoList.getModel().getSize(); i++) {
                ((VideoPost)newPost).setUrl_video(VideoList.getModel().getElementAt(i));
            }
            instancia.addPost(newPost);
            System.out.println(newPost.getContent());
        });
    }

    private void switchPanel(JPanel newPanel) {
        if (currentPanel != null) {
            PostPanel.remove(currentPanel);
        }
        if (newPanel != null) {
            currentPanel = newPanel;
            newPanel.setPreferredSize(new Dimension(getWidth(), 250));
            PostPanel.add(newPanel, BorderLayout.SOUTH);
        }
        PostPanel.revalidate();
        PostPanel.repaint();
    }

    private void addToList(DefaultListModel<String> model, String text) {
        if (!text.isEmpty()) {
            model.addElement(text);
        }
    }
}
