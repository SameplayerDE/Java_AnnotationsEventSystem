package io.github.SameplayerDE.AnnotationsEventSystem.Classes;

import io.github.SameplayerDE.AnnotationsEventSystem.Enums.StoryItemFlag;
import io.github.SameplayerDE.AnnotationsEventSystem.Enums.StoryItemMessageType;
import io.github.SameplayerDE.AnnotationsEventSystem.Events.Event;

import java.util.HashSet;

public class StoryItem {

    private int ID;
    private String title;
    private HashBiMap<Integer> items;
    private HashSet<StoryItemFlag> flags;
    private HashSet<String> events;
    private StoryItemMessageType messageType = StoryItemMessageType.OTHER;

    public StoryItem(int ID, String title) {
        this.ID = ID;
        this.title = title;
        items =  new HashBiMap<>();
        flags = new HashSet<>();
        events = new HashSet<>();
    }

    public StoryItem addFlag(StoryItemFlag flag) {
        flags.add(flag);
        return this;
    }

    public StoryItem addEvent(String event) {
        events.add(event);
        return this;
    }

    public StoryItem setMessageType(StoryItemMessageType messageType) {
        this.messageType = messageType;
        return this;
    }

    public StoryItem add(int key, int position, Object object) {
        items.put(key, position, object);
        return this;
    }

    public StoryItem add(int key, int ID, StoryItem storyItem) {

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
                System.out.println("** " + title + " **");
                if (!hasFlag(StoryItemFlag.INVISIBLE_ITEMS)) {
                    System.out.println("-----Optionen------\n");
                    if (items.size() == 1) {
                        System.out.println(1 + " -> " + items.get(0, 1));
                        System.out.println("\n------------------");
                        break;
                    }
                    for (int i = 0; i < items.size(); i++) {
                        System.out.println(i + 1 + " -> " + items.get(i, 1));
                    }
                    System.out.println("\n------------------");
                }
                break;
            case OTHER:
                System.out.println(title);
                if (!hasFlag(StoryItemFlag.INVISIBLE_ITEMS)) {
                    System.out.println("-----Optionen------\n");
                    if (items.size() == 1) {
                        System.out.println(1 + " -> " + items.get(0, 1));
                        System.out.println("\n------------------");
                        break;
                    }
                    for (int i = 0; i < items.size(); i++) {
                        System.out.println(i + 1 + " -> " + items.get(i, 1));
                    }
                    System.out.println("\n------------------");
                }
                break;
            case ANNOUNCER:
                System.out.println("! " + title + " !");
                if (!hasFlag(StoryItemFlag.INVISIBLE_ITEMS)) {
                    System.out.println("-----Optionen------\n");
                    if (items.size() == 1) {
                        System.out.println(1 + " -> " + items.get(0, 1));
                        System.out.println("\n------------------");
                        break;
                    }
                    for (int i = 0; i < items.size(); i++) {
                        System.out.println(i + 1 + " -> " + items.get(i, 1));
                    }
                    System.out.println("\n------------------");
                }
                break;
            case TIP:
                System.out.println("? [" + title + "] !");
                if (!hasFlag(StoryItemFlag.INVISIBLE_ITEMS)) {
                    System.out.println("-----Optionen------\n");
                    if (items.size() == 1) {
                        System.out.println(1 + " -> " + items.get(0, 1));
                        System.out.println("\n------------------");
                        break;
                    }
                    for (int i = 0; i < items.size(); i++) {
                        System.out.println(i + 1 + " -> " + items.get(i, 1));
                    }
                    System.out.println("\n------------------");
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

    public HashSet<String> getEvents() {
        return events;
    }

    public boolean hasEvent(Event event) {
        return events.contains(event);
    }

    public HashBiMap<Integer> getBasicItems() {
        return items;
    }

    public void convertBasicItemToStoryItem() {

    }

}
