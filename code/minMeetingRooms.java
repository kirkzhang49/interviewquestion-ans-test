/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution
{
    public int minMeetingRooms(Interval[] intervals)
    {
        int [] starts = new int [intervals.length];
        int [] ends = new int [intervals.length];
        for (int i = 0;i<intervals.length;i++)
        {//record start and end
             starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }//sort both start and ends 
        Arrays.sort(starts);
        Arrays.sort(ends);
        int rooms=0,endsItr=0;
        for (int i =0;i<starts.length;i++)
        {
            if (starts[i]<ends[endsItr])//if starts less than ends we need a new room
            rooms++;
            else 
              endsItr++;//move with i together to next end 
        }
     return rooms;
    }
}