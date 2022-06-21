class Node{
    Node links[] = new Node[26];
    boolean flag=false;
      
    boolean containsKey(char ch){
        return links[ch-'a']!=null;
    }
    Node get(char ch){
        return links[ch-'a'];
    }
    void put(char ch, Node node){
        links[ch-'a']=node;
    }
    void setEnd(){
        flag=true;
    }
    boolean isEnd(){
        return flag;
    }
}

public class Trie {
    //Initialize your data structure here
    private static Node root;
    Trie() {
        //Write your code here
        root=new Node();
    }

    //Inserts a word into the trie
    public static void insert(String word) {
        //Write your code here
        Node node=root;
        for(char ch:word.toCharArray()){
            if(!node.containsKey(ch))
                node.put(ch, new Node());
            node=node.get(ch);
        }
        node.setEnd();
    }

    //Returns if the word is in the trie
    public static boolean search(String word) {
        //Write your code here
        Node node=root;
        for(char ch:word.toCharArray()){
            if(!node.containsKey(ch))
                return false;
            node=node.get(ch);
        }
        return node.isEnd();
    }
    
    //Returns if there is any word in the trie that starts with the given prefix
    public static boolean startsWith(String prefix) {
        //Write your code here
        Node node=root;
        for(char ch:prefix.toCharArray()){
            if(!node.containsKey(ch))
                return false;
            node=node.get(ch);
        }
        return true;
    }
}