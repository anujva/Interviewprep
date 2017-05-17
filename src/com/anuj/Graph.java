/*
 * Copyright (c) 2016 GE. All Rights Reserved.
 * GE Confidential: Restricted Internal Distribution
 */
package com.anuj;

import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Graph {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    for (int a0 = 0; a0 < t; a0++) {
      HashMap<Integer, HashMap<Integer, Edge>> nodes = new HashMap<>();
      nodes = new HashMap<>();
      nodes.clear();
      int n = in.nextInt();
      for (int i = 0; i < n; i++) {
        nodes.put(i, new HashMap<>());
      }
      int m = in.nextInt();
      for (int a1 = 0; a1 < m; a1++) {
        int x = in.nextInt();
        int y = in.nextInt();
        int r = in.nextInt();
        Edge edge11 = new Edge();
        edge11.connectedNode = y - 1;
        edge11.distance = r;
        if (nodes.get(x - 1).containsKey(y - 1)) {
          //test if the distance of the stored edge is less than current.
          if (edge11.distance < nodes.get(x - 1).get(y - 1).distance) {
            nodes.get(x - 1).put(y - 1, edge11);
          }
        } else {
          nodes.get(x - 1).put(y - 1, edge11);
        }
        Edge edge12 = new Edge();
        edge12.connectedNode = x - 1;
        edge12.distance = r;
        if (nodes.get(y - 1).containsKey(x - 1)) {
          //test if the distance of the stored edge is less than current.
          if (edge12.distance < nodes.get(y - 1).get(x - 1).distance) {
            nodes.get(y - 1).put(x - 1, edge12);
          }
        } else {
          nodes.get(y - 1).put(x - 1, edge12);
        }
      }
      int s = in.nextInt();
      int[] answer = dijkstraForAllNodes(s - 1, nodes);
      for (int i = 0; i < answer.length; i++) {
        if (i != s - 1) {
          System.out.print(answer[i] + " ");
        }
      }
      System.out.println("");
    }

    return;
  }

  private static int[] dijkstraForAllNodes(int startNode, HashMap<Integer, HashMap<Integer, Edge>> nodes) {
    HashSet<Integer> visitedNodes = new HashSet<>();
    NodeWithWeight[] distanceValuesFromStart = new NodeWithWeight[nodes.size()];
    for (int i = 0; i < nodes.size(); i++) {
      distanceValuesFromStart[i] = new NodeWithWeight();
      distanceValuesFromStart[i].index = i;
      distanceValuesFromStart[i].distanceFromStart = Integer.MAX_VALUE;
      if (i == startNode) {
        distanceValuesFromStart[i].distanceFromStart = 0;
      }
    }
    PriorityQueue<NodeWithWeight> deque = new PriorityQueue<>();
    deque.add(distanceValuesFromStart[startNode]);
    while (!deque.isEmpty()) {
      int currentNode = deque.remove().index;
      if (!visitedNodes.contains(currentNode)) {
        HashMap<Integer, Edge> connectedNodes = nodes.get(currentNode);
        //put all connected nodes in a queue.
        visitedNodes.add(currentNode);
        //update the distance array
        for (Edge connectedNode : connectedNodes.values()) {
          if (distanceValuesFromStart[currentNode].distanceFromStart + connectedNode.distance
              < distanceValuesFromStart[connectedNode.connectedNode].distanceFromStart) {
            distanceValuesFromStart[connectedNode.connectedNode].distanceFromStart =
                distanceValuesFromStart[currentNode].distanceFromStart + connectedNode.distance;
          }
          deque.add(distanceValuesFromStart[connectedNode.connectedNode]);
        }
      }
    }
    int[] values = new int[nodes.size()];
    for (int i = 0; i < distanceValuesFromStart.length; i++) {
      values[i] = distanceValuesFromStart[i].distanceFromStart == Integer.MAX_VALUE
          ? -1
          : distanceValuesFromStart[i].distanceFromStart;
    }
    return values;
  }

  private static class Edge implements Comparable<Edge> {
    int connectedNode;
    int distance;

    @Override
    public int compareTo(Edge o) {
      return Integer.compare(this.distance, o.distance);
    }
  }

  private static class NodeWithWeight implements Comparable<NodeWithWeight> {
    int index;
    int distanceFromStart;

    @Override
    public int compareTo(NodeWithWeight o) {
      return Integer.compare(this.distanceFromStart, o.distanceFromStart);
    }
  }
}
