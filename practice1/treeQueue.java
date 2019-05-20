
public class treeQueue {
	private TreeNode[] elements;
	public treeQueue() {
		elements=new TreeNode[0];
	}
	//���
	public void add(TreeNode element) {
		//����һ��������
		TreeNode[] newArr=new TreeNode[elements.length+1];
		for (int i = 0; i < elements.length; i++) {
			newArr[i]=elements[i];
		}
		newArr[elements.length]=element;
		elements=newArr;
	}
	//����
	public TreeNode poll() {
		if(elements.length==0) {
			throw new RuntimeException("Queue is null");
		}
		TreeNode element=elements[0];
		TreeNode[] newArr=new TreeNode[elements.length-1];
		for (int i = 0; i < newArr.length; i++) {
			newArr[i]=elements[i+1];
		}
		elements=newArr;
		return element;
	}
	//�Ƿ�Ϊ��
	public boolean isEmpty() {
		return elements.length==0;
	}
}
