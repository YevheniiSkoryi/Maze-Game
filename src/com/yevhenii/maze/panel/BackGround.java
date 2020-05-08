package com.yevhenii.maze.panel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class BackGround extends JPanel {

    private final File background_file;

    public BackGround() {
        this.background_file = new File("Background.jpg");
    }

    public void paintComponent(Graphics g) {
        try {
            Image im = ImageIO.read(background_file);
            g.drawImage(im, 0, 0, null);
        } catch (IOException ignored) {
        }

    }
}
