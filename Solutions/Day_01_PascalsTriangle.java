import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {
	public static ArrayList<ArrayList<Long>> printPascal(int n) {
                 // Write your code here.
        ArrayList<ArrayList<Long>> res=new ArrayList<>();
        long num=1;
        for(int i=0;i<n;i++){
            ArrayList<Long> list=new ArrayList<>();
            for(int j=0;j<i;j++) {
                if(j==0 || i==0) num=1;
                else num=num*(i-j+1)/j;
                list.add(num);
            }
            list.add(1l);
            res.add(list);
        }
        return res;
	}
}
