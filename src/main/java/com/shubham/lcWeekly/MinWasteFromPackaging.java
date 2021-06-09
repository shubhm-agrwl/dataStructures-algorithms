package com.shubham.lcWeekly;

import java.util.Arrays;

public class MinWasteFromPackaging {

    public int minWastedSpace(int[] A, int[][] boxes) {
        Arrays.sort(A);
        long inf = (long)1e11, res = inf, mod = (long)1e9 + 7, sumA = 0L;
        for (int a : A)
            sumA += a;
        for (int[] B : boxes) {
            Arrays.sort(B);
            if (B[B.length - 1] < A[A.length - 1]) continue;
            long cur = 0, i = 0, j;
            for (int b : B) {
                j = binarySearch(A, b + 1);
                cur += b * (j - i);
                i = j;
            }
            res = Math.min(res, cur);
        }
        return res < inf ? (int)((res - sumA) % mod) : -1;
    }

    private int binarySearch(int[] A, int b) {
        int l = 0, r = A.length;
        while (l < r) {
            int m = (l + r) / 2;
            if (A[m] < b)
                l = m + 1;
            else
                r = m;
        }
        return l;
    }

}
