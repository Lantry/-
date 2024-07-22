package cn.zliangcheng.binarysearch;

public class SingleInDuplication {
    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length / 2;
        while (left <= right) {
            int mid = (left + right) / 2;
            int index = 2 * mid;
            if (index < nums.length - 1 && nums[index] != nums[index + 1]) {
                if (mid == 0 || nums[index - 1] == nums[index - 2]) {
                    return nums[index];
                }

                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return nums[nums.length - 1];
    }
}
