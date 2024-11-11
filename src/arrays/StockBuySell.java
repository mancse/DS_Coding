package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Condition: When multiple time buy and sell allowed.
 * There are 4 different varients of this problem described as mentioned below.
 * @author Manoj.K
 *
 */
class StockBuySell
{
	private static class BuySell
	{
		int buy;
		int sell;
	}
	
	/**
	 * StockBuySell-I varient: Here maximum of only 1 transaction is allowed to find maximum profit. 
	 * Idea here is to maintain two different variable i.e minimum price and maximum profilt at each index 
	 * where minimum price will be initialized with Integer.MAX_VALUE and maxprofit is 0.
	 * 
	 * The iterate over each index and check following:
	 * a.) if prices[i] < minprice then
	 *         minprice=prices[i]
	 *         index for buy = i; 
	 * b.) else if (prices[i] - minprice) then
	 *         maxprofit = prices[i] - minprice;
	 *         index for sell = i;
	 * On completion of the loop, we finds the index of buy and sell which can give maximum profi
	 * @param prices
	 * @return
	 */
	private BuySell buySell_1(int [] prices)
	{
        int n = prices.length;
		if (n < 2)
		{
			System.out.println("Atleast 2 different dates prices should be present");
			return null;
		}
		BuySell buysell= new BuySell();
		int minprice = Integer.MAX_VALUE;
		int maxprofit = 0;
		
		for (int i=0 ; i< prices.length ; i++)
		{
			if (prices[i] < minprice)
			{
				minprice = prices[i];
				buysell.buy = i;
			}
			
			else if (prices[i] - minprice > maxprofit)
			{
				maxprofit = prices[i] - minprice;
				buysell.sell = i;
			}
		}
		return buysell;
	}
	
	/**
	 * StockBuySell-II varient: Here any number of transactions are allowed to find maximum profit.
	 * The cost of a stock on each day is given in an pk
     * array, find the max profit that you can make by buying and selling 
     * in those days. For example, if the given array is {100, 180, 260, 310, 40, 535, 695}, the maximum profit can earned
     * by buying on day 0, selling on day 3. Again buy on day 4 and sell on day 6. 
     * If the given array of prices is sorted in decreasing order, then profit cannot be earned at all. 
	 * @param prices
	 * @return
	 */
	public int maxProfit(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }
	
	
	/**
	 * StockBuySell-III varient: Find maximum profit from stock buy and sell.
	 * Conditions are: 
	 * 1. Atmost of only 2 transactions are allowed. 
	 * 2. Must sell the stock before one buy the next stock.
	 * 
	 * Idea: Logic behind this is that at every index we need to check what is
	 * maximum profit in the left and right of the index. So, we can store the maximum left profit and maximum right
	 * profit at every index so we can maintain 2 equal sized array i.e maxleft[i] to track maximum profit before index i
	 * and maxright[i] to track maximum profit after i. 
	 * @param prices
	 * @return
	 */
	private int buysell_3 (int prices[])
	{
		int maxprofit = Integer.MIN_VALUE;
		int n = prices.length;
		
		int maxLeftProfit[]= new int[n];
		int maxRightProfit[] = new int[n];
		
		int min = prices[0];
		maxLeftProfit[0] = 0;
		for (int i=1 ; i<n ; i++)
		{
			/*
			 * Find minimum prices in left sub array till ith day. 
			 */
			min = Math.min(min, prices[i]);
			
			/**
			 * Here, we have 2 possibilities. 
			 * a. If we don't make transaction on day i, then maximum profit will be in left subarray and 
			 *    will be equal to maxleft[i-1]
			 * b. If we make transaction on day i, then maximum profit will be difference of price at ith 
			 *    day minus minimum price in left subarry which will be equal to prices[i] - min
			 * c. So, maximum left profit at index i will be max of above two. 
			 */
			maxLeftProfit[i] = Math.max(maxLeftProfit[i-1], prices[i] - min);
		}
		
		System.out.println(" Max left profit: ");
		
		for (int i=0 ; i<n; i++)
		{
			System.out.print(" "+maxLeftProfit[i]);
		}
		
		maxRightProfit[n-1] = 0;
		int max = prices[n-1];
		for (int i= n-2 ; i >= 0 ; i--)
		{
			/**
			 * Find maximum price in the right subarray from ith day 
			 */
			max = Math.max(max, prices[i]);
			
			/**
			 * Here, we have 2 possibilities. 
			 * a. If we don't make transaction on day i, then maximum profit will be in right subarray and 
			 *    will be equal to maxright[i+1]
			 * b. If we make transaction on day i, then maximum profit will be difference of maximum price 
			 *    in the right subarrray minus price at ith day. Hence equal to max - prices[i]. 
			 * c. So, maximum left profit at index i will be max of above two. 
			 */
			maxRightProfit[i] = Math.max(maxRightProfit[i+1], max - prices[i]);
		}
		
        System.out.println("\n Max right: ");
		for (int i=0 ; i<n; i++)
		{
			System.out.print(" "+maxRightProfit[i]);
		}
		
		/**
		 * Total maximum profit will be the largest value of maximim profit in left + right sub array 
		 * through out the array by comparing the value at each ith day. 
		 */
		for (int i=0 ; i<n ; i++)
		{
			maxprofit = Math.max(maxprofit,maxLeftProfit[i]+maxRightProfit[i]);
		}
		return maxprofit;
	}
	
