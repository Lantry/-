package cn.zliangcheng.string;

public class SubPalindromeStr {
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += subPalindrome(s, i, i);
            count += subPalindrome(s, i, i + 1);
        }

        return count;
    }

    public int subPalindrome(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }
}
