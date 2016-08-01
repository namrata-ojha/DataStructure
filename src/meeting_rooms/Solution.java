package meeting_rooms;

import sun.jvm.hotspot.utilities.Interval;

import java.util.Arrays;
import java.util.Comparator;


/**
 * Created by namrataojha on 6/7/16.
 * Problem
 Given an array of meeting time intervals consisting of start and end times [s1,e1],[s2,e2],..., determine if a person could attend all meetings.

 For example,

 Given [[0, 30],[5, 10],[15, 20]],

 return false.
 */
public class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null || intervals.length ==0) {
            return true;
        }

        // Sort according to the start time
        Arrays.sort(intervals, new IntervalComparator());

        Interval prev = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            Interval curr = intervals[i];
            if (isOverlapped(prev, curr)) {
                return false;
            }
            prev = curr;
        }

        return true;
    }

    public class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval a, Interval b) {
            return a.start - b.start;
        }
    }

    public class Interval {

        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    private boolean isOverlapped(Interval a, Interval b) {
        return a.end > b.start;
    }
}
