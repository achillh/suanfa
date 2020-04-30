package rangeMerge;

import java.util.Arrays;
import java.util.Comparator;

public class LeetCode56 {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        int[][] res = new int[intervals.length][2];

        int index = -1;
        for (int i = 0; i < intervals.length; i++) {
            if (index == -1 || res[index][1] < intervals[i][0]) {
                res[++index] = intervals[i];
            }else {
                res[index][1] = Math.max(res[index][1], intervals[i][1]);
            }
        }
        Arrays.copyOf(res, index + 1);

        return res;
    }
}
