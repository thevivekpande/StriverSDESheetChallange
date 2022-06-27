import java.util.*;
public class LFUCache {
    HashMap<Integer, Integer> vals;
    HashMap<Integer, Integer> counts;
    HashMap<Integer, LinkedHashSet<Integer>> lists;
    int cap;
    int min=-1;

	LFUCache(int capacity) {
		// Write your code here.
        cap=capacity;
        vals=new HashMap<>();
        counts=new HashMap<>();
        lists=new HashMap<>();
        lists.put(1, new LinkedHashSet<>());
	}

	int get(int key) {
		// Write your code here.
        if(!vals.containsKey(key))
            return -1;
        int count = counts.get(key);
        counts.put(key, count+1);
        lists.get(count).remove(key);
        if(count==min && lists.get(count).size()==0)
            min++;
        if(!lists.containsKey(count+1))
            lists.put(count+1, new LinkedHashSet<>());
        lists.get(count+1).add(key);
        return vals.get(key);
	}

	void put(int key, int value) {
		// Write your code here.
        if(cap<=0)
            return;
        if(vals.containsKey(key)){
            vals.put(key, value);
            get(key);
            return;
        }
        if(vals.size()>=cap){
            int evit=lists.get(min).iterator().next();
            lists.get(min).remove(evit);
            vals.remove(evit);
        }
        vals.put(key, value);
        counts.put(key, 1);
        min=1;
        lists.get(1).add(key);
	}
}
