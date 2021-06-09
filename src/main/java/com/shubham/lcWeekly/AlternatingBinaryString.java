package com.shubham.lcWeekly;

import java.util.HashSet;
import java.util.Set;

public class AlternatingBinaryString {

    public static void main(String[] args) {
        System.out.println(minFlips("111000"));
    }

    public static int minFlips(String s) {
        int min = Integer.MAX_VALUE;
        int n = s.length();
        Set<Integer> set = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        int expected = s.charAt(0) - '0';
        int expected2 = 1 - (s.charAt(0) - '0');
        for (int i = 0; i < 2*n; i++) {
            if (s.charAt(i % n) - '0' != expected) {
                set.add(i);
            }
            if (s.charAt(i % n) - '0' != expected2) {
                set2.add(i);
            }
            expected = 1 - expected;
            expected2 = 1 - expected2;
            if (i > n - 1) {
                set.remove(i - n);
                set2.remove(i - n);
            }
            if (i >= n - 1) {
                min = Math.min(set.size(), Math.min(set2.size(), min));
            }
        }
        return min;
    }
}
