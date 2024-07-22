package cn.zliangcheng.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeLargest {
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Queue<TreeNode> cur = new LinkedList<>();
        Queue<TreeNode> next = new LinkedList<>();
        cur.add(root);

        List<Integer> res = new ArrayList<>();
        int curMax = Integer.MIN_VALUE;

        while (!cur.isEmpty()) {
            TreeNode curNode = cur.poll();
            if (curNode.left != null) {
                next.add(curNode.left);
            }

            if (curNode.right != null) {
                next.add(curNode.right);
            }

            curMax = Math.max(curMax, curNode.val);

            if (cur.isEmpty()) {
                res.add(curMax);
                curMax = Integer.MIN_VALUE;
                cur = next;
                next = new LinkedList<>();
            }
        }

        return res;
    }
}
