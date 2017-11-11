
package com.anuj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class JourneyToTheMoon {
  public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();
    int P = scanner.nextInt();
    WeightedQuickUnionUF unionUF = new WeightedQuickUnionUF(N);
    while (P > 0) {
      int n1 = scanner.nextInt();
      int n2 = scanner.nextInt();
      unionUF.union(n1, n2);
      P--;
    }

    HashMap<Integer, ArrayList<Integer>> groups = new HashMap<>();

    for (int i = 0; i < N; i++) {
      int leader = unionUF.find(i);
      if (groups.containsKey(leader)) {
        groups.get(leader).add(i);
      } else {
        ArrayList<Integer> group = new ArrayList<>();
        group.add(i);
        groups.put(leader, group);
      }
    }

    //we have the groups
    int permutations = 0;
    ArrayList<ArrayList<Integer>> valuesAsList = new ArrayList<>();
    for (ArrayList<Integer> values : groups.values()) {
      valuesAsList.add(values);
    }

    for (int i = 0; i < valuesAsList.size(); i++) {
      for (int j = i + 1; j < valuesAsList.size(); j++) {
        permutations += valuesAsList.get(i).size() * valuesAsList.get(j).size();
      }
    }
    System.out.println(permutations);
  }

  private static class WeightedQuickUnionUF {
    private int[] parent;   // parent[i] = parent of i
    private int[] size;     // size[i] = number of sites in subtree rooted at i
    private int count;      // number of components

    /**
     * Initializes an empty union–find data structure with {@code n} sites
     * {@code 0} through {@code n-1}. Each site is initially in its own
     * component.
     *
     * @param n the number of sites
     * @throws IllegalArgumentException if {@code n < 0}
     */
    public WeightedQuickUnionUF(int n) {
      count = n;
      parent = new int[n];
      size = new int[n];
      for (int i = 0; i < n; i++) {
        parent[i] = i;
        size[i] = 1;
      }
    }

    /**
     * Returns the number of components.
     *
     * @return the number of components (between {@code 1} and {@code n})
     */
    public int count() {
      return count;
    }

    /**
     * Returns the component identifier for the component containing site {@code p}.
     *
     * @param p the integer representing one object
     * @return the component identifier for the component containing site {@code p}
     * @throws IndexOutOfBoundsException unless {@code 0 <= p < n}
     */
    public int find(int p) {
      validate(p);
      while (p != parent[p]) {
        p = parent[p];
      }
      return p;
    }

    // validate that p is a valid index
    private void validate(int p) {
      int n = parent.length;
      if (p < 0 || p >= n) {
        throw new IndexOutOfBoundsException("index " + p + " is not between 0 and " + (n - 1));
      }
    }

    /**
     * Returns true if the the two sites are in the same component.
     *
     * @param p the integer representing one site
     * @param q the integer representing the other site
     * @return {@code true} if the two sites {@code p} and {@code q} are in the same component;
     * {@code false} otherwise
     * @throws IndexOutOfBoundsException unless
     *                                   both {@code 0 <= p < n} and {@code 0 <= q < n}
     */
    public boolean connected(int p, int q) {
      return find(p) == find(q);
    }

    /**
     * Merges the component containing site {@code p} with the
     * the component containing site {@code q}.
     *
     * @param p the integer representing one site
     * @param q the integer representing the other site
     * @throws IndexOutOfBoundsException unless
     *                                   both {@code 0 <= p < n} and {@code 0 <= q < n}
     */
    public void union(int p, int q) {
      int rootP = find(p);
      int rootQ = find(q);
      if (rootP == rootQ) {
        return;
      }

      // make smaller root point to larger one
      if (size[rootP] < size[rootQ]) {
        parent[rootP] = rootQ;
        size[rootQ] += size[rootP];
      } else {
        parent[rootQ] = rootP;
        size[rootP] += size[rootQ];
      }
      count--;
    }
  }
}
