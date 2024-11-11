package designs;
/**
 * Design your implementation of the circular queue. The circular queue is a linear data structure in which 
 * the operations are performed based on FIFO (First In First Out) principle and the last position is 
 * connected back to the first position to make a circle. It is also called "Ring Buffer".One of the benefits
 * of the circular queue is that we can make use of the spaces in front of the queue. In a normal queue, once 
 * the queue becomes full, we cannot insert the next element even if there is a space in front of the queue.
 * But using the circular queue, we can use the space to store new values.
 * 
 * E.g: 
 * ---
 * Input
 * ["MyCircularQueue", "enQueue", "enQueue", "enQueue", "enQueue", "Rear", "isFull", "deQueue", "enQueue", "Rear"]
 * [[3], [1], [2], [3], [4], [], [], [], [4], []]
 * Output
 * [null, true, true, true, false, 3, true, true, true, 4]

 * Explanation
 * MyCircularQueue myCircularQueue = new MyCircularQueue(3);
 * myCircularQueue.enQueue(1); // return True
 * myCircularQueue.enQueue(2); // return True
 * myCircularQueue.enQueue(3); // return True
 * myCircularQueue.enQueue(4); // return False
 * myCircularQueue.Rear();     // return 3
 * myCircularQueue.isFull();   // return True
 * myCircularQueue.deQueue();  // return True
 * myCircularQueue.enQueue(4); // return True
 * myCircularQueue.Rear();     // return 4
 * @author Manoj.K
 *
 */
class CircularQueue {
    
    private int[] arr;
    private int head;
    private int tail;
    private int capacity;  // the total capacity of the queue
    private int size;    // num of items present in the queue at any time
    
    public CircularQueue(int k) {
        this.arr = new int[k];
        this.head = 0;
        this.tail = -1;
        this.capacity = k;
        this.size = 0;
    }
    
    public boolean enQueue(int value) {
        
        if(isFull()) {
            return false;
        }
        
        tail = (tail + 1) % capacity;
        arr[tail] = value;
        size++; 
        return true;
    }
    
    public boolean deQueue() {
        
        if(isEmpty()) {
            return false;
        }
        
        head = (head + 1) % capacity;
        size--;
        return true;
    }
    
    public int Front() {
        
        if(isEmpty()) {
            return -1;
        }
        
        return arr[head];
    }
    
    public int Rear() {
        
        if(isEmpty()) {
            return -1;
        }
        
        return arr[tail];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == capacity;
    }
}
