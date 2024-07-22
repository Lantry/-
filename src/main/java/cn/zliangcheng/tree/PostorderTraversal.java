package cn.zliangcheng.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 在后序遍历中，先遍历左子树，再遍历右子树，最后遍历根节点。
 */
public class PostorderTraversal {
    public List<Integer> postorderTraversalDFS(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, result);
        return result;
    }

    private void dfs(TreeNode root, List<Integer> result) {
        if (root != null) {
            dfs(root.left, result);
            dfs(root.right, result);
            result.add(root.val);
        }
    }

    public List<Integer> postorderTraversalStack(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.peek();
            if (cur.right != null && cur.right != pre) {
                cur = cur.right;
            } else {
                result.add(cur.val);
                pre = stack.pop();
                cur = null;
            }
        }

        return result;
    }
}
