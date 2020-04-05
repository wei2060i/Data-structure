package com.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * 也称最优二叉树:指对于一组带有确定权值的叶结点，构造的具有最小带权路径长度的二叉树
 */
public class HuffmanTree {

    public static void main(String[] args) {
        int arr[] = {3,6,1,0,11,99};
        TreeNode root = createHuffmanTree(arr);
        System.out.println(root.value);
    }

    //创建赫夫曼树
    public static TreeNode createHuffmanTree(int []arr) {
        //创建若干只有一个节点的二叉树
        List<TreeNode> nodes = new ArrayList<>();
        for(int value:arr) {
            nodes.add(new TreeNode(value));
        }
        while(nodes.size() > 1) {
            //小到 大排序
            Collections.sort(nodes);
            //取出权值最小的两个二叉树
            TreeNode left = nodes.get(0);
            TreeNode right = nodes.get(1);
            //组合新的二叉树
            TreeNode parent = new TreeNode(left.value+right.value);
            parent.left = left;
            parent.right = right;
            //移除原来的树，添加新树
            nodes.remove(left);
            nodes.remove(right);
            nodes.add(parent);
        }
        return nodes.get(0);
    }
}
class TreeNode implements Comparable<TreeNode>{
    int value;
    TreeNode left;
    TreeNode right;
    public TreeNode(int value){
        this.value = value;
    }
    @Override
    public int compareTo(TreeNode o) {
        return this.value-o.value;
    }
    @Override
    public String toString() {
        return "value:"+value;
    }
}