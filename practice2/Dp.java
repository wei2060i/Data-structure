package com.data;
/*
动态规划与分治算法不一样的是 分解得到的子问题不是相互独立的
下一个子问题 建立在上一个问题之上的
对于给定n个物品，v[i]、 w[i]分别是第i个物品的价值和重量
v[i][j] 表示在前i个 物品中能够装入容量为 j 的背包中的 最大价值
-----------------------------------------------------
物品  重量   价格
吉他   1     1500
音响   4     3000
电脑   3     2000
                                01背包 (每个物品最多放进去一个)
    0磅 1磅  2磅  3磅  4磅
    0   0    0    0    0
吉他0 1500 1500 1500 1500
音响0 1500 1500 1500 3000
电脑0 1500 1500 2000 3500
------------------------------------------------------
1、v[i][0]=v[0][j]=0  表示填入的表的第一行第一列是0
2、当w[i]>j时，v[i][j]=v[i-1][j] 当新增的物品的重量大于背包容量时，直接使用上一个单元格的装入策略
3、当j>=w[i]时，v[i][j]=max{v[i-1][j]，v[i]+v[i-1][j-w[i]] }
当新增的物品的重量小于等于背包容量时v[i-1][j]上一个单元格的装入的最大值
v[i]表示当前物品的价值   v[i-1][j-w[i]]装入i-1个商品时，到剩余空间j-w[i]的最大值
 */
public class Dp {

    public static void main(String[] args) {
        int[] w={1,4,3};  //物品重量
        int[] val={1500,3000,2000}; //物品价值
        int m=4; //背包容量
        int n=val.length; //物品个数
        int[][] v=new int[n+1][m+1];//表示在前i个 物品中能够装入容量为 j 的背包中的 最大价值
        int[][] path=new int[n+1][m+1]; //记录存放商品的情况
        //第一行 第一列 都是0
        for (int i=0;i<v.length;i++)
            v[i][0]=0;
        for (int i=0;i<v[0].length;i++)
            v[0][i]=0;
        for (int i=1;i< v.length;i++){
            for (int j=1;j< v[0].length;j++){
                if(w[i-1]> j){  //程序i是从1开始的，w[i]的物品 从w[i-1]开始
                    v[i][j]=v[i-1][j];
                }else {
                    //v[i][j]=Math.max(v[i-1][j],val[i-1]+v[i-1][j-w[i-1]]);
                    if(v[i-1][j] < val[i-1]+v[i-1][j-w[i-1]]){
                        v[i][j]= val[i-1]+v[i-1][j-w[i-1]];
                        System.out.println(i+"----------"+j);
                        path[i][j]=1;
                    }else {
                        v[i][j]=v[i-1][j];
                    }
                }
            }
        }
        for (int[] v1:v) {
            for (int v2:v1) {
                System.out.printf(v2+" ");
            }
            System.out.println();
        }
        System.out.println("===============================");
        int a=path.length-1;
        int b=path[0].length-1;
        while (a>0&&b>0){
            if(path[a][b]==1){
                System.out.printf("第%d个商品放入背包\n",a);
                b-=w[a-1];
            }
            a--;
        }

        for (int i=0;i<path.length;i++) {
            for (int j =0; j <path[0].length; j++) {
                System.out.printf(path[i][j]+" ");
            }
            System.out.println();
        }
    }











}
