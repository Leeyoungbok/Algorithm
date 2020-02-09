package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class paramFriend {
	int i;
	int cnt;

	paramFriend(int i, int cnt) {
		this.i = i;
		this.cnt = cnt;
	}
}

public class BFS_1389 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<paramFriend> queue = new LinkedList<paramFriend>();
		int N = sc.nextInt();
		int M = sc.nextInt();

		boolean[][] friends = new boolean[N + 1][N + 1];
		int[][] gameCnt = new int[N + 1][N + 1];
		for (int i = 0; i < M; i++) {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();

			friends[n1][n2] = friends[n2][n1] = true;
		}

		for (int i = 1; i <= N; i++) {
			boolean[] used = new boolean[N + 1];
			queue.add(new paramFriend(i, 0));
			while (!queue.isEmpty()) {
				paramFriend p = queue.poll();
				used[p.i] = true;
				for(int j = 1 ; j <= N ; j++) {
					if(i == j || used[j]) continue;
					if(!friends[p.i][j]) continue;
					if(gameCnt[i][j] == 0) {
						queue.add(new paramFriend(j,p.cnt+1));
						gameCnt[i][j] = p.cnt+1;
					}else if(gameCnt[i][j] > p.cnt+1) {
						queue.add(new paramFriend(j,p.cnt+1));
						gameCnt[i][j] = p.cnt+1;
					}
				}
			}
		}
		int min = 6000;
		int ans = 101;
		for (int i = N; i > 0; i--) {
			int sum = 0;
			for (int j = N; j > 0; j--) {
				sum += gameCnt[i][j];
			}
			if(min >= sum) {
				min = sum;
				ans = i;
			}
		}
		System.out.println(ans);
		sc.close();
	}

}
