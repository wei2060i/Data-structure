
public class Node {	
	int data;
	Node next;
	public Node(int data) {
		this.data = data;
	}
	//为链表追加 节点
	public Node append(Node node) {
		Node currentNode=this;
		while(true) {
			Node nextNode=currentNode.next;		
			if(nextNode==null) {
				break;
			}
			currentNode=nextNode;
		}
		currentNode.next=node;
		return this;
	}
	//遍历 数据
	public void show() {
		Node currentNode=this;
		while(true) {
			System.out.print(currentNode.data+"  ");
			currentNode=currentNode.next;
			if(currentNode==null) {
				break;
			}
		}
		System.out.println();
	}
	//删除下一个节点
	public void removeNext() {
		if(this.next==null) {
			throw new RuntimeException("There is no next node");
		}else {
			if(this.next.next==null) {
				this.next=null;
			}else {
				Node nextNext=this.next.next;
				this.next=nextNext;
			}
		}
	}
	//插入一个节点作为当前节点下一个节点
	public void after(Node node) {
		//取出 插入节点的 后面一个节点
		Node nextNext=this.next;
		//插入
		this.next=node;
		// 组合 
		node.next=nextNext;
	}
	//下一个节点
	public Node next() {
		if(this.next==null) {
			throw new RuntimeException("There is no next node");
		}
		return this.next;
	}
	//获取当前节点数据
	public int getDate(){
		return this.data;
	}
	//判断是否为最后一个节点
	public boolean isEmpty() {
		return this.next==null;
	}
	
}
