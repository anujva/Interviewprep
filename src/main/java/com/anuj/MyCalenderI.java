package com.anuj;

import java.util.Map;
import java.util.TreeMap;

public class MyCalenderI {

    Map<Integer, Range> map;

    public MyCalenderI() {
        map = new TreeMap<>();
    }

    public static void main(String[] args) {

    }

    public boolean book(int start, int end) {
        return false;
    }

    private static class Range implements Comparable<Range> {

        private int start;
        private int end;

        public Range(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Range o) {
            return 0;
        }
    }
}
