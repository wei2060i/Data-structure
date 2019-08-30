package com.data;

public class DoubleLinkedList {
    public static void main(String[] args){
        DoubleNode doubleNode=new DoubleNode();
        Node node1=new Node(1,"小舞");
        Node node2=new Node(2,"小舞2");
        Node node3=new Node(3,"小舞3");
        Node node4=new Node(4,"小舞4");
        doubleNode.add(node1);
        doubleNode.add(node2);
        doubleNode.add(node3);
        doubleNode.add(node4);
        doubleNode.list();
        doubleNode.updateByNo(new Node(1,"小三"));
        doubleNode.list();
        doubleNode.delByNo(4);
        doubleNode.list();
    }
}

class DoubleNode{
    private Node head=new Node(0,"");
    public Node getHead() {
        return head;
    }
    /*
        删除链表 通过no
       */
    public void delByNo(Integer no){
        if(head.next==null){
            System.out.println("链表是空，无法删除");
            return;
        }
        Node temp=head.next;
        boolean flag=false;
        while(true){
            if(temp==null){
                break;
            }
            if(temp.no==no){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if(flag==true){
            //找出 要删除的当前节点
            temp.pre.next=temp.next;
            if(temp.next!=null){
                temp.next.pre=temp.pre;
            }
        }else{
            System.out.printf("你要删除的编号%d 不存在\n",no);
        }
    }
    /*
      更加 id编号 修改
       */
    public void updateByNo(Node newNode){
        if(head.next==null){
            System.out.println("链表是空");
            return;
        }
        // 定义辅助变量  遍历查找
        Node temp=head.next;
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
    //添加结点
    public void add(Node node){
        Node temp=head;
        while (true){
            if(temp.next==null){
                break;
            }
            temp=temp.next;
        }
        temp.next=node;
        node.pre=temp;
    }
   // 遍历 链表
    public void list(){
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        Node temp=head.next;
        while (true){
            if(temp==null)
                break;
            System.out.println(temp);
            temp=temp.next;
        }
    }
}


class Node{
    public int no;
    public String name;
    public Node next;
    public Node pre;
    public Node(int no,String name){
        this.no=no;
        this.name=name;
    }
    @Override
    public String toString() {
        return "LinkNode[no="+no+" name="+name +"]";
    }
}