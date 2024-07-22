package cn.zliangcheng.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combine {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        cycle(result, new LinkedList<>(), n, 1, k);

        return result;
    }

    private void cycle(List<List<Integer>> result, LinkedList<Integer> subSet, int n, int index, int k) {
        if (subSet.size() == k) {
            result.add(new ArrayList<>(subSet));
        } else if (index <= n) {
            cycle(result, subSet, n, index + 1, k);
            subSet.add(index);
            cycle(result, subSet, n, index + 1, k);
            subSet.removeLast();
        }
    }
}
