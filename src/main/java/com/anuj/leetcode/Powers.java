package com.anuj.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Powers {
    public static void main(String[] args) {
        System.out.println(new Powers().myPow(2, 10));
    }

    public double myPow(double x, int n) {
        if(n == 0) return 1.0;
        double answer = 1.0;
        for(int i=0; i < n; i++) {
            answer *= x;
        }
        return answer;
    }

    public double myPow(double x, int n, Map<Integer, Double> storedPowers) {
        if(n == 0) return 1;
        if(n == 1) return x;
        if(storedPowers.containsKey(n)) return storedPowers.get(n);
        else {
            double answer = myPow(x, n-1, storedPowers);
            storedPowers.put(n, answer*x);
            return answer*x;
        }
    }
}
