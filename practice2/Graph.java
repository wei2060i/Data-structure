package com.controller.tree;
public class Graph {

	public Vertex[] vertex;
	//顶点个数
	private int currentSize;
	//邻接矩阵
	public int[][] adjMat;

	public static void main(String[] args) {
		Graph graph = new Graph(5);
		graph.addVertex(new Vertex("A"));
		graph.addVertex(new Vertex("B"));
		graph.addVertex(new Vertex("C"));
		graph.addVertex(new Vertex("D"));
		graph.addVertex(new Vertex("E"));

		graph.addEdge("A","B");
		graph.addEdge("A","C");
		graph.addEdge("C","B");
		graph.addEdge("B","D");
		graph.addEdge("B","E");

		graph.showAdjMat();
		graph.bfsShow();
    }

	//参数:size 是顶点个数
	public Graph(int size) {
		vertex = new Vertex[size];
		adjMat = new int[size][size];
		//自己与自己连通
		for(int i = 0;i < size;i++) {
			adjMat[i][i] = 1;
		}
	}
	//添加顶点
	public void addVertex(Vertex v) {
		vertex[currentSize++]=v;
	}
	//添加连通的边
	public void addEdge(String v1,String v2) {
		int index1 = 0;
		for (int i = 0; i < vertex.length; i++) {
			if(vertex[i].getValue().equals(v1)) {
				index1 = i;
				break;
			}
		}
		int index2=0;
		for (int i = 0; i < vertex.length; i++) {
			if(vertex[i].getValue().equals(v2)) {
				index2 = i;
				break;
			}
		}
		adjMat[index1][index2]=1;
		adjMat[index2][index1]=1;
	}
	//深度优先遍历,一条路走到黑
	public void dfsShow() {
		for(int i = 0;i < vertex.length;i++) {
			if(vertex[i].visited == false) {
				dfs(i);
			}
		}
	}
	private void dfs(int i) {
		System.out.println(vertex[i].getValue());
		vertex[i].visited = true;
		for(int j = i+1;j < vertex.length;j++) {
			if(adjMat[i][j]==1 && vertex[j].visited == false) {
				dfs(j);
			}
		}
	}
	//广度优先遍历,需要用队列
	public void bfsShow() {
		for(int i = 0;i < vertex.length;i++) {
			if(vertex[i].visited == false) {
				bfs(i);
			}
		}
	}
	private void bfs(int i) {
		//创建队列 bfs使用
		GraphQueue queue = new GraphQueue();
		queue.add(i);
		vertex[i].visited = true;
		System.out.println(vertex[i].getValue());
		while(!queue.isEmpty()) {
			//拿出队头
			int temp = queue.front();
			//队头 出队
			queue.poll();
			for(int j = 0;j < vertex.length && j > temp;j++) {
				if(adjMat[temp][j] == 1 && vertex[j].visited == false) {
					vertex[j].visited = true;
					System.out.println(vertex[j].getValue());
					queue.add(j);
				}
			}
		}
	}

	private void showAdjMat() {
		for (int[] ints : adjMat) {
			for (int anInt : ints) {
				System.out.print(anInt+"\t");
			}
			System.out.println();
		}
	}
}


//图的顶点
class Vertex{
	private String value;
	//是否访问
	public boolean visited;
	public Vertex(String value) {
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