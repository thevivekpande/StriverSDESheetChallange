import java.util.*;
class Meeting{
    int start;
    int end;
    int pos;
    Meeting(int start, int end, int pos){
        this.start=start;
        this.end=end;
        this.pos=pos;
    }
}

class MeetingComparator implements Comparator<Meeting>{
    public int compare(Meeting m1, Meeting m2){
        if(m1.end<m2.end)
            return -1;
        if(m1.end>m2.end)
            return 1;
        if(m1.pos<m2.pos)
            return -1;
        return 1;
    }
}

public class Solution {
    public static List<Integer> maximumMeetings(int[] start, int[] end) {        
        //Write your code here
        List<Meeting> meetings = new ArrayList();
        List<Integer> res=new ArrayList();
        int n=start.length;
        for(int i=0;i<n;i++)
            meetings.add(new Meeting(start[i], end[i], i+1));
        MeetingComparator mc=new MeetingComparator();
        Collections.sort(meetings, mc);
        res.add(meetings.get(0).pos);
        int limit=meetings.get(0).end;
        for(int i=1;i<n;i++){
            if(meetings.get(i).start>limit){
                limit=meetings.get(i).end;
                res.add(meetings.get(i).pos);
            }
        }
        return res;
    }
}