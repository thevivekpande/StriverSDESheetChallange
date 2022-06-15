import java.util.* ;
import java.io.*; 
public class Solution {

	public static ArrayList<ArrayList<Integer>> findTriplets(int[] arr, int n, int K)  {

	    // Write your code here.
        ArrayList<ArrayList<Integer>> res = new ArrayList();
        Arrays.sort(arr);
        for(int i=0;i<n-2;i++){
            int l=i+1, r=n-1;
            int minTwoSum = arr[l+1] + arr[l] + arr[i];
            if(K<minTwoSum) break;
            while(l<r){
                if(arr[i]+arr[l]+arr[r]==K){
                    ArrayList<Integer> list=new ArrayList();
                    list.add(arr[i]);
                    list.add(arr[l]);
                    list.add(arr[r]);
                        res.add(list);
                    int x=arr[l];
                    int y=arr[r];
                    while(l<r && arr[l]==x)
                        l++;
                    while(l<r && arr[r]==y)
                        r--;
                }else if(arr[i]+arr[l]+arr[r]>K){
                    r--;
                }else{
                    l++;
                }
            }
            while(i+1<n && arr[i]==arr[i+1])
                i++;
        }
        return res;
	}
}
