package com.shubham.myexperience;

import java.util.List;

public class ThirdProgram {

  public static void main(String[] args) {

    // Incomplete

  }

  public static int selectStock(int saving, List<Integer> currentValue, List<Integer> futureValue) {
    // Write your code here
    
    int profit = 0;
    int tempProfit=0;
    int s = saving;
    for (int k=0;k<currentValue.size();k++){
        saving = s;
        tempProfit = 0;
      for (int i = k; i < currentValue.size(); i++) {

        if (futureValue.get(i) > currentValue.get(i)){
          if (saving - currentValue.get(i) >= 0) {
            tempProfit += futureValue.get(i) - currentValue.get(i);
            saving -= currentValue.get(i);
          }
        }
      }

      if (tempProfit > profit){
        profit = tempProfit;
      }
    }

    return profit;

  }

}
