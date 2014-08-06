/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        if(intervals == null || newInterval==null)
            return intervals;
        ArrayList<Interval> res = new ArrayList<Interval>();
        int pos = 0;
        for(Interval tmpInterval:intervals){
            if(tmpInterval.end<newInterval.start){
                res.add(tmpInterval);
                pos++;
            }
            else if(tmpInterval.start > newInterval.end){
                res.add(tmpInterval);
            }
            else{
                newInterval.start = Math.min(newInterval.start,tmpInterval.start);
                newInterval.end = Math.max(newInterval.end,tmpInterval.end);
            }
        }
        res.add(pos,newInterval);
        return res;
    }
}
