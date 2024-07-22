package cn.zliangcheng.tree;

import java.util.HashMap;
import java.util.Map;

public class PathSum {
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        return dfs(root, targetSum, 0L, map);
    }

    private int dfs(TreeNode root, int targetSum, long path, Map<Long, Integer> map) {
        if (root == null) {
            return 0;
        }

        path += root.val;

        int count = map.getOrDefault(path - targetSum, 0);
        map.put(path, map.getOrDefault(path, 0) + 1);

        count += dfs(root.left, targetSum, path, map);
        count += dfs(root.right, targetSum, path, map);

        map.put(path, map.get(path) - 1);

        return count;
    }
}
