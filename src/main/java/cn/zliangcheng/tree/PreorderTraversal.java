package cn.zliangcheng.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的前序遍历, 即先遍历二叉树的根节点，再遍历二叉树的左子树，最后遍历二叉树的右子树.
 */
public class PreorderTraversal {
    public List<Integer> preorderTraversalDFS(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, result);
        return result;
    }

    private void dfs(TreeNode root, List<Integer> result) {
        if (root != null) {
            result.add(root.val);
            dfs(root.left, result);
            dfs(root.right, result);
        }
    }

    public List<Integer> preorderTraversalStack(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                result.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            cur = cur.right;
        }

        return result;
    }
}
