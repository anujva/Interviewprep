/*
 * Copyright (c) 2016 GE. All Rights Reserved.
 * GE Confidential: Restricted Internal Distribution
 */
package com.anuj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Objects;

public class Prefix {
  public static void main(String[] args) {
    ArrayList<String> a = new ArrayList<>(Arrays.asList("zebra", "dog", "duck", "dot"));
    ArrayList<String> prefixValues = prefix(a);
    System.out.println(prefixValues);
  }

  public static ArrayList<String> prefix(ArrayList<String> a) {
    Trie trie = new Trie(a);
    StringBuffer buffer = new StringBuffer("");
    StringBuffer bufferForLast = new StringBuffer("");
    LinkedHashMap<String, String> listOfPrefixes = new LinkedHashMap<>();
    for (int i = 0; i < a.size(); i++) {
      listOfPrefixes.put(a.get(i), null);
    }
    getAllStringPrefixes(trie.root, buffer, bufferForLast, listOfPrefixes);
    return new ArrayList(listOfPrefixes.values());
  }

  private static void getAllStringPrefixes(Node node, StringBuffer buffer, StringBuffer bufferForLast,
      LinkedHashMap<String, String> listOfPrefixes) {
    HashMap<Character, Node> children = node.children;
    if (children.size() > 1) {
      //this is the point where you grow the buffer.
      for (Character charValues : children.keySet()) {
        StringBuffer oldBufferValue = new StringBuffer(buffer);
        buffer.append(charValues);
        bufferForLast = new StringBuffer(buffer);
        getAllStringPrefixes(children.get(charValues), buffer, bufferForLast, listOfPrefixes);
        buffer = oldBufferValue;
      }
    } else if (children.size() == 1) {
      Node currentNode = children.values().iterator().next();
      buffer.append(currentNode.value);
      getAllStringPrefixes(currentNode, buffer, bufferForLast, listOfPrefixes);
    } else if (children.size() == 0) {
      listOfPrefixes.put(buffer.toString(), bufferForLast.toString());
    }
  }

  private static class Trie {
    Node root;

    public Trie(ArrayList<String> a) {
      root = new Node();
      for (int i = 0; i < a.size(); i++) {
        buildTrie(root, a.get(i));
      }
    }

    private static void buildTrie(Node root, String string) {
      Node currentNode = root;
      for (int i = 0; i < string.length(); i++) {
        if (currentNode.children.containsKey(string.charAt(i))) {
          currentNode = currentNode.children.get(string.charAt(i));
        } else {
          Node node = new Node(string.charAt(i));
          currentNode.children.put(string.charAt(i), node);
          currentNode = node;
        }
      }
    }

    @Override
    public String toString() {
      return "Trie{" + "root=" + root + '}';
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Trie trie = (Trie)o;
      return Objects.equals(root, trie.root);
    }

    @Override
    public int hashCode() {
      return Objects.hash(root);
    }
  }

  private static class Node {
    char value;
    HashMap<Character, Node> children;

    public Node() {
      children = new HashMap<>();
    }

    public Node(char value) {
      this.value = value;
      children = new HashMap<>();
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Node node = (Node)o;
      return value == node.value && Objects.equals(children, node.children);
    }

    @Override
    public int hashCode() {
      return Objects.hash(value, children);
    }

    @Override
    public String toString() {
      return "Node{" + "value=" + value + ", children=" + children + '}';
    }
  }
}
