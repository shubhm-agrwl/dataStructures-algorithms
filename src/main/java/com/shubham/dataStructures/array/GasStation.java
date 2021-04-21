package com.shubham.dataStructures.array;

public class GasStation {

  public int canCompleteCircuit(int[] gas, int[] cost) {
    int sumGas = 0;
    int sumCost = 0;
    int curGas = 0;
    int result = -1;

    for (int i = 0; i < gas.length; i++) {
      curGas += gas[i] - cost[i];

      // re-calculate the starting point
      if (curGas < 0) {
        result = -1;
        curGas = 0;
      }
      // set initial starting point
      else if (result == -1) {
        result = i;
      }

      sumGas += gas[i];
      sumCost += cost[i];
    }

    if (sumGas < sumCost) {
      return -1;
    }

    return result;
  }

}