	/**
	 * StockBuySell-III varient: Find maximum profit from stock buy and sell in O(n) time complexity
	 * and O(1) space complexity. 
	 * Conditions are: 
	 * 1. Atmost of only 2 transactions are allowed. 
	 * 2. Must sell the stock before one buy the next stock.
	 * 
	 * Idea: Idea is atmost there could be two possibilities that, maximum profit can be achieved by 
	 * only first buy and first sell or maximum profit can be with combination of two transactions i.e 
	 * combination of first buy-->first sell and second buy --> second sell. 
	 * 
	 * So, computation of second transaction is dependent on first transaction and should be computed 
	 * together. 
	 */
	private int buySell3(int prices[])
	{
		if (prices.length == 0)
			return 0;
		
		int firstBuy = Integer.MIN_VALUE;
		int secondBuy = Integer.MIN_VALUE;
		int firstSell = 0;
		int secondSell = 0;
		
		for (int i=0; i < prices.length; i++)
		{
			/*
			 * If one purchage any stock on day i, then he looses his money with the value of stock prices
			 * at ith day. so, taking maximum value of lost money as maximum of buy price so far and current
			 * lost price (i.e negative value).
			 */
			firstBuy = Math.max(firstBuy, -prices[i]);
			
			/*
			 * If one sell the stock on ith day, then it means he gains money with value at ith day. So, take
			 * maximum of sell price so far and difference of current sell price and privious buy price. So, 
			 * add prices[i] to firstBuy and then take maximum of firstSell so far and firstBuy + prices[i].  
			 */
			firstSell = Math.max(firstSell, firstBuy + prices[i]);
			
			/*
			 * Second buy of stock is depended on firstSell price. So, take maximum of secondBuy so far and 
			 * difference of money earned as firstSell minus current day stock price. 
			 */
			secondBuy = Math.max(secondBuy, firstSell - prices[i]);
			
			/*
			 * Similarly on selling the stock at second time, add the price to secondBuy Price and take maximum
			 * of secondSell and difference of current price and secondBuy. 
			 */
			secondSell = Math.max(secondSell, secondBuy + prices[i]);
			
			System.out.println("firstBuy: "+firstBuy+" firstSell: "+firstSell+" secondBuy: "+secondBuy+" secondSell: "+secondSell);
			
		}
		
		/*
		 * Return secondSell price as final result. 
		 */
		return secondSell;
	}
	
	/**
	 * Say you have an array for which the i-th element is the price of a given stock on day i.
     * Design an algorithm to find the maximum profit. You may complete at most k transactions.

     * Note:
     * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

     * Example 1:

     *Input: [2,4,1], k = 2
     *Output: 2
     *Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
     * Example 2:

     * Input: [3,2,6,5,0,3], k = 2
     * Output: 7
     * Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4.
             Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
	 * @param prices
	 * @param k
	 * @return
	 */
	private int buySell4(int prices[], int k)
	{
		if (prices.length <= 0 || k <=0)
			return 0;
			
	    int profit = 0;
			
	    if (k >= prices.length/2)
		{
	    	for (int i=0; i<prices.length-1; i++)
			{
	            if (prices[i] < prices[i+1])
	            	profit += prices[i+1]  - prices[i];
			}
			return profit;
		}
		int buy[] = new int[k];
		Arrays.fill(buy, Integer.MIN_VALUE);
		int sell[] = new int[k];
			
		for (int i=0; i<prices.length; i++)
		{
			for (int j=0; j<k; j++)
			{
				buy[j] = Math.max(buy[j], j==0? 0-prices[i]:sell[j-1]-prices[i]);
				sell[j] = Math.max(sell[j], buy[j] + prices[i]);
			}
		}
		return sell[k-1];
	}
	public static int maxProfitWithFee(int[] prices, int fee) 
	{
	     int obp = -prices[0];
	     int osp = 0;
	        
	     for (int i=1; i< prices.length; i++)
	     {            
	        int nbp = Math.max(obp, osp - prices[i]);
	        int nsp = Math.max((prices[i] + obp - fee), osp);
	            
	        obp = nbp;
	        osp = nsp; 
	        
	        //System.out.println("i: "+i+"prices[i]: "+prices[i]+"obp: "+obp+" osp: "+osp+" nbp: "+nbp+" nsp: "+nsp);
	     }
	        System.out.println("Maximum profit with fee: "+osp);
	        return osp;                    
	}
	
	 public static int maxProfitWithCooldown(int[] prices) 
	 {
	    if (prices == null || prices.length == 0)
	        return 0;
	    
	    int obp = -prices[0];
	    int osp = 0;
	    int ocp = 0;
	        
	    for (int i=1; i < prices.length; i++)
	    {
	        int nbp = Math.max(obp, ocp - prices[i]);
	        int nsp = Math.max(osp, prices[i] + obp);
	        int ncp = Math.max(ocp, osp);
	            
	        obp = nbp;
	        osp = nsp;
	        ocp = ncp;
	    }
	    System.out.println("Maximum profit with cooldown: "+osp);
	    return osp;
	 }
	public static void main(String args[])
	{
		 // stock prices on consecutive days 
        int prices[] = {1, 3, 2, 8, 4, 9}; 
        StockBuySell stock = new StockBuySell();
        BuySell buysell = stock.buySell_1(prices);
        
        System.out.println(" Result for stock buy sell varient-1: ");
        System.out.print("\n Buy on day : "+buysell.buy);
    	System.out.print(" Sell on day : "+buysell.sell);
    	
        int maxprofit = stock.buysell_3(prices);
        
        System.out.println(" \n Maximum profit by atmost 2 transactions algo : "+maxprofit);
        
        int maxprofit1 = stock.buySell3(prices);
        System.out.println(" \n Maximum profit by atmost 2 transactions algo : "+maxprofit1);
        
        int maxProfit = stock.buySell4(prices, 6);
        System.out.println("Maximum profit: "+maxProfit);
        
        maxProfitWithFee(prices,2);
        
        maxProfitWithCooldown(prices);
        
	}
}