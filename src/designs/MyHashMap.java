package designs;

class MyHashMap {

    int SIZE = 100;
    class Node{
        int key;
        int val;
        Node prev;
        Node next;
        
        public Node(int key,int val){
            this.key=key;
            this.val=val;
        }
    }
    
    Node[] buckets;
    /** Initialize your data structure here. */
    public MyHashMap() {
        buckets = new Node[SIZE];
        for (int i=0; i<SIZE; i++){
            buckets[i] = new Node(-1,0); //Add dummy node to each bucket.
        }
    }
    
    private Node search(int key){
        int index = key % SIZE;
        
        Node prev = buckets[index];
        
        Node curr = prev.next;
        
        while(curr != null && curr.key != key){
            prev = curr;
            curr = curr.next;
        }
        
        if (curr == null)
            return prev;
        
        return curr;
    }
    /** value will always be non-negative. */
    public void put(int key, int value) {
        Node node = search(key);
        
        if (node.key == key){
            node.val = value;
        }
        else{
            Node newNode = new Node(key,value);
            newNode.prev = node;
            node.next = newNode;
            return;
        }    
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        Node curr = search(key);
        
        if (curr.key == key)
            return curr.val;
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        Node curr = search(key);
        
        if (curr.key != key)
            return;
        
        Node prevNode = curr.prev;
        Node nextNode = curr.next;
        
        prevNode.next = curr.next;
        if (nextNode != null){
            nextNode.prev = prevNode;
        }
    } 
}
