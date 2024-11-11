package LinkList;

public class OddEvenLinkedList {
	static class ListNode{
		int val;
		ListNode next;
		public ListNode(){
		}
		public ListNode(int val){
			this.val=val;
		}
	}
    public static ListNode oddEvenList(ListNode head) {
        
    	if (head== null || head.next == null){
            return head;
        }
        ListNode oddHead = head;
        ListNode evenHead = head.next;
        
        ListNode currOdd = oddHead;
        ListNode currEven = evenHead;
        
        int cnt=3;
        ListNode curr = head.next.next;
        while(curr != null){
            if (cnt % 2 ==0){
                currEven.next = curr;
                currEven = currEven.next;
            }
            else{
                currOdd.next = curr;
                currOdd = currOdd.next;
            }
            cnt++;
            curr = curr.next;
        }
        currEven.next = null;
        currOdd.next = evenHead;
        return oddHead;
    }
    
    public static void main(String args[]){
    	ListNode head = new ListNode(1);
    	head.next = new ListNode(2);
    	head.next.next = new ListNode(3);
    	head.next.next.next = new ListNode(4);
    	head.next.next.next.next= new ListNode(5);
    	
    	ListNode list = oddEvenList(head); 
    	
    	while(list!=null){
    		System.out.print(" "+list.val);
    		list = list.next;
    	}
    }
}
