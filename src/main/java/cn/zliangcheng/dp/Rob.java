package cn.zliangcheng.dp;

public class Rob {
    public int rob(int[] nums) {
        int[][] dp = new int[2][2];
        dp[0][0] = 0;
        dp[1][0] = nums[0];
        int length = nums.length;

        for (int i = 1; i < length; i++) {
            dp[0][i % 2] = Math.max(dp[0][(i - 1) % 2], dp[1][(i - 1) % 2]);
            dp[1][i % 2] = dp[0][(i - 1) % 2] + nums[i];
        }

        return Math.max(dp[0][(length - 1) % 2], dp[1][(length - 1) % 2]);
    }
}
