package Study;

import java.awt.Point;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class A형_스타트택시 {

	static class Move implements Comparable<Move> {
		int x, y, dist;

		Move(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}

		@Override
		public int compareTo(Move o) {
			if (this.dist < o.dist)
				return -1;
			else if (this.dist > o.dist)
				return 1;
			else {
				if (this.x < o.x)
					return -1;
				else if (this.x > o.x)
					return 1;
				else {
					if (this.y < o.y)
						return -1;
					else
						return 1;
				}
			}
		}
	}

	static int N, M, fuel, taxiX, taxiY;
	static boolean[][] map;
	static boolean[][] used;
	static int[][] startMap, endMap;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static PriorityQueue<Move> startQueue = new PriorityQueue<Move>();
	static Queue<Point> endQueue = new LinkedList<Point>();

	public static void main(String[] args) {
		init();
		bfs();
		System.out.println(-1);
	}

	static void init() {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		fuel = sc.nextInt();

		map = new boolean[N + 1][N + 1];
		used = new boolean[N + 1][N + 1];
		startMap = new int[N + 1][N + 1];
		endMap = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				int input = sc.nextInt();
				map[i][j] = input == 1 ? false : true;
			}
		}

		taxiX = sc.nextInt();
		taxiY = sc.nextInt();

		for (int i = 0; i < M; i++) {
			startMap[sc.nextInt()][sc.nextInt()] = i+1;
			endMap[sc.nextInt()][sc.nextInt()] = i+1;
		}
	}

	static void bfs() {
		startQueue.add(new Move(taxiX, taxiY, 0));
		
		while (!startQueue.isEmpty()) {
			int Size = startQueue.size();
			if(fuel < 0) {
				System.out.println(-1);
				System.exit(0);
			}
			for (int size = 0; size < Size; size++) {
				Move move = startQueue.poll();
				if (startMap[move.x][move.y] != 0) {
					// end를 찾아준다.
					used = new boolean[N+1][N+1];
					endQueue.add(new Point(move.x, move.y));
					used[move.x][move.y] = true;
					bfs2(startMap[move.x][move.y]);
					startMap[move.x][move.y] = 0;
					used = new boolean[N+1][N+1];
					fuel++;
//					startQueue.add(new Move())
					break;
				}

				for (int k = 0; k < 4; k++) {
					int ax = move.x + dx[k];
					int ay = move.y + dy[k];

					if (ax < 1 || ax > N || ay < 1 || ay > N)
						continue;
					if (!map[ax][ay] || used[ax][ay])
						continue;

					startQueue.add(new Move(ax, ay, move.dist + 1));
					used[ax][ay] = true;
				}

			}
			
			fuel--;

		}
	}
	
	static void bfs2(int num) {
		int cost = 0;
		bfs2 : while(!endQueue.isEmpty()) {
			int Size = endQueue.size();
			cost++;
			fuel--;
			if(fuel < 0) {
				System.out.println(-1);
				System.exit(0);
			}
			for(int size = 0 ; size < Size ; size++) {
				
				Point p = endQueue.poll();
				for(int k = 0 ; k < 4 ; k++) {
					int ax = p.x + dx[k];
					int ay = p.y + dy[k];
					if (ax < 1 || ax > N || ay < 1 || ay > N)
						continue;
					if (!map[ax][ay] || used[ax][ay])
						continue;
					
					if(endMap[ax][ay] == num) {
						fuel += cost * 2;
						M--;
						endQueue.clear();
						startQueue.clear();
						startQueue.add(new Move(ax, ay, 0));
						if(M == 0) {
							System.out.println(fuel);
							System.exit(0);
						}
						break bfs2;
					}
					
					endQueue.add(new Point(ax, ay));
					used[ax][ay] = true;
				}
			}
			
		}
		System.out.println(-1);
		System.exit(0);
	}

}
