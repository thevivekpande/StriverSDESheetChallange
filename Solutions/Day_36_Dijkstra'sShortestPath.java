import java.util.*;
class Node implements Comparator<Node>{
    int v;
    int weight;
    Node(int _v, int _weight){
        v=_v;
        weight=_weight;
    }
    Node(){}
    int getV() { return v; }
    int getWeight(){ return weight;}
    
    public int compare(Node node1, Node node2){
        return (node1.weight - node2.weight);
    }
}
public class Solution {
	public static ArrayList < Integer > dijkstra(ArrayList< ArrayList < Integer > > vec, int vertices, int edges, int source){
		// Write your code here.
        HashMap<Integer, ArrayList<Node>> adj=new HashMap();
        for(int i=0;i<vertices;i++)
            adj.put(i, new ArrayList());
        
        for(int i=0;i<edges;i++){
            adj.get(vec.get(i).get(0)).add(new Node(vec.get(i).get(1), vec.get(i).get(2)));
            adj.get(vec.get(i).get(1)).add(new Node(vec.get(i).get(0), vec.get(i).get(2)));
        }
        
        ArrayList<Integer> dist=new ArrayList();
        for(int i=0;i<vertices;i++)
            dist.add(Integer.MAX_VALUE);
        dist.set(source, 0);
        
        PriorityQueue<Node> pq=new PriorityQueue<Node>(vertices, new Node());
        pq.add(new Node(source, 0));
        
        while(!pq.isEmpty()){
            Node cur=pq.poll();
            for(Node it:adj.get(cur.getV())){
                if((dist.get(cur.getV())+it.getWeight()) < dist.get(it.getV())){
                    dist.set(it.getV(), dist.get(cur.getV())+it.getWeight());
                    pq.add(new Node(it.getV(), dist.get(it.getV())));
                }
            }
        }
        return dist;
	}
}