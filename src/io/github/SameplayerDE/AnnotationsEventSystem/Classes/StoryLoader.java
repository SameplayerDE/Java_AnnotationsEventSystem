package io.github.SameplayerDE.AnnotationsEventSystem.Classes;

import io.github.SameplayerDE.AnnotationsEventSystem.Enums.StoryItemField;
import io.github.SameplayerDE.AnnotationsEventSystem.Enums.StoryItemFileField;
import io.github.SameplayerDE.AnnotationsEventSystem.Enums.StoryItemFlag;
import io.github.SameplayerDE.AnnotationsEventSystem.Enums.StoryItemMessageType;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class StoryLoader {

    public HashSet<StoryItem> storyItemHashSet;
    private final String storyFilePath = "story.txt";

    private boolean storyFileRead = false;
    private ArrayList<String> storyFileContent;

    public StoryLoader() {

        storyItemHashSet = new HashSet<>();
        storyFileContent = new ArrayList<>();

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream(storyFilePath)));
            String line = "";
            while ((line = reader.readLine()) != null) {
                //System.out.println("READER -> " + line);
                storyFileContent.add(line);
            }
            storyFileRead = true;
            readContent();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void readContent() {

        ArrayList<String> item = new ArrayList<>();
        boolean done = false;

        for (String line : storyFileContent) {
            //System.out.println(line);
            if (line.startsWith(StoryItemFileField.BEGIN)) {
                item.add(line);
            } else if (!line.startsWith(StoryItemFileField.END)) {
                item.add(line);
            } else {
                item.add(line);
                done = true;
            }
            if (done) {

                int ID = -1;
                StoryItem storyItem = null;
                String title = null;
                HashMap<Integer, String> sub = new HashMap<>();

                for (String s : item) {
                    if (s.startsWith(StoryItemFileField.BEGIN)) {
                        ID = Integer.parseInt(s.substring(7));
                    }
                    if (s.startsWith(StoryItemFileField.TITLE)) {
                        title = s.substring(7);
                        storyItem = new StoryItem(ID, title);
                    }
                    if (s.startsWith(StoryItemFileField.TYPE)) {
                        //sub.put(Integer.parseInt(s.substring(6, 9)), s.substring(10));
                        storyItem.setMessageType(StoryItemMessageType.valueOf(s.substring(9).toUpperCase()));
                    }
                    if (s.startsWith(StoryItemFileField.ITEM)) {
                        //sub.put(Integer.parseInt(s.substring(6, 9)), s.substring(10));
                        int key = storyItem.getBasicItems().size();
                        int subID = Integer.parseInt(s.substring(6, 9));
                        String text = "";
                        if (s.length() < 10) {
                            text = "EMPTY";
                        }else{
                           text = s.substring(10);
                        }
                        storyItem.add(key, StoryItemField.ID, subID);
                        storyItem.add(key, StoryItemField.TITLE, text);
                    }
                    if (s.startsWith(StoryItemFileField.FLAG)) {
                        storyItem.addFlag(StoryItemFlag.valueOf(s.substring(6).toUpperCase()));
                    }
                    if (s.startsWith(StoryItemFileField.END)) {
                        if (Integer.valueOf(s.substring(5)) == ID) {
                            storyItemHashSet.add(storyItem);
                        }
                    }
                }
                item.clear();
                sub.clear();
                done = false;
            }
        }

/**
        for (StoryItem storyItem : storyItemHashSet) {
        System.out.println(storyItem.getTitle() + " - " + storyItem.getID());
        for (Integer value : storyItem.getBasicItems().keySet()) {
        System.out.println(" ---> " + value + ": " + storyItem.getBasicItems().get(value));
        }
        }
**/

        polishItems();

    }

    private void polishItems() {
        Iterator<Integer> iterator;
        for (StoryItem item : storyItemHashSet) {
            iterator = item.getBasicItems().keySet().iterator();
            while (iterator.hasNext()) {
                int key = iterator.next();
                int ID = Integer.parseInt(String.valueOf(item.getBasicItems().get(key, 0)));
                item.getBasicItems().put(key, StoryItemField.ITEM, getItemByID(ID));
                //System.out.println("Adding " + ID + " TO " + item.getID());
            }

        }
    }

    public StoryItem readItemByID(int ID) {

        ArrayList<String> item = new ArrayList<>();
        boolean done = false;
        System.out.println("READing -> " + ID);
        for (String line : storyFileContent) {
            //System.out.println("READER -> " + line);
            if (line.startsWith("#BEGIN " + ID)) {
                item.add(line);
            }else if (!line.startsWith("#END " + ID)) {
                item.add(line);
            }else{
                item.add(line);
                done = true;
            }
            if (done) {

                StoryItem storyItem = null;
                String title = null;
                HashMap<Integer, String> sub = new HashMap<>();

                for (String s : item) {
                    if (s.startsWith("#TITLE")) {
                        title = s.substring(7);
                    }
                    if (s.startsWith("#ITEM")) {
                        sub.put(Integer.parseInt(s.substring(6, 9)), s.substring(10));
                    }
                    if (s.startsWith("#END")) {
                        storyItem = new StoryItem(ID,  title);
                        for (Integer id : sub.keySet()) {
                            //storyItem.add(id, readItemByID(id));
                            System.out.println(id + "");
                            readItemByID(id);
                            //System.out.println(readItemByID(id).getTitle());
                        }
                        //storyItemHashSet.add(storyItem);
                        return storyItem;
                    }
                }
                item.clear();
                done = false;
            }
        }

        /**for (StoryItem storyItem : storyItemHashSet) {
         System.out.println(storyItem.getTitle() + " - " + storyItem.getID());
         for (Integer value : storyItem.getItems().keySet()) {
         System.out.println(" ---> " + value + ": " + storyItem.getItems().get(value));
         }
         }**/

        return null;
    }

    public StoryItem getItemByID(int ID) {
        for (StoryItem item : storyItemHashSet) {
            if (item.getID() == ID) {
                return item;
            }
            continue;
        }
        return null;
    }

}
