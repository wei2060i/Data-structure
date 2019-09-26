package com.controller;
/**
 * X[n]  ---> y[n]
 * y[i]=x[0]*x[1]*x[2]*...x[n-1]/x[i]
 * 要求复杂度O(1)  不能使用除法和API
 */
public class 数组转换 {
    public static void main(String[] args) {
        int[] X={1,3,6,2,7},Y=new int[X.length];
        for (int i =0,j=0; i < X.length && j<X.length ;i++) {
            if(Y[j]==0){
                Y[j]=1;
            }
            if(j!=i)
                Y[j]*=X[i];
             if(i==X.length-1){
                 i=0;
                 System.out.println(Y[j]);
                 j++;
             }
        }
    }
}
