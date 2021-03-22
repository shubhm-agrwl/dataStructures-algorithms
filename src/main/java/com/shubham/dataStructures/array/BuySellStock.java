package com.shubham.dataStructures.array;

public class BuySellStock {

  public static void main(String[] args) {
    System.out.println(maxProfit3(new int[]{7, 1, 5, 3, 6, 4}));
  }

  public static int maxProfit(int[] prices) {

    int res = Integer.MIN_VALUE;

    int buy = 0;
    int sell = prices.length - 1;

    while (buy < sell) {
      int profit = prices[sell] - prices[buy];
      res = Math.max(res, profit);
      if (prices[buy] > prices[buy + 1]) {
        buy++;
      } else {
        sell--;
      }
    }

    return Math.max(res, 0);

  }

  public int maxProfit2(int[] prices) {
    int minprice = Integer.MAX_VALUE;
    int maxprofit = 0;
    for (int i = 0; i < prices.length; i++) {
      if (prices[i] < minprice) {
        minprice = prices[i];
      } else if (prices[i] - minprice > maxprofit) {
        maxprofit = prices[i] - minprice;
      }
    }
    return maxprofit;
  }

  public static int maxProfit3(int[] prices) {

    int res = 0;

    for (int i = 0; i < prices.length - 1; i++) {
      if (prices[i] < prices[i + 1]) {
        res = res + prices[i + 1] - prices[i];
      }
    }
    return res;
  }

  public int maxProfitWithFee(int[] prices, int fee) {
    int cash = 0, hold = -prices[0];
    for (int i = 1; i < prices.length; i++) {
      cash = Math.max(cash, hold + prices[i] - fee);
      hold = Math.max(hold, cash - prices[i]);
    }
    return cash;
  }


}
