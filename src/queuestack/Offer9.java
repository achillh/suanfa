package queuestack;

import java.util.Stack;

public class Offer9 {

    private Stack<Integer> stack1 = new Stack<>();//压栈
    private Stack<Integer> stack2 = new Stack<>();//用来弹出

    public Offer9() {

    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack2.size() == 0) {
            int size = stack1.size();
            for (int i = 0; i < size; i++) {
                Integer value = stack1.pop();
                stack2.push(value);
            }
        }
        if (stack2.size() > 0) {
            return stack2.pop();
        } else {
            return -1;
        }
    }
}
