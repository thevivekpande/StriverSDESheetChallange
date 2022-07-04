/****************************************************************

    Following is the class structure of the TreeNode class:

    class TreeNode<T> {
        public T data;
        public TreeNode<T> left;
        public TreeNode<T> right;

        TreeNode(T data) {
            this.data = data;
            left = null;
            right = null;
        }
    }


*****************************************************************/

import java.util.ArrayList;

public class Solution {
    public static TreeNode<Integer> helper(ArrayList<Integer> arr, int start, int end){
        if(start>end) return null;
        int mid=start+((end-start)>>1);
        TreeNode<Integer> root=new TreeNode(arr.get(mid));
        root.left=helper(arr, start, mid-1);
        root.right=helper(arr, mid+1, end);
        return root;
    }
    public static TreeNode<Integer> sortedArrToBST(ArrayList<Integer> arr, int n) {
        // Write your code here.
        return helper(arr,0,n-1);
    }
}