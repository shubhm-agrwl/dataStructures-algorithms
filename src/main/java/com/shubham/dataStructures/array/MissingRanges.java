package com.shubham.dataStructures.array;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        int prev = lower - 1;
        for (int i = 0; i <= nums.length; i++) {
            int curr = (i < nums.length) ? nums[i] : upper + 1;
            if (prev + 1 <= curr - 1) {
                if (prev + 1 == curr - 1) {
                    res.add(String.valueOf(prev + 1));
                } else {
                    res.add((prev + 1) + "->" + (curr - 1));
                }
            }
            prev = curr;
        }
        return res;
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        for (int i=0; i<nums.length;i++) {
            int prev = nums[i];
            while (i<nums.length-1 && nums[i+1]-nums[i]==1){
                i++;
            }
            if (prev==nums[i]){
                res.add(String.valueOf(prev));
            } else {
                res.add(prev+"->"+nums[i]);
            }
        }
        return res;
    }
}
