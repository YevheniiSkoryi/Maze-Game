package com.yevhenii.maze.service;

import com.yevhenii.maze.domain.Player;

import javax.swing.*;

public interface GameService {
    void saveGame(Player player);

    void startGame(Player player);

    void startLevelBasedOnAchievedLevel(Player player);

    DefaultListModel<Player> loadPlayers();
}
