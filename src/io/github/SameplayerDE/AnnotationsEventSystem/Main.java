package io.github.SameplayerDE.AnnotationsEventSystem;

import io.github.SameplayerDE.AnnotationsEventSystem.Classes.Game;
import io.github.SameplayerDE.AnnotationsEventSystem.Classes.GameLoader;
import io.github.SameplayerDE.AnnotationsEventSystem.Classes.GameManager;
import io.github.SameplayerDE.AnnotationsEventSystem.Events.GameEvents.GameStartEvent;

public class Main extends Game {

    @Override
    public void onEnable() {
        System.out.println("Hello");
        getGameManager().registerEvents(new ListenerGameStart());
        run();
    }

    public void run() {

        getGameManager().callEvent(new GameStartEvent(this));

    }

}
