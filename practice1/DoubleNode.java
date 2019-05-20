
public class DoubleNode {
	//双向循环链表
	DoubleNode pre=this;
	DoubleNode next=this;
	int data;
	public DoubleNode(int data) {
		this.data = data;
	}
	//增加节点
	public void after(DoubleNode node) {	
		//this下一个节点
		DoubleNode nextNode=this.next;
		this.next=node;
		node.pre=this;
		node.next=nextNode;
		nextNode.pre=node;
	}
	//上一个节点
	public DoubleNode pre() {
		return this.pre;
	}
	//下一个节点
	public DoubleNode next() {
		return this.next;
	}
}
