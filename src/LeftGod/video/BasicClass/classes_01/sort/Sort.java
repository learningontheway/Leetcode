package LeftGod.video.BasicClass.classes_01.sort;


import java.util.Random;

public class Sort {
    /**
     * 插入排序
     * @param array
     */
    public static void  InsertionSort(int[] array){
        if(array==null||array.length<2) return ;
        for(int i=1;i<array.length;i++){
            //这里需要注意得是每一个元素都需要向后移动
            for (int j = i-1; j >=0&&array[j]>array[j+1] ; j--) {
                swap(array,j,j+1);
            }
        }
    }

    /**
     * 桶排序，0~200以内的数字排序可以用这个方法
     * @param array
     */
    public static void bucketSort(int[] array){
        if(array==null||array.length<2) return;
        int max=Integer.MIN_VALUE;
        for (int i = 0; i <array.length ; i++) {
            max=array[i]>max?array[i]:max;
        }
        //默认初始化为全0的数组
        int[] bucket=new int[max+1];
        for (int i = 0; i <array.length ; i++) {
            bucket[array[i]]++;
        }
        int j=0;
        for (int i = 0; i <bucket.length ; i++) {
            while (bucket[i]-->0) array[j++]=i;
        }
    }

    /**
     * 选择排序
     * @param array
     */
    public static void SelectionSort(int[] array){
        if(array==null||array.length<2) return;
        for (int i = 0; i < array.length-1; i++) {
            int minIndex=i;
            for(int j=i+1;j<array.length;j++){
                if(array[minIndex]>array[j])minIndex=j;
            }
            swap(array,i,minIndex);
        }
}

    /**
     * 冒泡排序
     * @param array
     */
    public static void BubbleSort(int[] array){
        for (int i = 0; i <array.length-1 ; i++) {
            for (int j = 0; j < array.length-1-i; j++) {
                if(array[j]>array[j+1])
                swap(array,j,j+1);
            }
        }
    }
    /**
     * 归并排序
     * @param array
     */
    public static void MergeSort(int[] array){
        if(array==null||array.length<2) return;
        MergeSort(array,0,array.length-1);
    }
    //这里会拆分成n个数，每一个组里只有一个数字
    public static void MergeSort(int[] array,int left,int right){
            if(left<right){
                int mid=(left+right)/2;
                MergeSort(array,left,mid);
                MergeSort(array,mid+1,right);
                merge(array,left,mid,right);
            }
 }

    public static void merge(int[] array,int left,int mid,int right) {
        int[] temp=new int[right-left+1];
        int p1=left,p2=mid+1;
        int i=0;
        while (p1<=mid&&p2<=right)
            temp[i++]=array[p1]<=array[p2]?array[p1++]:array[p2++];
        while (p1<=mid)
            temp[i++]=array[p1++];
        while (p2<=right)
            temp[i++]=array[p2++];
        for (int j = 0; j <right-left+1 ; j++) {
            array[left+j]=temp[j];
        }
    }
    /**
     * 随机快排
     * @param array
     */
    public static void QuickSort(int[] array){
        if(array.length<2||array==null) return;
        QuickSort(array,0,array.length-1);

    }
    public static void QuickSort(int[] array,int l,int r){
        Random random=new Random();
            if (l<r){
                //增加这个代码就变成随机快排了
                swap(array,l+random.nextInt(r-l),r);
                int[] p=partition(array,l,r);
                QuickSort(array,l,p[0]-1);
                QuickSort(array,p[1]+1,r);

            }
    }
    //返回等于x数的左右区间值
    public static int[] partition(int[] array,int l,int r){
        //less表示从零到less区间内保存的数据为小于array[r]的数据
        //more表示从more到r区间内保存的数据为小于array[r]的数据
        int less=l-1;
        int more=r;
        while (l<more){
            if(array[l]<array[r])swap(array,++less,l++);
            else if (array[l]>array[r])swap(array,--more,l);
                 else    l++;
        }
        swap(array,more,r);
        return new int[]{less+1,more};
    }

    /**
     * 堆排序
     * @param array
     */
    public static void heapSort(int[] array){
        if(array.length<2||array==null) return;
        for (int i = 0; i <array.length ; i++) {
            heapInsert(array,i);
        }
        int size=array.length;
        swap(array,0,--size);
        while (size>0){
            heapify(array,0,size);
            swap(array,0,--size);
        }

    }
    public static void heapInsert(int[] array,int index){
        //这里构造的是大根堆，因为每次都是把最大的元素和最后一位交换，所以从后往前依次减少
        while (array[index]>array[(index-1)/2]){
            swap(array,index,(index-1)/2);
            index=(index-1)/2;
        }
    }


    public static void heapify(int[] array,int index,int size){
        int left=index*2+1;
        while (left<size){
            //边界判定很重要
            int largest=array[left+1]>array[left]&&left+1<size?left+1:left;
            largest=array[largest]>array[index]?largest:index;
            if(largest==index) break;

            swap(array,largest,index);
            index=largest;
            left=index*2+1;
        }

    }

    //不需要额外空间得交换方法
    public static void swap(int[] arr, int i, int j) {
        if(i==j)return;
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }


}
