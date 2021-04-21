package com.shubham.dataStructures.array;

import java.util.Arrays;

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

  public int maxProfitAtMost2Transactions(int[] prices) {
    int k = 2;
    int buy[] = new int[k + 1];
    int sell[] = new int[k + 1];
    Arrays.fill(buy, Integer.MAX_VALUE);

    for (int price : prices) {
      for (int i = 1; i <= k; i++) {
        buy[i] = Math.min(buy[i], price - sell[i - 1]);
        sell[i] = Math.max(sell[i], price - buy[i]);
      }
    }
    return sell[k];
  }

  public int maxProfitAtMostKTransactions(int k, int[] prices) {
    int buy[] = new int[k + 1];
    int sell[] = new int[k + 1];
    Arrays.fill(buy, Integer.MAX_VALUE);

    for (int price : prices) {
      for (int i = 1; i <= k; i++) {
        buy[i] = Math.min(buy[i], price - sell[i - 1]);
        sell[i] = Math.max(sell[i], price - buy[i]);
      }
    }
    return sell[k];
  }


}
