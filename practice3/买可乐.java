package com.controller;
/**
 * 一个人买可乐，2块钱买一瓶可乐，3个瓶盖换一瓶可乐，2个空瓶换一瓶可乐
 * 问 40 、60、100 可以买多少瓶可乐  递归
 */
public class 买可乐 {
    //定义可乐、瓶盖、空瓶
    private static int countKL=0,countKLPG=0,countKLnull=0;
    public static void main(String[] args) {
        //4块钱   输出  5
        System.out.println(Js(4));
    }
    public static int  Js(int money){
        countKL+=money/2;
        countKLPG+=money/2;
        countKLnull+=money/2;
        if(countKLPG >=3){
            int flag=countKLPG/3;
            countKLPG=countKLPG%3;
            Js(flag*2);
        }
        if(countKLnull >= 2){
            int flag=countKLnull/2;
            countKLnull=countKLnull%2;
            Js(flag*2);
        }
        return countKL;
    }
}
