package cn.zliangcheng.queue;

import java.util.LinkedList;
import java.util.Queue;

public class RecentCounter {
    int windowSize = 3000;
    Queue<Integer> queue;
    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        while (!queue.isEmpty() && queue.peek() + windowSize < t) {
            queue.poll();
        }
        queue.offer(t);

        return queue.size();
    }
}
