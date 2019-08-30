package com.data;

import java.util.Scanner;

public class ArrayQueue {
    public static void main(String[] args){
        Queue queue=new Queue(3);
        char key=' ';
        Scanner scanner=new Scanner(System.in);
        boolean loop=true;
        while (loop){
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出队列");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):出队列");
            System.out.println("h(head):查看队头");
            key=scanner.next().charAt(0);
            switch(key){
                case 's':
                    queue.showQueue();break;
                case 'a':
                    System.out.println("输入数据");
                    int value=scanner.nextInt();
                    queue.addQueue(value);break;
                case 'g':
                    try{
                        int res=queue.getQueue();
                        System.out.println("取出的数据是"+res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try{
                        int res=queue.headQueue();
                        System.out.println("队列头的数据是"+res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop=false;
                    break;
                    default:
                        break;
            }
        }
        System.out.println("退出");
    }
}
/*
循环队列，空一个位置作为约定
最大存入maxSize-1个数据
 */
class Queue{
    private int maxSize; //容量
    private int front;//指向队列头部，分析front是指向队列第一个元素 初始值0
    private int rear;//指向队列尾，rear指向队列最后一个元素的后一个位置  初始值0
    private int[] arr; //数据  最后空一个位置
    public Queue(int arrMaxSize){
        this.maxSize=arrMaxSize;
        arr=new int[maxSize];
    }
    //判断是否满
    public boolean isFull(){
        return (rear+1)%maxSize==front;
    }
    //判断是否空
    public boolean isEmpty(){
        return rear==front;
    }
    //查看队头数据
    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列空，没有数据");
        }
        return arr[front];
    }
    //遍历队列
   public void showQueue(){
       if(isEmpty()){
           System.out.println("队列空，没有数据");
           return;
       }
       for (int i=front;i<front+size();i++){
           System.out.printf("arr[%d]=%d\n",i%maxSize,arr[i%maxSize]);
       }
   }
    //当前队列有效数据的个数
    public int size(){
        return (rear+maxSize-front)%maxSize;
    }
    //出队
    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列空，不能取数据");
        }
        //先把front对应的值保存到临时变量,然后后移指针,最后返回临时变量
        int value=arr[front];
        front=(front+1)%maxSize;
        return value;
    }
    //添加数据
    public void addQueue(int n){
        if(isFull()){
            System.out.println("队列已满，不能加数据");
            return;
        }
        arr[rear]=n;
        //向后移动一个位置
        rear=(rear+1)%maxSize;
    }
}