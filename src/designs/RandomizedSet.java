package designs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
/**
 * 
 * @author Manoj.K
 *
 */
class RandomizedSet {

    Map<Integer,Integer> map = null;
    List<Integer> list = null;
    Random rand = null;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (!map.containsKey(val)){
           list.add(val);
           int index = list.size()-1;
           map.put(val,index);
           return true;
        }
        return false;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (map.containsKey(val)){
            int index = map.get(val);
            int lastVal = list.get(list.size()-1);
            list.set(index,lastVal);
            map.put(lastVal,index);
            map.remove(val);
            list.remove(list.size()-1);
            return true;
        }
        return false;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        
        int index =  rand.nextInt(list.size());
        return list.get(index);
    }
    
    public static void main(String args[]){
    	
    	RandomizedSet rSet =new  RandomizedSet();
    	boolean a = rSet.insert(3);
    	System.out.print(" " +a);
    	boolean b = rSet.insert(3);
    	System.out.print(" " +b);
    	int c = rSet.getRandom();
    	System.out.print(" "+c);
    	int d = rSet.getRandom();
    	System.out.print(" "+d);
    	boolean e = rSet.insert(1);
    	System.out.print(" "+e);
    	boolean f = rSet.remove(3);
    	System.out.print(" "+f);
    	int g = rSet.getRandom();
    	System.out.print(" "+g);
    	int h = rSet.getRandom();
    	System.out.print(" "+h);
    	boolean i = rSet.insert(0);
    	System.out.print(" "+i);
    	boolean j = rSet.remove(0);
    	System.out.print(" "+j);
    	
    }
}
