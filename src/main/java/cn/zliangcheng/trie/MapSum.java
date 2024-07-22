package cn.zliangcheng.trie;

public class MapSum {
    Node root;

    public MapSum() {
        root = new Node();
    }

    public void insert(String key, int val) {
        Node cur = root;
        for (char ch : key.toCharArray()) {
            if (cur.children[ch - 'a'] == null) {
                cur.children[ch - 'a'] = new Node();
            }

            cur = cur.children[ch - 'a'];
        }

        cur.value = val;
    }

    public int sum(String prefix) {
        Node cur = root;
        for (char ch : prefix.toCharArray()) {
            if (cur.children[ch - 'a'] == null) {
                return 0;
            }

            cur = cur.children[ch - 'a'];
        }

        return getSum(cur);
    }

    private int getSum(Node root) {
        if (root == null) {
            return 0;
        }

        int result = root.value;
        for (Node cur : root.children) {
            result += getSum(cur);
        }

        return result;
    }

    public static class Node {
        Node[] children;
        int value;

        public Node() {
            children = new Node[26];
            value = 0;
        }
    }
}
