package cn.zliangcheng.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KSmallPairs {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> nums1[p1[0]] + nums2[p1[1]] - nums1[p2[0]] - nums2[p2[1]]);
        List<List<Integer>> res = new ArrayList<>();
        if (nums2.length > 0) {
            for (int i = 0; i < Math.min(k, nums1.length); i++) {
                pq.offer(new int[]{i, 0});
            }
        }

        while (k-- > 0 && !pq.isEmpty()) {
            int[] poll = pq.poll();
            res.add(List.of(nums1[poll[0]], nums2[poll[1]]));

            if (poll[1] < nums2.length - 1) {
                pq.offer(new int[]{poll[0], poll[1] + 1});
            }
        }

        return res;
    }
}
