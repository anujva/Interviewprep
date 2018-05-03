package com.anuj;

import static com.anuj.TrieImplementation.Trie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class BoggleSearchWithDictionary {

  public static void main(String[] args) {
    Trie trie = new Trie();
    trie.insertWord("FIRECODE");
    trie.insertWord("IS");
    trie.insertWord("THE");
    char[][] board = new char[][]{
        {'A', 'F', 'A', 'J'},
        {'S', 'I', 'V', 'A'},
        {'E', 'R', 'O', 'C'},
        {'C', 'X', 'E', 'K'},
        {'O', 'D', 'F', 'T'},
        {'D', 'E', 'E', 'H'}
    };
    ArrayList<String> foundWords = boggleSearchWithDict(board, trie);
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
          boggleSearchWithDictSubroutine(board, new StringBuffer(buffer), rowIdx + 1, colIdx,
              foundWords, new HashSet<>(indexesVisited), dictionary);
        }
        if (!indexesVisited.contains((rowIdx - 1) + "," + colIdx)) {
          boggleSearchWithDictSubroutine(board, new StringBuffer(buffer), rowIdx - 1, colIdx,
              foundWords, new HashSet<>(indexesVisited), dictionary);
        }
        if (!indexesVisited.contains(rowIdx + "," + (colIdx + 1))) {
          boggleSearchWithDictSubroutine(board, new StringBuffer(buffer), rowIdx, colIdx + 1,
              foundWords, new HashSet<>(indexesVisited), dictionary);
        }
        if (!indexesVisited.contains(rowIdx + "," + (colIdx - 1))) {
          boggleSearchWithDictSubroutine(board, new StringBuffer(buffer), rowIdx, colIdx - 1,
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
}
