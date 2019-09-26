package com.controller;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 给定字符串 String s="2黎明34张白衣24王哈哈90白衣仙子7礼拜2王婆"
 * 在内部以数字加汉字为一组  按照 数字排序
 */
public class 字符串内部Sort {
    public static void main(String[] args) {
        String s="2黎明34张白衣24王哈哈90白衣仙子7礼拜2王婆";
        Pattern pp=Pattern.compile("\\d+[\u4e00-\u9fa5]+");
        Matcher matcher = pp.matcher(s);
        TreeSet<String> ts=new TreeSet<>(new Comparator<String>() {
            public int compare(String s1,String s2){
                Pattern p1=Pattern.compile("\\d+");
                Matcher m1= p1.matcher(s1);
                m1.find();
                Integer g1= Integer.valueOf(m1.group());
                Matcher m2= p1.matcher(s2);
                m2.find();
                Integer g2= Integer.valueOf(m2.group());
                return g1-g2 ==0 ? 1 :g1-g2;
            }
        });
       while (matcher.find()){
            ts.add(matcher.group());
       }
       //[2黎明, 2王婆, 7礼拜, 24王哈哈, 34张白衣, 90白衣仙子]
        System.out.println(ts);
    }
}