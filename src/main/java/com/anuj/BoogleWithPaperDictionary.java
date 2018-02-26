package com.anuj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class BoogleWithPaperDictionary {

    public static void main(String[] args) {
        char[][] board = new char[][]{
            {'A', 'F', 'A', 'J'},
            {'S', 'I', 'V', 'A'},
            {'E', 'R', 'O', 'C'},
            {'C', 'X', 'L', 'K'},
            {'O', 'D', 'L', 'T'},
            {'D', 'E', 'E', 'H'}
        };
        ArrayList<String> dictionary = new ArrayList<>(Arrays.asList(
            "HELLO", "HOW", "ARE", "YOU"
        ));
        ArrayList<String> foundWords = boggleByot(board, dictionary);
        System.out.println(foundWords);
    }

    public static void boggleSearchWithDictSubroutine(char[][] board,
        StringBuffer buffer, int rowIdx, int colIdx, HashSet<String>
        foundWords, HashSet<String> indexesVisited, Trie dictionary) {
        if (rowIdx > -1 && colIdx > -1 && rowIdx < board.length &&
            colIdx < board[0].length) {
            //whatever is there in the buffer.. concat the value
            // of the current index here.
            buffer.append(board[rowIdx][colIdx]);
            //Take the Trie implementation and see if the prefix matches.
            //and returns true. otherwise there is no need of starting a
            //recursion
            if (dictionary.searchPrefix(buffer.toString())) {
                if (dictionary.searchWord(buffer.toString())) {
                    //we have actually found a word.. add it to the list.
                    foundWords.add(buffer.toString());
                }
                //we should continue searching.. since it might be that we will
                //find another word.
                indexesVisited.add(rowIdx + "," + colIdx);
                if (!indexesVisited.contains((rowIdx + 1) + "," + colIdx)) {
                    boggleSearchWithDictSubroutine(board, new StringBuffer(buffer), rowIdx + 1,
                        colIdx,
                        foundWords, new HashSet<>(indexesVisited), dictionary);
                }
                if (!indexesVisited.contains((rowIdx - 1) + "," + colIdx)) {
                    boggleSearchWithDictSubroutine(board, new StringBuffer(buffer), rowIdx - 1,
                        colIdx,
                        foundWords, new HashSet<>(indexesVisited), dictionary);
                }
                if (!indexesVisited.contains(rowIdx + "," + (colIdx + 1))) {
                    boggleSearchWithDictSubroutine(board, new StringBuffer(buffer), rowIdx,
                        colIdx + 1,
                        foundWords, new HashSet<>(indexesVisited), dictionary);
                }
                if (!indexesVisited.contains(rowIdx + "," + (colIdx - 1))) {
                    boggleSearchWithDictSubroutine(board, new StringBuffer(buffer), rowIdx,
                        colIdx - 1,
                        foundWords, new HashSet<>(indexesVisited), dictionary);
                }
            }
        }
    }

    public static ArrayList<String> boggleSearchWithDict(char[][] board,
        Trie dictionary) {
        HashSet<String> foundWords = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                StringBuffer buffer = new StringBuffer();
                HashSet<String> indexes = new HashSet<>();
                boggleSearchWithDictSubroutine(board, buffer, i, j,
                    foundWords, indexes, dictionary);
            }
        }
        ArrayList<String> foundWordsList = new ArrayList<>();
        foundWordsList.addAll(foundWords);
        Collections.sort(foundWordsList);
        return foundWordsList;
    }

    public static ArrayList<String> boggleByot(char[][] board,
        ArrayList<String> dictionary) {
        Trie trie = new Trie();
        for (String dictWord : dictionary) {
            trie.insertWord(dictWord);
        }

        return boggleSearchWithDict(board, trie);
    }

    static class TrieNode {

        Character c;
        Boolean isLeaf = false;
        HashMap<Character, TrieImplementation.TrieNode> children = new HashMap<>();

        public TrieNode() {
        }

        public TrieNode(Character c) {
            this.c = c;
        }
    }

    static class Trie {

        private TrieImplementation.TrieNode root;

        // Implement these methods :
        public Trie() {
        }

        public void insertWord(String word) {
            if (word == null || word.length() == 0) {
                return;
            }
            if (root == null) {
                root = new TrieImplementation.TrieNode();
            }
            TrieImplementation.TrieNode temp = root;
            for (int i = 0; i < word.length(); i++) {
                if (temp.children == null) {
                    temp.children = new HashMap<>();
                }
                if (temp.children.containsKey(word.charAt(i))) {
                    temp = temp.children.get(word.charAt(i));
                } else {
                    temp.children
                        .put(word.charAt(i), new TrieImplementation.TrieNode(word.charAt(i)));
                    temp = temp.children.get(word.charAt(i));
                }
            }
            //after this loop, temp will have pointer to the last node
            temp.isLeaf = true;
        }

        public Boolean searchWord(String word) {
            TrieImplementation.TrieNode temp = root;
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
            TrieImplementation.TrieNode temp = root;
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
