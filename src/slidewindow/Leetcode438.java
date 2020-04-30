package slidewindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
 */
public class Leetcode438 {
    public static void main(String[] args) {
        Leetcode438 leetcode438 = new Leetcode438();
        leetcode438.findAnagrams("abab",
                "ab");
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.trim().equals("") || p.length() > s.length()) {
            return result;
        }

        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> pMap = new HashMap<>();

        for (Character key : p.toCharArray()) {
            put(key,pMap);
        }

        int right = 0, k = p.length(),left=0;
        int desiredCount = pMap.size();
        int meetCount = 0;
        while (right < s.length()) {
            Character character = s.charAt(right++);
            put(character,window);
            if (pMap.containsKey(character) && window.containsKey(character) && window.get(character).intValue() == pMap.get(character).intValue()) {
                meetCount++;
            }
            while (meetCount == desiredCount && left <= right) {
                if (right - left == k) {
                    result.add(left);
                }
                Character leftKey = s.charAt(left);
                if (pMap.containsKey(leftKey) && window.containsKey(leftKey) && window.get(leftKey).intValue() == pMap.get(leftKey).intValue()) {
                    meetCount--;
                }
                delete(leftKey, window);
                left++;
            }
        }
        return result;

    }

    private void put(Character key, Map<Character, Integer> target) {
        if (target.containsKey(key)) {
            target.put(key, (target.get(key).intValue()) + 1);
        }else{
            target.put(key, 1);
        }
    }

    private void delete(Character key, Map<Character, Integer> target) {
        if (target.containsKey(key)) {
            if (target.get(key).intValue() <= 1) {
                target.remove(key);
            } else {
                target.put(key, target.get(key).intValue() - 1);
            }
        }
    }

    private boolean isCondition(Map<Character,Integer> s,Map<Character,Integer> t) {
        if (s.size() != t.size()) {
            return false;
        }
        for (Character key : t.keySet()) {
            if (!s.containsKey(key)) {
                return false;
            } else if (t.get(key)!=s.get(key)) {
                return false;
            }
        }
        return true;
    }
}
