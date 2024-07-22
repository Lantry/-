package cn.zliangcheng.sort;

import java.util.Random;

public class FindKLargest {
    public int findKthLargest(int[] nums, int k) {
        int target = nums.length - k;
        int start = 0;
        int end = nums.length - 1;
        int index = partition(nums, start, end);
        while (index != target) {
            if (index < target) {
                start = index + 1;
            } else {
                end = index - 1;
            }
            index = partition(nums, start, end);
        }
        return nums[index];
    }

    private int partition(int[] nums, int start, int end) {
        int index = new Random().nextInt(end - start + 1) + start;
        swap(nums, index, end);
        int small = start - 1;
        for (int i = start; i <= end; i++) {
            if (nums[i] < nums[end]) {
                small++;
                swap(nums, small, i);
            }
        }
        small++;
        swap(nums, small, end);
        return small;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
