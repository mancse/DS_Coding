/**
** Problem: https://leetcode.com/problems/online-stock-span/description/
** 
*/

class StockSpanner {
    Stack<int[]> st; 
    public StockSpanner() {
        st = new Stack<>();
    }
    
    public int next(int price) {
        int span = 1;
        
        while(!st.isEmpty() && st.peek()[0] <= price){
            span += st.peek()[1];
            st.pop();
        }
        
        int[] elem = new int[2];
        elem[0] = price;
        elem[1] = span;
        st.add(elem);
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
