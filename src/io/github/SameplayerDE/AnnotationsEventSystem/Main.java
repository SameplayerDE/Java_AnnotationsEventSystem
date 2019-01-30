package io.github.SameplayerDE.AnnotationsEventSystem;

import io.github.SameplayerDE.AnnotationsEventSystem.Classes.*;
import io.github.SameplayerDE.AnnotationsEventSystem.Events.GameEvents.GameStartEvent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main extends Game {

    private StoryManager storyManager;

    @Override
    public void onEnable() {
        super.onEnable();
        storyManager = new StoryManager(storyLoader);
        //System.out.println("Hello");
        getGameManager().registerEvents(new ListenerGameStart());
        run();
    }

    public void run() {

        getGameManager().callEvent(new GameStartEvent(this));
        try {
            int i = Integer.parseInt(reader.readLine());
            for (StoryItem item : storyLoader.storyItemHashSet) {
                if (item.getID() == i) {
                    item.print();
                }else{
                    continue;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
