package cn.zliangcheng.dp;

public class PlantingHouse {
    public int minCost(int[][] costs) {
        int[][] dp = new int[3][costs.length];
        dp[0][0] = costs[0][0];
        dp[1][0] = costs[0][1];
        dp[2][0] = costs[0][2];

        int count = costs.length;
        for (int i = 1; i < count; i++) {
            dp[0][i] = Math.min(dp[1][i - 1], dp[2][i - 1]) + costs[i][0];
            dp[1][i] = Math.min(dp[0][i - 1], dp[2][i - 1]) + costs[i][1];
            dp[2][i] = Math.min(dp[0][i - 1], dp[1][i - 1]) + costs[i][2];
        }

        return Math.min(dp[0][count - 1], Math.min(dp[1][count - 1], dp[2][count - 1]));
    }
}
