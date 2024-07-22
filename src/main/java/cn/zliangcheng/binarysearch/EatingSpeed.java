package cn.zliangcheng.binarysearch;

public class EatingSpeed {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        int left = 1;
        int right = max;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (getHour(piles, mid) <= h) {
                if (mid == 1 || getHour(piles, mid - 1) > h) {
                    return mid;
                }
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public int getHour(int[] piles, int speed) {
        int hour = 0;
        for (int pile : piles) {
            hour += (pile + speed - 1) / speed;
        }

        return hour;
    }
}
