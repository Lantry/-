package cn.zliangcheng.stack;

import java.util.Stack;

public class MaximalRectangle {
    public int maximalRectangle(String[] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].isEmpty()) {
            return 0;
        }
        int[] height = new int[matrix[0].length()];
        int maxArea = 0;
        for (String s : matrix) {
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '0') {
                    height[i] = 0;
                } else {
                    height[i]++;
                }
            }

            maxArea = Math.max(maxArea, largestRectangleArea(height));
        }

        return maxArea;
    }

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        stack.push(-1);
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[i] < heights[stack.peek()]) {
                int high = heights[stack.pop()];
                int width = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, high * width);
            }
            stack.push(i);
        }

        while (stack.peek() != -1 ) {
            int high = heights[stack.pop()];
            int width = heights.length - stack.peek() - 1;
            maxArea = Math.max(maxArea, high * width);
        }
        return maxArea;
    }
}
