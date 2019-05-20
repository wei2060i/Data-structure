
public class Graph {
	
	public Vertex[] vertex;
	//�������
	private int currentSize;
	//�ڽӾ���
	public int[][] adjMat;
	
	//����:size �Ƕ������
	public Graph(int size) {
		super();
		vertex=new Vertex[size];
		adjMat=new int[size][size];
		//�Լ����Լ���ͨ
		for(int i=0;i<size;i++) {
			adjMat[i][i]=1;
		}
	}
	//��Ӷ���
	public void addVertex(Vertex v) {
		vertex[currentSize++]=v;
	}
	//�����ͨ�ı�
	public void addEdge(String v1,String v2) {
		int index1=0;
		for (int i = 0; i <vertex.length; i++) {
			if(vertex[i].getValue().equals(v1)) {
				index1=i;
				break;
			}
		}
		int index2=0;
		for (int i = 0; i <vertex.length; i++) {
			if(vertex[i].getValue().equals(v2)) {
				index2=i;
				break;
			}
		}
		adjMat[index1][index2]=1;
		adjMat[index2][index1]=1;
	}
	//������ȱ���,һ��·�ߵ���
	public void dfsShow() {
		for(int i=0;i<vertex.length;i++) {
			if(vertex[i].visited==false) {
				dfs(i);
			}
		}
	}
	private void dfs(int i) {
		System.out.println(vertex[i].getValue());
		vertex[i].visited=true;
		for(int j=i+1;j<vertex.length;j++) {
			if(adjMat[i][j]==1&&vertex[j].visited==false) {
				dfs(j);
			}
		}
	}
	//������ȱ���,��Ҫ�ö���
	public void bfsShow() {
		for(int i=0;i<vertex.length;i++) {
			if(vertex[i].visited==false) {
				bfs(i);
			}
		}
	}
	private void bfs(int i) {
		//�������� bfsʹ��
		MyQueue queue=new MyQueue();
		queue.add(i);
		vertex[i].visited=true;
		System.out.println(vertex[i].getValue());
		while(!queue.isEmpty()) {
			//�ó���ͷ
			int temp=queue.front();
			//��ͷ ����
			queue.poll();
			for(int j=0;j<vertex.length&&j>temp;j++) {
				if(adjMat[temp][j]==1&&vertex[j].visited==false) {
					vertex[j].visited=true;
					System.out.println(vertex[j].getValue());
					queue.add(j);
				}
			}
		}
	}
}


//ͼ�Ķ���
class Vertex{
	private String value;
	//�Ƿ����
	public boolean visited;
	public Vertex(String value) {
		super();
		this.value = value;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return value;
	}
}