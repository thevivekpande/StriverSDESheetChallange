import java.util.* ;
import java.io.*; 
public class Solution {
  public static String fourSum(int[] arr, int target, int n) {
      // Write your code here.
      Arrays.sort(arr);
      for(int i=0;i<n-2;i++){
          for(int j=i+1;j<n-2;j++){
              int temp=target-arr[i]-arr[j];
              int start=j+1, last=n-1;
              
              int minTwoSum = arr[j+1] + arr[j+2];
              int maxTwoSum = arr[n - 1] + arr[n - 2];
              if(temp < minTwoSum || temp > maxTwoSum) continue;

              while(start<last){
                  if(arr[start]+arr[last]==temp) return "Yes";
                  else if(arr[start]+arr[last]<temp) start++;
                  else last--;
              }
          }
      }
      return "No";
  }
}
