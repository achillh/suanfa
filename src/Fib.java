public class Fib {
    public int fib(int n) {
        int result = 0;
        int divide = (int) (Math.pow(10, 9) + 7);
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            int pre = fib(1);
            int prePre = fib(0);
            for (int i = 2; i <= n; i++) {
                result = (pre + prePre)%divide;
                prePre = pre%divide;
                pre = result%divide;
            }
        }

        return result;
    }
}
