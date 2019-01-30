package io.github.SameplayerDE.AnnotationsEventSystem.Classes;

public class StoryManager {

    private StoryItem currentItem;
    private int lastOption;
    private StoryLoader storyLoader;
    
    public StoryManager(StoryLoader loader) {
    
        storyLoader = loader;
    
    }

}
