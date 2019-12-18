package LeftGod.video.BasicClass.classes_04;

/**
 *从一个每一行每一列都是从小到大排列的矩阵中找到数值等于k的数，并打印其坐标
 *
 * 解题思想：从右上角开始查找，如果小于当前数，则往左走，如果大于当前数，往下走，否则返回当前坐标
 */
public class findKInMatrix {
    public static int[] findK(int[][] Matrix,int num){
        int j=Matrix[0].length-1;
        int i=0;
        while (j>=0&&i<Matrix.length){
            if(Matrix[i][j]>num) j--;
            else if(Matrix[i][j]<num) i++;
            else {
                System.out.println(num+"的坐标为：【"+i+","+j+"】");
                return new int[]{i,j};
            }
        }
        System.out.println("矩阵中不存在当前查找的数");
        return null;
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        int[] Coordinates=findK(matrix,16);

    }

}
