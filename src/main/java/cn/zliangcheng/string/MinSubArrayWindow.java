package cn.zliangcheng.string;

import java.util.HashMap;
import java.util.Map;

public class MinSubArrayWindow {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int minLen = Integer.MAX_VALUE;
        int left = 0;
        String str = "";

        for (int right = 0; right < s.length(); right++) {
            if (map.containsKey(s.charAt(right))) {
                map.put(s.charAt(right), map.get(s.charAt(right)) - 1);
                while (checkContainSubString(map)) {
                    int currentMin = Math.min(minLen, right - left + 1);
                    if (currentMin < minLen) {
                        minLen = currentMin;
                        str = s.substring(left, right + 1);
                    }
                    if (map.containsKey(s.charAt(left))) {
                        map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                    }
                    left++;
                }
            }
        }

        return str;
    }

    public boolean checkContainSubString(Map<Character, Integer> map) {
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 0) {
                return false;
            }
        }

        return true;
    }
}
