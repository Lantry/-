package cn.zliangcheng.dp;

public class Rob2 {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int result1 = robHelper(0, nums.length - 1, nums);
        int result2 = robHelper(1, nums.length, nums);
        return Math.max(result1, result2);
    }

    private int robHelper(int start, int end, int[] nums) {
        int[][] dp = new int[2][2];
        dp[0][start] = 0;
        dp[1][start] = nums[start];
        for (int i = start + 1; i < end; i++) {
            dp[0][i % 2] = Math.max(dp[0][(i - 1) % 2], dp[1][(i - 1) % 2]);
            dp[1][i % 2] = nums[i] + dp[0][(i - 1) % 2];
        }

        return Math.max(dp[0][(end - 1) % 2], dp[1][(end - 1) % 2]);
    }
}
