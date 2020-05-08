package com.yevhenii.maze.domain;

public class Game {

    private Player player;
    private LevelConfiguration currentLevel;


    public Game(Player player) {
        this.player = player;
        this.currentLevel = LevelConfiguration.EASY;
    }

    public Game(Player player, LevelConfiguration currentLevel) {
        this.player = player;
        this.currentLevel = currentLevel;
    }

    public Player getPlayer() {
        return player;
    }


    public LevelConfiguration getCurrentLevel() {
        return currentLevel;
    }

}
