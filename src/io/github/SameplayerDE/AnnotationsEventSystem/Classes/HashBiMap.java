package io.github.SameplayerDE.AnnotationsEventSystem.Classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class HashBiMap<K> {

    HashMap<K, Object[]> saves;
    Object[] values;

    public HashBiMap() {
        values = new Object[999];
        saves = new HashMap<>();
    }

    public void put(K key, int position, Object value) {
        values = saves.containsKey(key) ? saves.get(key) : new Object[999];
        values[position] = value;
        saves.put(key, values);
    }

    public void put(K key, Object... value) {
        values = value;
        saves.put(key, values);
    }

    public Object first(int position) {
        K key = saves.entrySet().iterator().next().getKey();
        values = saves.containsKey(key) ? saves.get(key) : new Object[999];
        return (!(position > get(key).length)) && saves.containsKey(key) ? saves.entrySet().iterator().next().getValue()[position] : null;
    }

    public int size() {
        return saves.size();
    }

    public Object[] get(K key) {
        values = saves.containsKey(key) ? saves.get(key) : new Object[999];
        return saves.containsKey(key) ? values : null;
    }

    public Set<K> keySet() {
        return saves.keySet();
    }

    public Object get(K key, int position) {
        values = saves.containsKey(key) ? saves.get(key) : new Object[999];
        return (!(position > get(key).length)) && saves.containsKey(key) ? get(key)[position] : null;
    }

}
