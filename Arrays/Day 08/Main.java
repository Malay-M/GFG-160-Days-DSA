/*Day 8: Stock Buy and Sell – Max one Transaction Allowed */
/*https://www.geeksforgeeks.org/batch/gfg-160-problems/track/arrays-gfg-160/problem/buy-stock-2 */

class Main {
    public static void main(String[] args) {
        int[] prices = {7, 10, 1, 3, 6, 9, 2};
        // int[] prices = {3, 8, 7};
        System.out.println(maximumProfit(prices));
    }

    public static int maximumProfit(int prices[]) {
        int maxProfit = 0;
        int min = prices[0];
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] < min) {
                min = prices[i];
            }

            if(maxProfit < (prices[i] - min)) {
                maxProfit = prices[i] - min;
            }

        }

        return maxProfit;
    }
}