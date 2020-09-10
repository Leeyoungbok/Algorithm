package Study;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 쉬운최단거리 {
	static int N, M;
	   static int[][] map;
	   static boolean[][] used;

	   static int[] dx = { 0, -1, 0, 1 };
	   static int[] dy = { -1, 0, 1, 0 };

	   public static void main(String[] args) {
	      Scanner sc = new Scanner(System.in);

	      N = sc.nextInt();
	      M = sc.nextInt();

	      map = new int[N + 1][M + 1];
	      used = new boolean[N + 1][M + 1];
	      int endPointX = -1;
	      int endPointY = -1;
	      for (int i = 1; i <= N; i++) {
	         for (int j = 1; j <= M; j++) {
	            map[i][j] = sc.nextInt();
	            if (map[i][j] == 2) {
	               endPointX = i;
	               endPointY = j;
	               map[i][j] = 0;
	               used[endPointX][endPointY] = true;
	            }
	         }
	      }

	      Queue<Point> queue = new LinkedList<>();
	      queue.add(new Point(endPointX, endPointY));

	      int dist = 0;
	      while (!queue.isEmpty()) {
	         int size = queue.size();
	         dist++;
	         for (int s = 0; s < size; s++) {
	            Point p = queue.poll();
	            for (int k = 0; k < 4; k++) {
	               int ax = p.x + dx[k];
	               int ay = p.y + dy[k];

	               if (ax < 1 || ax > N || ay < 1 || ay > M || used[ax][ay])
	                  continue;
	               if (map[ax][ay] == 0)
	                  continue;

	               map[ax][ay] = dist;
	               used[ax][ay] = true;
	               queue.add(new Point(ax, ay));

	            }
	         }

	      }

	      for (int i = 1; i <= N; i++) {
	         for (int j = 1; j <= M; j++) {
	            if (map[i][j] != 0 && !used[i][j])
	               System.out.print(-1 + " ");
	            else
	               System.out.print(map[i][j] + " ");
	         }
	         System.out.println();
	      }
	   }

	}