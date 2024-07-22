package cn.zliangcheng.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        calculate(result, new LinkedList<>(), candidates, target, 0, 0);

        return result;
    }

    private void calculate(List<List<Integer>> result, LinkedList<Integer> combine, int[] candidates, int target, int index, int sum) {
        if (index >= candidates.length || sum > target) {
            return;
        }
        if (sum == target) {
            result.add(new ArrayList<>(combine));
            return;
        }

        sum += candidates[index];
        combine.add(candidates[index]);
        calculate(result, combine, candidates, target, index, sum);
        sum -= candidates[index];
        combine.removeLast();
        calculate(result, combine, candidates, target, index + 1, sum);
    }
}
