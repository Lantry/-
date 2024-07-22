package cn.zliangcheng.string;

public class NotDuplicationSubArray {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int max = 0;
        boolean flag = false;
        int[] count = new int[256];

        for (int right = 0; right < s.length(); right++) {
            if (count[s.charAt(right)] != 0) {
                flag = true;
            }
            while (left < right && flag) {
                count[s.charAt(left)]--;
                left++;

                if (count[s.charAt(right)] == 0) {
                    flag = false;
                }
            }

            count[s.charAt(right)]++;
            max = Math.max(max, right - left + 1);
        }

        return max;
    }

    public boolean checkExist(int[] count, Character c) {
        return count[c] != 0;
    }
}
