package io.github.SameplayerDE.AnnotationsEventSystem.Classes;

public class Player extends Entity {

    private String name;

    public Player(String name) {
        health = 20;
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
