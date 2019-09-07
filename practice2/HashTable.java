package com.data;

import java.util.Scanner;

public class HashTable {
    public static void main(String[] args) {
        HashTab hashTab=new HashTab(10);
        String key="";
        Scanner scanner=new Scanner(System.in);
        while (true){
            System.out.println("add: 添加雇员");
            System.out.println("list: 显示雇员");
            System.out.println("find: 查找雇员");
            System.out.println("exit: 退出系统");
            key=scanner.next();
            switch (key){
                case "add":
                    System.out.println("输入id");
                    int id=scanner.nextInt();
                    System.out.println("输入名字");
                    String name=scanner.next();
                    Emp emp=new Emp(id,name);
                    hashTab.Add(emp);
                    break;
                case "list":
                    hashTab.List();
                    break;
                case "find":
                    System.out.println("输入查找的雇员id");
                    id=scanner.nextInt();
                    hashTab.findEmpById(id);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                    default: break;
            }
        }
    }

}
class HashTab{
    public EmpLinkedList[] empLinkedListArray;
    private int size;
    public HashTab(int size){
        this.size=size;
        empLinkedListArray=new EmpLinkedList[size];
        for (int i=0;i<empLinkedListArray.length;i++) {
            empLinkedListArray[i]=new EmpLinkedList();
        }
    }
    public void findEmpById(int id){
        int empLinkedListNo=hashFun(id);
        Emp emp=empLinkedListArray[empLinkedListNo].findEmpById(id);
        if(emp!=null){
            System.out.printf("在第%d条链表中找到雇员 id=%d\n",(empLinkedListNo+1),id);
        }else{
            System.out.println("哈希表里面没有改雇员");
        }
    }

    //添加 hash
    public void Add(Emp emp){
        //根据 员工id，得到员工应该 添加到哪条链表
        int empLinkedListNo=hashFun(emp.id);
        empLinkedListArray[empLinkedListNo].add(emp);
    }
    //遍历 list
    public void List(){
        for (int i=0;i<empLinkedListArray.length;i++){
            empLinkedListArray[i].list(i);
        }
    }
    //简单 散列函数
    public int hashFun(int id){
        return id%size;
    }
}

class EmpLinkedList{
    // 头指针
    private Emp head;
    public Emp findEmpById(int id){
        if(head==null){
            return null;
        }
        Emp curEmp=head;
        while (true){
            if(curEmp.id==id)
                break;
            if(curEmp.next==null){
                curEmp=null;
                break;
            }
            curEmp=curEmp.next;
        }
        return curEmp;
    }

    public void list(int no){
        if(head==null){
            System.out.println("第"+(no+1)+"条链表是空啊");
            return;
        }
        System.out.print("第"+(no+1)+"条链表信息是：");
        Emp curEmp=head;
        while (true){
            System.out.printf("id=%d && name=%s\t",curEmp.id,curEmp.name);
            if(curEmp.next==null)
                break;
            curEmp=curEmp.next;
        }
        System.out.println();
    }
    //为了方便，假定 添加的员工 id是自增的，直接添加到最后即可
    public void add(Emp emp){
        if(head==null){
            head=emp;
            return;
        }
        //使用辅助 指针 添加元素
        Emp curEmp=head;
        while (true){
            if(curEmp.next==null)
                break;
            curEmp=curEmp.next;
        }
        curEmp.next=emp;
    }
}
class Emp{
    public int id;
    public String name;
    public Emp next;
    public Emp(int id,String name){
        this.id=id;
        this.name=name;
    }
}