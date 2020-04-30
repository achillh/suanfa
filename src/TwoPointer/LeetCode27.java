package TwoPointer;

import slidewindow.Leetcode438;

public class LeetCode27 {

    public int removeElement(int[] nums, int val) {
        int left = 0, right = 0;
        for (; right < nums.length; right++) {
            if (nums[right] != val) {
                nums[left++] = nums[right];
            }
        }
        return left;
    }
}
