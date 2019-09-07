package com.data;
/*
 顺序存储二叉树
 只适用于 完全二叉树
 第n个元素的左子节点为2*n +1
 第n个元素的右子节点为2*n +2
 注：n是数组下标  n从0开始
 */
public class ArrBinaryTree {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7};
        ArrBinaryTree arrBinaryTree=new ArrBinaryTree(arr);
        arrBinaryTree.preOrder(0);
    }
    private static int[] arr;
    public ArrBinaryTree(int[] arr){
        this.arr=arr;
    }

    public static void preOrder(int index){
        if(arr==null||arr.length==0){
            System.out.println("数组是空，无法前序遍历");
        }
        System.out.println(arr[index]);
        //向左 递归 遍历
        if((index*2+1)< arr.length){
            preOrder(index*2+1);
        }
        //向右 递归 遍历
        if((index*2+2)< arr.length){
            preOrder(index*2+2);
        }
    }
}
