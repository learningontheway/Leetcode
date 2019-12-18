package LeftGod.video.BasicClass.classes_04;

/**
 * 90°旋转矩阵
 */
public class rotateMatrix {
    public static void  rotateMatrix(int[][] Matrix){
        if(Matrix==null) return;
        if(Matrix.length!=Matrix[0].length) System.out.println("当前矩阵不是正方形矩阵，无法旋转");
        int a=0,b=0,c=Matrix.length-1,d=Matrix[0].length-1;
        while (a<c)
            rotateMatrix(Matrix,a++,b++,c--,d--);
    }
    public static void  rotateMatrix(int[][] Matrix,int a,int b,int c,int d){
        if(a>c||b>d) return;
        if(a<c&&b<d){
            for (int i = 0; i <(c-a) ; i++) {
                int temp=Matrix[a][b+i];
                Matrix[a][b+i]=Matrix[c-i][b];
                Matrix[c-i][b]=Matrix[c][d-i];
                Matrix[c][d-i]=Matrix[a+i][d];
                Matrix[a+i][d]=temp;
            }

        }
    }
    public static void printMatrix(int[][] Matrix){
        for (int i = 0; i < Matrix.length; i++) {
            for (int j = 0; j <Matrix[0].length ; j++) {
                System.out.print(Matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix= { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };

        printMatrix(matrix);
        System.out.println("=======================");
        rotateMatrix(matrix);
        printMatrix(matrix);

    }
}
