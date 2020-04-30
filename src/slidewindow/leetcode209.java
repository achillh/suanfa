package slidewindow;

import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 */
public class leetcode209 {
    public static void main(String[] args) {
        leetcode209 leetcode209 = new leetcode209();
        System.out.println(leetcode209.minWindow("cabwefgewcwaefgcf",
                "cae"));
    }

    /**
     * https://leetcode-cn.com/problems/minimum-size-subarray-sum/
     * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int left=0, right = 0;
        int result = Integer.MAX_VALUE;
        int sum = 0;
        while (right < len) {
            sum += nums[right++];
            while (sum >= s) {
                result = Math.min(result, right - left);

                sum -= nums[left++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    /**
     * https://leetcode-cn.com/problems/minimum-window-substring/
     * @param s source
     * @param t target
     * @return
     */
    public String minWindow(String s, String t) {
        int left = 0, right = 0,resultLeft=0;
        Map<String, Integer> target = new HashMap<>();
        Map<String, Integer> window = new HashMap<>();
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < t.length(); i++) {
            String key = t.substring(i, i + 1);
            put(key,target);
        }

        while (right < s.length()) {
            String c = s.substring(right, right + 1);
            put(c,window);
            right++;
            while (isCondition(window, target)) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    resultLeft = left;
                }
                String leftStr = s.substring(left, left + 1);
                window.put(leftStr, window.get(leftStr).intValue() - 1);
                left++;
            }

        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(resultLeft, minLen+resultLeft-1);
    }



    private void put(String key, Map<String, Integer> target) {
        if (target.containsKey(key)) {
            target.put(key, (target.get(key).intValue()) + 1);
        }else{
            target.put(key, 1);
        }
    }

    private boolean isCondition(Map<String,Integer> s,Map<String,Integer> t) {
        for (String key : t.keySet()) {
            if (!s.containsKey(key)) {
                return false;
            } else if (t.get(key)>s.get(key)) {
                return false;
            }
        }
        return true;
    }
}
