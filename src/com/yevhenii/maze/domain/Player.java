package com.yevhenii.maze.domain;

import java.io.File;

public class Player {

    private String name;
    private File character;
    private int achievedLevel;

    public Player(String name, File character) {
        this.name = name;
        this.character = character;
        this.achievedLevel = 1;
    }

    public Player(String name, File character, int achievedLevel) {
        this.name = name;
        this.character = character;
        this.achievedLevel = achievedLevel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public File getCharacter() {
        return character;
    }

    public void setCharacter(File character) {
        this.character = character;
    }

    public int getAchievedLevel() {
        return achievedLevel;
    }

    public void setAchievedLevel(int achievedLevel) {
        this.achievedLevel = achievedLevel;
    }

    @Override
    public String toString() {
        return "Name " + name +", achieved level " + achievedLevel;
    }

}
