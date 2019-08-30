package com.data;

import java.util.*;

public class ArrayStack {
    public static void main(String[] args){
     /*  Stack stack=new Stack(4);
       String key="";
       boolean loop=true;
       Scanner scanner=new Scanner(System.in);
        while (loop){
            System.out.println("show:显示栈");
            System.out.println("exit:退出程序");
            System.out.println("push:添加数据到入栈");
            System.out.println("pop:出栈");
            System.out.println("请输入你的选择");
            key=scanner.nextLine();
            switch (key){
                case "show":
                    stack.list(); break;
                case "push":
                    System.out.println("输入一个数");
                    int value=scanner.nextInt();
                    stack.push(value); break;
                case "pop":
                    try{
                        int res=stack.pop();
                        System.out.printf("出栈的数据是%d",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                        scanner.close();
                        loop=false;
                        break;
                        default:
                            break;
            }
        }
        System.out.println("退出");  */
        System.out.println(suffixExpression(infixToSuffix()));
    }
    /*
     中缀表达式转后缀表达式
     */
    public static List<String> infixToSuffix(){
        String s="1+((2+3)*4)-5";
        List<String> ls=new ArrayList<>();
        int i=0;
        StringBuffer str=new StringBuffer("");
        char c;
        do{
            //非数字 直接加入集合
            if((c=s.charAt(i))<48 || (c=s.charAt(i))>57){
                ls.add(c+"");
                i++;
            }else{
                str.setLength(0);
                while (i<s.length() &&(c=s.charAt(i))>=48&&(c=s.charAt(i))<=57){
                    str.append(c);
                    i++;
                }
                ls.add(str.toString());
            }
        }while (i<s.length());
        // 定义 一个栈  一个集合
        Stack<String> s1=new Stack<>();
        List<String> s2=new ArrayList<>();
        //遍历 中缀表达式对应的集合
        for (String item:ls) {
            // 如果是数  加入s2
            if(item.matches("\\d+")){
                s2.add(item);
            }else if(item.equals("(")){
                s1.push(item);
            }else if(item.equals(")")){
                //如果是 右括号，则依次弹出s1栈顶的运算符，并加入s2，直到遇到左括号为止,此时要丢弃一对括号
                while (!s1.peek().equals("(")){
                    s2.add(s1.pop());
                }
                s1.pop(); //将s1的左括号 出栈
            }else {
                //当item 运算符的优先级小于等于 s1栈顶的运算符，将s1栈顶的运算符弹出放入 s2里面,循环之
                while (s1.size()!=0&&priority(s1.peek().charAt(0))>=priority(item.charAt(0))){
                    s2.add(s1.pop());
                }
                //  item压入 s1栈
                s1.push(item);
            }
        }
        //s1剩余 的符合  加入s2
        while (s1.size()!=0){
            s2.add(s1.pop());
        }
        return s2;
    }
    /*
      (3 + 4) × 5 - 6 就是中缀表达式
       - × + 3 4 5 6 前缀表达式(从右面 开始所有数字入栈，遇到运算符与出栈两个数字计算结果再入栈.....)
      3 4 + 5 × 6 - 后缀表达式(从左面开始入栈，遇到符号，出栈两个数字，运算并入栈.....)
     */
    public static int suffixExpression(List<String > ls){
        Stack<String> stack=new Stack<>();
        for (String item:ls) {
            if(item.matches("\\d+")){
                stack.push(item);
            }else {
                int num2=Integer.parseInt(stack.pop());
                int num1=Integer.parseInt(stack.pop());
                int res=0;
                if(item.equals("+")){
                    res=num1+num2;
                }else if(item.equals("-")){
                    res=num1-num2;
                }else if(item.equals("*")){
                    res=num1*num2;
                }else if(item.equals("/")){
                    res=num1/num2;
                }else{
                    throw new RuntimeException("运算符有误。。");
                }
                stack.push(res+"");
            }
        }
        return Integer.parseInt(stack.pop());
    }

    /*
    栈 模拟计数器  中缀表达式
     */
    public static void JSQ(){
        String expression="20/10*23-6";
        StackArray numStack=new StackArray(10);
        StackArray operStack=new StackArray(10);
        int index=0; //用于扫描
        int num1=0;
        int num2=0;
        int oper=0;
        int res=0;
        StringBuffer keepNum=new StringBuffer();
        char ch=' ';//每次扫描得到的char
        while (true){
            ch=expression.substring(index,index+1).charAt(0);
            if(isOper(ch)){
                if(!operStack.isEmpty()){
            /*运算符栈不是空 ,如果当前运算符优先级小于等于栈里面的运算符
            就需要从数栈里pop出两个数，符合栈里pop一个符合，得到结果 放入数栈，当前运算符放入符号栈
            */
                    if(priority(ch)<=priority(operStack.peek())){
                         num2=numStack.pop();
                         num1=numStack.pop();
                         oper=operStack.pop();
                         res=cal(num1,num2,oper);
                         numStack.push(res);
                         operStack.push(ch);
                    }else{
                        operStack.push(ch);
                    }
                }else {
                    operStack.push(ch);
                }
            }else{  //如果是数字，直接入栈,处理多位数字
                keepNum.append(ch);
               if(index==expression.length()-1){
                   numStack.push(Integer.parseInt(keepNum.toString()));
               }else{
                   // ch 下一个是不是符合
                    if(isOper(expression.substring(index+1,index+2).charAt(0))){
                        numStack.push(Integer.parseInt(keepNum.toString()));
                        //清空 StringBuffer
                        keepNum.setLength(0);
                    }
               }
            }
            //让 index加1  并判断是否扫描到最后
            if(++index >= expression.length()){
                break;
            }
        }
        //扫描完毕 就顺序的从数栈、符合栈取出数据，并运行结果
        while (true){
            if(operStack.isEmpty()){
                break;
            }
            num2=numStack.pop();
            num1=numStack.pop();
            oper=operStack.pop();
            res=cal(num1,num2,oper);
            numStack.push(res);
        }
        System.out.printf("表达式 %s = %d",expression,numStack.peek());
    }
    //计算
    public static int cal(int num1,int num2,int oper){
        int res=0;
        switch(oper){
            case '+':
                res=num1+num2; break;
            case '-':
                res=num1-num2; break;
            case '*':
                res=num1*num2; break;
            case '/':
                res=num1/num2; break;
                default:break;
        }
        return res;
    }
    //运算符 优先级 判断
    public static int priority(int oper){
        if(oper=='*'||oper=='/')
            return 1;
        else if(oper=='+'||oper=='-')
            return 0;
        else return -1;
    }
    //判断是不是一个运算符
    public static boolean isOper(char val){
        return val=='+'||val=='-'||val=='*'|val=='/';
    }
}

class StackArray{
    private int maxSize;
    private int[] stack;
    private int top=-1; //栈顶，初始化为-1
    public StackArray(int maxSize){
        this.maxSize=maxSize;
        stack=new int[maxSize];
    }
    //查看栈顶
    public int peek(){
        return stack[top];
    }
    public void list(){
     if(isEmpty()){
         System.out.println("栈空，没有数据");
         return;
     }
     for (int i=top;i>=0;i--){
         System.out.printf("stack[%d]=%d\n",i,stack[i]);
     }
    }
    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("栈空啊啊");
        }
        return stack[top--];
    }

    public void push(int value){
        if(isFull()){
            System.out.println("栈满");
            return;
        }
        stack[++top]=value;
    }

    public boolean isEmpty(){
        return top==-1;
    }
   public boolean isFull(){
        return top==maxSize-1;
   }
}