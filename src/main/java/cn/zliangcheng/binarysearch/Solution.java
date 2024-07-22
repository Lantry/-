package cn.zliangcheng.binarysearch;

import java.util.Random;

/**
 * 权重数组随机.
 * 给定一个正整数数组 w ，其中 w[i] 代表下标 i 的权重（下标从 0 开始），请写一个函数 pickIndex ，它可以随机地获取下标 i，选取下标 i 的概率与 w[i] 成正比。
 * 例如，对于 w = [1, 3]，挑选下标 0 的概率为 1 / (1 + 3) = 0.25 （即，25%），而选取下标 1 的概率为 3 / (1 + 3) = 0.75（即，75%）。
 * 也就是说，选取下标 i 的概率为 w[i] / sum(w)
 */
public class Solution {
    int[] sum;
    int total;

    public Solution(int[] w) {
        sum = new int[w.length];
        for (int i = 0; i < w.length; i++) {
            total += w[i];
            sum[i] = total;
        }
    }

    public int pickIndex() {
        Random random = new Random();
        int nextInt = random.nextInt(total);

        int left = 0;
        int right = sum.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (sum[mid] > nextInt) {
                if (mid == 0 || sum[mid - 1] <= nextInt) {
                    return mid;
                }

                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return sum.length - 1;
    }
}
