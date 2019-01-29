package io.github.SameplayerDE.AnnotationsEventSystem.Classes;

import io.github.SameplayerDE.AnnotationsEventSystem.Main;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;

public abstract class Game extends Object {

    protected static GameManager gameManager = new GameManager();
    protected static StoryLoader storyLoader = new StoryLoader();
    protected static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static HashSet<Class> children = new HashSet<>();

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
        for (StoryItem item : storyLoader.storyItemHashSet) {
            if (item.getID() == 0) {
                item.print();
                break;
            }
        }
    }

    protected String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    protected void add(Class c) {
        children.add(c);
    }

    public static GameManager getGameManager() {
        return gameManager;
    }

}
