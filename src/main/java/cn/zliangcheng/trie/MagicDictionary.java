package cn.zliangcheng.trie;

public class MagicDictionary {
    static class Node {
        Node[] children;
        boolean isEnd;

        public Node() {
            children = new Node[26];
            isEnd = false;
        }
    }

    Node root;

    /** Initialize your data structure here. */
    public MagicDictionary() {
        root = new Node();
    }

    public void buildDict(String[] dictionary) {
        for (String word : dictionary) {
            Node current = root;
            for (char c : word.toCharArray()) {
                if (current.children[c - 'a'] == null) {
                    current.children[c - 'a'] = new Node();
                }
                current = current.children[c - 'a'];
            }
            current.isEnd = true;
        }
    }

    public boolean search(String searchWord) {
        return dfs(root, searchWord, 0, 0);
    }

    public boolean dfs(Node current, String searchWord, int index, int edit) {
        if (current == null) {
            return false;
        }
        if (current.isEnd && searchWord.length() == index && edit == 1) {
            return true;
        }
        if (index < searchWord.length() && edit <= 1) {
            boolean result = false;
            for (int i =0; i < 26 && !result; i++) {
                int nextEdit = searchWord.charAt(index) - 'a' == i ? edit : edit + 1;
                result = dfs(current.children[i], searchWord, index + 1, nextEdit);
            }
            return result;
        }
        return false;
    }
}
