package io.github.SameplayerDE.AnnotationsEventSystem.Events;

import io.github.SameplayerDE.AnnotationsEventSystem.Classes.Game;

public abstract class GameEvent extends Event {

    private Game game;

    public GameEvent(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }
}
