package cn.zliangcheng.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SubSet {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        cycle(result, new LinkedList<>(), nums, 0);

        return result;
    }

    private void cycle(List<List<Integer>> result, LinkedList<Integer> subSet, int[] nums, int index) {
        if (index == nums.length) {
            result.add(new ArrayList<>(subSet));
            return;
        }
        cycle(result, subSet, nums, index + 1);
        subSet.add(nums[index]);
        cycle(result, subSet, nums, index + 1);
        subSet.removeLast();
    }
}
