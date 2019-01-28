package io.github.SameplayerDE.AnnotationsEventSystem.Classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class StoryLoader {

    public HashSet<StoryItem> storyItemHashSet;

    public StoryLoader() {
        storyItemHashSet = new HashSet<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File("src/story.txt")));

            String line = "";
            ArrayList<String> item = new ArrayList<>();
            boolean done = false;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                if (line.startsWith("#BEGIN")) {
                    item.add(line);
                }else if (!line.startsWith("#END")) {
                    item.add(line);
                }else{
                    item.add(line);
                    done = true;
                }
                if (done) {

                    int ID = -1;
                    StoryItem storyItem = null;
                    String title = null;
                    HashMap<Integer, String> sub = new HashMap<>();

                    for (String s : item) {
                        if (s.startsWith("#BEGIN")) {
                            ID = Integer.parseInt(s.substring(7));
                        }
                        if (s.startsWith("#TITLE")) {
                            title = s.substring(7);
                        }
                        if (s.startsWith("#ITEM")) {
                            sub.put(Integer.parseInt(s.substring(6, 9)), s.substring(10));
                        }
                        if (s.startsWith("#END")) {
                            if (Integer.valueOf(s.substring(5)) == ID) {
                                storyItem = new StoryItem(ID,  title);
                                for (Integer id : sub.keySet()) {
                                    storyItem.add(id, sub.get(id));
                                }
                                storyItemHashSet.add(storyItem);
                            }
                        }
                    }
                    item.clear();
                    done = false;
                }
            }

            for (StoryItem storyItem : storyItemHashSet) {
                System.out.println(storyItem.getTitle() + " - " + storyItem.getID());
                for (Integer value : storyItem.getItems().keySet()) {
                    System.out.println(" ---> " + value + ": " + storyItem.getItems().get(value));
                }
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}
