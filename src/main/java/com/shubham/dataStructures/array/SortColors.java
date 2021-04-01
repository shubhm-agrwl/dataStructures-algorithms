package com.shubham.dataStructures.array;

public class SortColors {

  public static void main(String[] args) {
    sortColorsWorking(new int[]{2, 0, 2, 1, 1, 0});
  }

  public static void sortColors(int[] nums) {
    int k = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] < nums[k]) {
        int temp = nums[k];
        nums[k] = nums[i];
        nums[i] = temp;
        k++;
      }
    }
  }

  public static void sortColorsWorking(int[] nums) {

    int zero = 0;
    int cursor = 0;
    int two = nums.length - 1;

    while (zero <= two && cursor <= two) {
      if (nums[cursor] == 0) {
        int temp = nums[cursor];
        nums[cursor++] = nums[zero];
        nums[zero++] = temp;
      } else if (nums[cursor] == 2) {
        int temp = nums[cursor];
        nums[cursor] = nums[two];
        nums[two] = temp;
        two--;
      } else {
        cursor++;
      }
    }
  }

}
