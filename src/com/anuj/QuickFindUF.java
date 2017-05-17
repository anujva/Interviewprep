/*
 * Copyright (c) 2016 GE. All Rights Reserved.
 * GE Confidential: Restricted Internal Distribution
 */
package com.anuj;

public class QuickFindUF {
  int[] arr;

  public QuickFindUF(int[] arr) {
    this.arr = arr;
    for (int i = 0; i < arr.length; i++) {
      this.arr[i] = i;
    }
  }

  public boolean connected(int p, int q) {
    return arr[p] == arr[q];
  }

  public void union(int p, int q) {

  }
}
