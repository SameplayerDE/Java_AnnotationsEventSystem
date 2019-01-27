package io.github.SameplayerDE.AnnotationsEventSystem.Classes;

public abstract class Entity {

    protected int health;

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void damage(int damage) {
        if (health - damage < 1) {
            //call event
        }
        health -= damage;
    }

}
