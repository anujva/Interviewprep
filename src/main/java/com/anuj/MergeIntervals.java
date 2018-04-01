package com.anuj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Interval implements Cloneable {
    int start;
    int end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "Interval{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }

    @Override
    public Interval clone() {
        return new Interval(this.start, this.end);
    }
}

public class MergeIntervals {
    public static void main(String[] args) {
        ArrayList<Interval> intervals = new ArrayList<>(Arrays.asList(
                new Interval(1, 3),
                new Interval(2, 6),
                new Interval(8, 10),
                new Interval(15, 18)
        ));

        ArrayList<Interval> answer = mergeIntervals(intervals);
        answer.stream().forEach(x -> System.out.println(x));
    }

    public static ArrayList<Interval> mergeIntervals(ArrayList<Interval> intervals) {
        //Sort the merge intervals by the start times.
        Comparator<Interval> comparator = (o1, o2) -> {
            if (o1.start < o2.start) {
                return -1;
            } else if (o1.start > o2.start) {
                return 1;
            } else if (o1.end < o2.end) {
                return -1;
            } else if (o1.end > o2.end) {
                return 1;
            } else {
                //this branch will be reached when o1 and o1 have the same start
                //and end times.
                return 0;
            }
        };

        Collections.sort(intervals, comparator);
        //Now that the collection is sorted, we have the intervals sorted by start time.
        //we will then traverse the intervals and see if the end of the first overlaps with
        //the start of the second.
        ArrayList<Interval> answer = new ArrayList<>();
        Interval current = intervals.get(0).clone();
        answer.add(current);
        for (int i = 1; i < intervals.size(); i++) {
            if (current.end >= intervals.get(i).start) {
                if (current.end < intervals.get(i).end) {
                    current.end = intervals.get(i).end;
                }
            } else {
                current = intervals.get(i).clone();
                answer.add(current);
            }
        }
        return answer;
    }
}
