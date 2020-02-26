package Study;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class move {
	int x;
	int y;
	int prevShape;

	move(int x, int y, int prevShape) {
		this.x = x;
		this.y = y;
		this.prevShape = prevShape;
	}
}

public class A형_파이프옮기기1_BFS {
	static int[] dx = { 0, 0, 1, 1 };
	static int[] dy = { 0, 1, 1, 0 };
	static int[][] myRoom;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<move> queue = new LinkedList<move>();

		int N = sc.nextInt();
		myRoom = new int[N + 1][N + 1];
		int ans = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				myRoom[i][j] = sc.nextInt();
			}
		}
		// 1 -> ㅡ
		// 2 -> \
		// 3 -> |
		queue.add(new move(1, 2, 1));

		while (!queue.isEmpty()) {
			move m = queue.poll();
			if (m.x == N && m.y == N) {
				ans++;
				if(ans == 1000000)
					break;
				continue;
			}
			for (int i = 1; i < 4; i++) {
				if (m.prevShape == 1 && i == 3)
					continue;
				else if (m.prevShape == 3 && i == 1)
					continue;
				int ax = m.x + dx[i];
				int ay = m.y + dy[i];

				if (ax > N || ay > N || myRoom[ax][ay] == 1)
					continue;
				if (i == 2 && (myRoom[ax - 1][ay] == 1 || myRoom[ax][ay] == 1 || myRoom[ax][ay - 1] == 1))
					continue;
				queue.add(new move(ax, ay, i));
			}
		}
		System.out.println(ans);
		sc.close();

	}

}
