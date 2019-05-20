
public class MyStack {
	//栈底层我们使用数组存储数据
	private int[] elements;
	public MyStack() {
		elements=new int[0];
	}
	//压栈
	public void push(int element) {
		//创建一个新数组
		int[] newArr=new int[elements.length+1];
		for (int i = 0; i < elements.length; i++) {
			newArr[i]=elements[i];
		}
		newArr[elements.length]=element;
		elements=newArr;
	}
	//出栈
	public int pop() {
		if(elements.length==0) {
			throw new RuntimeException("Stack is null");
		}
		//取出最后一个元素
		int element=elements[elements.length-1];
		int [] newArr=new int[elements.length-1];
		for (int i = 0; i < elements.length-1; i++) {
			newArr[i]=elements[i];
		}
		elements=newArr;
		return element;
	}
	//查看栈顶元素
	public int peek() {
		if(elements.length==0) {
			throw new RuntimeException("Stack is null");
		}
		return elements[elements.length-1];
	}
	//是否为空
	public boolean isEmpty() {
		return elements.length==0;
	}
}
