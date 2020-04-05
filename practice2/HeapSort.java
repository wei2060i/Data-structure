package com.controller;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
      int arr[] = {9,6,8};
        heapSort(arr);
//        adjustHeap(arr,0,arr.length);
//        System.out.println(Arrays.toString(arr));

    }

    public static void heapSort(int arr[]){
        //从 最后一个非叶子节点 开始调
        for(int i = arr.length/2 -1;i >= 0;i--){
            adjustHeap(arr, i, arr.length);
        }
        System.out.println(Arrays.toString(arr));
        int temp;
        for(int j = arr.length-1;j > 0;j--){
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr,0,j);
        }
        System.out.println(Arrays.toString(arr));
    }
    /**
     * @param arr  需要调整的数组
     * @param i  非叶子节点在数组中的索引  从最后一个非叶子节点开始
     * @param length  数组里面 需要调整的元素的个数
     */
    public static void adjustHeap(int arr[],int i,int length){
        int temp = arr[i];
        for(int k = i*2+1;k < length;k = k*2+1){
            if(k+1 < length && arr[k] < arr[k+1]){ //左节点小于 右节点
                k++;
            }
            if(arr[k] > temp){
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        arr[i] = temp;
    }
}
