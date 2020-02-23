package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class tree implements Comparable<tree> {
	int x;
	int y;
	int z;

	tree(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public int compareTo(tree o) {
		return this.z - o.z;
	}
}

public class A형_나무재테크 {

	static int N, M, K;
	static int[][] map;
	static int[][] copy;
	static ArrayList<tree> list = new ArrayList<tree>();
	static ArrayList<tree> deadList = new ArrayList<tree>();
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
			list.add(new tree(x,y,z));
		}
		while (k < K) {
			Collections.sort(list);
			spring();
			summer();
			fall();
			winter();
			k++;
		}
		System.out.println(list.size());

	}

	static void spring() {
		for (int i = 0; i < list.size(); i++) {
			if (map[list.get(i).x][list.get(i).y] >= list.get(i).z) {
				map[list.get(i).x][list.get(i).y] -= list.get(i).z;
				list.get(i).z += 1;
			} else {
				deadList.add(list.remove(i));
				i--;
			}
		}
	}

	static void summer() {
		while(!deadList.isEmpty()) {
			tree t = deadList.remove(0);
			map[t.x][t.y] += t.z / 2;
		}
	}

	static void fall() {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).z % 5 == 0) {
				tree t = list.get(i);
				for (int k = 0; k < 8; k++) {
					int ax = t.x + dx[k];
					int ay = t.y + dy[k];

					if (ax < 1 || ax > N || ay < 1 || ay > N)
						continue;
					list.add(new tree(ax, ay, 1));
				}
			}
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
