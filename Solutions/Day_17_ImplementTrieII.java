class Node{
    Node links[] = new Node[26];
    int cntEndsWith=0;
    int cntPrefix=0;
    
    boolean containsKey(char ch){
        return links[ch-'a']!=null;
    }
    Node get(char ch){
        return links[ch-'a'];
    }
    void put(char ch, Node node){
        links[ch-'a']=node;
    }
    void increaseEnd(){
        cntEndsWith++;
    }
    void increasePrefix(){
        cntPrefix++;
    }
    void deleteEnd(){
        cntEndsWith--;
    }
    void reducePrefix(){
        cntPrefix--;
    }
    int getEnd(){
        return cntEndsWith;
    }
    int getPrefix(){
        return cntPrefix;
    }
}
public class Trie {
    private Node root;
    public Trie() {
        // Write your code here.
        root=new Node();
    }

    public void insert(String word) {
        // Write your code here.
        Node node=root;
        for(char ch:word.toCharArray()){
            if(!node.containsKey(ch))
                node.put(ch, new Node());
            node=node.get(ch);
            node.increasePrefix();
        }
        node.increaseEnd();
    }

    public int countWordsEqualTo(String word) {
        // Write your code here.
        Node node=root;
        for(char ch:word.toCharArray()){
            if(node.containsKey(ch))
                node=node.get(ch);
            else
                return 0;
        }
        return node.getEnd();
    }

    public int countWordsStartingWith(String word) {
        // Write your code here.
        Node node=root;
        for(char ch:word.toCharArray()){
            if(node.containsKey(ch))
                node=node.get(ch);
            else return 0;
        }
        return node.getPrefix();
    }

    public void erase(String word) {
        // Write your code here.
        Node node=root;
        for(char ch:word.toCharArray()){
            if(node.containsKey(ch)){
                node=node.get(ch);
                node.reducePrefix();
            }else{
                return;
            }
        }
        node.deleteEnd();
    }

}
