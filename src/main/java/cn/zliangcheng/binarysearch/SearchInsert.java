package cn.zliangcheng.binarysearch;

public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int medium = (left + right) / 2;
            if (nums[medium] >= target) {
                if (medium == 0 || nums[medium - 1] < target) {
                    return medium;
                }

                right = medium - 1;
            } else {
                left = medium + 1;
            }
        }

        return nums.length;
    }
}
