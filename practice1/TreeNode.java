import java.util.Collections;

/*
 * ˳��洢�Ķ�����ͨ��ֻ������ȫ������(�������ΪK�ģ���n�����Ķ�������
 * ���ҽ�����ÿһ����㶼�����ΪK�����������б�Ŵ�1��n�Ľ��һһ��Ӧ)
 * 
 */
public class TreeNode implements Comparable<TreeNode>{
	public int data;
	public TreeNode leftNode;
	public TreeNode rightNode;
	//������������ 0����������   1��ǰ�����
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
	//ǰ�����
	public void beforeShow(TreeNode root) {
		System.out.println(this.data);
		if(this.leftNode !=null) {
			leftNode.beforeShow(leftNode);
		}
		if(this.rightNode !=null) {
			rightNode.beforeShow(rightNode);
		}
	}
	//�������
	public void midShow(TreeNode root) {
		if(this.leftNode !=null) {
			leftNode.midShow(leftNode);
		}
		System.out.println(this.data);
		if(this.rightNode !=null) {
			rightNode.midShow(rightNode);
		}
	}
	//��������
	public void afterShow(TreeNode root) {
		if(this.leftNode !=null) {
			leftNode.afterShow(leftNode);
		}
		if(this.rightNode !=null) {
			rightNode.afterShow(rightNode);
		}
		System.out.println(this.data);
	}
	
	//���ڱȽ�����  Collections.sort  ��С����
	@Override
	public int compareTo(TreeNode o) {
		return o.data-this.data;
	}
}
