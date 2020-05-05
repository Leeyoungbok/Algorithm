package Study;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class 탈옥 {
	static int N, M;
	static char[][] map;
	static int[][] cntMap,cntMap2;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();

		for (int tc = 1; tc <= TC; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();

			map = new char[N + 1][M + 1];
//			cntMap = new int[N + 1][M + 1];
			cntMap2 = new int[N+1][M+1];
			int[] arr = new int[4];
			int idx = 0;
			Deque<Prison> queue = new LinkedList<>();

			for (int i = 1; i <= N; i++) {
				String str = sc.next();
				for (int j = 1; j <= M; j++) {
					map[i][j] = str.charAt(j - 1);
					if (map[i][j] == '$') {
						map[i][j] = '.';
						arr[idx++] = i;
						arr[idx++] = j;
					}
				}
			}
			HashMap<Integer, Integer> map1 = new HashMap<>();
			HashMap<Integer, Integer> map2 = new HashMap<>();
			int ans = 20000;
			for (int i = 0; i < 4; i += 2) {
				cntMap = new int[N + 1][M + 1];
				boolean[][][] used = new boolean[N + 1][M + 1][10001];
				queue.add(new Prison(arr[i], arr[i + 1], 0));
				used[arr[i]][arr[i + 1]][0] = true;
				while (!queue.isEmpty()) {
					// 첫번쨰꺼는 그냥 가장자리에 도착했을때 문 몇개 부시고왔는지만 기록함
					// 만약 두번째가 도착했는데 이게 0이야? 그럼 첫번째꺼 다시 확인하면서 최소값을 찾아줘야함.
					Prison p = queue.poll();
					System.out.println(i+ "번째 :  " +p.x + " " + p.y + " "  +p.cnt);
					if (p.x == 1 || p.x == N || p.y == 1 || p.y == M) {
						if (i == 0) {
							if(map1.containsKey(p.x*10 + p.y)) {
								if(map1.get(p.x*10 + p.y) > p.cnt) {
									map1.replace(p.x*10 + p.y, p.cnt);
								}
							}else {
								map1.put(p.x*10 + p.y, p.cnt);
							}
							continue;
						} else if (i == 2) {
							if(map2.containsKey(p.x*10 + p.y)) {
								if(map2.get(p.x*10 + p.y) > p.cnt) {
									map2.replace(p.x*10 + p.y, p.cnt);
								}
							}else {
								map2.put(p.x*10 + p.y, p.cnt);
							}
							continue;
						}
					}

					for (int k = 0; k < 4; k++) {
						int ax = p.x + dx[k];
						int ay = p.y + dy[k];

						if (ax < 1 || ax > N || ay < 1 || ay > M || map[ax][ay] == '*')
							continue;
						if (map[ax][ay] == '.' && !used[ax][ay][p.cnt]) {
							queue.add(new Prison(ax, ay, p.cnt));
							used[ax][ay][p.cnt] = true;
						} else if (map[ax][ay] == '#') {
//							if (i == 0) {
								if (cntMap[ax][ay] == 0 || p.cnt + 1 < cntMap[ax][ay]) {
									cntMap[ax][ay] = p.cnt + 1;
									queue.add(new Prison(ax, ay, p.cnt + 1));
								}
//							} else if (i == 2) {
//								if(cntMap[ax][ay] == 0 && cntMap2[ax][ay] == 0) {
//									cntMap2[ax][ay] = p.cnt + 1;
//									queue.add(new Prison(ax, ay, p.cnt + 1));
//								}else if(cntMap[ax][ay] != 0 && cntMap2[ax][ay] == 0) {
//									cntMap2[ax][ay] = p.cnt + cntMap[ax][ay];
//									queue.add(new Prison(ax, ay, p.cnt + cntMap[ax][ay]));
//								}else if(cntMap[ax][ay] == 0 && cntMap2[ax][ay] != 0) {
//									if(cntMap2[ax][ay] > p.cnt+1) {
//										cntMap2[ax][ay] = p.cnt + 1;
//										queue.add(new Prison(ax, ay, p.cnt + 1));
//									}
//								}else if(cntMap[ax][ay] == 0 && cntMap2[ax][ay] == 0) {
//									if(p.cnt + cntMap[ax][ay] < cntMap2[ax][ay]) {
//										cntMap2[ax][ay] = p.cnt + cntMap[ax][ay];
//										queue.add(new Prison(ax, ay, p.cnt + cntMap[ax][ay]));
//									}
//								}
								/*
								 * 1. 나도 안가봤고 전에도 안가봤음
								 * -> cntMap2 ++
								 * 2. 전엔 가봤고, 난 안가봤어
								 * -> cntMap2 = p.cnt + cntMap
								 * 3. 전에 안가봤고, 난 가봤어
								 * -> cntMap2 > p.cnt+1
								 * 4. 전에도 가봤고, 나도 가봤어
								 * -> p.cnt + cntMap[ax][ay] < cntMap2[ax][ay]
								 */
//							}
						}
					}
				}
			}
			for(int n1 : map1.keySet()) {
				for(int n2 : map2.keySet()) {
					if(n1 == n2) {
						ans = ans > map1.get(n1) ? map1.get(n1) : ans;
					}else {
						int a = map1.get(n1);
						int b = map2.get(n2);
						ans = ans > a+b ? a+b : ans;
					}
				}
			}
			System.out.println(ans);
		}
	}

	static class Prison {
		int x, y, cnt;

		Prison(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
}
