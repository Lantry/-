package cn.zliangcheng.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumArray {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        // i自增的操作通过while中的i++实现
        for (int i = 0; i < nums.length - 2;) {
            sumTwo(nums, i, result);
            int temp = nums[i];
            while (i < nums.length && nums[i + 1] == temp) {
                i++;
            }
        }
        return result;
    }

    private void sumTwo(int[] nums, int i, List<List<Integer>> result) {
        int j = i + 1;
        int k = nums.length - 1;
        while (j < k) {
            int sum = nums[i] + nums[j] + nums[k];
            if (sum == 0) {
                result.add(List.of(nums[i], nums[j], nums[k]));
                int temp = nums[j];
                while (j < k && nums[j + 1] == temp) {
                    j++;
                }
            } else if (sum < 0) {
                j++;
            } else {
                k--;
            }
        }
    }
}
