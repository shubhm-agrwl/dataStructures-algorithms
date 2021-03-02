package com.shubham.dataStructures.array;

public class MergeSortedArrays {

  public static void main(String[] args) {

  }

  public void merge(int[] nums1, int m, int[] nums2, int n) {

    int i = m -1;
    int j = n -1;
    int len = m + n;
    int k = 1;
    while (i >= 0 || j >= 0 ){
      if( i >= 0 && j >= 0 ){
        if(nums1[i] < nums2[j]){
          nums1[len - k] = nums2[j--];
        } else {
          nums1[len - k] = nums1[i--];
        }
        k++;
        continue;
      }

      if (i >= 0){
        nums1[len - k] = nums1[i--];
        k++;
      }

      if (j >= 0){
        nums1[len - k] = nums2[j--];
        k++;
      }
    }


  }

}
