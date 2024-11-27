package com.perdi.frontend.uipkg;

import com.perdi.backend.feed.postpkg.Post;
import com.perdi.backend.feed.postpkg.TextPost;
import com.perdi.backend.storage.datapkg.DataCenter;
import com.perdi.backend.systempkg.reccomendationpkg.Recommendation;
import com.perdi.backend.userpkg.User;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.UUID;

public class MainPage extends JFrame {

    private JPanel MainPage;
    private JButton RecommendedPosts;
    private JButton FriendsPosts;
    private JButton GroupPosts;
    private JPanel Feed;
    private JPanel CurrentPost;
    private JPanel CommentSection;
    private JPanel NavBar;
    private JPanel MainContent;
    private JPanel UserBar;
    private JPanel Icon;
    private JPanel UserOptions;
    private JLabel Nickname;
    private JLabel Username;
    private JLabel TitleLabel;

    private DefaultListModel<String> postModel;

    private User CurrentUser = new User(null, null, null, null, null, false);
    private DataCenter instancia = DataCenter.getInstance();

    public MainPage() {
        setupFrame();
        initComponents();
        setupNavBar();
        setupNavBarListeners();
        organizeLayout();
        setVisible(true);
    }

    private void setupFrame() {
        setTitle("Main Page");
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void initComponents() {
        MainPage = new JPanel(new BorderLayout());
        MainPage.setBorder(new EmptyBorder(10, 10, 10, 10));

        TitleLabel = new JLabel("Rede Social P\n");

        postModel = new DefaultListModel<>();
        JList<String> PostList = new JList<>(postModel);
        PostList.setVisibleRowCount(5);
        PostList.setFixedCellWidth(600);
        PostList.setFixedCellHeight(100);
        Feed = new JPanel();
        Feed.add(new JScrollPane(PostList));

        MainContent = new JPanel();
        MainContent.add(Feed);

        setupNavBarListeners();
    }

    private void organizeLayout() {
        setLayout(new BorderLayout());

        setupMainContent();
        setupUserBar();

        add(NavBar, BorderLayout.NORTH);
        add(MainContent, BorderLayout.CENTER);
        add(UserBar, BorderLayout.WEST);
    }

    private void setupNavBar() {
        RecommendedPosts = new JButton("Recommended Posts");
        FriendsPosts = new JButton("Friend's Posts");
        GroupPosts = new JButton("Group's Posts");

        NavBar = new JPanel();
        NavBar.setLayout(new FlowLayout());
        NavBar.add(RecommendedPosts);
        NavBar.add(FriendsPosts);
        NavBar.add(GroupPosts);
    }

    private void setupMainContent() {
        MainContent.setLayout(new BorderLayout());
        MainContent.add(Feed, BorderLayout.CENTER);
    }

    private void setupUserBar() {
        UserBar = new JPanel();
        UserBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        UserBar.setPreferredSize(new Dimension(200, getHeight()));

        Icon = new JPanel();
        Icon.setPreferredSize(new Dimension(150,150));
        Icon.setBackground(new Color(99,99,99));

        JPanel userInfoPanel = new JPanel();
        userInfoPanel.setLayout(new BoxLayout(userInfoPanel, BoxLayout.Y_AXIS));
        userInfoPanel.setOpaque(false);

        Nickname = new JLabel("Nickname");
        Username = new JLabel("@Username");
        userInfoPanel.add(Nickname);
        userInfoPanel.add(Username);

        UserOptions = new JPanel();
        JButton newPostButton = new JButton("New Post");
        JButton friendListButton = new JButton("Friends");
        JButton groupListButton = new JButton("Groups");
        JButton settingsButton = new JButton("Settings");
        JButton logoutButton = new JButton("Log Out");
        UserOptions.add(newPostButton);
        UserOptions.add(friendListButton);
        UserOptions.add(groupListButton);
        UserOptions.add(settingsButton);
        UserOptions.add(logoutButton);

        UserBar.add(Icon);
        UserBar.add(userInfoPanel);
        UserBar.add(UserOptions);
    }

    private void setupNavBarListeners() {
        if (RecommendedPosts != null) {
            RecommendedPosts.addActionListener(e -> updateFeed("Recommended"));
        } else {
            System.err.println("RecommendedPosts ainda é nulo!");
        }

        if (FriendsPosts != null) {
            FriendsPosts.addActionListener(e -> updateFeed("Friends"));
        } else {
            System.err.println("FriendsPosts ainda é nulo!");
        }

        if (GroupPosts != null) {
            GroupPosts.addActionListener(e -> updateFeed("Groups"));
        } else {
            System.err.println("GroupPosts ainda é nulo!");
        }
    }


    private void updateFeed(String type) {
        Post newPost = new TextPost(UUID.randomUUID(), "Hi");
        instancia.addPost(newPost);
        postModel.clear();
        ArrayList<Post> FeedPosts;
        FeedPosts = instancia.getPosts();
        for (int i = 0; i < 5; i++) {
            postModel.addElement("Post from " + FeedPosts.get(i).getPostTitle() + " - " + (i+1));
        }
        Feed.revalidate();
        Feed.repaint();
    }


}
