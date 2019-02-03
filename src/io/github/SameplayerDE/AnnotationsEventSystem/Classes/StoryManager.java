package io.github.SameplayerDE.AnnotationsEventSystem.Classes;

import io.github.SameplayerDE.AnnotationsEventSystem.Events.Event;
import io.github.SameplayerDE.AnnotationsEventSystem.Events.StoryEvents.StoryItemPrintEvent;

public class StoryManager {

    private StoryItem currentItem;
    private StoryItem lastItem;
    private int lastOption;
    private StoryLoader storyLoader;
    
    public StoryManager(StoryLoader loader) {
    
        this.storyLoader = loader;
        currentItem = loader.getItemByID(0);
    }

    public void setCurrentItem(StoryItem item) {
        this.lastItem = this.currentItem;
        this.currentItem = item;
    }

    public void print() {
        currentItem.print(this);
        storyLoader.getGame().getGameManager().callEvent(new StoryItemPrintEvent(currentItem.getID()));
    }

    public StoryItem getCurrentItem() {
        return currentItem;
    }

    public StoryItem getLastItem() {
        return lastItem;
    }
}
