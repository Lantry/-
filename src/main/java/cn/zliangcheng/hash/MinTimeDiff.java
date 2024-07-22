package cn.zliangcheng.hash;

import java.util.List;

public class MinTimeDiff {
    public int findMinDifference(List<String> timePoints) {
        if (timePoints.size() > 1440) {
            return 0;
        }
        boolean[] allTime = new boolean[1440];
        for (String timePoint : timePoints) {
            String[] hourAndMinutes = timePoint.split(":");
            int time = Integer.parseInt(hourAndMinutes[0]) * 60 + Integer.parseInt(hourAndMinutes[1]);
            if (allTime[time]) {
                return 0;
            }

            allTime[time] = true;
        }

        return calculateTime(allTime);
    }

    private int calculateTime(boolean[] allTime) {
        int pre = -1;
        int min = allTime.length;
        int first = allTime.length;
        int last = -1;
        for (int i = 0; i < allTime.length; i++) {
            if (allTime[i]) {
                if (pre >= 0) {
                    min = Math.min(i - pre, min);
                }

                pre = i;
                first = Math.min(i, first);
                last = Math.max(i, last);
            }
        }

        return Math.min(first + allTime.length - last, min);
    }
}
