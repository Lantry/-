package cn.zliangcheng.backtracking;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        cycle(result, candidates, target, 0, new LinkedList<>());

        return result;
    }

    private void cycle(List<List<Integer>> result, int[] candidates, int target, int index, LinkedList<Integer> combine) {
        if (0 == target) {
            result.add(new ArrayList<>(combine));
            return;
        }

        if (target < 0 || index >= candidates.length) {
            return;
        }

        cycle(result, candidates, target, getNext(candidates, index), combine);

        combine.add(candidates[index]);

        cycle(result, candidates, target - candidates[index], index + 1, combine);

        combine.removeLast();
    }

    private int getNext(int[] candidates, int index) {
        int next = index;
        while (next < candidates.length && candidates[next] == candidates[index]) {
            next++;
        }

        return next;
    }

    public static void main(String[] args) {
        CombinationSum2 combinationSum2 = new CombinationSum2();
        List<List<Integer>> result = combinationSum2.combinationSum2(new int[]{1, 1, 2, 2, 5}, 5);
        System.out.println(result);
    }
}
