package io.github.SameplayerDE.AnnotationsEventSystem.Events;

import io.github.SameplayerDE.AnnotationsEventSystem.Classes.Player;

public abstract class PlayerEvent extends Event {

    private Player player;

    public PlayerEvent(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }
}
