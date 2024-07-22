package cn.zliangcheng.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeSection {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> result = new ArrayList<>();
        int index = 0;
        while (index < intervals.length) {
            int[] temp = new int[]{intervals[index][0], intervals[index][1]};
            int newIndex = index + 1;
            while (newIndex < intervals.length && intervals[newIndex][0] <= temp[1]) {
                temp[1] = Math.max(temp[1], intervals[newIndex][1]);
                newIndex++;
            }

            result.add(temp);
            index = newIndex;
        }

        return result.toArray(new int[result.size()][]);
    }
}
