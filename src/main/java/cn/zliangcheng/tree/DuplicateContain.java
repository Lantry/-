package cn.zliangcheng.tree;

import java.util.HashMap;
import java.util.Map;

public class DuplicateContain {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        Map<Integer, Integer> map = new HashMap<>();
        int bucketSize = t + 1;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int id = generateId(num, bucketSize);
            if (map.containsKey(id)
                    || map.containsKey(id - 1) && map.get(id - 1) + t >= num
                    || map.containsKey(id + 1) && map.get(id + 1) - t <= num) {
                return true;
            }
            map.put(id, num);
            if (i >= k) {
                map.remove(generateId(nums[i - k], bucketSize));
            }
        }
        return false;
    }

    private int generateId(int num, int bucketSize) {
        return num >= 0 ? num / bucketSize : (num + 1) / bucketSize - 1;
    }
}
