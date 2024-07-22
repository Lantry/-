package cn.zliangcheng.integer;

public class WordLengthMultiplication {
    public int maxProduct(String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }
        int[] flag = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (Character c : words[i].toCharArray()) {
                flag[i] |= 1 << (c - 'a');
            }
        }

        int max = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((flag[i] & flag[j]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }

        return max;
    }
}
