package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS_7576 {
	static class pos {
		int x, y;

		pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), m = sc.nextInt(), res = 0;
		int[][] box = new int[m][n];
		int[] dx = { 0, 0, 1, -1 };
		int[] dy = { 1, -1, 0, 0 };
		Queue<pos> queue = new LinkedList<pos>();

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				box[i][j] = sc.nextInt();
			}
		}
//		====================================queue start
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (box[i][j] == 1) {
					queue.add(new pos(i, j));
				}
			}
		}
//		======================================
		while (true) {
			int cnt = queue.size();
			while (cnt > 0) {
				pos p = queue.poll();
				for (int i = 0; i < dx.length; i++) {
					int ax = p.x + dx[i];
					int ay = p.y + dy[i];
					if (0 <= ax && ax < m && 0 <= ay && ay < n) {
						if (box[ax][ay] != -1 && box[ax][ay] != 1) {
							queue.add(new pos(ax, ay));
							box[ax][ay] = 1;
						}
					}
				}
				cnt--;
			}
			if (queue.isEmpty())
				break;
			res++;
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (box[i][j] == 0) {
					res = -1;
				}
			}
		}
		System.out.println(res);
		sc.close();
	}

}
//for(int i = 0 ; i < m; i++) {
//	for(int j = 0 ; j < n ; j++) {
//		System.out.print(box[i][j] + " "); 
//	}
//	System.out.println("");
//}
