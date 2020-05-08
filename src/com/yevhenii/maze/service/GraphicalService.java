package com.yevhenii.maze.service;



import com.yevhenii.maze.panel.Level;

import java.awt.*;
import java.awt.event.KeyEvent;

public interface GraphicalService {

    void move(KeyEvent event, int[][] maze, Level level);

    void drawBoard(Graphics g, Level level);

    void drawImage(Image image, Graphics2D g2, int playerPositionX, int playerPositionY);
}
