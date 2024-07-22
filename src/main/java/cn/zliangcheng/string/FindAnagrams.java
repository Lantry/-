package cn.zliangcheng.string;

import java.util.ArrayList;
import java.util.List;

public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();

        if (s.length() < p.length()) {
            return res;
        }

        int[] count = new int[26];

        for (int i = 0; i < p.length(); i++) {
            count[p.charAt(i) - 'a']++;
            count[s.charAt(i) - 'a']--;
        }

        if (checkZero(count)) {
            res.add(0);
        }

        for (int i = p.length(); i < s.length(); i++) {
            count[s.charAt(i) - 'a']--;
            count[s.charAt(i - p.length()) - 'a']++;
            if (checkZero(count)) {
                res.add(i - p.length() + 1);
            }
        }

        return res;
    }

    public boolean checkZero(int[] count) {
        for (int i : count) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }
}
