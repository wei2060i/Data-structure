package com.data;

public class Queen8 {
    // 皇后个数
    private int max=8;
    //  保存 皇后放置的 位置，索引是第几行(也代表第几个皇后)，值是第几列
    int[] array=new int[max];
    //计数
    static int count=0;
    public static void main(String[] args){
        Queen8 queen8=new Queen8();
        queen8.check(0);
        System.out.println("一共有"+count);
    }
    //放置 皇后
    public  void check(int n){
        if(n==max){
            print();
            return;
        }
        //依次放入皇后，并判断是否 冲突
        for (int i=0;i<max;i++){
            array[n]=i; //当前皇后 放入第i列
            if(judge(n)){
                check(n+1); //如果不冲突 就放下一个皇后
            }
            // 冲突 就 array[n]=i; 就放到下一列
        }
    }

    //判断是否 冲突
    public boolean judge(int n){
        for(int i=0;i<n;i++){
            //   列判断                       同一斜线判断
            if(array[i]==array[n]||Math.abs(n-i)==Math.abs(array[n]-array[i])){
                return false;
            }
        }
        return true;
    }
    //输出 皇后位置
    private void print(){
        count++;
        for (int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }
}
