package LeftGod.video.AdvancedClass.class_03;

import java.util.Stack;

public class MaxArea {
    //计算直方图的最大矩形区域面积
    public static int MaxAreaOfHis(int[] arr){
        Stack<Integer> stack=new Stack<>();
        int index;
        int maxArea=0;
        for (int i = 0; i <arr.length ; i++) {
            //栈不为空且栈顶元素大于当前元素，出栈并结算区域面积
            while (!stack.isEmpty()&&arr[stack.peek()]>arr[i]){
                index=stack.pop();
                //面积计算公式为（当前元素下标-栈顶元素下标-1）*出栈元素的高度
                maxArea=Math.max((i-(stack.size()>0?stack.peek():-1)-1)*arr[index],maxArea);
            }
            stack.push(i);
        }
        //数组中的所有元素遍历完之后栈中剩下的元素结算其区域面积
        while (!stack.isEmpty()){
            index=stack.pop();
            //面积计算为（整个数组的长度-栈顶元素下标-1）*出栈元素的高度
            maxArea=Math.max((arr.length-(stack.size()>0?stack.peek():-1)-1)*arr[index],maxArea);
        }
        return maxArea;
    }
    //把矩阵为一的区域面积转换为求 matrix[0].length个直方图的面积
    public static int MaxAreaOfMatrix(int[][] matrix){
        int maxArea=0;
        int temp[]=matrix[0];
        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                //temp直方图的每一个数字含义：以当前行为底，上面有多少个连续的1，当前下标值对应的数就是多少
               temp[j]=matrix[i][j]==1?temp[j]+1:0;
            }
            maxArea=Math.max(MaxAreaOfHis(temp),maxArea);
        }
        return maxArea;
    }
    public static void main(String[] args) {
        int arr[][]={{1,0,1,1},{1,1,1,1},{1,1,1,0},{1,0,0,1}};
        System.out.println(MaxAreaOfMatrix(arr));
    }


}
