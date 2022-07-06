/***************************************************************************

  Class for graph node is as follows:

  class graphNode {
      public int data;
      public ArrayList<graphNode> neighbours;

      graphNode() {
          data = 0;
          neighbours = new ArrayList<graphNode>();
      }

      graphNode(int val) {
          data = val;
          neighbours = new ArrayList<graphNode>();
      }

      graphNode(int val, ArrayList<graphNode> neighbours) {
          data = val;
          this.neighbours = neighbours;
      }
    }

******************************************************************************/
import java.util.*;
public class Solution {
    static HashMap<Integer, graphNode> map;
    private static graphNode clone(graphNode node){
        if(node==null) return null;
        if(map.containsKey(node.data)) return map.get(node.data);
        graphNode newNode=new graphNode(node.data, new ArrayList<graphNode>());
        map.put(node.data, newNode);
        for(graphNode neighbour : node.neighbours)
            newNode.neighbours.add(clone(neighbour));
        return newNode;
    }
    public static graphNode cloneGraph(graphNode node) {
        // Write your code here.
        map=new HashMap();
        return clone(node);
    }
}