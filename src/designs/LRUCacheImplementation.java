package designs;

import java.util.HashMap;
import java.util.Map;

class LRUCacheImplementation
{
    static class Node
    {
        int key;
        int val;
        Node prev;
        Node next;
        
        public Node()
        {
        }
        public Node(int key, int val)
        {
        	this.key = key;
        	this.val = val;
        }
    }
    
    Node head = new Node();
    Node tail = new Node();
    Map<Integer,Node> map = null;
    
    int capacity;
    
    public LRUCacheImplementation(int capacity) 
    {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) 
    {
        int result = -1;
        
        Node node = map.get(key);
        
        if (node != null)
        {
            result = node.val;
            remove(node);
            add(node);
        }
        return result;
    }
    
    public void put(int key, int value) 
    {
        Node node = map.get(key);
        if (node != null)
        {
            remove(node);
            node.val = value;
            add(node);
        }
        else
        {
            if (map.size() == capacity)
            {
                map.remove(tail.prev.key);
                remove(tail.prev);
            }
            node = new Node();
            node.key = key;
            node.val = value;
            map.put(key,node);
            add(node);
        }
    }
    
    private void add(Node node)
    {
        Node head_next = head.next;
        head.next = node;
        node.prev= head;
        node.next = head_next;
        head_next.prev = node;
    }
    
    private void remove(Node node)
    {
        Node node_next = node.next;
        Node node_prev = node.prev;
        node_next.prev = node_prev;
        node_prev.next = node_next;
    }
    
    public static void main(String args[])
    {
    	LRUCacheImplementation lruCache = new LRUCacheImplementation(3);
    	lruCache.put(1, 1);
    	System.out.println("Cache size: "+lruCache.map.size());
    	lruCache.put(2, 2);
    	lruCache.put(3, 2);
    	lruCache.put(4, 2);
    	
    	lruCache.get(1);
    	System.out.println("Cache size: "+lruCache.map.size());
    }
}
