package com.douglasryoung.ctci.contacts;

import java.util.*;

class PrefixMap {
    private Map<String, List<String>> tree;

    PrefixMap() {
        tree = new HashMap<>();
    }

    public Map<String, List<String>> insert(String word) {
        for (int i = 1; i <= word.length(); i++) {
            String slice = word.substring(0, i);
            tree.compute(slice, (key, value) -> addWord(word, value));
        }

        return tree;
    }

    public int search(String prefix) {
        return tree.getOrDefault(prefix, new LinkedList<>()).size();
    }

    public boolean containsKey(String key) {
        return tree.containsKey(key);
    }

    public List<String> get(String key) {
        return tree.getOrDefault(key, new LinkedList<>());
    }

    private List<String> addWord(String word, List<String> value) {
        if (value == null) {
            value = new LinkedList<>(Collections.singletonList(word));
        } else {
            value.add(word);
        }

        return value;
    }
}
