
package com.anuj;

import java.util.HashMap;
import java.util.Scanner;

public class SockMerchant {
    public static void main(String [] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c[] = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int c_i=0; c_i < n; c_i++){
            c[c_i] = in.nextInt();
            if(map.containsKey(c[c_i])) {
                map.put(c[c_i], map.get(c[c_i])+1);
            }else {
                map.put(c[c_i], 1);
            }
        }
        int countPairs = 0;
        for(Integer val : map.values()) {
            countPairs += val/2;
        }

        System.out.println(countPairs);
    }
}
