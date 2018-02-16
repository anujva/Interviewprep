package com.anuj;

import java.util.ArrayList;
import java.util.Arrays;

public class MinTriangleDepth {

  public static void main(String[] args) {
    ArrayList<ArrayList<Integer>> input = new ArrayList<>();
    int num = 1;
    for (int i = 0; i < 4; i++) {
      input.add(new ArrayList<>());
      for (int j = 0; j <= i; j++) {
        input.get(i).add(num++);
      }
    }

    System.out.println(minTriangleDepth(input));
  }

  public static int minTriangleDepth(ArrayList<ArrayList<Integer>> input) {
    ArrayList<ArrayList<Integer>> minTriangle = new ArrayList<>();
    minTriangle.add(new ArrayList<>(Arrays.asList(input.get(0).get(0))));
    for (int i = 1; i < input.size(); i++) {
      minTriangle.add(new ArrayList<>());
      for (int j = 0; j < input.get(i).size(); j++) {
        //I will look at the current cell for minTriangle that I am
        //trying to populate. And then I will create
        if (j - 1 > -1 && j < input.get(i - 1).size()) {
          minTriangle.get(i).add(Math.min(minTriangle.get(i - 1).get(j - 1),
              minTriangle.get(i - 1).get(j)) + input.get(i).get(j));
        } else if (j - 1 > -1) {
          minTriangle.get(i).add(minTriangle.get(i - 1).get(j - 1) + input.get(i).get(j));
        } else if (j < input.get(i - 1).size()) {
          minTriangle.get(i).add(minTriangle.get(i - 1).get(j) + input.get(i).get(j));
        }
      }
    }
    //find the minimum value in the last row and return that
    int minimum = minTriangle.get(minTriangle.size() - 1).get(0);
    for (int i = 1; i < minTriangle.get(minTriangle.size() - 1).size(); i++) {
      if (minimum > minTriangle.get(minTriangle.size() - 1).get(i)) {
        minimum = minTriangle.get(minTriangle.size() - 1).get(i);
      }
    }
    return minimum;
  }
}