/*
 * Copyright (c) 2016 GE. All Rights Reserved.
 * GE Confidential: Restricted Internal Distribution
 */
package com.anuj;

public class UnionFind {
  int[] id;
  int[] size;

  public UnionFind(int numOfElements) {
    id = new int[numOfElements];
    size = new int[numOfElements];
    for (int i = 0; i < numOfElements; i++) {
      id[i] = i;
      size[i] = 1;
    }
  }

  public boolean union(int p, int q) {
    //does it make sense to check if the nodes are connected.
    //before actually connecting it.
    if (size[p] > size[q]) {
      id[q] = p;
      size[p] += size[q];
    } else {
      id[p] = q;
      size[q] += p;
    }
    return true;
  }

  public boolean connected(int p, int q) {
    if (parent(p) == parent(q)) {
      return true;
    }
    return false;
  }

  private int parent(int p) {
    while (id[p] != p) {
      p = id[p];
    }
    return p;
  }
}
