package com.controller.tree;

/**
 * 二叉排序树 ->平衡二叉排序树(AVL)
 */
public class BinarySortTree {
    public static void main(String[] args) {
        AVLTree();

    }

    public static void AVLTree(){

        int[] arr = {10,11,7,6,8,9};

        BinarySortTreeDemo binarySortTree = new BinarySortTreeDemo();

        for (int i : arr) {
            binarySortTree.addAVL(new Node(i));
        }

        Node root = binarySortTree.getRoot();
        System.out.println("树的高度"+root.height());
        System.out.println("树左子树的高度"+root.leftHeight());
        System.out.println("树右子树的高度"+root.rightHeight());

        
    }

}


class BinarySortTreeDemo{
    private Node root;

    //删除节点
    public void delNode(int value) {
        if(root == null) {
            return;
        } else {
           //先找到 要删除的 节点
            Node targetNode = search(value);
            if(targetNode == null) {
                return;
            }
            //如果当前二叉排序树只有一个节点
            if(root.left == null && root.right == null) {
                 root = null;
                 return;
            }
            //查找父节点
            Node parent = searchPrent(value);
            //要删除的 节点 是叶子节点
            if(targetNode.left == null && targetNode.right == null) {
                //判断是左节点还是右节点
                if(parent.left != null && parent.left.value ==value) {
                    parent.left = null;
                } else if(parent.right != null && parent.right.value == value) {
                    parent.right = null;
                }
            } else if(targetNode.left != null && targetNode.right != null) {
                 //删除有两颗子树 的 节点
                //找到右子树的最小值 删了
                int MinVal = delRightTreeMin(targetNode.right);
                targetNode.value = MinVal; //最小值 赋给targetNode

            } else {  //删除只有一颗 子节点 的节点
                if(targetNode.left != null) { //只有左节点
                    if(parent.left.value == value) {
                        parent.left = targetNode.left;
                    } else {
                        parent.right = targetNode.left;
                    }
                } else { //只有右节点
                    if(parent.left.value == value) {
                        parent.left = targetNode.right;
                    } else {
                        parent.right = targetNode.right;
                    }
                }
            }
        }
    }

    /**
     * 删除 以Node为根节点的 二叉排序树的最小节点的值
     * @param node
     * @return
     */
    public int delRightTreeMin(Node node) {
        Node target = node;
        while (target.left != null) {
            target = target.left;
        }
        delNode(target.value);
        return target.value;
    }

    //查找父节点
    public Node searchPrent(int value) {
        if(root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }

    //查找要删除的节点
    public Node search(int value) {
        if(root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }
    //添加节点的方法
    public void add(Node node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }
    //中序遍历
    public void infixOrder(){
        if (root != null) {
            root.infixOrder();
        } else {
            System.out.println("当前二叉排序树为空");
        }
    }

    public Node getRoot() {
        return root;
    }

    public void addAVL(Node node) {
        if (root == null) {
            root = node;
        } else {
            root.addAVL(node);
        }
    }
}

class Node {

    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    //左旋转方法
    private void leftRotate() {
        //创建新节点,以当前根节点的值
        Node newNode = new Node(value);
        //把新节点的左子树 设置为当前节点的左子树
        newNode.left = left;
        //把新节点的右子树 设置为当前节点的右子树的左子树
        newNode.right = right.left;
        //把当前节点的值 替换为右子节点的值
        value = right.value;
        //把当前节点的右子树 设置为当前节点的右子树的右子树
        right = right.right;
        //把当前节点的左子树设置 为新节点
        left = newNode;
    }
    //右旋转方法
    private void rightRotate() {
        //创建新节点,以当前根节点的值
        Node newNode = new Node(value);
        //把新节点的右子树 设置为当前节点的右子树
        newNode.right = right;
        //把新节点的左子树 设置为当前节点的左子树的右子树
        newNode.left = left.right;
        //把当前节点的值 替换为左子节点的值
        value = left.value;
        //把当前节点的左子树 设置为当前节点的左子树的左子树
        left = left.left;
        //把当前节点的右子树设置 为新节点
        right = newNode;
    }

    //递归添加节点
    public void addAVL(Node node) {
        if(node == null) {
            return;
        }
        if(node.value < this.value) {
            if(this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        } else {
            if(this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }
        if(rightHeight() - leftHeight() > 1) {
            if(right.leftHeight() > leftHeight()) {
                right.rightRotate();
            }
            leftRotate(); //左旋转
        }

        if(leftHeight() - rightHeight() > 1) {
            if(left.rightHeight() > rightHeight()) { //10 11 7 6 8 9
                left.leftRotate();
            }
            rightRotate(); //右旋转
        }

    }

    //返回右子树的高度
    public int leftHeight() {
        if(left == null)
            return 0;
        return left.height();
    }
    //返回右子树的高度
    public int rightHeight() {
        if(right == null)
            return 0;
        return right.height();
    }
    //返回以该节点为根节点 的树高度
    public int height(){
        return Math.max(left == null ? 0 : left.height(),right == null ? 0 : right.height()) +1;
    }
    /**
     * 查找父节点
     * @param value
     * @return
     */
    public Node searchParent(int value){
        if((this.left != null && this.left.value == value) ||
            (this.right != null && this.right.value == value)) {
           return this;
        } else if(value < this.value && this.left != null) {
            return this.left.searchParent(value);
        } else if(value > this.value && this.right != null) {
            return this.right.searchParent(value);
        } else {
            return null;
        }
    }
    /**
     * 查找要删除的节点
     * @param value
     * @return Node
     */
    public Node search(int value) {
        if(value == this.value) {
            return this;
        } else if(value < this.value){
            if(this.left == null)
                return null;
            return this.left.search(value);
        } else {
            if(this.right == null)
                return null;
            return this.right.search(value);
        }
    }

    //中序遍历
    public void infixOrder(){
        if(this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if(this.right != null) {
            this.right.infixOrder();
        }
    }

    //递归添加节点
    public void add(Node node) {
        if(node == null) {
            return;
        }
        if(node.value < this.value) {
            if(this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        } else {
            if(this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }
    }
}