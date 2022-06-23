class Node{
    Node links[] = new Node[2];
    boolean containsKey(int n){
        return links[n]!=null;
    }
    Node get(int n){
        return links[n];
    }
    void put(int n, Node node){
        links[n]=node;       
    }
}

class Trie{
    private Node root;
    
    public Trie(){
        root=new Node();
    }
    public  void insert(int num){
        Node node=root;
        for(int i=31;i>=0;i--){
            int bit=(num>>i) & 1;
            if(!node.containsKey(bit))
                node.put(bit, new Node());
            node=node.get(bit);
        }
    }
    public int getMax(int num){
        Node node=root;
        int max=0;
        for(int i=31;i>=0;i--){
            int bit=(num>>i)&1;
            if(node.containsKey(1-bit)){
                max|=(1<<i);
                node=node.get(1-bit);
            }else{
                node=node.get(bit);
            }
        }
        return max;
    }

}
public class Solution {
    public static int maximumXor(int[] A) {
        // Write your Code here
        Trie trie= new Trie();
        for(int i:A)
            trie.insert(i);
        int res=0;
        for(int i:A)
            res=Math.max(res, trie.getMax(i));
        return res;
    }
}