package com.yevhenii.maze.service;

import com.yevhenii.maze.domain.LevelConfiguration;
import com.yevhenii.maze.domain.Game;
import com.yevhenii.maze.domain.Player;
import com.yevhenii.maze.panel.Level;

import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class GameServiceImpl implements GameService {

    private static final String SAVE_PATH = "Save.txt";
    private static final String FILE_EXTENSION = ".png";

    public void startGame(Player player) {
        Game game = new Game(player);
        JDialog level = new Level(game.getPlayer(), game.getCurrentLevel());
    }

    public void saveGame(Player player) {
        String text = player.getName() + "," + player.getAchievedLevel() + "\n";
        try {
            Files.write(Paths.get(SAVE_PATH), text.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void startLevelBasedOnAchievedLevel(Player player) {
        int achievedLevel = player.getAchievedLevel();

        JDialog m;

        switch (achievedLevel) {
            case 1:
                m = new Level(player, LevelConfiguration.EASY);
                break;
            case 2:
                m = new Level(player, LevelConfiguration.MEDIUM);
                break;
            case 3:
                m = new Level(player, LevelConfiguration.HARD);
                break;
            case 4:
                m = new Level(player, LevelConfiguration.DEMON);
                break;
            default:
                JOptionPane.showMessageDialog(null, "You've finished maze");
        }

    }

    public DefaultListModel<Player> loadPlayers() {
        BufferedReader reader;
        String line;
        DefaultListModel<Player> dlm = new DefaultListModel<>();
        List<Player> list = new ArrayList<>();
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(SAVE_PATH)));
            while ((line = reader.readLine()) != null) {
                String[] array = line.split(",");
                String name = array[0];
                File character = new File(name + FILE_EXTENSION);

                Player p = new Player(name, character, Integer.parseInt(array[1]));
                dlm.addElement(p);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException ignored) {
        }
        return dlm;
    }

}
