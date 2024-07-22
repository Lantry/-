package cn.zliangcheng.hash;

public class AlienSortedWord {
    public boolean isAlienSorted(String[] words, String order) {
        int[] orderArray = new int[order.length()];
        for (int i = 0; i < order.length(); i++) {
            orderArray[order.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < words.length - 1; i++) {
            if (!sorted(words[i], words[i + 1], orderArray)) {
                return false;
            }
        }

        return true;
    }

    private boolean sorted(String word1, String word2, int[] orderArray) {
        int i = 0;
        for (; i < word1.length() && i < word2.length(); i++) {
            if (orderArray[word1.charAt(i) - 'a'] < orderArray[word2.charAt(i) - 'a']) {
                return true;
            }

            if (orderArray[word1.charAt(i) - 'a'] > orderArray[word2.charAt(i) - 'a']) {
                return false;
            }
        }
        return i == word1.length();
    }
}
