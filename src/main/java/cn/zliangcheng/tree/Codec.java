package cn.zliangcheng.tree;

import java.util.Objects;

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }

        String left = serialize(root.left);
        String right = serialize(root.right);

        return root.val + "," + left + "," + right;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] dataArr = data.split(",");
        int[] cur = {0};

        return rebuild(dataArr, cur);
    }

    private TreeNode rebuild(String[] dataArr, int[] cur) {
        String data = dataArr[cur[0]];
        cur[0]++;

        if (Objects.equals(data, "#")) {
            return null;
        }
        TreeNode curNode = new TreeNode(Integer.parseInt(data));

        curNode.left = rebuild(dataArr, cur);
        curNode.right = rebuild(dataArr, cur);
        return curNode;
    }
}
