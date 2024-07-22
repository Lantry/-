package cn.zliangcheng.hash;

import java.util.*;

public class AnagramGroup {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str: strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortStr = new String(chars);

            map.putIfAbsent(sortStr, new ArrayList<>());
            map.get(sortStr).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
