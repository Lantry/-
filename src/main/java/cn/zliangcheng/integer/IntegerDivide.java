package cn.zliangcheng.integer;

public class IntegerDivide {
    public int divide(int a, int b) {
        if (b == 0) {
            return Integer.MAX_VALUE;
        }

        if (a == Integer.MIN_VALUE && b == -1) {
            return Integer.MAX_VALUE;
        }
        int flag = 1;
        if (a > 0) {
            a = -a;
            flag = -flag;
        }
        if (b > 0) {
            b = -b;
            flag = -flag;
        }
        int result = divideCore(a, b);
        return flag == 1 ? result : -result;
    }

    private int divideCore(int dividend, int divisor) {
        int result = 0;
        while (dividend <= divisor) {
            int value = divisor;
            int quoted = 1;
            while (value >= 0xc0000000 && dividend < value + value) {
                value += value;
                quoted = quoted << 1;
            }
            result += quoted;
            dividend = dividend - value;
        }
        return result;
    }
}
