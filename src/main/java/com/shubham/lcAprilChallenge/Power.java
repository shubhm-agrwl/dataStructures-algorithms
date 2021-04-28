package com.shubham.lcAprilChallenge;

public class Power {

  public boolean isPowerOfThree(int n) {

    while (n > 0) {
      if (n % 3 == 0) {
        n = n / 3;
      } else {
        break;
      }
    }

    if (n == 1) {
      return true;
    }
    return false;
  }

  public boolean checkPowersOfThree(int n) {
    while (n > 1) {
      int r = n % 3;
      n = n / 3;
      if (r == 2) {
        return false;
      }
    }
    return true;
  }

  public boolean isPowerOfTwo(int n) {

    while (n > 0) {
      if (n % 2 == 0) {
        n = n / 2;
      } else {
        break;
      }
    }

    if (n == 1) {
      return true;
    }
    return false;
  }

  public boolean isPowerOfFour(int n) {
    while (n > 0) {
      if (n % 4 == 0) {
        n = n / 4;
      } else {
        break;
      }
    }

    if (n == 1) {
      return true;
    }
    return false;
  }

}
