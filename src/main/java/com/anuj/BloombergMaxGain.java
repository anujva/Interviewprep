
package com.anuj;

public class BloombergMaxGain {
    public static void main(String[] args) {
        int [] a = new int[] {
            4, 5, 6, 7, 1, 6
        };
        System.out.println(maxGain(a));
    }

    public static int maxGain(int[] a) {
        if (a == null) {
            return 0;
        }
        int gain = 0;
        int min = a[0];

        for (int i = 0; i < a.length; i++) {
            if (min > a[i]) {
                min = a[i];
            }
            int currentGain = a[i] - min;
            if (currentGain > gain) {
                gain = currentGain;
            }
        }

        return gain;
    }
}
