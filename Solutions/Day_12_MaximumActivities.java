import java.util.*;
class Activity{
    int start;
    int end;
    Activity(int start, int end){
        this.start=start;
        this.end=end;
    }
}

class ActivityComparator implements Comparator<Activity>{
    public int compare(Activity a1, Activity a2){
        if(a1.end<a2.end)
            return -1;
        if(a1.end>a2.end)
            return 1;
        if(a1.start<a2.start)
            return -1;
        return 1;
    }
}

public class Solution {
    public static int maximumActivities(List<Integer> start, List<Integer> end) {
        //Write your code here
        int n=start.size();
        List<Activity> activities=new ArrayList();
        for(int i=0;i<n;i++)
            activities.add(new Activity(start.get(i), end.get(i)));
        ActivityComparator ac=new ActivityComparator();
        Collections.sort(activities,ac);
        int res=1;
        int limit=activities.get(0).end;
        for(int i=1;i<n;i++){
            if(activities.get(i).start>=limit){
                limit=activities.get(i).end;
                res++;
            }
        }
        return res;
    }
}