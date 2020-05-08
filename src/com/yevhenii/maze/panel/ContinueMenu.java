package com.yevhenii.maze.panel;


import com.yevhenii.maze.domain.Player;
import com.yevhenii.maze.service.GameService;
import com.yevhenii.maze.service.GameServiceImpl;

import javax.swing.*;
import java.awt.*;

public class ContinueMenu extends JDialog {

    private JButton nextLevel;
    private JButton saveGame;
    private JButton exit;
    private JPanel panel;
    private Player player;
    private final GameService gameService;

    public ContinueMenu(Player player) {
        this.nextLevel = new JButton("Continue");
        this.saveGame = new JButton("Save and continue");
        this.exit = new JButton("Exit");
        this.panel = new JPanel();
        this.gameService = new GameServiceImpl();
        this.player = player;
        setTitle("Load game");
        setPreferredSize(new Dimension(200, 200));
        createPanel();
        add(panel);
        setResizable(false);
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
    }

    private void createPanel() {
        panel.setLayout(new GridLayout(3, 2, 15, 15));
        panel.add(nextLevel);
        panel.add(saveGame);
        panel.add(exit);
        nextLevel.addActionListener(e -> {
            gameService.startLevelBasedOnAchievedLevel(player);
            dispose();
        });
        saveGame.addActionListener(e -> {
            gameService.saveGame(player);
            gameService.startLevelBasedOnAchievedLevel(player);
            dispose();
        });
        exit.addActionListener(e -> dispose());
    }


}
