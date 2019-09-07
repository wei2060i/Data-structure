package com.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 贪心
 */
public class Greedy {
    public static void main(String[] args) {
        //创建广播电台
        HashMap<String ,HashSet<String>> broadcasts=new HashMap<>();
        //广播台 对应地区
        HashSet<String> hashSet1=new HashSet<>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");
        HashSet<String> hashSet2=new HashSet<>();
        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");
        HashSet<String> hashSet3=new HashSet<>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");
        HashSet<String> hashSet4=new HashSet<>();
        hashSet4.add("天津");
        hashSet4.add("上海");
        HashSet<String> hashSet5=new HashSet<>();
        hashSet5.add("杭州");
        hashSet5.add("大连");
        broadcasts.put("k1",hashSet1);
        broadcasts.put("k2",hashSet2);
        broadcasts.put("k3",hashSet3);
        broadcasts.put("k4",hashSet4);
        broadcasts.put("k5",hashSet5);
        HashSet<String> allAreas=new HashSet<>();
        allAreas.add("北京");
        allAreas.add("上海");
        allAreas.add("天津");
        allAreas.add("广州");
        allAreas.add("深圳");
        allAreas.add("成都");
        allAreas.add("杭州");
        allAreas.add("大连");
        //创建 ArrayList 存放选择的电台
        ArrayList<String> selects=new ArrayList<>();
        //临时集合  存放遍历过程中 电台覆盖地区和当前还没有覆盖的地区的交集
        HashSet<String> tempSet=new HashSet<>();
        //maxKey 存放遍历过程中 能够覆盖最大未覆盖的地区对应的电台的key
        String maxKey=null;
        while (allAreas.size()!=0){
            maxKey=null;
            for (String key:broadcasts.keySet()){
                tempSet.clear();//临时比较 每一个key
                //当前key可以覆盖的地区
                HashSet<String> areas = broadcasts.get(key);
                tempSet.addAll(areas);
                //取tempSet和 allAreas交集 赋值给tempSet
                tempSet.retainAll(allAreas);
                if(tempSet.size()>0 &&
                        (maxKey==null || tempSet.size() > broadcasts.get(maxKey).size())){
                    maxKey=key;
                }
            }
            if(maxKey!=null){
                //选择覆盖地区的 电台
                selects.add(maxKey);
                // 移除已覆盖的地区
                allAreas.removeAll(broadcasts.get(maxKey));
            }
        }
        System.out.println(selects);
    }
}
