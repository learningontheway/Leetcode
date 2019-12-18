package LeftGod.book;

import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

import static LeftGod.video.BasicClass.classes_01.logarithm.ArrayLogarithm.printArray;


public class question_01 {
    /***
     * 设计一个getMin得栈
     */
    public static void stackPush(Stack<Integer> stack, int num) {
        Stack<Integer> stack1 = new Stack();
        if (stack.empty()) {
            stack.push(num);
            return;
        }
        while (!stack.empty() && stack.peek() < num) {
            stack1.push(stack.pop());
        }
        stack.push(num);
        while (!stack1.empty()) stack.push(stack1.pop());
    }

    public static void stackPop(Stack stack) {
        stack.pop();
    }

    public static int getMin(Stack stack) {
        return (Integer) stack.peek();
    }

    public static void main(String[] args) {
        Random random = new Random();
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < 10000; i++) {
            int[] num = new int[5];
            for (int j = 0; j < 5; j++) {
                int x = random.nextInt(j * 100+1);
                num[j]=x;
                stackPush(stack, x);
            }

            if (getMin(stack) != Arrays.stream(num).min().getAsInt()) {
                System.out.println("算法错误");
                printArray(num);
            }

        }
    }
}


