package io.github.SameplayerDE.AnnotationsEventSystem.Classes;

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
        currentItem.print();
    }

    public StoryItem getCurrentItem() {
        return currentItem;
    }

    public StoryItem getLastItem() {
        return lastItem;
    }
}
