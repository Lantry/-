package cn.zliangcheng.trie;

import java.util.ArrayList;
import java.util.List;

public class ReplaceWord {
    public String replaceWords(List<String> dictionary, String sentence) {
        Node root = buildTree(dictionary);
        String[] s = sentence.split(" ");
        for (int i = 0; i < s.length; i++) {
            String prefix = findPrefix(root, s[i]);
            s[i] = prefix.isEmpty() ? s[i] : prefix;
        }
        return String.join(" ", s);
    }

    Node buildTree(List<String> dictionary) {
        Node root = new Node();
        for (String word : dictionary) {
            Node curr = root;
            for (char c : word.toCharArray()) {
                if (curr.children[c - 'a'] == null) {
                    curr.children[c - 'a'] = new Node();
                }
                curr = curr.children[c - 'a'];
            }
            curr.isEnd = true;
        }
        return root;
    }

    String findPrefix(Node root, String word) {
        Node curr = root;
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (curr.isEnd || curr.children[c - 'a'] == null) {
                break;
            }
            sb.append(c);
            curr = curr.children[c - 'a'];

        }
        return curr.isEnd ? sb.toString() : "";
    }

    class Node {
        Node[] children;
        boolean isEnd;

        public Node() {
            children = new Node[26];
            isEnd = false;
        }
    }
}
