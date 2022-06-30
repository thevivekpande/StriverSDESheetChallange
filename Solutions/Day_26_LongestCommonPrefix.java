import java.util.*;
public class Solution {
	public static String longestCommonPrefix(String[] arr, int n) {
		// Write your code here
        Arrays.sort(arr);
        int i=0;
        while(i<arr[0].length() && i<arr[n-1].length() && arr[0].charAt(i)==arr[n-1].charAt(i)){
            i++;
        }
        return arr[0].substring(0, i);
	}

}
