package Q00121_BestTimeToBuyAndSellStock.solutions;

public class Solution {
    public int maxProfit(int[] prices) {
        int[] maxInFuture = new int[prices.length];

        int maxSoFar = 0;
        for (int loop = prices.length - 1; loop >=0; loop--) {
            maxSoFar = Math.max(maxSoFar, prices[loop]);
            maxInFuture[loop] = maxSoFar;
        }

        int maxProfit = 0;
        for (int loop = 0; loop < prices.length; loop++) {
            maxProfit = Math.max(maxProfit, maxInFuture[loop] - prices[loop]);
        }

        return maxProfit;
    }

    public String solutionDescription() {
        return "N/A";
    }
}