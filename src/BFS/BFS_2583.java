package BFS;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class square {
	int x;
	int y;

	square(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class BFS_2583 {
	static int[][] map;
	static boolean[][] used;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		Queue<square> queue = new LinkedList<square>();
		int M = sc.nextInt();
		int N = sc.nextInt();

		map = new int[M][N];
		used = new boolean[M][N];
		int K = sc.nextInt();

		for (int i = 0; i < K; i++) {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			int n3 = sc.nextInt();
			int n4 = sc.nextInt();

			for (int j = n2; j < n4; j++) {
				for (int k = n1; k < n3; k++) {
					map[j][k] = -1;
				}
			}
		}
		
//		for (int i = 0; i < M; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();

		int groupNum = 0;

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0) {
					queue.add(new square(i, j));
					groupNum++;
					map[i][j] = groupNum;
					while (!queue.isEmpty()) {
						square s = queue.poll();

						for (int k = 0; k < 4; k++) {
							int ax = s.x + dx[k];
							int ay = s.y + dy[k];
							if (ax < 0 || ax > M - 1 || ay < 0 || ay > N - 1 || map[ax][ay] == -1)
								continue;
							if (map[ax][ay] == 0) {
								map[ax][ay] = groupNum;
								queue.add(new square(ax, ay));
							}
						}
					}
				}
			}
		}
//		for (int i = 0; i < M; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		int[] ans = new int[groupNum + 1];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == -1)
					continue;
				ans[map[i][j]]++;
			}
		}
		Arrays.sort(ans);
		System.out.println(groupNum);
		for (int i = 1; i <= groupNum; i++) {
			System.out.print(ans[i] + " ");
		}
	}

}
