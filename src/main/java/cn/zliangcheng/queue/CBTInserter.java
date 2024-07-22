package cn.zliangcheng.queue;

import java.util.LinkedList;
import java.util.Queue;

public class CBTInserter {
    Queue<TreeNode> queue;
    TreeNode root;

    public CBTInserter(TreeNode root) {
        this.queue = new LinkedList<>();
        this.root = root;
        queue.add(root);
    }

    public int insert(int v) {
        TreeNode newNode = new TreeNode(v);
        while (!queue.isEmpty()) {
            TreeNode node = queue.peek();
            if (node.left == null) {
                node.left = newNode;
                return node.val;
            } else if (node.right == null) {
                node.right = newNode;
                return node.val;
            } else {
                queue.poll();
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        return -1;
    }

    public TreeNode get_root() {
        return root;
    }
}
