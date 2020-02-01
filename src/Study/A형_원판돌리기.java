package Study;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class A형_원판돌리기 {
	static int N;
	static int M;
	static int T;

	static class param {
		int x;
		int y;

		param(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // N 번째 원판
		M = sc.nextInt(); // M 개의 수
		T = sc.nextInt(); // T 번 회전

		int[][] circle = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				circle[i][j] = sc.nextInt();
			}
		}

		int x_i = 0; // x_i 배수의 원판을
		int d_i = 0; // d_i 방향으로(0은 시계, 1은 반시계)
		int k_i = 0; // k_i 칸 이동한다.

		for (int i = 0; i < T; i++) {
			x_i = sc.nextInt();
			d_i = sc.nextInt();
			k_i = sc.nextInt();

			swap(circle, x_i, d_i, k_i);
			boolean check = removeNum(circle);
			if (!check)
				getAverage(circle);
			
		}
		System.out.println(getSum(circle));

	}

	static void swap(int[][] circle, int x_i, int d_i, int k_i) {
//		원판을 아래와 같은 방법으로 총 T번 회전시키려고 한다. 원판의 회전 방법은 미리 정해져 있고, i번째 회전할때 사용하는 변수는 xi, di, ki이다.
//
//		번호가 xi의 배수인 원판을 di방향으로 ki칸 회전시킨다. di가 0인 경우는 시계 방향, 1인 경우는 반시계 방향이다.
//		인접하면서 수가 같은 것을 모두 찾는다.
//		그러한 수가 있는 경우에는 원판에서 인접하면서 같은 수를 모두 지운다.
//		없는 경우에는 원판에 적힌 수의 평균을 구하고, 평균보다 큰 수에서 1을 빼고, 작은 수에는 1을 더한다.
		for (int i = 0; i < N; i++) {
			if (i == 0)
				continue;
			if ((i + 1) % x_i != 0)
				continue;
			for (int j = 0; j < k_i; j++) {
				int tmp;
				if (d_i == 0) { // 시계
					tmp = circle[i][M - 1];
					for (int k = M - 1; k > 0; k--) {
						circle[i][k] = circle[i][k - 1];
					}
					circle[i][0] = tmp;
				} else { // 반시계
					tmp = circle[i][0];
					for (int k = 0; k < M - 1; k++) {
						circle[i][k] = circle[i][k + 1];
					}
					circle[i][M - 1] = tmp;
				}
			}
		}
	}

	static boolean removeNum(int[][] circle) {
//		(i, 1)은 (i, 2), (i, M)과 인접하다.
//		(i, M)은 (i, M-1), (i, 1)과 인접하다.
//		(i, j)는 (i, j-1), (i, j+1)과 인접하다. (2 ≤ j ≤ M-1)
//		(1, j)는 (2, j)와 인접하다.
//		(N, j)는 (N-1, j)와 인접하다.
//		(i, j)는 (i-1, j), (i+1, j)와 인접하다. (2 ≤ i ≤ N-1)
		boolean removeCheck = false;
		Queue<param> queue = new LinkedList<param>();
		int[] dx = { 0, 0, -1, 1 };
		int[] dy = { 1, -1, 0, 0 };
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (circle[i][j] != 0) {
					queue.add(new param(i, j));
					int num = circle[i][j];
					while (!queue.isEmpty()) {
						param p = queue.poll();
						int x = p.x;
						int y = p.y;
						for (int k = 0; k < 4; k++) {
							int ax = x + dx[k];
							int ay = y + dy[k];
							if(ay == -1) ay = M-1;
							if(ay == M) ay = 0;
							if(ax== -1 || ax == N || circle[ax][ay] == 0 ) continue;
							if(num == circle[ax][ay]) {
								circle[x][y] = 0;
								circle[ax][ay] = 0;
								removeCheck = true;
								queue.add(new param(ax,ay));
							}
						}
					}
				}
			}
		}

		return removeCheck;
	}

	static void getAverage(int[][] circle) {
		int sum = 0;
		double avg = 0;
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (circle[i][j] != 0) {
					sum += circle[i][j];
					cnt++;
				}

			}
		}
		avg = (double) sum / cnt;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (circle[i][j] == 0)
					continue;
				if (circle[i][j] < avg)
					circle[i][j]++;
				else if (circle[i][j] > avg)
					circle[i][j]--;
			}
		}
	}

	static int getSum(int[][] circle) {
		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sum += circle[i][j];
			}
		}
		return sum;
	}
}
//2 3 4 -1-1-1 
//5 6 3 4 -1 -1 
//-1 4 -1 -1 -1 -1
//-1 8 -1 -1 5 -1 

//2 3 4 -1 -1 -1 
//3 -1 -1 -1 5 6  
//-1 -1 -1 -1 -1 -1 
//-1 -1 5 -1 -1 8 

//2 3 4 -1 -1 -1 
//3 -1 -1 -1 5 6 
//-1 -1 -1 -1 -1 -1 
//-1 -1 5 -1 -1 8 