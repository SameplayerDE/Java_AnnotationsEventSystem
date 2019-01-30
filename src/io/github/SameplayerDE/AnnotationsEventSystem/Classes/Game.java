package io.github.SameplayerDE.AnnotationsEventSystem.Classes;

import io.github.SameplayerDE.AnnotationsEventSystem.Enums.InputState;
import io.github.SameplayerDE.AnnotationsEventSystem.Main;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;

public abstract class Game extends Object implements Runnable {

    protected static GameManager gameManager = new GameManager();
    protected static StoryLoader storyLoader = new StoryLoader();
    protected static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    protected static StoryManager storyManager;
    protected static Thread thread;
    private static boolean running = false;

    private static HashSet<Class> children = new HashSet<>();

    protected static InputState inputState = InputState.CLOSE;

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(new File("src/game.txt")));

        String line = "";
        while ((line = reader.readLine()) != null) {
            //System.out.println(line);
            if (line.startsWith("init: ")) {
                line = line.substring(6);
                //System.out.println(line);
                try {
                    children.add(ClassLoader.getSystemClassLoader().loadClass(line));
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }


        try {
            for (Method m : Game.class.getDeclaredMethods()) {
                if (!m.getName().equals("onEnable")) {
                    continue;
                }
                for (Class c : children) {
                    m.invoke(c.newInstance());
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onEnable() {

        thread = new Thread(this);

        storyManager = new StoryManager(storyLoader);
        storyManager.setCurrentItem(storyLoader.getItemByID(0));
        storyManager.print();

        //start();
    }

    protected void stop() {
        running = false;
    }

    protected boolean isRunning() {
        return running;
    }

    protected void start() {
        running = true;
        setInputState(InputState.OPEN);
        thread.run();
    }

    public static void setInputState(InputState inputState) {
        //println(Game.getInputState().toString() + " -> " + inputState.toString());
        Game.inputState = inputState;
    }

    public static StoryLoader getStoryLoader() {
        return storyLoader;
    }

    public static InputState getInputState() {
        return inputState;
    }

    protected String readLine() {
        if (inputState.equals(InputState.OPEN)) {
            try {
                return reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "";
        }else{
            return null;
        }
    }

    protected void add(Class c) {
        children.add(c);
    }

    public static GameManager getGameManager() {
        return gameManager;
    }

    public static void print(String s) {
        System.out.print(s);
    }

    public static void println(String s) {
        System.out.println(s);
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
