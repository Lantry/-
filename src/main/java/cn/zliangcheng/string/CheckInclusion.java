package cn.zliangcheng.string;

public class CheckInclusion {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] count = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }

        if (checkZero(count)) {
            return true;
        }

        for (int i = s1.length(); i < s2.length(); i++) {
            count[s2.charAt(i) - 'a']--;
            count[s2.charAt(i - s1.length()) - 'a']++;
            if (checkZero(count)) {
                return true;
            }
        }

        return false;
    }

    private boolean checkZero(int[] count) {
        for (int i : count) {
            if (i != 0) {
                return false;
            }
        }
         return true;
    }
}
