package com.yevhenii.maze.service;


import com.yevhenii.maze.panel.Level;

import java.awt.*;
import java.awt.event.KeyEvent;

public class GraphicalServiceImpl implements GraphicalService {


    private final int TITLE_HEIGHT = 35;

    public void drawBoard(Graphics g, Level level) {
        int[][] maze = level.getConfiguration().getMaze();

      /*  for (int row = level.getPlayerPositionX() - 1; row <= level.getPlayerPositionX() + 1; row++) {
            for (int col = level.getPlayerPositionY() - 1; col <= level.getPlayerPositionY() + 1; col++) {*/
        int playerPositionX = level.getPlayerPositionX();
        int playerPositionY = level.getPlayerPositionY();

        for (int row = playerPositionX - 1; row <= playerPositionX + 1; row++) {
            for (int col = playerPositionY - 1; col <= playerPositionY + 1; col++) {
                Color color;
                switch (maze[row][col]) {
                    case 1:
                    case 2:
                        color = Color.BLACK;
                        break;
                    case 9:
                        color = Color.RED;
                        break;
                    default:
                        color = Color.WHITE;
                        break;
                }
                g.setColor(color);
                g.fillRect(30 * col, TITLE_HEIGHT + 30 * row, 30, 30);
                g.setColor(Color.BLACK);
                g.drawRect(30 * col, TITLE_HEIGHT + 30 * row, 30, 30);
            }
        }
    }

    @Override
    public void drawImage(Image image, Graphics2D g2, int playerPositionX, int playerPositionY) {
        g2.drawImage(image, playerPositionY * 30, TITLE_HEIGHT + playerPositionX * 30, 30, 30, null);
    }


    public void move(KeyEvent event, int[][] maze, Level level) {
        if (event.getID() != KeyEvent.KEY_PRESSED) {
            return;
        }
        int keyCode = event.getKeyCode();
        int x = level.getPlayerPositionX();
        int y = level.getPlayerPositionY();
        switch (keyCode) {
            case KeyEvent.VK_UP:
                if (maze[x - 1][y] != 1) {
                    level.setPlayerPositionX(x - 1);
                }
                break;
            case KeyEvent.VK_DOWN:
                if (maze[x + 1][y] != 1) {
                    level.setPlayerPositionX(x + 1);
                }
                break;
            case KeyEvent.VK_LEFT:
                if (maze[x][y - 1] != 1) {
                    level.setPlayerPositionY(y - 1);
                }
                break;
            case KeyEvent.VK_RIGHT:
                if (maze[x][y + 1] != 1) {
                    level.setPlayerPositionY(y + 1);
                }
                break;

            default:
                break;
        }
    }

}
