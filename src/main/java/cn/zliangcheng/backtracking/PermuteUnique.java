package cn.zliangcheng.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class PermuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute(nums, result, 0);
        return result;
    }

    private void permute(int[] nums, List<List<Integer>> result, int index) {
        if (index == nums.length) {
            List<Integer> list = new LinkedList<>();
            for (int num : nums) {
                list.add(num);
            }
            result.add(list);
        } else {
            Set<Integer> set = new HashSet<>();
            for (int j = index; j < nums.length; j++) {
                if (set.contains(nums[j])) {
                    continue;
                }
                set.add(nums[j]);
                swap(nums, j, index);
                permute(nums, result, index + 1);
                swap(nums, index, j);
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
