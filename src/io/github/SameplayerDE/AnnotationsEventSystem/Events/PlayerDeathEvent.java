package io.github.SameplayerDE.AnnotationsEventSystem.Events;

import io.github.SameplayerDE.AnnotationsEventSystem.Classes.Player;

public class PlayerDeathEvent extends PlayerEvent {
    public PlayerDeathEvent(Player player) {
        super(player);
    }
}
