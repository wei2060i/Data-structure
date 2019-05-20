
public class LoopNode {	
	int data;
	LoopNode next=this;
	public LoopNode(int data) {
		this.data = data;
	}
	//删除下一个节点
	public void removeNext() {
		LoopNode nextNext=this.next.next;
		this.next=nextNext;
	}
	//插入一个节点作为当前节点下一个节点
	public void after(LoopNode node) {
		//取出 插入节点的 后面一个节点
		LoopNode nextNext=this.next;
		//插入
		this.next=node;
		// 组合 
		node.next=nextNext;
	}
	//下一个节点
	public LoopNode next() {
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
