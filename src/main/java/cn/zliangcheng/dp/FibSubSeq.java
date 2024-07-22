package cn.zliangcheng.dp;

import java.util.HashMap;
import java.util.Map;

public class FibSubSeq {
    public int lenLongestFibSubseq(int[] arr) {
        Map<Integer, Integer> temp = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            temp.put(arr[i], i);
        }

        int[][] dp = new int[arr.length][arr.length];
        int result = 0;

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0, k = i - 1; j < k; j++, k--) {
                if (arr[i] == arr[j] + arr[k]) {
                    dp[i][k] = dp[k][j] == 0 ? 3 : dp[i][k] + 1;
                }
                result = Math.max(result, dp[i][k]);
            }
        }

        return result > 2 ? result : 0;
    }
}
