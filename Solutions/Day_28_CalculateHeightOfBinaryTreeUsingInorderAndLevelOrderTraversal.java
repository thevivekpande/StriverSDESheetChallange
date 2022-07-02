import java.util.*;
class Node{
    int height;
    int left;
    int right;
    Node(int _height, int _left, int _right){
        height=_height;
        left=_left;
        right=_right;
    }
}
public class Solution {
	public static int heightOfTheTree(int[] inorder, int[] levelOrder, int N){
		// Write your code here.
        Queue<Node> q=new LinkedList();
        q.offer(new Node(0, 0, N-1));
        int[] pos=new int[N+1];
        for(int i=0;i<N;i++){
            pos[inorder[i]]=i;
        }
        int maxHeight=0;
        for(int i=0;i<N;i++){
            int cur=levelOrder[i];
            Node currNode = q.poll();
            int currPos=pos[cur];
            if(currPos>currNode.left){
                q.offer(new Node(currNode.height+1, currNode.left, currPos-1));
                maxHeight=Math.max(maxHeight, currNode.height+1);
            }
            
            if(currPos<currNode.right){
                q.offer(new Node(currNode.height+1, currPos+1, currNode.right));
                maxHeight=Math.max(maxHeight, currNode.height+1);
            }
        }
        return maxHeight;
	}
}