package slidewindow;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class leetcode3 {
    public static void main(String[] args) {
        leetcode3 ml = new leetcode3();
        System.out.println(ml.lengthOfLongestSubstring(" "));
    }

    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, ans = 0;
        Set<Character> set = new HashSet<>();
        while (left < s.length() && right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right++));
                ans = Math.max(ans, right - left);
            }else {
                set.remove(s.charAt(left++));
            }
        }

        return ans;
    }

    private boolean inCondition(int[] result) {
        for (int i : result) {
            if (i > 1) {
                return false;
            }
        }
        return true;
    }
}
