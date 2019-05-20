import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
 * Ҳ�����Ŷ�����:ָ����һ�����ȷ��Ȩֵ��Ҷ��㣬����ľ�����С��Ȩ·�����ȵĶ�����
 * 
 */
public class HuffmanTree {

	public HuffmanTree() {
		super();
	}
	//�����շ�����
	public TreeNode createHuffmanTree(int []arr) {
		//��������ֻ��һ���ڵ�Ķ�����
		List<TreeNode> nodes=new ArrayList<>();
		for(int value:arr) {
			nodes.add(new TreeNode(value));
		}
		while(nodes.size()>1) {
			//��С����
			Collections.sort(nodes);
			//ȡ��Ȩֵ��С������������
			TreeNode left = nodes.get(nodes.size()-1);
			TreeNode right = nodes.get(nodes.size()-2);
			//����µĶ�����
			TreeNode parent=new TreeNode(left.data+right.data);
			parent.leftNode=left;
			parent.rightNode=right;
			//�Ƴ�ԭ���������������
			nodes.remove(left);
			nodes.remove(right);
			nodes.add(parent);
		}
		return nodes.get(0);
	}
}
