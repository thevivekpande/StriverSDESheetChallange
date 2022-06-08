import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution 
{
    public static ArrayList<Integer> majorityElementII(ArrayList<Integer> arr) 
    {
        // Write your code here.
        int count1=0, count2=0, element1=-1, element2=-1;
        for(int i=0;i<arr.size();i++){
            if(arr.get(i)==element1) count1++;
            else if(arr.get(i)==element2) count2++;
            else if(count1==0) {
                count1++;
                element1=arr.get(i);
            }else if(count2==0){
                count2++;
                element2=arr.get(i);
            }else{
                count1--;
                count2--;
            }
        }
        count1=count2=0;
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<arr.size();i++){
            if(arr.get(i)==element1) count1++;
            else if(arr.get(i)==element2) count2++; 
        }
         if(count1>(arr.size())/3) list.add(element1);
            if(count2>(arr.size())/3) list.add(element2);
        return list;
    }
}