package cn.zliangcheng.queue;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {
    int size;
    Queue<Integer> queue = new LinkedList<>();
    double sum = 0;

    public MovingAverage(int size) {
        this.size = size;
    }

    public double next(int val) {
        sum += val;
        queue.offer(val);

        if (queue.size() > size) {
            sum -= queue.poll();
            return sum / queue.size();
        }

        return sum / queue.size();
    }
}
