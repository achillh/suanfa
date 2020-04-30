package slidewindow;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/contains-duplicate-ii/
 */
public class LeetCode219 {
    public static void main(String[] args) {
        LeetCode219 leetCode219 = new LeetCode219();
        int[] array = {99, 99};
        System.out.println(leetCode219.containsNearbyDuplicate(array,2));
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k < 1 || nums.length < 1) {
            return false;
        }
        int left = 0, right = 0;
        Set<Integer> set = new HashSet<>();


        while (right < nums.length) {
            if (set.contains(nums[right])) {
                if (right - left <= k) {
                    return true;
                } else {
                    set.remove(nums[left++]);
                }
            } else {
                set.add(nums[right++]);
            }
        }
        return false;
    }

}
