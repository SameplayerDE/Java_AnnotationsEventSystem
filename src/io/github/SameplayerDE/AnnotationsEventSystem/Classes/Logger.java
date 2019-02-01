package io.github.SameplayerDE.AnnotationsEventSystem.Classes;

public class Logger {

    private Level level = Level.INFO;

    public Logger setLevel(Level level) {
        this.level = level;
        return this;
    }

    public void debug(String string) {
        if (level.equals(Level.DEBUG)) {
            System.out.println("[DEBUG] " + string);
        }
    }

    public void info(String string) {
        System.out.println("[INFO] " + string);
    }

    public enum Level {

        DEBUG,
        INFO,

    }

}
