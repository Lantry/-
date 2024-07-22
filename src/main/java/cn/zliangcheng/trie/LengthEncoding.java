package cn.zliangcheng.trie;

public class LengthEncoding {
    public int minimumLengthEncoding(String[] words) {
        Node root = buildTrie(words);
        int[] total = new int[]{0};
        dfs(root, 1, total);
        return total[0];
    }

    private Node buildTrie(String[] words) {
        Node root = new Node();
        for (String word : words) {
            Node cur = root;
            for (int i = word.length() - 1; i >= 0; i--) {
                char ch = word.charAt(i);

                if (cur.children[ch - 'a'] == null) {
                    cur.children[ch - 'a'] = new Node();
                }

                cur = cur.children[ch - 'a'];
            }
        }

        return root;
    }

    private void dfs(Node cur, int length, int[] total) {
        boolean isLeaf = true;
        for (Node child : cur.children) {
            if (child != null) {
                isLeaf = false;
                dfs(child, length + 1, total);
            }
        }

        if (isLeaf) {
            total[0] += length;
        }
    }

    public static class Node {
        Node[] children;

        public Node() {
            children = new Node[26];
        }
    }
}
