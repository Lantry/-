package cn.zliangcheng.binarysearch;

public class Sqrt {
    public int mySqrt(int x) {
        int left = 1;
        int right = x - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (mid <= x / mid) {
                if (mid >= x / (mid + 1)) {
                    return mid;
                }

                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return x;
    }
}
