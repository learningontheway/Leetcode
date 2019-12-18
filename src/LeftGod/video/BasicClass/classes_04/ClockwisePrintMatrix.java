package LeftGod.video.BasicClass.classes_04;

/**
 * 顺时针打印矩阵
 */
public class ClockwisePrintMatrix {
    public static void printMatrix(int[][] Matrix){
        if(Matrix==null) return;
        int hight=Matrix.length;
        int wide=Matrix[0].length;
        printMatrix(Matrix,0,0,hight-1,wide-1);


    }
    public static void printMatrix(int[][] Matrix,int a,int b,int c,int d){
        if(a>c||b>d) return;
        if(a==c)
            for (int i = 0; i <(d-b) ; i++) {
                System.out.print(Matrix[a][b+i]+" ");
        }
        if(b==d)
            for (int i = 0; i <(c-a) ; i++) {
                System.out.print(Matrix[a+i][b]+" ");
            }
        if(a==c&&b==d) System.out.print(Matrix[a][b]);
        if(a<c&&b<d){
            for (int i = 0; i <(d-b) ; i++) {
                System.out.print(Matrix[a][b+i]+" ");
            }
            for (int i = 0; i <(c-a) ; i++) {
                System.out.print(Matrix[a+i][d]+" ");
            }
            for (int i = 0; i <(d-b) ; i++) {
                System.out.print(Matrix[c][d-i]+" ");
            }
            for (int i = 0; i <(c-a) ; i++) {
                System.out.print(Matrix[c-i][b]+" ");
            }
            printMatrix(Matrix,a+1,b+1,c-1,d-1);
        }
    }


    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        printMatrix(matrix);

    }

}
