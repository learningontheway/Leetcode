package LeftGod.video.BasicClass.classes_04;

/**
 * 之字形打印矩阵
 */
public class ZigZagPrintMatrix {
    public static void printMatrix(int[][] Matrix){
        int height=Matrix.length-1;
        int wide=Matrix[0].length-1;
        Boolean flag=false;
        int a=0,b=0,c=0,d=0;
        for (int i = 0; i <=height+wide ; i++) {
            print(Matrix,a,b,c,d,flag);
            if(b<wide) b++;
            else a++;
            if(c<height) c++;
            else d++;
            flag=flag==true? false:true;
        }

    }
    public static void print(int[][] Matrix,int a,int b,int c,int d,Boolean flag){
        if(flag){
            //向下为true
            for (int i = 0; i <=(c-a); i++) {
                System.out.print(Matrix[a+i][b-i]+" ");
            }
        }
        else {
            //向上为false
            for (int i = 0; i <= (c-a); i++) {
                System.out.print(Matrix[c-i][d+i]+" ");
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        printMatrix(matrix);

    }
}
