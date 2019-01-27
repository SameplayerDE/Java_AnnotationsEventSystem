package io.github.SameplayerDE.AnnotationsEventSystem.Events.GameEvents;

import io.github.SameplayerDE.AnnotationsEventSystem.Classes.Game;
import io.github.SameplayerDE.AnnotationsEventSystem.Events.GameEvent;

public class GameStartEvent extends GameEvent {

    public GameStartEvent(Game game) {
        super(game);
    }

    @Override
    public String getEventName() {
        return "GAME_START_EVENT";
    }
}
