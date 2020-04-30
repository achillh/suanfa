package array;

/**
 * 题目描述
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。
 * 时间复杂度
 */
public class arrayfind {
    public static void main(String[] args) {
        int target = 7;
        int[][] array = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        System.out.println(Find(target,array));

    }

    private static boolean Find(int target, int [][] array){
        if (array == null) {
            return false;
        }
        int verticalLen = array.length;
        int horizonLen = array[0].length;
        int i = 0;
        int j = verticalLen - 1;
        while (i < horizonLen && j >= 0) {
            if (target == array[j][i]) {
                return true;
            }
            if (target > array[j][i]) {
                i++;
                continue;
            }
            if (target < array[j][i]) {
                j--;
                continue;
            }
        }
        return false;
    }
}
