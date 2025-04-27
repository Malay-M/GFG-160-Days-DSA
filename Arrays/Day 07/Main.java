/*Day 7: Stock Buy and Sell – Multiple Transaction Allowed */
/*https://www.geeksforgeeks.org/batch/gfg-160-problems/track/arrays-gfg-160/problem/stock-buy-and-sell2615 */

class Main {
    public static void main(String[] args) {
        
        int prices[] = {200, 100, 180, 260, 310, 40, 535, 695};
        System.out.println(maximumProfit(prices));
        maximumProfit(prices);
        
    }

    public static int maximumProfit(int prices[]) {
        
        /*Approach 1 */
        /* 
        int profit = 0;
        int min = prices[0];
        int max = prices[0];

        int n = prices.length;
        int i = 0;
        while(i < n - 1){

            while(i < n - 1 && prices[i] > prices[i+1]) {
                i++;
            }
            min = prices[i];

            while(i < n - 1 && prices[i] < prices[i+1]) {
                i++;
            }
            max = prices[i];

            profit = profit + (max - min);
        }
        */


        /* Approach 2*/

        int profit = 0;


        for(int i = 0; i < prices.length - 1; i++) {

            if(prices[i] <= prices[i+1]) {
                profit = profit + (prices[i+1] - prices[i]);
            }

        }
        


        return profit;
    }
}
