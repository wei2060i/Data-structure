package com;
/**
 * n 旋转度数   90度的整数倍
 *  2  6  18
 *  8  27 99
 *  旋转90度后
 *  8   2
 *  27  6
 *  99  18
 */
public class RotationMatrix {

    public static void main(String[] args) {
        int[][] arrays={
                {2,6,18},
                {8,27,99}};
        int n=90;
        for (int i=0;i< n/90;i++){
            arrays=xuanZhuan(arrays);
        }
        for (int[] array : arrays) {
            for (int i : array) {
                System.out.print(i+"\t");
            }
            System.out.println();
        }
    }
    public static int[][] xuanZhuan(int[][] a){
        int width=a[0].length;
        int height=a.length;
        int[][] newArr=new int[width][height];
        for(int i=0;i<a.length;i++){
            for (int j=0;j<a[0].length;j++){
                newArr[j][height-i-1]=a[i][j];
            }
        }
        return newArr;
    }

}