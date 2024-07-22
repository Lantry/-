package cn.zliangcheng.array;

import java.util.HashMap;
import java.util.Map;

public class SubArraySum {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> sumToCount = new HashMap<>();
        int sum = 0;
        int count = 0;
        sumToCount.put(0, 1);
        for (int num : nums) {
            sum += num;
            count += sumToCount.getOrDefault(sum - k, 0);
            sumToCount.put(sum, sumToCount.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
