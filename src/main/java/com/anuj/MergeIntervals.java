
package com.anuj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Interval {
    int start;
    int end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class MergeIntervals {
    public static void main(String[] args) {

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
        Interval interval = new Interval(intervals.get(0).start, intervals.get(0).end);
        for (int i = 1; i < intervals.size(); i++) {
            if (interval.end >= intervals.get(i).start) {
                if (interval.end < intervals.get(i).end) {
                    interval.end = intervals.get(i).end;
                } // else swallowed
            } else {
                answer.add(interval);
                interval = new Interval(intervals.get(i).start, intervals.get(i).end);
            }
        }
        //was the last interval swallowed/added?
        if (interval.start == intervals.get(intervals.size() - 1).start && interval.end == intervals
            .get(intervals.size() - 1).end) {
            answer.add(interval);
        }
        return answer;
    }
}
