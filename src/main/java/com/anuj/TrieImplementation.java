/*
 * Copyright (c) 2016 GE. All Rights Reserved.
 * GE Confidential: Restricted Internal Distribution
 */
package com.anuj;

import java.util.HashMap;

public class TrieImplementation {
    // java.util.* has been imported for this problem.
    // You don't need any other imports.

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insertWord("First");
        trie.insertWord("Fir");

        System.out.println(trie.searchPrefix("Fir"));
        System.out.println(trie.searchPrefix("Firs"));
        System.out.println(trie.searchPrefix("First"));
        System.out.println(trie.searchWord("First"));
        System.out.println(trie.searchWord("Fir"));
        System.out.println(trie.searchWord("Firs"));

        trie.insertWord("");
        System.out.println(trie.searchWord(""));
    }

    static class TrieNode {
        Character c;
        Boolean isLeaf = false;
        HashMap<Character, TrieNode> children = new HashMap<>();

        public TrieNode() {
        }

        public TrieNode(Character c) {
            this.c = c;
        }
    }

    static class Trie {
        private TrieNode root;

        // Implement these methods :
        public Trie() {
        }

        public void insertWord(String word) {
            if (word == null || word.length() == 0) {
                return;
            }
            if (root == null) {
                root = new TrieNode();
            }
            TrieNode temp = root;
            for (int i = 0; i < word.length(); i++) {
                if (temp.children == null) {
                    temp.children = new HashMap<>();
                }
                if (temp.children.containsKey(word.charAt(i))) {
                    temp = temp.children.get(word.charAt(i));
                } else {
                    temp.children.put(word.charAt(i), new TrieNode(word.charAt(i)));
                    temp = temp.children.get(word.charAt(i));
                }
            }
            //after this loop, temp will have pointer to the last node
            temp.isLeaf = true;
        }

        public Boolean searchWord(String word) {
            TrieNode temp = root;
            if (temp.children == null) {
                return false;
            }
            for (int i = 0; i < word.length(); i++) {
                if (temp.children.containsKey(word.charAt(i))) {
                    temp = temp.children.get(word.charAt(i));
                } else {
                    return false;
                }
            }
            if (temp.isLeaf == true) {
                return true;
            }

            return false;
        }

        public Boolean searchPrefix(String word) {
            TrieNode temp = root;
            if (temp.children == null) {
                return false;
            }
            for (int i = 0; i < word.length(); i++) {
                if (temp.children.containsKey(word.charAt(i))) {
                    temp = temp.children.get(word.charAt(i));
                } else {
                    return false;
                }
            }
            return true;
        }
    }
}
