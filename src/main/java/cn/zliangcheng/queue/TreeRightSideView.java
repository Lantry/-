package cn.zliangcheng.queue;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }
        Queue<TreeNode> cur = new LinkedList<>();
        Queue<TreeNode> next = new LinkedList<>();
        cur.add(root);

        List<Integer> res = new LinkedList<>();

        while (!cur.isEmpty()) {
            TreeNode node = cur.poll();
            if (node.left != null) {
                next.add(node.left);
            }

            if (node.right != null) {
                next.add(node.right);
            }

            if (cur.isEmpty()) {
                res.add(node.val);
                cur = next;
                next = new LinkedList<>();
            }
        }

        return res;
    }
}
