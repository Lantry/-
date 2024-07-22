package cn.zliangcheng.dp;

public class ClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[]{cost[0], cost[1]};
        for (int i = 2; i < cost.length; i++) {
            dp[i % 2] = Math.min(dp[0], dp[1]) + cost[i];
        }

        return Math.min(dp[0], dp[1]);
    }
}
