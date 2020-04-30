package TwoPointer;

public class LeetCode26 {

    public static void main(String[] args) {
        LeetCode26 leetCode26 = new LeetCode26();
        int[] array = {1, 1, 2};
        System.out.println(leetCode26.removeDuplicates(array));
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int left = 0, right = left + 1;
        for (; right < nums.length; right++) {
            if (nums[right] != nums[left]) {
                nums[++left] = nums[right];
            }
        }
        return left;
    }
}
