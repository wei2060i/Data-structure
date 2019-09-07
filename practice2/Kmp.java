package com.data;

import java.util.Arrays;

public class Kmp {
    public static void main(String[] args) {
       String s1="aaatba ssafaaaabaf4";
       String s2="aaaaba";
       int[] t = kmpNext(s2);
       System.out.println(kmpSearch(s1,s2,t));
    }
    /**
     * @param str1 源字符串
     * @param str2  子串
     * @param next  部分匹配表
     * @return 位置
     */
    public static int kmpSearch(String str1,String str2,int[] next){
        for (int i=0,j=0;i<str1.length();i++){
            while (j>0 && str1.charAt(i)!=str2.charAt(j)){
                j=next[j-1];
            }
            if(str1.charAt(i)==str2.charAt(j))
                j++;
            if(j==str2.length()){
                return i-j+1;
            }
        }
        return -1;
    }

    //获取一个字符串的部分匹配值表
    //next 下标对应的字符串长度  对应最长相等前、后缀
    //例：aaaaba    [0, 1, 2, 3, 0, 1]
    public static int[] kmpNext(String dest){
        //创建next数组 保存部分匹配值
        int[] next=new int[dest.length()];
        next[0]=0; //如果字符串长度是1  部分匹配值是0
        for (int i=1,j=0;i< dest.length();i++){
            //kmp核心 当dest.charAt(i)!=dest.charAt(j)
            //从next[j-1] 里面获取新的 j
            while (j>0 && dest.charAt(i)!=dest.charAt(j)){
                j=next[j-1];
            }
            if(dest.charAt(i)==dest.charAt(j))
                j++;
            next[i]=j;
        }
        return next;
    }

    //暴力匹配
    public static int violenceMatch(String str1,String str2){
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        int s1Len=s1.length;
        int s2Len=s2.length;
        int i=0; // 指向s1
        int j=0;  //指向s2
        while (i<s1Len && j<s2Len){
            if(s1[i]==s2[j]){
                i++;
                j++;
            }else {
                i=i-(j-1);
                j=0;
            }
        }
        if(j==s2Len)
            return i-j;
        else return -1;
    }
}
