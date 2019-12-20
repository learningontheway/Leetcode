package LeftGod.video.AdvancedClass.class_02;

public class BFPRT {
    //这里求得是第k小得值，如果求第k大得值，可以把其转换为求第n-k+1小得值
    public static int BFPRT(int[] arr,int k){
        return BFPRT(arr,0,arr.length-1,k-1);
    }
    //BFPRT算法主体
    public static int BFPRT(int[] arr,int begin,int end,int i){
        if(begin==end) return arr[begin];
        //求中位数
        int pivot=medianOfMedians(arr,begin,end);
        //利用中位数进行划分,返回划分点
        int pivotRange[]=partition(arr,begin, end,pivot);
        //i在等于区域内，直接返回
        if(i>=pivotRange[0]&&i<=pivotRange[1])
            return arr[i];
        else {
            //i在小于区域内，继续在在小于区域进行BFPRT算法
            if(i<pivotRange[0])
                return BFPRT(arr,begin,pivotRange[0]-1,i);
            //i在大于区域内，继续在在大于区域进行BFPRT算法
            else return BFPRT(arr,pivotRange[1]+1,end,i);
        }
    }
    //找中位数
    public static int medianOfMedians(int[] arr,int begin,int end){
        int num=end-begin+1;
        int offset=num%5==0?0:1;
        int mArr[]=new int[num/5+offset];
        for (int i = 0; i <mArr.length ; i++) {
            int mBegin=begin+i*5;
            int mEnd=mBegin+4;
            mArr[i]=getMedia(arr,mBegin,Math.min(end,mEnd));
        }
        return BFPRT(mArr,0,mArr.length-1,mArr.length/2);
    }
    //利用中位数进行划分
    public static int[] partition(int[] arr,int begin,int end,int pivot){
        int small=begin-1;
        int cur=begin;
        int big=end+1;
        while (cur!=big){
            if(arr[cur]<pivot)
                swap(arr,++small,cur++);
            else if(arr[cur]>pivot)
                swap(arr,cur,--big);
                else cur++;
        }
        int range[]=new int[2];
        range[0]=small+1;
        range[1]=big-1;
        return range;
    }
    //获取中位数
    public static int getMedia(int[] arr,int begin,int end){
        insertionSort(arr,begin,end);
        int sum=begin+end;
        int mid=(sum/2)+(sum%2);
        return arr[mid];
    }
    //插入排序
    public static void insertionSort(int[] arr,int begin,int end){
        for (int i = begin+1; i !=end+1 ; i++) {
            for(int j=i;j!=begin;j--){
                if(arr[j-1]>arr[j])
                    swap(arr,j-1,j);
                else break;
            }
        }
    }
    //交换数组中两个位置的数值
    public static void swap(int[] arr,int index1,int index2){
        int temp=arr[index1];
        arr[index1]=arr[index2];
        arr[index2]=temp;
    }
    public static void main(String[] args) {
        int[] arr={2,1,3,5,6,4,7,9,8,10};
        System.out.println(BFPRT(arr,10));
    }
}
