package LeftGod.book;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

public class question_02 {
    /**
     * 两个栈组成一个队列
     */
    public static class queue{
        Stack<Integer> stack1;
        Stack<Integer> stack2;

        public queue(){
            stack2=new Stack<>();
            stack1=new Stack<>();
        }
        void add(int num){
            stack1.push(num);
             }
        int poll(){
            while (!stack1.empty()) stack2.push(stack1.pop());
            return stack2.pop();

        }
        public  int peek(){
            return stack2.peek();
        }
    }
    public static void main(String[] args) {
        Queue<Integer> queue=new LinkedList<Integer>();
        queue queue1=new queue();
        Random random=new Random();
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 6; j++) {
                int x=random.nextInt(j+1);
                queue.add(x);
                queue1.add(x);
            }
            for (int k = queue.size(); k >0; k--) {
                if(queue.poll()!=queue1.poll()) {
                    System.out.println("算法错误");
                    return;
                }
            }
        }
        System.out.println("算法正确");
    }
}
