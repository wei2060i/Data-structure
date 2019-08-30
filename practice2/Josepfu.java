package com.data;

public class Josepfu {

    public static void main(String[] args){
        CircleSingleLinkedList circleSingleLinkedList=new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.countBoy(1,2,5);
    }
}

class CircleSingleLinkedList{
     //创建第一个节点，当前没有编号
    private Boy first=null;

    /**
     * @param startNo 从第几个小孩开始数数
     * @param countNum 数几次
     * @param nums 最初 有多少小孩
     */
    public void countBoy(int startNo,int countNum,int nums){
        if(first==null||startNo<1||startNo>nums){
            System.out.println("输入参数有误");
            return;
        }
        //创建辅助 指针
        Boy helper=first;
        while (true){
            if(helper.getNext()==first){
                break;
            }
            helper=helper.getNext();
        }
        //报数 前，先让helper、first 移动startNo-1次
        for(int j=0;j<startNo-1;j++){
            first=first.getNext();
            helper=helper.getNext();
        }
        //报数时 helper、first 移动countNum-1次,再出圈
        while (true){
            if(helper==first){
                break; //只剩一个节点了
            }
            for (int j=0;j<countNum-1;j++){
                first=first.getNext();
                helper=helper.getNext();
            }
            System.out.printf("小孩%d出圈\n",first.getNo());
            first=first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后的小孩编号是%d\n",first.getNo());
    }

    public void showBoy(){
        if(first==null){
            System.out.println("没有任何小孩");
            return;
        }
        Boy curBoy=first;
        while(true){
            System.out.printf("小孩的编号%d \n",curBoy.getNo());
            if(curBoy.getNext()==first){
                break;
            }
            curBoy=curBoy.getNext();
        }
    }
    //构建环形链表
    public void addBoy(int nums){
        if(nums<1){
            System.out.println("nums值不正确");
            return;
        }
        Boy curBoy=null; //辅助指针 ，帮助构建环形链表
        for (int i=1;i<=nums;i++){
            Boy boy=new Boy(i);
            if(i==1){
                first=boy;
                first.setNext(first);
                curBoy=first;
            }else{
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy=boy;
            }
        }
    }
}

class  Boy{
    private int no;
    private Boy next;
    public Boy(int no){
        this.no=no;
    }
    public int getNo() {
        return no;
    }
    public void setNo(int no) {
        this.no = no;
    }
    public Boy getNext() {
        return next;
    }
    public void setNext(Boy next) {
        this.next = next;
    }
}