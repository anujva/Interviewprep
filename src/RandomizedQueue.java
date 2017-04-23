/*
 * Copyright (c) 2016 GE. All Rights Reserved.
 * GE Confidential: Restricted Internal Distribution
 */

import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item> {
  private static final int INITIAL_SIZE = 10;
  Object[] nodes;
  private int size;

  public RandomizedQueue() {
    nodes = new Object[INITIAL_SIZE];
  }

  public static void main(String[] args) {

  }

  public boolean isEmpty() {

    return false;
  }

  public int size() {

    return 0;
  }

  public void enqueue(Item item) {

  }

  public Item dequeue() {
    return null;
  }

  public Item sample() {

    return null;
  }

  @Override
  public Iterator<Item> iterator() {
    return null;
  }
}
