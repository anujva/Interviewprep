package com.anuj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraShortestPath {

    public static void main(String[] args) {

    }

    public static List<Vertex> getShortestPath(Vertex source, Vertex target) {
        PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>();
        source.minDistance = 0;
        priorityQueue.add(source);
        HashSet<Vertex> visitedVertex = new HashSet<>();
        while (!priorityQueue.isEmpty()) {
            //get the top of the priority queue.
            Vertex currentVertex = priorityQueue.poll();
            if (currentVertex == target) {
                break;
            }
            //update the distances of all the adjacent nodes
            for (Edge adjEdge : currentVertex.adjacencies) {
                double distance = adjEdge.weight + currentVertex.minDistance;
                if (distance < adjEdge.target.minDistance) {
                    adjEdge.target.minDistance = distance;
                    adjEdge.target.previous = currentVertex;
                }
                if (!visitedVertex.contains(adjEdge.target)) {
                    priorityQueue.add(adjEdge.target);
                }
            }
            visitedVertex.add(currentVertex);
        }
        //the target is either found and updated with min distance
        //by now. Or its not present.
        if (target.minDistance == Double.POSITIVE_INFINITY) {
            return null;
        }
        List<Vertex> nodesOnPath = new ArrayList<>();
        Vertex vertex = target;
        while (vertex != source) {
            nodesOnPath.add(vertex);
            vertex = vertex.previous;
        }
        nodesOnPath.add(source);
        Collections.reverse(nodesOnPath);
        return nodesOnPath;
    }


    private static class Vertex implements Comparable<Vertex> {

        public final String name;
        public Edge[] adjacencies;
        public double minDistance = Double.POSITIVE_INFINITY;
        public Vertex previous; // Previous optimal path node

        public Vertex(String argName) {
            name = argName;
        }

        public String toString() {
            return name;
        }

        public int compareTo(Vertex other) {
            return Double.compare(minDistance, other.minDistance);
        }
    }

    private static class Edge {

        public final Vertex target; // Target node of the edge
        public final double weight; // Edge weight

        public Edge(Vertex argTarget, double argWeight) {
            target = argTarget;
            weight = argWeight;
        }
    }
}
