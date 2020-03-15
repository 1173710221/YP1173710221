package p3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FriendshipGraphTest {
	FriendshipGraph graph = new FriendshipGraph();
	Person rachel = new Person("Rachel");
	Person ross = new Person("Ross");
	Person ben = new Person("Ben");
	Person kramer = new Person("Kramer");
	
	@Test(expected = AssertionError.class)
	public void testAssertionsEnabled() {
		assert false;
	}
	
	@Test
	public void testaddVertex(){
		Person[] ans = new Person[10000];
		graph.addVertex(rachel);
		ans[0]=rachel;
		assertArrayEquals(ans, graph.graphvertex);
		graph.addVertex(ross);
		ans[1]=ross;
		assertArrayEquals(ans, graph.graphvertex);
		graph.addVertex(ben);
		ans[2]=ben;
		assertArrayEquals(ans, graph.graphvertex);
		graph.addVertex(kramer);
		ans[3]=kramer;
		assertArrayEquals(ans, graph.graphvertex);
	}
	
//	@Test
//	public void addEdge() {
//		int[][]	ans = new int[10000][10000];
//		graph.addEdge(rachel, ross);
//		ans[0][1]=1;
//		assertArrayEquals(ans, graph.graphedge);
//		graph.addEdge(ross, rachel);
//		ans[1][0]=1;
//		assertArrayEquals(ans, graph.graphedge);
//		graph.addEdge(ross, ben);
//		ans[1][2]=1;
//		assertArrayEquals(ans, graph.graphedge);
//		graph.addEdge(ben, ross);
//		ans[2][1]=1;
//		assertArrayEquals(ans, graph.graphedge);
//	}
}
