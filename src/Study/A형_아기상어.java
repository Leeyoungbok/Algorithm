package Study;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

class shark implements Comparable<shark> {
	int x;
	int y;

	shark(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(shark o) {
		if (this.x > o.x)
			return 1;
		if (this.x < o.x)
			return -1;
		if (this.y > o.y)
			return 1;
		return 1;
	}
}

public class A형_아기상어 {
	static int N, ans, sharkSize;
	static int[] fish = new int[5000];
	static int[][] map;
	static boolean[][] used;
	static int[] dx = { -1, 0, 0, 1 };
	static int[] dy = { 0, -1, 1, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N + 1][N + 1];
		used = new boolean[N + 1][N + 1];
		sharkSize = 2;
		int cnt = 0;
		int sharkEatCnt = 0;
		boolean check = false;
		Deque<shark> queue = new LinkedList<>();
		ArrayList<shark> list = new ArrayList<>();

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 9) {
					map[i][j] = 0;
					queue.add(new shark(i, j));
					used[i][j] = true;
				}
				if (map[i][j] != 0 && map[i][j] != 9)
					fish[map[i][j]]++;
			}
		}
		
		
		while (!queue.isEmpty()) {

			int size = queue.size();
			cnt++;
			for (int i = 0; i < size; i++) {
				shark s = queue.poll();
				for (int k = 0; k < 4; k++) {
					int ax = s.x + dx[k];
					int ay = s.y + dy[k];

					if (ax < 1 || ax > N || ay < 1 || ay > N || map[ax][ay] > sharkSize || used[ax][ay])
						continue;
					if (map[ax][ay] != 0 && map[ax][ay] < sharkSize) {
						list.add(new shark(ax, ay));
					} else {
						queue.add(new shark(ax, ay));
						used[ax][ay] = true;
					}
				}
			}
			if (list.size() != 0) {
				check = true;
				Collections.sort(list);
				shark sh = list.remove(0);
				fish[map[sh.x][sh.y]]--;
				map[sh.x][sh.y] = 0; // 물고기가 있던 자리를 지워줌
				sharkEatCnt++;
				ans += cnt;
				cnt = 0;

				if (sharkEatCnt == sharkSize) {
					sharkEatCnt = 0;
					sharkSize++;
				}

				used = new boolean[N + 1][N + 1];
				queue.clear();
				list.clear();
				queue.add(new shark(sh.x, sh.y));
				used[sh.x][sh.y] = true;
			}
		}
		if(!check)
			System.out.println(0);
		else 
			System.out.println(ans);
		sc.close();
	}

	static boolean isContinue() {
		for (int i = 0; i < sharkSize; i++) {
			if (fish[i] != 0)
				return true;
		}
		return false;
	}
}
