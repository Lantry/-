package cn.zliangcheng.dp;

public class MonoIncr {
    public int minFlipsMonoIncr(String s) {
        int[][] dp = new int[2][2];
        dp[0][0] = s.charAt(0) == '0' ? 0 : 1;
        dp[1][0] = s.charAt(0) == '1' ? 0 : 1;

        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '0') {
                dp[0][i % 2] = dp[0][(i - 1) % 2];
                dp[1][i % 2] = Math.min(dp[0][(i - 1) % 2], dp[1][(i - 1) % 2]) + 1;
            } else if (c == '1') {
                dp[0][i % 2] = dp[0][(i - 1) % 2] + 1;
                dp[1][i % 2] = Math.min(dp[0][(i - 1) % 2], dp[1][(i - 1) % 2]);
            }
        }

        return Math.min(dp[0][(s.length() - 1) % 2], dp[1][(s.length() - 1) % 2]);
    }
}
