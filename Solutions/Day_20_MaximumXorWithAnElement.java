import java.util.*;
class Node{
    Node[] links=new Node[2];
    boolean containsKey(int bit){
        return links[bit]!=null;
    }
    void set(Node node, int bit){
        links[bit]=node;
    }
    Node get(int bit){
        return links[bit];
    }
}

class Trie{
    Node root;
    public Trie(){
        root=new Node();
    }
    
    void insert(int num){
        Node node=root;
        for(int i=31;i>=0;i--){
            int bit=(num>>i)&1;
            if(!node.containsKey(bit)){
                node.set(new Node(), bit);
            }
            node=node.get(bit);
        }
    }
    
    int getMax(int num){
        Node node=root;
        int max=0;
        for(int i=31;i>=0;i--){
            int bit=(num>>i)&1;
            if(!node.containsKey(1-bit)){
                node=node.get(bit);
            }else{
                max=max|(1<<i);
                node=node.get(1-bit);
            }
        }
        return max;
    }
}
public class Solution {
    public static ArrayList<Integer> maxXorQueries(ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> queries) {
        // Write your code here.
        ArrayList<Integer> res=new ArrayList();
        int n=arr.size(), m=queries.size();
        Trie trie=new Trie();
        Collections.sort(arr);
        for(int i=0;i<m;i++)
            res.add(0);
        for(int i=0;i<queries.size();i++)
            queries.get(i).add(i);
        Collections.sort(queries, (a, b) -> a.get(1)-b.get(1));
        int i=0;
        for(ArrayList<Integer> query:queries){
            int x=query.get(0), a=query.get(1), ind=query.get(2);
            while(i<n && arr.get(i)<=a){
                trie.insert(arr.get(i));
                i++;
            }
            if(i==0) res.set(ind, -1);
            else res.set(ind, trie.getMax(x));
        }
        return res;
        
    }
}