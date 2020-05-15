package Study;

import java.util.ArrayList;
import java.util.Scanner;

public class A형_새로운게임2 {
	static int N, K;
	static int[][] Matrix;
	static int[][][] map;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		K = sc.nextInt();
		Matrix = new int[N + 1][N + 1];
		map = new int[N + 1][N + 1][K];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				Matrix[i][j] = sc.nextInt();
			}
		}

		ArrayList<Horse> list = new ArrayList<>();
		list.add(new Horse(0, 0, 0));
		for (int i = 0; i < K; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int dir = sc.nextInt() - 1;
			list.add(new Horse(x, y, dir)); // ����Ʈ���� �� horse �� ������ ������� / idx�� 1������ ������.
			map[x][y][0] = i + 1; // ���� ��ȣ�� 1���� ������.
		}
		
		int len = list.size();
		int ans = 0;
		while (ans < 1000) {
			ans++;
			for (int idx = 1; idx < len; idx++) {
				Horse h = list.get(idx);
				int x = h.x, y = h.y, dir = h.dir;
				int ax = x + dx[dir];
				int ay = y + dy[dir];
				if(ax < 1 || ax > N || ay < 1 || ay > N || Matrix[ax][ay] == 2) {
					if(dir == 0) { // �̵��ϰ� list�� �ִ� ���� �ٽ� ����������� !!!
						dir = 1;
					}else if(dir == 1) {
						dir = 0;
					}else if(dir == 2) {
						dir = 3;
					}else if(dir == 3) {
						dir = 2;
					}
					ax = x + dx[dir];
					ay = y + dy[dir];
					list.get(idx).dir = dir;
					if(ax < 1 || ax > N || ay < 1 || ay > N || Matrix[ax][ay] == 2) {
						continue;
					}
				}
				
				if(Matrix[ax][ay] == 0) {
					int afterIdx = 0;
					int beforeIdx = 0;
					for(int i = 0 ; i < K ; i++) { // �̵��� ĭ ���� ���� ��ġ ã�� 
						if(map[ax][ay][i] == 0) {
							afterIdx = i;
							break;
						}
					}
					for(int i = 0 ; i < K ; i++) {
						if(map[x][y][i] == idx) {
							beforeIdx = i;
							break;
						}
					}
					
					for(int i = afterIdx ; i < K ; i++) {
						if(map[x][y][beforeIdx] == 0) 
							break;
						map[ax][ay][i] = map[x][y][beforeIdx];
						list.get(map[x][y][beforeIdx]).x = ax;
						list.get(map[x][y][beforeIdx]).y = ay;
						map[x][y][beforeIdx++] = 0;
						if(i >= 3) {
//							System.out.println("���� 1");
							System.out.println(ans);
							return;
						}
					}
				}else if(Matrix[ax][ay] == 1) {
					int afterIdx = 0;
					int beforeIdx = 0;
					int[] memo = new int[K];
					int memoIdx = 0;
					for(int i = 0 ; i < K ; i++) { // �̵��� ĭ ���� ���� ��ġ ã�� 
						if(map[ax][ay][i] == 0) {
							afterIdx = i;
							break;
						}
					}
					for(int i = 0 ; i < K ; i++) {
						if(map[x][y][i] == idx) {
							beforeIdx = i;
							break;
						}
					}
					
					for(int i = beforeIdx ; i < K ;i++) {
						if(map[x][y][i] == 0) {
							memoIdx--;
							break;
						}
						memo[memoIdx++] = map[x][y][i];
						map[x][y][i] = 0;
					}
//					for(int n1 : memo) {
//						System.out.println(n1);
//					}
//					
					for(int i = afterIdx ; i < K ; i++) {
						if(memoIdx == -1) 
							break;
						list.get(memo[memoIdx]).x = ax;
						list.get(memo[memoIdx]).y = ay;
						map[ax][ay][i] = memo[memoIdx--];
						if(i >= 3) {
//							System.out.println("���� 2");
//							System.out.println(ax + " " + ay);
//							for(int n1 : map[ax][ay])
//								System.out.println(n1);
							System.out.println(ans);
							return;
						}
					}
				}
			}
//			System.out.println();
//			System.out.println(ans);
//			int a = 0;
//			for(Horse horse : list) {
//				System.out.println(a++ + " " +horse.x + " " + horse.y + " " + horse.dir);
//			}
		}
		System.out.println(-1);
	}

	static class Horse {
		int x, y, dir;

		Horse(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}
}
