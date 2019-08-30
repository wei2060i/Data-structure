package com.data;

import java.util.Scanner;
import java.util.Stack;

public class SingleLinkedList {
    public static void main(String[] args){
        SingleLink singleLink=new SingleLink();
        LinkNode node1=new LinkNode(1,"小舞");
        LinkNode node2=new LinkNode(2,"小舞2");
        LinkNode node3=new LinkNode(3,"小舞3");
        LinkNode node4=new LinkNode(4,"小舞4");
        singleLink.addByOrder(node2);
        singleLink.addByOrder(node4);
        singleLink.addByOrder(node1);
        singleLink.addByOrder(node3);
        singleLink.list();
        reversePrint(singleLink.getHead());
    }

    /*
     利用栈 翻转链表
     */
    public static void reversePrint(LinkNode head){
        if(head.next==null){
            return; //空链表 不能打印
        }
        Stack<LinkNode> stack=new Stack<>();
        LinkNode c=head.next;
        while (c!=null){
            stack.push(c);
            c=c.next;
        }
        while (stack.size()>0){
            System.out.println(stack.pop());
        }
    }
    /*
     链表翻转
     */
    public static void reverseList(LinkNode head){
        //链表是空 或者链表只有一个节点 不需要翻转
        if(head.next==null||head.next.next==null){
            return;
        }
        LinkNode c=head.next;
        LinkNode next=null; //当前节点的下一个节点
        LinkNode reverseHead=new LinkNode(0,"");
        while (c!=null){
            next=c.next; //保存当前节点的 下一个节点
            c.next=reverseHead.next;//当前节点的下一个节点指向 reverseHead的第一个节点
            reverseHead.next=c;//reverseHead 的第一个节点变成 指向c节点
            c=next; // c节点 变为 当前节点的下一个节点
        }
        head.next=reverseHead.next;
    }
    /*
        head是链表  index是倒数第几个 索引
     */
    public static LinkNode findLastIndexNode(LinkNode head,int index){
        // 链表是空  找不到
        if(head.next==null){
            return null;
        }
        //获取 链表长度
        int size=getLength(head);
        if(index<=0|| index>size){
            return null;
        }
        LinkNode m=head.next;
        for(int i=1;i<=size-index;i++){
            m=m.next;
        }
        return m;
    }
    // 返回有效节点个数
    public static int getLength(LinkNode node){
        if(node.next==null){
            return 0;
        }
        int length=0;
        //去掉 头节点
        LinkNode cur=node.next;
        while(cur!=null){
            length++;
            cur=cur.next;
        }
        return length;
    }
}

class SingleLink{
    //头结点 不放数据
    private LinkNode head=new LinkNode(0,"");

    public  LinkNode getHead() {
        return head;
    }
    /*
          删除链表 通过no
         */
    public void delByNo(Integer no){
        LinkNode temp=head;
        boolean flag=false;
        while(true){
            if(temp.next==null){
                break;
            }
            if(temp.next.no==no){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if(flag==true){
            temp.next=temp.next.next;
        }else{
            System.out.printf("你要删除的编号%d 不存在\n",no);
        }
    }
    /*
    更加 id编号 修改
     */
    public void updateByNo(LinkNode newNode){
        if(head.next==null){
            System.out.println("链表是空");
            return;
        }
        // 定义辅助变量  遍历查找
        LinkNode temp=head.next;
        boolean flag=false;
        while (true){
            if(temp==null){
                break; //遍历完了
            }
            if(temp.no==newNode.no){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if(flag){
            temp.name=newNode.name;
        }else{
            System.out.printf("你要修改的编号%d 不存在\n",newNode.no);
        }
    }
    /*
      按照id大小 添加结点
     */
    public void addByOrder(LinkNode node){
        LinkNode temp=head;
        boolean flag=false; //标志编号是否存在，默认false
        while(true){
            if(temp.next==null){
                break; //链表已经在最后
            }
            if(temp.next.no>node.no){
                break; //找到位置，在temp后面 插入
            }else if(temp.next.no==node.no){
                flag=true; //说明编号存在
                break;
            }
            temp=temp.next;
        }
        if(flag==true){
            System.out.printf("准备插入的英雄%d 已经存在,不能加人\n",node.no);
        }else{
            node.next=temp.next;
            temp.next=node;
        }
    }
    public void list(){
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        LinkNode temp=head.next;
        while (true){
            if(temp==null)
                break;
            System.out.println(temp);
            temp=temp.next;
        }
    }
    //添加结点
    public void add(LinkNode node){
        LinkNode temp=head;
        while (true){
            if(temp.next==null){
                break;
            }
            temp=temp.next;
        }
        temp.next=node;
    }
}

class LinkNode{
    public int no;
    public String name;
    public LinkNode next;
    public LinkNode(int no,String name){
        this.no=no;
        this.name=name;
    }
    @Override
    public String toString() {
        return "LinkNode[no="+no+" name="+name +"]";
    }
}