package cn.zliangcheng.trie;

public class MaximumXOR {
    public int findMaximumXOR(int[] nums) {
        int max = Integer.MIN_VALUE;
        Node root = buildTrie(nums);

        for (int num : nums) {
            Node cur = root;
            int xor = 0;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (cur.children[1 - bit] != null) {
                    xor = (xor << 1) + 1;
                    cur = cur.children[1 - bit];
                } else {
                    xor = xor << 1;
                    cur = cur.children[bit];
                }
            }
            max = Math.max(max, xor);
        }

        return max;
    }

    public Node buildTrie(int[] nums) {
        Node root = new Node();
        for (int num : nums) {
            Node cur = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (cur.children[bit] == null) {
                    cur.children[bit] = new Node();
                }

                cur = cur.children[bit];
            }
        }

        return root;
    }

    static class Node {
        Node[] children;

        public Node() {
            children = new Node[2];
        }
    }
}
