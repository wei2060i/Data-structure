package com.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySearch {
    private static int maxSize=10;
    public static void main(String[] args) {
//        int[] a={0,3,6,8,9,14,14,16,17,21};
//        ArrayList arrayList = Search_two(a, 14);
//        arrayList.forEach(it-> System.out.println(it));
//        int mm=InsertValueSearch(a,0,a.length-1,3);
//        System.out.println(mm);
        int[] a={1,8,10,56,1000,1232};
        System.out.println(fibSearch(a,56));
    }
   /*  f[k]-1=(f[k-1] -1) +(f[k-2]-1)+1
                   f[k]-1
       low (f[k-1] -1) mid (f[k-2]-1)
    */
    public static int fibSearch(int []a,int key){
        int low=0;
        int high=a.length-1;
        int k=0; //斐波那契 分割数值的下标
        int mid=0;//存放mid 下标
        int [] f =fib();
        while (high>f[k]-1){
            k++;
        }
        //[1, 8, 10, 56, 1000, 1232, 0, 0]  temp
        // 1  1   2   3   5     8        fib数列
        // 0  1   2   3   4     5    6   7   fib下标
        int[] temp=Arrays.copyOf(a,f[k]);
        //[1, 8, 10, 56, 1000, 1232, 1232, 1232]
        for(int i=high+1;i<temp.length;i++)
            temp[i]=a[high];
        while (low <= high){
            mid=low+f[k-1]-1;
            if(key<temp[mid]){
                high=mid-1;
                k--;
            }else if(key > temp[mid]){
                low=mid+1;
                k-=2;
            }else {
                if(mid <= high)
                    return mid;
                else return high;
            }
        }
     return -1;
    }
    public static int[] fib(){
        int[] f=new int[maxSize];
        f[0]=1;
        f[1]=1;
        for (int i=2;i<maxSize;i++)
            f[i]=f[i-1]+f[i-2];
        return f;
    }
    //差值 查找
    public static int InsertValueSearch(int[]arr,int left,int right,int findV){
       if(left>right||findV<arr[0]||findV>arr[arr.length-1])
           return -1;
       int mid=left+(right-left)*(findV-arr[left])/(arr[right]-arr[left]);
       int midVal=arr[mid];
       if(findV >midVal){
           return InsertValueSearch(arr,mid+1,right,findV);
       }else if(findV < midVal){
           return InsertValueSearch(arr,left,mid-1,findV);
       }else return mid;
    }
    // 二分 法
    public static ArrayList Search_two(int[] arr, int m){
       int min=0,max=arr.length-1;
       int mid=(min+max)/2;
       while(arr[mid]!= m){
           if(arr[mid] < m){
               min=mid+1;
           }else if(arr[mid] >m){
               max=mid-1;
           }
           mid=(min+max)/2;
           if(min>max)
               return new ArrayList<Integer>();
       }
       ArrayList<Integer> resIndexList=new ArrayList<>();
        int temp=mid-1;
       while (true){
           if(temp<0||arr[temp]!=m){
               break;
           }
           resIndexList.add(temp);
           temp--;
       }
        resIndexList.add(mid);
        temp=mid+1;
        while (true){
            if(temp>arr.length-1||arr[temp]!=m){
                break;
            }
            resIndexList.add(temp);
            temp++;
        }
        return resIndexList;
    }
}
