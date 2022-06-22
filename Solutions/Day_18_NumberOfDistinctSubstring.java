class Node {
    Node[] links=new Node[26];
    
    boolean containsKey(char ch){
        return links[ch-'a']!=null;
    }
    
    void set(Node node, char ch){
        links[ch-'a']=node;
    }
    
    Node get(char ch){
        return links[ch-'a'];
    }
}
public class Solution {
    public static int distinctSubstring(String word) {
        // Write your code here.
        Node root=new Node();
        int count=0, n=word.length();
        for(int i=0;i<n;i++){
            Node node=root;
            for(int j=i;j<n;j++){
                if(!node.containsKey(word.charAt(j))){
                    node.set(new Node(), word.charAt(j));
                    count++;
                }
                node=node.get(word.charAt(j));
            }
        }
        return count;
    }
}
