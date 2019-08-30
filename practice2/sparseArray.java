package com.data;

public class sparseArray {
    public static void main(String[] args){
        //创建一个原始的二维数组11*11
        //0:没有棋子 1:黑子  2:白字
        int chessArr1[][]=new int[11][11];
        chessArr1[1][2]=1;
        chessArr1[2][3]=2;
        System.out.println("原始二维数组");
        for (int[] row: chessArr1) {
            for (int data:row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
        //遍历二维数组，得到非零的个数
        int sum=0;
        for (int i=0;i<chessArr1.length;i++){
            for(int j=0;j<chessArr1[0].length;j++){
                if(chessArr1[i][j]!=0){
                    sum++;
                }
            }
        }
        //创建对应的稀疏数组
        int sparseArr[][]=new int[sum+1][3];
        // 分别存入行数、列数、非零的个数
        sparseArr[0][0]=chessArr1.length;
        sparseArr[0][1]=chessArr1[0].length;
        sparseArr[0][2]=sum;
        //存入非零的值 及所在的行、列  count记录第几个非零数
        int count=0;
        for (int i=0;i<chessArr1.length;i++){
            for(int j=0;j<chessArr1[0].length;j++){
                if(chessArr1[i][j]!=0){
                    count++;
                    sparseArr[count][0]=i;
                    sparseArr[count][1]=j;
                    sparseArr[count][2]=chessArr1[i][j];
                }
            }
        }
        System.out.println("得到的稀疏数组");
        for(int i=0;i<sparseArr.length;i++){
            System.out.printf("%d\t%d\t%d\n",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
        }
        System.out.println("稀疏数组恢复过程。。。");
        int chessArr2[][]=new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i=1;i<sparseArr.length;i++){
            chessArr2[sparseArr[i][0]][sparseArr[i][1]]=sparseArr[i][2];
        }
        for (int[] row: chessArr2) {
            for (int data:row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

    }


}