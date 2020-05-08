package com.yevhenii.maze.panel;

import com.yevhenii.maze.service.ButtonService;

import javax.swing.*;
import java.awt.*;

public class About extends BackGround implements ButtonService {

    private final JTextArea aboutText;
    private final JButton backToMainMenu;
    private final String FONT = "Times new roman";
    private final String ABOUT = "Description informing user that the game is for personal use and all characters are " +
            "copyrighted for FOX company";

    private final JLabel aboutLabel;

    public About(JPanel mainMenu) {
        this.backToMainMenu = new JButton("Back");
        this.aboutText = new JTextArea();
        this.aboutLabel = new JLabel("About:        ");
        setLayout(new GridLayout(3, 2, 15, 15));
        setOpaque(false);

        configureButton(backToMainMenu);

        add(new JLabel(" "));
        add(aboutLabel);
        add(new JLabel(" "));
        add(aboutText);
        add(new JLabel(" "));
        add(backToMainMenu);


        aboutText.setEditable(false);
        aboutText.setText(ABOUT);
        aboutText.setOpaque(false);
        aboutText.setLineWrap(true);
        aboutText.setWrapStyleWord(true);
        aboutText.setFont(new Font(FONT, Font.PLAIN, 14));
        aboutLabel.setFont(new Font(FONT, Font.PLAIN, 25));

        backToMainMenu.setContentAreaFilled(false);
        backToMainMenu.setBorderPainted(false);
        backToMainMenu.addActionListener(e -> {
            mainMenu.setVisible(true);
            setVisible(false);
        });
        setVisible(false);
    }
}
