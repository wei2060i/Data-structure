package com;

import java.util.Arrays;
/*
 动态规划
面额2/3/5的若干硬币，获取11元最少多少个硬币
    f(i)=j  获取i元最少 j个硬币
    f(i)=min{f(i-2)+1,f(i-3)+1,f(i-5)+1}
    f(0) =0 f(1)=-1  f(2)=1 f(3)=min{f(3-3)+1}=1 f(4)=2
    f(5)=min{f(5-2)+1,f(5-3)+1,f(5-5)+1}=1
    -1表示无法凑出这个钱
 */
public class Dp2 {
    public static void main(String[] args) {
        int[] money={2,3,5};
        int sum=11;
        int[] array=new int[sum+1];  // f(i)=j
        for (int i = 0; i <= sum; i++) {
            if(i==0){
                array[i]=0;
            }else if(i < money[0]){
                array[i]=-1;  //-1表示 不可能凑出这个钱啊
            }else {
                int m=Integer.MAX_VALUE;
                for (int j = 0; j < money.length;j++) {
                    if(i-money[j]>= 0 && array[i-money[j]]!=-1){
                        int a=array[i-money[j]]+1;
                        m=Math.min(a,m);
                    }
                }
                array[i]=m;
            }
        }
        System.out.println(Arrays.toString(array));
        int mm=array.length-1;
        System.out.println("当需要"+mm+"元，需要"+array[mm]+"个硬币");
    }
}
