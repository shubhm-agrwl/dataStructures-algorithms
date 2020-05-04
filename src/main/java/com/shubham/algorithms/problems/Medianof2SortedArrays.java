package com.shubham.algorithms.problems;

public class Medianof2SortedArrays {

  public static void main(String[] args) {

    /*
     * Problem 4: There are two sorted arrays nums1 and nums2 of size m and n respectively.
     *
     * Find the median of the two sorted arrays. The overall run time complexity should be O(log
     * (m+n)).
     *
     * You may assume nums1 and nums2 cannot be both empty.
     *
     * Example 1:
     *
     * nums1 = [1, 3] nums2 = [2]
     *
     * The median is 2.0
     *
     * Example 2:
     *
     * nums1 = [1, 2] nums2 = [3, 4]
     *
     * The median is (2 + 3)/2 = 2.5
     */

    int nums[] = {1, 2};
    int nums2[] = {3, 4};
    System.out.println(Medianof2SortedArrays.findMedianSortedArrays(nums, nums2));

  }

  private static double findMedianSortedArrays(int[] nums1, int[] nums2) {

    int totalLenght = nums1.length + nums2.length;
    int[] resarr;
    boolean even = false;

    if (totalLenght % 2 == 0) {
      even = true;
    }
    resarr = new int[(totalLenght / 2) + 1];
    int k = 0, i = 0, j = 0;
    while (k < resarr.length) {
      if ((i < nums1.length) && (j < nums2.length)) {
        if (nums1[i] > nums2[j]) {
          resarr[k] = nums2[j];
          j++;
        } else {
          resarr[k] = nums1[i];
          i++;
        }
        k++;
        continue;
      }
      if (i < nums1.length) {
        resarr[k] = nums1[i];
        i++;
      }
      if (j < nums2.length) {
        resarr[k] = nums2[j];
        j++;
      }
      k++;
    }
    if (even) {
      return ((double) resarr[resarr.length - 1] + resarr[resarr.length - 2]) / 2;
    }
    return resarr[resarr.length - 1];
  }

  public double findMedianSortedArraysSol(int[] A, int[] B) {
    int m = A.length;
    int n = B.length;
    if (m > n) { // to ensure m<=n
      int[] temp = A;
      A = B;
      B = temp;
      int tmp = m;
      m = n;
      n = tmp;
    }
    int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
    while (iMin <= iMax) {
      int i = (iMin + iMax) / 2;
      int j = halfLen - i;
      if (i < iMax && B[j - 1] > A[i]) {
        iMin = i + 1; // i is too small
      } else if (i > iMin && A[i - 1] > B[j]) {
        iMax = i - 1; // i is too big
      } else { // i is perfect
        int maxLeft = 0;
        if (i == 0) {
          maxLeft = B[j - 1];
        } else if (j == 0) {
          maxLeft = A[i - 1];
        } else {
          maxLeft = Math.max(A[i - 1], B[j - 1]);
        }
        if ((m + n) % 2 == 1) {
          return maxLeft;
        }

        int minRight = 0;
        if (i == m) {
          minRight = B[j];
        } else if (j == n) {
          minRight = A[i];
        } else {
          minRight = Math.min(B[j], A[i]);
        }

        return (maxLeft + minRight) / 2.0;
      }
    }
    return 0.0;
  }

}
