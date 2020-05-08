package com.yevhenii.maze.panel;

import com.yevhenii.maze.domain.Player;
import com.yevhenii.maze.service.ButtonService;
import com.yevhenii.maze.service.GameService;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class CharacterMenu extends BackGround implements ButtonService {

    private final String QUAGMIRE_FILE;
    private final String PETER_FILE;
    private final String JOE_FILE;
    private final String CLEVELAND_FILE;

    private final JButton peter;
    private final JButton joe;
    private final JButton quagmire;
    private final JButton cleveland;
    private final JButton back;

    private final JLabel newG;
    private final JLabel selectC;
    private final JPanel main;

    private final GameService gameService;

    public CharacterMenu(GameService gameService, JPanel main) {
        this.main = main;
        this.gameService = gameService;

        this.QUAGMIRE_FILE = "Quagmire.png";
        this.PETER_FILE = "Peter Griffin.png";
        this.JOE_FILE = "Joe.png";
        this.CLEVELAND_FILE = "Cleveland.png";

        this.back = new JButton("Back to main menu");
        this.cleveland = new JButton("Cleveland");
        this.quagmire = new JButton("Quagmire");
        this.joe = new JButton("Joe");
        this.peter = new JButton("Peter");

        this.newG = new JLabel("   New Game");
        this.selectC = new JLabel("   Select character:");

        newG.setFont(new Font("Times new roman", Font.PLAIN, 26));
        selectC.setFont(new Font("Times new roman", Font.PLAIN, 26));
        setPreferredSize(new Dimension(750, 450));
        setLayout(new GridLayout(7, 1, 15, 15));
        add(newG);
        add(selectC);
        add(peter);
        add(joe);
        add(quagmire);
        add(cleveland);
        add(back);

        configureButton(joe, peter, quagmire, cleveland, back);
        configureButtonsActions();


        setVisible(false);
    }

    public void configureButtonsActions() {

        back.addActionListener(e -> {
            setVisible(false);
            main.setVisible(true);
        });
        joe.addActionListener(e -> {
            start("Joe", JOE_FILE);
        });
        peter.addActionListener(e -> {
            start("Peter Griffin", PETER_FILE);
        });
        quagmire.addActionListener(e -> {
            start("Quagmire", QUAGMIRE_FILE);
        });
        cleveland.addActionListener(e -> {
            start("Cleveland", CLEVELAND_FILE);
        });
    }

    private void start(String playerName, String playerFile) {
        File clevelandFile = new File(playerFile);
        Player player = new Player(playerName, clevelandFile);
        gameService.startGame(player);
    }

}
