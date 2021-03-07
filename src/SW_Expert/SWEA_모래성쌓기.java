package SW_Expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

class sand {
	int x;
	int y;

	sand(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class SWEA_모래성쌓기 {
	static int[][] map;
	static int N, M;
	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//		int TC = Integer.parseInt(br.readLine());

//		for (int tc = 1; tc <= TC; tc++) {
			Deque<sand> queue = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N + 1][M + 1];
			for (int i = 1; i <= N; i++) {
				String str = br.readLine();
				for (int j = 1; j <= M; j++) {
					char ch = str.charAt(j - 1);
					if (ch == '.') {
						map[i][j] = -1;
						queue.add(new sand(i, j));
					} else {
						map[i][j] = Integer.parseInt(ch + "");
					}
				}
			}

			int ans = 0;
//			System.out.print("#" + tc + " ");
			while (!queue.isEmpty()) {
				int size = queue.size();
				for (int i = 0; i < size; i++) {
					sand c = queue.poll();
					for (int k = 0; k < 8; k++) {
						int ax = c.x + dx[k];
						int ay = c.y + dy[k];

						if (ax < 1 || ax > N || ay < 1 || ay > M || map[ax][ay] == -1)
							continue;
						
						if (map[ax][ay] > 0) {
							map[ax][ay]--;
							if (map[ax][ay] == 0) {
								map[ax][ay] = -1;
								queue.add(new sand(ax, ay));
							}
						}
					}
				}
				ans++;
			}
			System.out.println(ans-1);
//		}
	}
}
