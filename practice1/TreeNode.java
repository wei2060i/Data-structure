import java.util.Collections;

/*
 * 顺序存储的二叉树通常只考虑完全二叉树(对于深度为K的，有n个结点的二叉树，
 * 当且仅当其每一个结点都与深度为K的满二叉树中编号从1至n的结点一一对应)
 * 
 */
public class TreeNode implements Comparable<TreeNode>{
	public int data;
	public TreeNode leftNode;
	public TreeNode rightNode;
	//线索二叉树用 0是左右子树   1是前驱后继
	public int leftType;
	public int rightType;

	public TreeNode(int data) {
		this.data = data;
	}
	public void setLeftNode(TreeNode leftNode) {
		this.leftNode = leftNode;
	}
	public void setRightTree(TreeNode rightNode) {
		this.rightNode = rightNode;
	}
	// bfs
	public void bfs(TreeNode root) {
		treeQueue q=new treeQueue();
		if(root == null) {
			return ;
		}
		q.add(root);
		while(!q.isEmpty()) {
			TreeNode poll = q.poll();
			System.out.println(poll.data);
			if(poll.leftNode !=null){
				q.add(poll.leftNode);
			}
			if(poll.rightNode !=null) {
				q.add(poll.rightNode);
			}
		}	
	}
	//前序遍历
	public void beforeShow(TreeNode root) {
		System.out.println(this.data);
		if(this.leftNode !=null) {
			leftNode.beforeShow(leftNode);
		}
		if(this.rightNode !=null) {
			rightNode.beforeShow(rightNode);
		}
	}
	//中序遍历
	public void midShow(TreeNode root) {
		if(this.leftNode !=null) {
			leftNode.midShow(leftNode);
		}
		System.out.println(this.data);
		if(this.rightNode !=null) {
			rightNode.midShow(rightNode);
		}
	}
	//后续遍历
	public void afterShow(TreeNode root) {
		if(this.leftNode !=null) {
			leftNode.afterShow(leftNode);
		}
		if(this.rightNode !=null) {
			rightNode.afterShow(rightNode);
		}
		System.out.println(this.data);
	}
	
	//用于比较排序  Collections.sort  大到小排序
	@Override
	public int compareTo(TreeNode o) {
		return o.data-this.data;
	}
}
