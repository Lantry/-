package cn.zliangcheng.tree;

import java.util.Stack;

public class IncreasingBST {
    public TreeNode increasingBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;
        TreeNode fisrt = null;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            if (pre == null) {
                fisrt = cur;
            } else {
                pre.right = cur;
            }

            pre = cur;
            pre.left = null;
            cur = cur.right;
        }

        return fisrt;
    }
}
