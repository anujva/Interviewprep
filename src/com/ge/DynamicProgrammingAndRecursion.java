/*
 * Copyright (c) 2016 GE. All Rights Reserved.
 * GE Confidential: Restricted Internal Distribution
 */
package com.ge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class will be dedicated to the dynamic programming problems
 * that I will be tackling during my prep work for the facebook interview
 */
public class DynamicProgrammingAndRecursion {
  public static void main(String[] args) {
    ArrayList<Integer> gas = new ArrayList<>(Arrays.asList(1, 2));
    ArrayList<Integer> cost = new ArrayList<>(Arrays.asList(2, 1));
    System.out.println(canCompleteCircuit(gas, cost));
  }

  public static int canCompleteCircuit(final List<Integer> gas, final List<Integer> cost) {
    for (int i = 0; i < cost.size(); i++) {
      //I am going to start from this point
      //can do it with a while loop as well.. what is the better way of achieving this.
      int index = i;
      int currentGas = gas.get(index);
      while (true) {
        if (currentGas >= cost.get(index)) {
          //expend the gas and reach the station.
          currentGas = currentGas - cost.get(index) + gas.get((index + 1) % cost.size());
          index++;
          index = index % cost.size();
          if (index == i) {
            //reached this point.
            return i;
          }
        } else {
          break;
        }
      }
    }
    return -1;
  }
}
