
public class ThreadedBinaryTree {
		//��ʱ�洢ǰ���ڵ�  Ĭ����null
		public TreeNode pre;
		
		//����  ��������������
		public void midShow(TreeNode root){
			//��ʱ�洢��ǰ�����Ľڵ�
			TreeNode node=root;
			while(node !=null) {
				//ѭ���ҵ��ʼ�Ľڵ�
				while(node.leftType==0) {
					node=node.leftNode;
				}
				//���ֵ
				System.out.println(node.data);
				//�����ǰ�ڵ��������� ��̣����ܺ�̽ڵ�ĺ��� ���к��
				while(node.rightType==1) {
					node=node.rightNode;
					System.out.println(node.data);
				}
				//�滻 �ڵ�
				node=node.rightNode;
			}
		}
		//���� ����������
	 	public void midThreadNodes(TreeNode node) {
			if(node==null) return;
			//����������
			midThreadNodes(node.leftNode);
			//����ǰ���ڵ�
			if(node.leftNode==null) {
				//�õ�ǰ�ڵ����ָ�� ָ��ǰ��pre
				node.leftNode=pre;
				//�ı�����
				node.leftType=1;
			}
			//����ǰ���� �ҽڵ�  �п��� û��ǰ��
			if(pre!=null && pre.rightNode==null) {
				pre.rightNode=node;
				pre.rightType=1;
			}
			//ÿ����һ���ڵ㣬��ǰ�ڵ�����һ���ڵ��ǰ���ڵ�
			pre=node;
			//����������
			midThreadNodes(node.rightNode);
		}
}
