package com.yevhenii.maze;


import com.yevhenii.maze.panel.About;
import com.yevhenii.maze.panel.BackGround;
import com.yevhenii.maze.panel.CharacterMenu;
import com.yevhenii.maze.panel.LoadWindow;
import com.yevhenii.maze.service.ButtonService;
import com.yevhenii.maze.service.GameService;
import com.yevhenii.maze.service.GameServiceImpl;

import javax.swing.*;
import java.awt.*;

public class Menu extends JFrame implements ButtonService {

    private final JButton loadGame;
    private final JButton newGame;
    private final JButton about;

    private final JLabel mainTitle;

    private final JPanel mainMenu;
    private final JPanel aboutMenu;
    private final JPanel characterMenu;
    private final JPanel backGroundPanel;
    private final JPanel mainPanel;


    private final GameService gameService = new GameServiceImpl();


    public static void main(String[] args) {
        Menu gui = new Menu();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setVisible(true);
    }

    public Menu() {
        this.mainMenu = new JPanel();
        this.mainPanel = new JPanel();
        this.characterMenu = new CharacterMenu(gameService, mainMenu);
        this.aboutMenu = new About(mainMenu);
        this.backGroundPanel = new BackGround();

        this.newGame = new JButton("    New game   ");
        this.loadGame = new JButton("   Load game   ");
        this.about = new JButton("        About        ");


        this.mainTitle = new JLabel("Family Guy Maze game");

        initWindow();
    }

    public void initWindow() {
        setTitle("Family Guy");
        setPreferredSize(new Dimension(750, 450));
        setLayout(new BorderLayout());
        backGroundPanel.setLayout(new BorderLayout());
        setContentPane(backGroundPanel);
        createMainMenuPanel();
        mainPanel.setOpaque(false);
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(characterMenu, BorderLayout.WEST);
        mainPanel.add(mainMenu, BorderLayout.CENTER);
        mainPanel.add(aboutMenu, BorderLayout.EAST);
        backGroundPanel.add(mainPanel, BorderLayout.WEST);
        pack();
        setLocationRelativeTo(null);

    }

    public void createMainMenuPanel() {
        mainMenu.setLayout(new GridLayout(5, 1, 15, 15));
        configureButton(newGame,loadGame,about);

        mainMenu.setOpaque(false);
        mainMenu.add(generateEmptyLabel());
        mainMenu.add(mainTitle);
        mainMenu.add(generateEmptyLabel());
        mainMenu.add(newGame);
        mainMenu.add(generateEmptyLabel());
        mainMenu.add(loadGame);
        mainMenu.add(generateEmptyLabel());
        mainMenu.add(about);
        mainMenu.add(generateEmptyLabel());
        mainMenu.add(generateEmptyLabel());

        newGame.addActionListener(e -> {
            mainMenu.setVisible(false);
            characterMenu.setVisible(true);
        });
        about.addActionListener(e -> {
            mainMenu.setVisible(false);
            aboutMenu.setVisible(true);
        });
        loadGame.addActionListener(e -> {
            Dialog d = new LoadWindow(gameService);
        });

    }

    private JLabel generateEmptyLabel() {
        return new JLabel(" ");
    }

}
