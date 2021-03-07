package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Tree implements Comparable<Tree> {
	int x;
	int y;
	int z;

	Tree(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public int compareTo(Tree o) {
		return this.z - o.z;
	}
}

public class A형_나무재테크 {

	static int N, M, K;
	static int[][] map;
	static int[][] copy;
	static PriorityQueue<Tree> list = new PriorityQueue<>();
	static PriorityQueue<Tree> aliveList = new PriorityQueue<>();
	static PriorityQueue<Tree> deadList = new PriorityQueue<>();
	static int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int k = 0;
		map = new int[N + 1][N + 1];
		copy = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				copy[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 1 ; i <= N ; i++) {
			for(int j =1 ; j <= N ; j++) {
				map[i][j] = 5;
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			list.add(new Tree(x,y,z));
		}
		while (k < K) {
			spring();
			summer();
			fall();
			winter();
			k++;
		}
		System.out.println(list.size());

	}

	static void spring() {
		while( ! list.isEmpty() ) {
			Tree tree = list.poll();
			//������ ��ġ�� ����� ����ϴٸ� ������ ���̸�ŭ ����� ���ְ� �����ѻ�ø��� alive ť�� ����
			if( tree.z <= map[tree.x][tree.y] ) {
				map[tree.x][tree.y] -= tree.z;
				tree.z++;
				aliveList.add(tree);
			}
			else
				deadList.add(tree);
		}
	}

	static void summer() {
		while(!deadList.isEmpty()) {
			Tree t = deadList.poll();
			map[t.x][t.y] += t.z / 2;
		}
	}

	static void fall() {
		while( !aliveList.isEmpty() ) {
			Tree tree = aliveList.poll();
			if( tree.z % 5 == 0 ) {
				for(int d = 0; d < 8; d++) {
					int nr = tree.x + dx[d];
					int nc = tree.y + dy[d];
					if( nr >= 1 && nc >= 1 && nr <= N && nc <= N)
						list.add(new Tree(nr, nc, 1));
				}
			}
			list.add(tree);
		}
	}

	static void winter() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] += copy[i][j];
			}
		}
	}
}
