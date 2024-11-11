package designs;

class MyHashSet {

    int SIZE=1000;
    class Node{
        int key;
        Node prev;
        Node next;
        
        public Node(int key){
            this.key = key;
        }
    }
    
    Node[] buckets= null;
    /** Initialize your data structure here. */
    public MyHashSet() {
        buckets = new Node[SIZE];
        for (int i=0; i<SIZE; i++){
            buckets[i] = new Node(-1); //Dummy node
        }
    }
    
    public Node search(int key){
        int index = key % SIZE;
        
        Node prev = buckets[index];
        
        Node curr = prev.next;
        
        while (curr != null && curr.key != key){
            prev = curr;
            curr = curr.next;
        }
        if (curr == null)
            return prev;
        return curr;
    }
    public void add(int key) {
        Node curr = search(key);
        
        if (curr.key != key){
            Node newNode = new Node(key);
            curr.next = newNode;
            newNode.prev = curr;
        }
        else{
            //Do nothing
        }
    }
    
    public void remove(int key) {
        Node curr = search(key);
        if (curr.key == key) {

            Node nextNode = curr.next;
            Node prevNode = curr.prev;
            
            prevNode.next = nextNode;
            
            if (nextNode != null){
                nextNode.prev = prevNode;
            }
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        Node curr = search(key);
        
        if (curr.key == key)
            return true;
        
        return false;
    }
}

