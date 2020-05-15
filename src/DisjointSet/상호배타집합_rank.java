package DisjointSet;

import java.util.Arrays;

public class 상호배타집합_rank {
	static int[] parents;
	static int[] rank; // rank�� Ʈ���� �����̱⶧����.
	public static void main(String[] args) {
		// 0 0 0 0 0 0
		parents = new int[6];
		rank = new int[6];
		
		for(int i = 0; i < parents.length; i++)
			makeSet(i);
		//makeSet�� ���� �ڽ��� �θ� �ڱ��ڽ����� ������.
		//0 1 2 3 4 5
		System.out.println(Arrays.toString(parents));
		
		//1�� ���� ������ ��ǥ�ڸ� 0�� ���� ������ ��ǥ�ڷ� ����.
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
		//findSet�� �ش� ���Ұ� ���� ������ ��ǥ�ڸ� ã���ݴϴ�.
		int px = findSet(x); //x�� ���� ������ ��ǥ��.
		int py = findSet(y); //y�� ���� ������ ��ǥ��.
		
		
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