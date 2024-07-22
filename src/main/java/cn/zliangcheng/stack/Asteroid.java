package cn.zliangcheng.stack;

import java.util.Stack;

public class Asteroid {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {
            if (asteroid < 0) {
                while (!stack.isEmpty()
                        && stack.peek() > 0
                        && Math.abs(asteroid) > stack.peek()) {
                    stack.pop();
                }
                if (!stack.isEmpty() && Math.abs(asteroid) < stack.peek()) {
                    continue;
                }

                if (!stack.isEmpty() && Math.abs(asteroid) == stack.peek()) {
                    stack.pop();
                    continue;
                }

            }
            stack.push(asteroid);
        }

        return stack.stream().mapToInt(i -> i).toArray();
    }
}
