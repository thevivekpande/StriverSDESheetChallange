import java.util.* ;
import java.io.*; 
/*******************************************************

    Following is the Interval class structure

    class Interval {
        int start, int finish;

        Interval(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }
    }
    
*******************************************************/

import java.util.List;
import java.util.ArrayList;

public class Solution {
    public static List<Interval> mergeIntervals(Interval[] intervals) {
        // write your code here.
        List<Interval> list = new ArrayList<>();
        if(intervals.length==0 || intervals==null)
            return list;
        Arrays.sort(intervals, (a, b) -> a.start - b.start);
        int start=intervals[0].start;
        int end=intervals[0].finish;
        for(Interval i : intervals){
            if(i.start<=end){
                end=Math.max(end, i.finish);
            }
            else{
                list.add(new Interval(start, end));
                start=i.start;
                end=i.finish;
            }
        }
        list.add(new Interval(start, end));
        return list;
    }
}
