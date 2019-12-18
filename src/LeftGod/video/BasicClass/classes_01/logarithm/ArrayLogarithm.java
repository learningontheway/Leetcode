package LeftGod.video.BasicClass.classes_01.logarithm;

import LeftGod.video.BasicClass.classes_01.sort.Sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 整数数组比较器
 */
public class ArrayLogarithm {
    /**
     * 随机生成一个最大值为max的size大小的数组
     * @param size
     * @param max
     * @return
     */
    public static int[] generationArray(int size,int max){
        int[] array=new int[size];
        Random random=new Random();
        for(int i=0;i<size;i++){
            //生成随机的正负数
            //random.nextInt(max)获取的是[0,max-1)范围内的整数
            array[i]=random.nextInt(max)-random.nextInt(max);
        }
        return array;
    }

    /**
     * 判断输入的两个数组存储的内容是否是完全一样，如果不一样，输出case
     * @param array1
     * @param array2
     * @return
     */
    public static Boolean isEqual(int[] array1,int[] array2){
        if(array1==null&&array2!=null) return Boolean.FALSE;
        if(array1!=null&&array2==null) return Boolean.FALSE;
        if(array1.length!=array2.length) return Boolean.FALSE;
        for(int i=0;i<array1.length;i++){
            if(array1[i]!=array2[i])
                return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    /***
     * 复制array数组的内容到另一个数组
     * @param array
     * @return
     */
    public static int[] copyArray(int[] array ){
        if(array==null) return null;
        int[] copyArray=new int[array.length];
        for(int i=0;i<array.length;i++){
            copyArray[i]=array[i];
        }
        return copyArray;
    }

    /***
     * 打印数组内容
     * @param array
     */
    public static void printArray(int[] array){
        if(array==null) return;
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

    /**
     * Arrays的排序
     * @param array
     */
    public static void comparator(int[] array){
         Arrays.sort(array);
    }

    /**
     * 数组交换值
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int[] arr, int i, int j) {
        if(i==j) return;
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 7;
        int maxValue = 6;
        for (int i = 0; i < testTime; i++) {
            //原始数组
            int[] array1 = generationArray(maxSize, maxValue);
            //需要测试结果
            int[] array2 = copyArray(array1);
            //正确结果
            int[] array3=copyArray(array1);
            //更换这个方法即可
            Sort.heapSort(array2);
            comparator(array3);
            if (!isEqual(array2, array3)) {
                System.out.println("算法错误");
                printArray(array1);
                printArray(array2);
                printArray(array3);
                return;
            }
        }
        System.out.println("算法正确!" );


    }

}
