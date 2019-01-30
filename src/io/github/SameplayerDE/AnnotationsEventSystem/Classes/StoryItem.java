package io.github.SameplayerDE.AnnotationsEventSystem.Classes;

import io.github.SameplayerDE.AnnotationsEventSystem.Enums.StoryItemFlag;
import io.github.SameplayerDE.AnnotationsEventSystem.Enums.StoryItemMessageType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class StoryItem {

    private int ID;
    private String title;
    private HashBiMap<Integer> items;
    private HashSet<StoryItemFlag> flags;
    private StoryItemMessageType messageType = StoryItemMessageType.OTHER;

    public StoryItem(int ID, String title) {
        this.ID = ID;
        this.title = title;
        items =  new HashBiMap<>();
        flags = new HashSet<>();
    }

    public StoryItem addFlag(StoryItemFlag flag) {
        flags.add(flag);
        return this;
    }

    public StoryItem setMessageType(StoryItemMessageType messageType) {
        this.messageType = messageType;
        return this;
    }

    public StoryItem add(int ID, int position, Object object) {
        items.put(ID, position, object);
        return this;
    }

    public int getID() {
        return ID;
    }

    public String getTitle() {
        return title;
    }

    public void print() {
        switch (messageType) {
            case SELF:
                System.out.println("~* " + title + " *~");
                for (Integer index : items.keySet()) {
                    System.out.println(index + " -> " + items.get(index, 1));
                }
                break;
            case OTHER:
                System.out.println(title);
                for (Integer index : items.keySet()) {
                    System.out.println(index + " -> " + items.get(index, 1));
                }
                break;
        }
    }

    public HashSet<StoryItemFlag> getFlags() {
        return flags;
    }

    public boolean hasFlag(StoryItemFlag flag) {
        return flags.contains(flag);
    }

    public HashBiMap<Integer> getBasicItems() {
        return items;
    }

    public void convertBasicItemToStoryItem() {

    }

}
