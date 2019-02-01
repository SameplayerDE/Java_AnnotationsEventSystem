package io.github.SameplayerDE.AnnotationsEventSystem.Enums;

public class StoryItemField {

    public static final int ID = 0;
    public static final int TITLE = 1;
    public static final int ITEM = 2;

    public static String valueOf(int value) {
        if (value == TITLE) {
            return "TITLE";
        }
        if (value == ID) {
            return "ID";
        }
        if (value == ITEM) {
            return "ITEM";
        }
        return "UNKNOWN";
    }

}
