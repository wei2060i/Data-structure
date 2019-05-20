
public class Node {	
	int data;
	Node next;
	public Node(int data) {
		this.data = data;
	}
	//Ϊ����׷�� �ڵ�
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
	//���� ����
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
	//ɾ����һ���ڵ�
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
	//����һ���ڵ���Ϊ��ǰ�ڵ���һ���ڵ�
	public void after(Node node) {
		//ȡ�� ����ڵ�� ����һ���ڵ�
		Node nextNext=this.next;
		//����
		this.next=node;
		// ��� 
		node.next=nextNext;
	}
	//��һ���ڵ�
	public Node next() {
		if(this.next==null) {
			throw new RuntimeException("There is no next node");
		}
		return this.next;
	}
	//��ȡ��ǰ�ڵ�����
	public int getDate(){
		return this.data;
	}
	//�ж��Ƿ�Ϊ���һ���ڵ�
	public boolean isEmpty() {
		return this.next==null;
	}
	
}
