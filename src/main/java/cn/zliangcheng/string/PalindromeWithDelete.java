package cn.zliangcheng.string;

public class PalindromeWithDelete {

    public boolean validPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        while (start < s.length() / 2) {
            if (s.charAt(start) != s.charAt(end)) {
                break;
            }
            start++;
            end--;
        }
        return start >= end || isPalindrome(s, start + 1, end) || isPalindrome(s, start, end - 1);
    }

    public boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }
}
