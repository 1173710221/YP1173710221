package p3;

import java.util.HashSet;
import java.util.Set;

public class FriendshipGraph {
	int vnum = 0;
	int flag = 0;
	Person[] graphvertex = new Person[10000];
	Set personcheck = new HashSet<String>();
	int[][]	graphedge = new int[10000][10000];
	void addVertex(Person person) {
		if (personcheck.contains(person.name))	{
			System.out.println("已存在该元素("+person.name+"),请重新输入");
			System.exit(0);;
		}
		graphvertex[vnum] = person;
		person.ID = vnum;
		graphedge[vnum][vnum] = 0;
		vnum++;
		flag = 0;
		personcheck.add(person.name);
	}  
	
	void  addEdge(Person a,Person b) {
		int va = a.ID;
		int vb = b.ID;
		graphedge[va][vb] = 1;
	}
	
	void init() {
		for (int i=0;i<10000;i++) {
			for (int j=0;j<10000;j++)
				graphedge[i][j] = -1;
		}
	}
	
	public void Floyd() {
		for (int i=0;i<vnum;i++) {
			for (int j=0;j<vnum;j++) {
				for (int k=0;k<vnum;k++) {
					if (graphedge[i][k]!=-1&&graphedge[k][j]!=-1)	{
						int nowlength = graphedge[i][k]+graphedge[k][j];
						if (graphedge[i][j]>nowlength||graphedge[i][j]==-1)	graphedge[i][j]=nowlength;
					}
				}
			}
		}
	};
	
	int getDistance(Person a,Person b) {
		if (flag == 0)	{
			Floyd();
		}
		flag = 1;
		return graphedge[a.ID][b.ID];
	}
	
	public static void main(String args[]) {
		FriendshipGraph graph = new FriendshipGraph();
		Person rachel = new Person("Rachel");
		Person ross = new Person("Ross");
		Person ben = new Person("Ben");
		Person kramer = new Person("Kramer");
		graph.init();
		graph.addVertex(rachel);
		graph.addVertex(ross);
		graph.addVertex(ben);
		graph.addVertex(kramer);
		graph.addEdge(rachel, ross);
		graph.addEdge(ross, rachel);
		graph.addEdge(ross, ben);
		graph.addEdge(ben, ross);
		System.out.println(graph.getDistance(rachel, ross));
		System.out.println(graph.getDistance(rachel, ben));
		System.out.println(graph.getDistance(rachel, rachel));
		System.out.println(graph.getDistance(rachel, kramer));

	}
}