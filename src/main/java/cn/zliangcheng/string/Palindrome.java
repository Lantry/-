package cn.zliangcheng.string;

public class Palindrome {
    public static boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }

        String s1 = s.toLowerCase();
        int left = 0;
        int right = s1.length() - 1;
        while (left < right) {
            if (!Character.isLetterOrDigit(s1.charAt(left))) {
                left++;
            } else if (!Character.isLetterOrDigit(s1.charAt(right))) {
                right--;
            } else {
                if (s1.charAt(left++) != s1.charAt(right--)) {
                    return false;
                }
            }

        }

        return true;
    }
}
