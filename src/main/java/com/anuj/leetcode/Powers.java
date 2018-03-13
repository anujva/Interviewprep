package com.anuj.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Powers {
    public static void main(String[] args) {
        System.out.println(new Powers().myPow(2, 10));
    }

    public double myPow(double x, int n) {
        Map<Integer, Double> storedPowers = new HashMap<>();
        return myPow(x, x, n, storedPowers);
    }

    public double myPow(double x, double y, int n, Map<Integer, Double> storedPowers) {
        if(n == 0) return 1;
        if(n == 1) return x;
        if(storedPowers.containsKey(n)) return storedPowers.get(n);
        else {
            double answer = myPow(x*y, y, n-1, storedPowers);
            storedPowers.put(n, answer);
            return answer;
        }
    }
}
