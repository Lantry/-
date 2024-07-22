package cn.zliangcheng.array;

public class MinSubArray {
    public int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int left = 0;
        int right = 0;
        int current = 0;
        int min = Integer.MAX_VALUE;

        while (right < nums.length) {
            current += nums[right++];
            while (left < right && current >= target) {
                min = Math.min(min, right - left);
                current -= nums[left++];
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
