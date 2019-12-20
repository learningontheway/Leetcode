package LeftGod.video.AdvancedClass.class_02;

import java.util.LinkedList;

/**
 * 窗口最大值的更新结构
 */
public class SlidingWindowMaxArray {
    public static int[] getMaxWindow(int[] arr, int w) {//w窗口大小
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }
        LinkedList<Integer> qmax = new LinkedList<Integer>();
        int[] res = new int[arr.length - w + 1];//收集所有想要的结果
        int index = 0;//res[index]写入index
        for (int i = 0; i < arr.length; i++) {//i表示窗口R
            //准备存入i位置的arr[i]比尾部数据大
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) {
                qmax.pollLast();//从尾部弹出
            }
            qmax.addLast(i);//加入arr[i]到尾部
            if (qmax.peekFirst() == i - w) {//如果头部已经要过期了  i - w表示过期的下标，弹出头部，更新窗口结构
                qmax.pollFirst();
            }
            if (i >= w - 1) {//当窗口已经形成了，记录每一步的res
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }


    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = { 4, 3, 5, 4, 3, 3, 6, 7 };
        int w = 3;
        printArray(getMaxWindow(arr, w));

    }


}
