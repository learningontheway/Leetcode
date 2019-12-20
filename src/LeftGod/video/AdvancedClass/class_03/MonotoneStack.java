package LeftGod.video.AdvancedClass.class_03;

import java.util.Stack;

/***
 * 单调栈结构原型
 */
public class MonotoneStack {
    public static int[][] MonotoneStack(int[] num){
        int res[][]=new int[num.length][2];
        int index;
        //stack存放数组的下标
        Stack<Integer> stack=new Stack<>();
        //对数组的所有元素进行单调栈判断
        for (int i = 0; i <num.length ; i++) {
            //判断是否符合从从栈底到栈顶满足从大到小的规则，如果不满足，一直弹出栈顶元素直到满足为止
            while (!stack.isEmpty()&&num[stack.peek()]<num[i]){
                index=stack.pop();
                res[index][0]=stack.size()>0?stack.peek():-1;
                res[index][1]=i;
            }
            stack.push(i);
        }
        //对栈中剩下的元素进行结算
        while (!stack.isEmpty()){
            index=stack.pop();
            res[index][0]=stack.size()>0?stack.peek():-1;
            res[index][1]=-1;
        }
        return res;
    }
    public static void printArray(int[][] nums){
        for (int i = 0; i <nums.length ; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                System.out.print(nums[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int num[]={1,2,5,8,3,6,9,4,0,2};
        printArray(MonotoneStack(num));
    }
}
