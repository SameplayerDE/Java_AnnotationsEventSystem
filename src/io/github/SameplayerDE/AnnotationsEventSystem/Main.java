package io.github.SameplayerDE.AnnotationsEventSystem;

import io.github.SameplayerDE.AnnotationsEventSystem.Classes.Game;
import io.github.SameplayerDE.AnnotationsEventSystem.Classes.GameLoader;
import io.github.SameplayerDE.AnnotationsEventSystem.Classes.GameManager;
import io.github.SameplayerDE.AnnotationsEventSystem.Classes.Player;
import io.github.SameplayerDE.AnnotationsEventSystem.Events.GameEvents.GameStartEvent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main extends Game {

    private Player p;

    @Override
    public void onEnable() {
        System.out.println("Hello");
        getGameManager().registerEvents(new ListenerGameStart());
        run();
    }

    public void run() {

        getGameManager().callEvent(new GameStartEvent(this));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            p = new Player (reader.readLine());
            
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
