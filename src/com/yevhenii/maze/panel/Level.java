package com.yevhenii.maze.panel;


import com.yevhenii.maze.domain.LevelConfiguration;
import com.yevhenii.maze.domain.Player;
import com.yevhenii.maze.service.GraphicalService;
import com.yevhenii.maze.service.GraphicalServiceImpl;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class Level extends JDialog {

    private GraphicalService graphicalService;
    private Player player;
    private Image image;
    private LevelConfiguration configuration;

    private int playerPositionX;
    private int playerPositionY;

    public Level(Player player, LevelConfiguration configuration) {
        this.player = player;
        this.graphicalService = new GraphicalServiceImpl();
        this.configuration = configuration;
        this.playerPositionX = configuration.getStartPosX();
        this.playerPositionY = configuration.getStartPosY();
        try {
            this.image = ImageIO.read(player.getCharacter());
        } catch (IOException e) {
            this.image = null;
        }
        configureLevel();
    }

    private void configureLevel() {
        setTitle(configuration.getTitle());
        setPreferredSize(new Dimension(configuration.getDimensionX(), configuration.getDimensionY()));
        setResizable(false);
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
    }

    @Override
    public void paint(Graphics g) {
        graphicalService.drawBoard(g, this);
        graphicalService.drawImage(image, (Graphics2D)g, playerPositionX, playerPositionY);

        if (playerPositionX == configuration.getEndPosX() && playerPositionY == configuration.getEndPosY()) {
            player.setAchievedLevel(player.getAchievedLevel() + 1);
            JDialog d = new ContinueMenu(player);
            dispose();
        }
    }


    @Override
    protected void processKeyEvent(KeyEvent event) {
        graphicalService.move(event, configuration.getMaze(), this);
        repaint();
    }

    public int getPlayerPositionX() {
        return playerPositionX;
    }

    public int getPlayerPositionY() {
        return playerPositionY;
    }

    public void setPlayerPositionX(int playerPositionX) {
        this.playerPositionX = playerPositionX;
    }

    public void setPlayerPositionY(int playerPositionY) {
        this.playerPositionY = playerPositionY;
    }

    public LevelConfiguration getConfiguration() {
        return configuration;
    }
}
