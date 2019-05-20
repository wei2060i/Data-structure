
public class MyQueue {
	
	private int[] elements;
	public MyQueue() {
		elements=new int[0];
	}
	//���
	public void add(int element) {
		//����һ��������
		int[] newArr=new int[elements.length+1];
		for (int i = 0; i < elements.length; i++) {
			newArr[i]=elements[i];
		}
		newArr[elements.length]=element;
		elements=newArr;
	}
	//����
	public int poll() {
		if(elements.length==0) {
			throw new RuntimeException("Queue is null");
		}
		int element=elements[0];
		int[] newArr=new int[elements.length-1];
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
