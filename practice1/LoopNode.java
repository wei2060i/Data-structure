
public class LoopNode {	
	int data;
	LoopNode next=this;
	public LoopNode(int data) {
		this.data = data;
	}
	//ɾ����һ���ڵ�
	public void removeNext() {
		LoopNode nextNext=this.next.next;
		this.next=nextNext;
	}
	//����һ���ڵ���Ϊ��ǰ�ڵ���һ���ڵ�
	public void after(LoopNode node) {
		//ȡ�� ����ڵ�� ����һ���ڵ�
		LoopNode nextNext=this.next;
		//����
		this.next=node;
		// ��� 
		node.next=nextNext;
	}
	//��һ���ڵ�
	public LoopNode next() {
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
