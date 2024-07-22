package cn.zliangcheng.hash;

public class Anagram {
    public boolean isAnagram(String s, String t) {
        int[] count = new int[26];
        if (s.length() != t.length() || s.equals(t)) {
            return false;
        }

        for (int c : s.toCharArray()) {
            count[c - 'a']++;
        }

        for (int c : t.toCharArray()) {
            if (count[c - 'a'] == 0) {
                return false;
            }

            count[c - 'a']--;
        }

        return true;
    }
}
