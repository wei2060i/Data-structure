
public class DoubleNode {
	//˫��ѭ������
	DoubleNode pre=this;
	DoubleNode next=this;
	int data;
	public DoubleNode(int data) {
		this.data = data;
	}
	//���ӽڵ�
	public void after(DoubleNode node) {	
		//this��һ���ڵ�
		DoubleNode nextNode=this.next;
		this.next=node;
		node.pre=this;
		node.next=nextNode;
		nextNode.pre=node;
	}
	//��һ���ڵ�
	public DoubleNode pre() {
		return this.pre;
	}
	//��һ���ڵ�
	public DoubleNode next() {
		return this.next;
	}
}
