package cn.zliangcheng.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PartitionPalindrome {
    public String[][] partition(String s) {
        List<List<String>> result = new ArrayList<>();
        cycle(result, s, 0, new LinkedList<>());
        return result.stream().map(list -> list.toArray(new String[0])).toArray(String[][]::new);
    }

    private void cycle(List<List<String>> result, String s, int start, LinkedList<String> temp) {
        if (start == s.length()) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int index = start; index < s.length(); index++) {
            String substring = s.substring(start, index + 1);
            if (isPalindromeString(substring)) {
                temp.add(substring);
                cycle(result, s, index + 1, temp);
                temp.removeLast();
            }
        }
    }

    private boolean isPalindromeString(String substring) {
        int start = 0;
        int end = substring.length() - 1;
        while (start <= end) {
            if (substring.charAt(start++) != substring.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PartitionPalindrome partitionPalindrome = new PartitionPalindrome();
        System.out.println(partitionPalindrome.partition("google"));
    }
}
