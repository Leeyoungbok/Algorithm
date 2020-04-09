package DisjointSet;

import java.util.Arrays;

public class 상호배타집합_rank {
	static int[] parents;
	static int[] rank; // rank는 트리의 높이이기때문에.
	public static void main(String[] args) {
		// 0 0 0 0 0 0
		parents = new int[6];
		rank = new int[6];
		
		for(int i = 0; i < parents.length; i++)
			makeSet(i);
		//makeSet을 통해 자신의 부모가 자기자신으로 지정됨.
		//0 1 2 3 4 5
		System.out.println(Arrays.toString(parents));
		
		//1이 속한 집합의 대표자를 0이 속한 집합의 대표자로 변경.
		union(0, 1);
		//0 0 2 3 4 5
		System.out.println(Arrays.toString(parents));
		union(2, 3);
		//0 0 2 2 4 5
		System.out.println(Arrays.toString(parents));
		union(0, 3);
		//0 0 0 2 4 5
		System.out.println(Arrays.toString(parents));
		union(4, 5);
		//0 0 0 2 4 4
		System.out.println(Arrays.toString(parents));
		union(2, 4);
		//0 0 0 2 0 4
		System.out.println(Arrays.toString(parents));
	}
	
	static void makeSet(int x) {
		parents[x] = x;
	}
	static int findSet(int x) {
		
		if( x == parents[x] )
			return x;
		else {
			parents[x] = findSet(parents[x]);
			return parents[x];
		}
	}
	static void union(int x, int y) {
		//findSet은 해당 원소가 속한 집합의 대표자를 찾아줍니다.
		int px = findSet(x); //x가 속한 집합의 대표자.
		int py = findSet(y); //y가 속한 집합의 대표자.
		
		
//		parents[py] = px;
		if( rank[px] > rank[py] ) {
			parents[py] = px;
		}
		else {
			parents[px] = py;
			if( rank[px] == rank[py] )
				rank[py]++;
		}
	}
}