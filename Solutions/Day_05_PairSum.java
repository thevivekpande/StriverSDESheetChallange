import java.util.* ;
import java.io.*; 
public class Solution{
    public static int[][] pairSum(int[] arr, int s) {
        // Write your code here.
        ArrayList<int[]> list=new ArrayList<>();
        int i=0, n=arr.length, j=0;
        Arrays.sort(arr);
       for(i=0;i<n-1;i++){
           for(j=i+1;j<n;j++){
           if(arr[i]+arr[j]==s){
               int[] temp=new int[2];
               temp[0]=arr[i];
               temp[1]=arr[j];
               list.add(temp);
           }
           }
       }
        int[][] res=new int[list.size()][2];
        i=0;
        for(int[] row:list){
            res[i][0]=row[0];
            res[i++][1]=row[1];
        }
        return res;
    }
}