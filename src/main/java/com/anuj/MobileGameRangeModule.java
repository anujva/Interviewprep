package com.anuj;

import java.util.ArrayList;
import java.util.Arrays;

public class MobileGameRangeModule {
    public static void main(String[] args) {
        ArrayList<Interval> intervalList = new ArrayList<>(Arrays.asList(new Interval(0, 1), new Interval(4, 5)));
//        ArrayList<Interval> intervalList = new ArrayList<>(Arrays.asList(new Interval(0, 5)));
//        ArrayList<Interval> intervalList = new ArrayList<>();
        Interval insert = new Interval(2, 3);
        ArrayList<Interval> mergedInterval = insertRange(intervalList, insert);

        for (Interval interval : mergedInterval) {
            System.out.print(interval + " ");
        }
    }

    public static ArrayList<Interval> insertRange(ArrayList<Interval> intervalsList, Interval insert) {
        //Store the merged ranges in another List.
        ArrayList<Interval> mergedRanges = new ArrayList<>();
        boolean merged = false;
        for (Interval interval : intervalsList) {
            //case if the interval doesn't overlap at all.
            if (insert.start >= interval.end) {
                // There is no overlap and in this case we will just add this interval
                mergedRanges.add(interval);
            }
            if (interval.start >= insert.end && merged != true) {
                mergedRanges.add(insert);
                mergedRanges.add(interval);
                merged = true;
            }
            if (interval.start <= insert.start && interval.end >= insert.end) {
                //interval subsumes .. no need of any new
                mergedRanges.add(interval);
                merged = true;
            } else if (insert.start <= interval.start && insert.end >= interval.end) {
                mergedRanges.add(insert);
                merged = true;
            }
            if (interval.start <= insert.start && interval.end >= insert.start && insert.end >= interval.end) {
                mergedRanges.add(new Interval(interval.start, insert.end));
                merged = true;
            } else if (insert.start < interval.start && interval.start < insert.end && insert.end < interval.end) {
                mergedRanges.add(new Interval(insert.start, interval.end));
                merged = true;
            }
        }

        if (!merged) {
            mergedRanges.add(insert);
        }

        ArrayList<Interval> secondPass = new ArrayList<>();
        if (!mergedRanges.isEmpty())
            secondPass.add(mergedRanges.get(0));
        else
            return new ArrayList<>();
        int index = 1;
        while (index < mergedRanges.size()) {
            if (secondPass.get(secondPass.size() - 1).end > mergedRanges.get(index).start) {
                if (secondPass.get(secondPass.size() - 1).end < mergedRanges.get(index).end) {
                    secondPass.get(secondPass.size() - 1).end = mergedRanges.get(index).end;
                }
            } else {
                secondPass.add(mergedRanges.get(index));
            }
            index++;
        }
        return secondPass;
    }
}
