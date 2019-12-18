package Leetcode;


import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class test{
    public static class comparator implements Comparator<Integer>{

        @Override
        public int compare(Integer o1, Integer o2) {
            return -(o1-o2);
        }
    }
    public static int[] sum(int[] a,int[] b,int[] c,int[] d) {
        int[] sum=new int[a.length+b.length+c.length+d.length];
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<Integer>(new comparator());
        for (int i = 0; i <a.length ; i++) {
            priorityQueue.add(a[i]);

        }
        for (int i = 0; i <b.length ; i++) {
            priorityQueue.add(b[i]);
        }
        for (int i = 0; i <c.length ; i++) {
            priorityQueue.add(c[i]);
        }
        for (int i = 0; i <d.length ; i++) {
            priorityQueue.add(d[i]);
        }
        for (int i = 0; i <sum.length ; i++) {
            sum[i]=priorityQueue.poll();
            System.out.print(sum[i]+" ");
        }


       return sum;
    }
    public static void main(String[] args) {
       int[] x1={1,3,5,8};
        int[] x2= {2,4,9,11};
        int[] x3= {1,6,7,9,10};
        int[] x4= {2,88,99};
       int[] s=sum(x1,x2,x3,x4);
    }
}