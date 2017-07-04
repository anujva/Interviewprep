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
        size = 0;
    }

    public static void main(String[] args) {

    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public void enqueue(Item item) {
        nodes[size] = item;
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
