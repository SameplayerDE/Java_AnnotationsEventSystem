package io.github.SameplayerDE.AnnotationsEventSystem.Classes;

import java.util.HashMap;

public class StoryItem {

    private int ID;
    private String title;
    private HashMap<Integer, String> items;

    public StoryItem(int ID, String title) {
        this.ID = ID;
        this.title = title;
        items = new HashMap<>();
    }

    public StoryItem add(int ID, String title) {
        items.put(ID, title);
        return this;
    }

    public int getID() {
        return ID;
    }

    public String getTitle() {
        return title;
    }

    public HashMap<Integer, String> getItems() {
        return items;
    }

    public void print() {
        System.out.println(title);
        for (Integer index : items.keySet()) {
            System.out.println(index + " -> " + items.get(index));
        }
    }

}
