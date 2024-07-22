package cn.zliangcheng.tree;

import java.util.Stack;

public class FindTarget {
    public boolean findTarget(TreeNode root, int k) {
        BSTIterator iterator = new BSTIterator(root);
        BSTIteratorReverse iteratorReverse = new BSTIteratorReverse(root);
        int min = iterator.next();
        int large = iteratorReverse.next();
        while (min != large) {
            if (min + large == k) {
                return true;
            }
            if (min + large > k) {
                large = iteratorReverse.next();
                continue;
            }
            if (min + large < k) {
                min = iterator.next();
            }
        }
        return false;
    }

    class BSTIterator {
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

    class BSTIteratorReverse {
        TreeNode current;
        Stack<TreeNode> stack = new Stack<>();

        public BSTIteratorReverse(TreeNode root) {
            this.current = root;
        }

        public int next() {
            int result;
            while (current != null) {
                stack.push(current);
                current = current.right;
            }

            current = stack.pop();
            result = current.val;
            current = current.left;

            return result;
        }

        public boolean hasNext() {
            return current != null && !stack.isEmpty();
        }
    }
}
