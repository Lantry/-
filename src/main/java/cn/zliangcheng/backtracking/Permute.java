package cn.zliangcheng.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static java.util.Collections.swap;

public class Permute {
    public List<List<Integer>> permute(int[] nums) {
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
            for (int j = index; j < nums.length; j++) {
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
