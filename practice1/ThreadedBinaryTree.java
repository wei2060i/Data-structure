
public class ThreadedBinaryTree {
		//临时存储前驱节点  默认是null
		public TreeNode pre;
		
		//遍历  中序线索二叉树
		public void midShow(TreeNode root){
			//临时存储当前遍历的节点
			TreeNode node=root;
			while(node !=null) {
				//循环找到最开始的节点
				while(node.leftType==0) {
					node=node.leftNode;
				}
				//输出值
				System.out.println(node.data);
				//如果当前节点右类型是 后继，可能后继节点的后面 还有后继
				while(node.rightType==1) {
					node=node.rightNode;
					System.out.println(node.data);
				}
				//替换 节点
				node=node.rightNode;
			}
		}
		//中序 线索二叉树
	 	public void midThreadNodes(TreeNode node) {
			if(node==null) return;
			//处理左子树
			midThreadNodes(node.leftNode);
			//处理前驱节点
			if(node.leftNode==null) {
				//让当前节点的左指针 指向前驱pre
				node.leftNode=pre;
				//改变类型
				node.leftType=1;
			}
			//处理前驱的 右节点  有可能 没有前驱
			if(pre!=null && pre.rightNode==null) {
				pre.rightNode=node;
				pre.rightType=1;
			}
			//每处理一个节点，当前节点是下一个节点的前驱节点
			pre=node;
			//处理右子树
			midThreadNodes(node.rightNode);
		}
}
