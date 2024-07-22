package cn.zliangcheng.tree;

import java.util.Map;
import java.util.TreeMap;

public class MyCalendar {
    TreeMap<Integer, Integer> map;

    public MyCalendar() {
        map = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Map.Entry<Integer, Integer> beforeEvent = map.floorEntry(start);
        if (beforeEvent != null && beforeEvent.getValue() > start) {
            return false;
        }
        Map.Entry<Integer, Integer> afterEvent = map.ceilingEntry(start);
        if (afterEvent != null && afterEvent.getKey() < end) {
            return false;
        }

        map.put(start, end);

        return true;
    }
}
