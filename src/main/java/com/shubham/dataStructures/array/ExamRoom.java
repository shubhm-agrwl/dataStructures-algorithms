package com.shubham.dataStructures.array;

public class ExamRoom {

  int[] seats;

  public ExamRoom(int n) {
    seats = new int[n];
  }

  public int seat() {

    if (seats[0] == 0) {
      seats[0] = 1;
      return 0;
    }

    int res = 0;
    int reslt = 0;

    for (int i = 1; i < seats.length; i++) {
      if (seats[i] == 0) {
        int j = i;
        int k = i;
        while (j >= 0 && seats[j] == 0) {
          j--;
        }
        while (k < seats.length && seats[k] == 0) {
          k++;
        }
        int temp_min = 0;
        if (j < 0) {
          temp_min = k - i;
        } else if (k == seats.length) {
          if (i - j <= i) {
            temp_min = i - j;
          }
        } else {
          temp_min = Math.min(i - j, k - i);
        }
        if (temp_min > res) {
          res = temp_min;
          reslt = i;
        }

      }
    }
    seats[reslt] = 1;
    return reslt;

  }

  public void leave(int p) {
    seats[p] = 0;
  }

}
