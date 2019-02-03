package io.github.SameplayerDE.AnnotationsEventSystem.Classes;

import com.google.common.collect.Iterators;
import io.github.SameplayerDE.AnnotationsEventSystem.Enums.StoryItemFlag;
import io.github.SameplayerDE.AnnotationsEventSystem.Enums.StoryItemMessageType;
import io.github.SameplayerDE.AnnotationsEventSystem.Events.Event;

import java.util.*;

import com.google.common.collect.PeekingIterator;

import javax.swing.text.html.HTMLDocument;

public class StoryItem {

    private int ID;
    private String title;
    private HashBiMap<Integer> items;
    private HashSet<StoryItemFlag> flags;
    private HashSet<String> events;
    private int timerDuration = 0;
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

    public StoryItem setTimerDelay(int timerDelay) {
        this.timerDuration = timerDelay;
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

    private void printTitle() {
        switch (messageType) {
            case SELF:
                if (title.contains("::")) {
                    ArrayList<Integer> index = new ArrayList<>();
                    index.add(0);
                    for (int i = -1; (i = title.indexOf("::", i + 1)) != -1; i++) {
                        index.add(i);
                    }

                    Iterator iterator = index.iterator();
                    PeekingIterator peekingIterator = Iterators.peekingIterator(iterator);
                    while (peekingIterator.hasNext()) {
                        int i = (int) peekingIterator.next();
                        if (peekingIterator.hasNext()) {
                            int next = (int) peekingIterator.peek();
                            System.out.println("** " + title.substring(i, next).replaceAll("::", "") + " **");
                        }else{
                            System.out.println("** " + title.substring(i).replaceAll("::", "") + " **");
                        }
                    }
                }else{
                    System.out.println("** " + title + " **");
                }
                break;
            case OTHER:
                if (title.contains("::")) {
                    ArrayList<Integer> index = new ArrayList<>();
                    index.add(0);
                    for (int i = -1; (i = title.indexOf("::", i + 1)) != -1; i++) {
                        index.add(i);
                    }

                    Iterator iterator = index.iterator();
                    PeekingIterator peekingIterator = Iterators.peekingIterator(iterator);
                    while (peekingIterator.hasNext()) {
                        int i = (int) peekingIterator.next();
                        if (peekingIterator.hasNext()) {
                            int next = (int) peekingIterator.peek();
                            System.out.println(title.substring(i, next).replaceAll("::", ""));
                        }else{
                            System.out.println(title.substring(i).replaceAll("::", ""));
                        }
                    }
                }else{
                    System.out.println(title);
                }
                break;
            case ANNOUNCER:
                if (title.contains("::")) {
                    ArrayList<Integer> index = new ArrayList<>();
                    index.add(0);
                    for (int i = -1; (i = title.indexOf("::", i + 1)) != -1; i++) {
                        index.add(i);
                    }

                    Iterator iterator = index.iterator();
                    PeekingIterator peekingIterator = Iterators.peekingIterator(iterator);
                    while (peekingIterator.hasNext()) {
                        int i = (int) peekingIterator.next();
                        if (peekingIterator.hasNext()) {
                            int next = (int) peekingIterator.peek();
                            System.out.println("! " + title.substring(i, next).replaceAll("::", "") + " !");
                        }else{
                            System.out.println("! " + title.substring(i).replaceAll("::", "") + " !");
                        }
                    }
                }else{
                    System.out.println("! " + title + " !");
                }
                break;
            case TIP:
                if (title.contains("::")) {
                    ArrayList<Integer> index = new ArrayList<>();
                    index.add(0);
                    for (int i = -1; (i = title.indexOf("::", i + 1)) != -1; i++) {
                        index.add(i);
                    }

                    Iterator iterator = index.iterator();
                    PeekingIterator peekingIterator = Iterators.peekingIterator(iterator);
                    while (peekingIterator.hasNext()) {
                        int i = (int) peekingIterator.next();
                        if (peekingIterator.hasNext()) {
                            int next = (int) peekingIterator.peek();
                            System.out.println("? [" + title.substring(i, next).replaceAll("::", "") + "] !");
                        }else{
                            System.out.println("? [" + title.substring(i).replaceAll("::", "") + "] !");
                        }
                    }
                }else{
                    System.out.println("? [" + title + "] !");
                }
                break;
        }
    }

    private void printOptions() {
        if (!(items.size() <= 0)) {
            if (!hasFlag(StoryItemFlag.INVISIBLE_ITEMS)) {
                System.out.println("-----Optionen------\n");
                for (int i = 0; i < items.size(); i++) {
                    System.out.println(i + 1 + " -> " + items.get(i, 1));
                }
                System.out.println("\n------------------\n");
            }
        }
    }

    public void print(StoryManager manager) {
        printTitle();
        printOptions();
        if (hasFlag(StoryItemFlag.TIMER)) {
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    manager.setCurrentItem((StoryItem) getBasicItems().first(2));
                    manager.print();
                }
            }, 1000*timerDuration);
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

}
