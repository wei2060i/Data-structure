package com.data;

import sun.reflect.generics.tree.Tree;

public class BinaryTree {
    public static void main(String[] args) {
        BinaryTreeDemo binaryTree=new BinaryTreeDemo();
        TreeNode root=new TreeNode(1,"松江");
        TreeNode n1=new TreeNode(2,"无用");
        TreeNode n2=new TreeNode(3,"卢俊义");
        TreeNode n3=new TreeNode(4,"林冲");
        root.setLeft(n1);
        root.setRight(n2);
        n2.setRight(n3);
        binaryTree.setRoot(root);
        binaryTree.threadedNodes(root);
        binaryTree.threadedList();
    }
}
class BinaryTreeDemo{
    private TreeNode root;
    // 线索二叉树使用，保存当前节点的前一个节点
    private TreeNode pre=null;
    public void setRoot(TreeNode root) {
        this.root = root;
    }
    // 中序线索 二叉树 的 遍历
    public void  threadedList(){
        TreeNode node=root;
        while (node !=null){
            while (node.getLeftType()==0){
                node=node.getLeft();
            }
            System.out.println(node);
            while (node.getRightType()==1){
                node=node.getRight();
                System.out.println(node);
            }
            node=node.getRight();
        }
    }
    // 中序线索 二叉树
    public void threadedNodes(TreeNode node){
        if(node==null){
            return;
        }
        threadedNodes(node.getLeft());
        //处理前驱节点
        if(node.getLeft()==null) {
            //让当前节点的左指针 指向前驱pre
            node.setLeft(pre);
            //改变类型
            node.setLeftType(1);
        }
        //处理前驱的 右节点  有可能 没有前驱
        if(pre!=null && pre.getRight()==null) {
            pre.setRight(node);
            pre.setRightType(1);
        }
        //每处理一个节点，当前节点是下一个节点的前驱节点
        pre=node;
        threadedNodes(node.getRight());
    }

    //删除 节点
    public void delNode(int no){
        if(root!=null){
            if(root.getNo()==no){
                root=null;
            }else {
                root.delNode(no);
            }
        }else {
            System.out.println("树是空 无法删除");
        }
    }
    public TreeNode PreOrderSearch(int no){
        if(root!=null){
            return root.PrePrderSearch(no);
        }else return null;
    }
    public TreeNode infixOrderSearch(int no){
        if(root!=null)
            return root.infixOrderSearch(no);
        else return null;
    }
    public TreeNode postOrderSearch(int no){
        if(root!=null)
            return root.postOrderSearch(no);
        else return null;
    }
    public void PreOrder(){
        if(this.root!=null){
            this.root.PreOrder();
        }else {
            System.out.println("当前树是空");
        }
    }
    public void infixOrder(){
        if(this.root!=null){
            this.root.infixOrder();
        }else {
            System.out.println("当前树是空");
        }
    }
    public void postOrder(){
        if(this.root!=null){
            this.root.postOrder();
        }else {
            System.out.println("当前树是空");
        }
    }
}
class TreeNode{
    private int no;
    private String name;
    private TreeNode left;
    private TreeNode right;
    // leftType==0 是左子树  1 前驱节点
    private int leftType;
    //rightType==0是右子树  1后继节点
    private int rightType;

    public TreeNode(int no,String name){
        this.no=no;
        this.name=name;
    }
    /*
     如果删除的是叶节点，则直接删除
     如果删除的是非叶节点，则直接删叶节点以及其树
     判断当前节点的子节点是否要删除(节点之间 单向)
     */
    public void delNode(int no){
        if(this.left!=null && this.left.no==no){
            this.setLeft(null);
        }
        if(this.right!=null && this.right.no==no){
            this.setRight(null);
        }
        //向左 递归删除
        if(this.left!=null){
            this.left.delNode(no);
        }
        //向右 递归删除
        if(this.right!=null){
            this.right.delNode(no);
        }
    }
   //前序遍历
    public void PreOrder(){
        // 打印当前 节点数据
        System.out.println(this);
        if(this.left!=null){
            this.left.PreOrder();
        }
        if(this.right!=null){
            this.right.PreOrder();
        }
    }
    //前序遍历查找
    public TreeNode PrePrderSearch(int no){
        System.out.println("前序遍历*次中.........");
        if(this.no==no){
            return this;
        }
        TreeNode res=null;
        if(this.left!=null){
            res=this.left.PrePrderSearch(no);
        }
        if(res!=null)
            return res;
        if(this.right!=null){
            res=this.right.PrePrderSearch(no);
        }
        return res;
    }
    //中序遍历
    public void  infixOrder(){
        if(this.left!=null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if(this.right!=null){
            this.right.infixOrder();
        }
    }
    //中序遍历查找
    public TreeNode  infixOrderSearch(int no){
        TreeNode res=null;
        if(this.left!=null){
            res=this.left.infixOrderSearch(no);
        }
        if(res!=null)
            return res;
        System.out.println("中序遍历*次中.........");
        if(this.no==no)
            return this;
        if(this.right!=null){
            res=this.right.infixOrderSearch(no);
        }
        return res;
    }
    //后续遍历
    public  void  postOrder(){
        if(this.left!=null){
            this.left.postOrder();
        }
        if(this.right!=null){
            this.right.postOrder();
        }
        System.out.println(this);
    }
    //后续查找
    public TreeNode postOrderSearch(int no){
        TreeNode res=null;
        if(this.left!=null){
            res=this.left.postOrderSearch(no);
        }
        if(res!=null)
            return res;
        if(this.right!=null){
            res=this.right.postOrderSearch(no);
        }
        if(res!=null)  //如果右子树找到了  就返回
            return res;
        System.out.println("后序遍历*次中.........");
        if(this.no==no)
            return this;
        return res;
    }
    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getLeftType() {
        return leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    @Override
    public String toString() {
        return "Node[no="+no+"  name="+name+"]";
    }
}