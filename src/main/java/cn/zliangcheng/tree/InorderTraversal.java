package cn.zliangcheng.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 如果按照中序遍历的顺序，则先遍历二叉树的左子树，然后遍历二叉树的根节点，最后遍历二叉树的右子树。
 */
public class InorderTraversal {
    public List<Integer> inorderTraversalDFS(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    public void dfs(TreeNode root, List<Integer> res) {
        if (root != null) {
            dfs(root.left, res);
            res.add(root.val);
            dfs(root.right, res);
        }
    }

    public List<Integer> inorderTraversalStack(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }
}
