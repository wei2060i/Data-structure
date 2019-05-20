import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
 * 也称最优二叉树:指对于一组带有确定权值的叶结点，构造的具有最小带权路径长度的二叉树
 * 
 */
public class HuffmanTree {

	public HuffmanTree() {
		super();
	}
	//创建赫夫曼树
	public TreeNode createHuffmanTree(int []arr) {
		//创建若干只有一个节点的二叉树
		List<TreeNode> nodes=new ArrayList<>();
		for(int value:arr) {
			nodes.add(new TreeNode(value));
		}
		while(nodes.size()>1) {
			//大到小排序
			Collections.sort(nodes);
			//取出权值最小的两个二叉树
			TreeNode left = nodes.get(nodes.size()-1);
			TreeNode right = nodes.get(nodes.size()-2);
			//组合新的二叉树
			TreeNode parent=new TreeNode(left.data+right.data);
			parent.leftNode=left;
			parent.rightNode=right;
			//移除原来的树，添加新树
			nodes.remove(left);
			nodes.remove(right);
			nodes.add(parent);
		}
		return nodes.get(0);
	}
}
