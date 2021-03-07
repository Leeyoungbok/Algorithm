package Samsung;

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

		N = sc.nextInt(); // N ��° ����
		M = sc.nextInt(); // M ���� ��
		T = sc.nextInt(); // T �� ȸ��

		int[][] circle = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				circle[i][j] = sc.nextInt();
			}
		}

		int x_i = 0; // x_i ����� ������
		int d_i = 0; // d_i ��������(0�� �ð�, 1�� �ݽð�)
		int k_i = 0; // k_i ĭ �̵��Ѵ�.

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
		sc.close();
	}

	static void swap(int[][] circle, int x_i, int d_i, int k_i) {
//		������ �Ʒ��� ���� ������� �� T�� ȸ����Ű���� �Ѵ�. ������ ȸ�� ����� �̸� ������ �ְ�, i��° ȸ���Ҷ� ����ϴ� ������ xi, di, ki�̴�.
//
//		��ȣ�� xi�� ����� ������ di�������� kiĭ ȸ����Ų��. di�� 0�� ���� �ð� ����, 1�� ���� �ݽð� �����̴�.
//		�����ϸ鼭 ���� ���� ���� ��� ã�´�.
//		�׷��� ���� �ִ� ��쿡�� ���ǿ��� �����ϸ鼭 ���� ���� ��� �����.
//		���� ��쿡�� ���ǿ� ���� ���� ����� ���ϰ�, ��պ��� ū ������ 1�� ����, ���� ������ 1�� ���Ѵ�.
		for (int i = 0; i < N; i++) {
			if (i == 0)
				continue;
			if ((i + 1) % x_i != 0)
				continue;
			for (int j = 0; j < k_i; j++) {
				int tmp;
				if (d_i == 0) { // �ð�
					tmp = circle[i][M - 1];
					for (int k = M - 1; k > 0; k--) {
						circle[i][k] = circle[i][k - 1];
					}
					circle[i][0] = tmp;
				} else { // �ݽð�
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
//		(i, 1)�� (i, 2), (i, M)�� �����ϴ�.
//		(i, M)�� (i, M-1), (i, 1)�� �����ϴ�.
//		(i, j)�� (i, j-1), (i, j+1)�� �����ϴ�. (2 �� j �� M-1)
//		(1, j)�� (2, j)�� �����ϴ�.
//		(N, j)�� (N-1, j)�� �����ϴ�.
//		(i, j)�� (i-1, j), (i+1, j)�� �����ϴ�. (2 �� i �� N-1)
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
							if (ay == -1)
								ay = M - 1;
							if (ay == M)
								ay = 0;
							if (ax == -1 || ax == N || circle[ax][ay] == 0)
								continue;
							if (num == circle[ax][ay]) {
								circle[x][y] = 0;
								circle[ax][ay] = 0;
								removeCheck = true;
								queue.add(new param(ax, ay));
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