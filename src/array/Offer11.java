package array;

public class Offer11 {
    public int minArray(int[] numbers) {
        if (numbers.length == 0) {
            return 0;
        }
        int index = 0;
        int begin = Integer.MIN_VALUE;
        for (; index < numbers.length; index++) {
            int value = numbers[index];
            if (value >= begin) {
                begin = value;
            } else {
                return value;
            }
        }
        return numbers[0];
    }
}
