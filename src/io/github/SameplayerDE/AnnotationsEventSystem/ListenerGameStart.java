package io.github.SameplayerDE.AnnotationsEventSystem;

import io.github.SameplayerDE.AnnotationsEventSystem.Annotations.EventHandler;
import io.github.SameplayerDE.AnnotationsEventSystem.Events.GameEvents.GameStartEvent;
import io.github.SameplayerDE.AnnotationsEventSystem.Events.Listener;

public class ListenerGameStart implements Listener {

    @EventHandler
    public void onStart(GameStartEvent event) {
        System.out.println("Spiel wurde gestartet!");

    }

}
