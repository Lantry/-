package cn.zliangcheng.integer;

public class NumberOccursTimes {
    /**
     * 输入一个整数数组，数组中只有一个数字出现m次，其他数字都出现n次。请找出那个唯一出现m次的数字。假设m不能被n整除
     */
    public int singleNumber(int[] nums, int m, int n) {
       int[] counts = new int[32];
       for (int num : nums) {
           for (int i = 0; i < 32; i++) {
               counts[i] += (num >> (31 - i) & 1);
           }
       }
       int res = 0;
       for (int i = 0; i < 32; i++) {
           res = (res << 1) + counts[i] % n;
       }
       return res;
    }

    public int[] singleNumber2(int[] nums) {
        int eor = 0;
        int[] res = new int[2];
        for (int num : nums) {
            eor ^= num;
        }
        int right = eor & -eor;
        for (int num : nums) {
            if ((num & right) == 0) {
                res[0] ^= num;
            }
        }
        res[1] = res[0] ^ eor;
        return res;
    }
}
