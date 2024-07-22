package cn.zliangcheng.tree;

import java.util.Stack;

public class BSTIterator {
    TreeNode current;
    Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        this.current = root;
    }

    public int next() {
        int result;
        while (current != null) {
            stack.push(current);
            current = current.left;
        }

        current = stack.pop();
        result = current.val;
        current = current.right;

        return result;
    }

    public boolean hasNext() {
        return current != null && !stack.isEmpty();
    }
}
