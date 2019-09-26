package com.controller;

public class 汉诺塔 {
    public static void main(String[] args) {
        hanoi(3,'A','B','C');
    }
    /**
     * @param n 一共几个盘子
     * @param from 开始的位置
     * @param in  中间的位置
     * @param to  目标位置
     * 把所有大于2个的盘子都   看成是两个盘子
     */
    public static void hanoi(int n,char from,char in,char to){
        if(n==1){
            System.out.println("第一个盘子从"+from+"移到"+to);
        }else {
            //n-1个盘子移动方法
            hanoi(n-1,from,to,in);
            //最后一个盘子移动方式
            System.out.println("第"+n+"个盘子从"+from+"移动到"+to);
            //n-1个盘子移动方法
            hanoi(n-1,in,from,to);
        }
    }
}
