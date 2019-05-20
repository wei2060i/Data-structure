
public class MyStack {
	//ջ�ײ�����ʹ������洢����
	private int[] elements;
	public MyStack() {
		elements=new int[0];
	}
	//ѹջ
	public void push(int element) {
		//����һ��������
		int[] newArr=new int[elements.length+1];
		for (int i = 0; i < elements.length; i++) {
			newArr[i]=elements[i];
		}
		newArr[elements.length]=element;
		elements=newArr;
	}
	//��ջ
	public int pop() {
		if(elements.length==0) {
			throw new RuntimeException("Stack is null");
		}
		//ȡ�����һ��Ԫ��
		int element=elements[elements.length-1];
		int [] newArr=new int[elements.length-1];
		for (int i = 0; i < elements.length-1; i++) {
			newArr[i]=elements[i];
		}
		elements=newArr;
		return element;
	}
	//�鿴ջ��Ԫ��
	public int peek() {
		if(elements.length==0) {
			throw new RuntimeException("Stack is null");
		}
		return elements[elements.length-1];
	}
	//�Ƿ�Ϊ��
	public boolean isEmpty() {
		return elements.length==0;
	}
}
