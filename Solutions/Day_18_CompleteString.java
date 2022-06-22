class Node{
    Node[] links=new Node[26];
    boolean end=false;
}
class Solution {
    static void insert(Node root, String s){
        Node node=root;
        for(char ch:s.toCharArray()){
            if(node.links[ch-'a']==null)
                node.links[ch-'a']=new Node();
            node = node.links[ch-'a'];
        }
        node.end=true;
    }
    
    static int getCount(Node root, String s){
        Node node=root;
        int count=0;
        for(char ch: s.toCharArray()){
            node=node.links[ch-'a'];
            count+=node.end?1:0;
        }
        return count;
    }

  public static String completeString(int n, String[] a) {
    // Write your code here.
      Node root=new Node();
      
      for(String s:a)
          insert(root, s);
      
      int maxLen=0;
      String res="";
      for(String s:a){
          int count=getCount(root,s);
          if(count==s.length()){
              if(count>maxLen){
                  maxLen=count;
                  res=s;
              }else if(count==maxLen)
                  res=s;
          }
      }
      return res==""?"None":res;
  }
}

//******************************************************

//****************** Improvised code *******************

//******************************************************
class Node{
    Node[] links=new Node[26];
    boolean end=false;
    
    boolean containsKey(char ch){
        return links[ch-'a']!=null;
    }
    
    void set(Node node, char ch){
        links[ch-'a']=node;
    }
    
    Node get(char ch){
       return links[ch-'a'];
    }
    
    void setEnd(){
        end=true;
    }
    
    boolean isEnd(){
        return end;
    }
}
class Solution {
    static void insert(Node root, String s){
        Node node=root;
        for(char ch:s.toCharArray()){
            if(!node.containsKey(ch))
                node.set(new Node(), ch);
            node = node.get(ch);
        }
        node.setEnd();
    }
    
    static int getCount(Node root, String s){
        Node node=root;
        int count=0;
        for(char ch: s.toCharArray()){
            node=node.get(ch);
            count+=node.isEnd()?1:0;
        }
        return count;
    }

  public static String completeString(int n, String[] a) {
    // Write your code here.
      Node root=new Node();
      
      for(String s:a)
          insert(root, s);
      
      int maxLen=0;
      String res="";
      for(String s:a){
          int count=getCount(root,s);
          if(count==s.length()){
              if(count>maxLen){
                  maxLen=count;
                  res=s;
              }else if(count==maxLen)
                  res=s;
          }
      }
      return res==""?"None":res;
  }
}