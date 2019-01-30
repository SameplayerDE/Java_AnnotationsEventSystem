package io.github.SameplayerDE.AnnotationsEventSystem;

import com.sun.xml.internal.ws.util.StringUtils;
import io.github.SameplayerDE.AnnotationsEventSystem.Classes.*;
import io.github.SameplayerDE.AnnotationsEventSystem.Enums.InputState;
import io.github.SameplayerDE.AnnotationsEventSystem.Enums.StoryItemFlag;
import io.github.SameplayerDE.AnnotationsEventSystem.Events.GameEvents.GameStartEvent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;

public class Main extends Game {

    private Logger logger;

    @Override
    public void onEnable() {
        super.onEnable();
        logger = new Logger().setLevel(Logger.Level.DEBUG);
        logger.debug("Main onEnable called");
        getGameManager().registerEvents(new ListenerGameStart());
        start();
    }

    @Override
    public void run() {

        getGameManager().callEvent(new GameStartEvent(this));
       // storyLoader.readItemByID(0);
        while (isRunning()) {

            if (getInputState().equals(InputState.OPEN)) {
                logger.debug("OPEN");
                String input = readLine();
                if (input.isEmpty() || input == null) {
                    if (!storyManager.getCurrentItem().hasFlag(StoryItemFlag.ENTER)) {
                        logger.debug("NULL or EMPTY");
                        continue;
                    }
                    storyManager.setCurrentItem((StoryItem) storyManager.getCurrentItem().getBasicItems().first(2));
                    storyManager.print();
                    continue;
                }
                if (!GenericUtils.isNumeric(input)) {
                    if (input.equals("<")) {
                        setInputState(InputState.CLOSE);
                        if (storyManager.getCurrentItem().hasFlag(StoryItemFlag.RETURN)) {
                            storyManager.setCurrentItem(storyManager.getLastItem());
                            storyManager.print();
                        }
                        setInputState(InputState.OPEN);
                    }
                    logger.debug("NO NUMBER");
                    continue;
                }
                setInputState(InputState.CLOSE);
                int option = Integer.parseInt(input);
                Iterator<Integer> iterator = storyManager.getCurrentItem().getBasicItems().keySet().iterator();
                while (iterator.hasNext()) {
                    int i = iterator.next();
                    if (i == option) {
                        storyManager.setCurrentItem(storyLoader.getItemByID(i));
                        storyManager.print();
                        setInputState(InputState.OPEN);
                        break;
                    }
                    if (!iterator.hasNext()) {
                        clearScreen();
                        logger.debug("NO VALID OPERATOR");
                        setInputState(InputState.OPEN);
                    }
                    continue;
                }

            }

        }

    }

    @Override
    protected void start() {
        super.start();
        println("Thread wurde gestartet!");
    }
}
