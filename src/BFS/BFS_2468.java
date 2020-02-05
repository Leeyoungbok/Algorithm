package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class cityInfo{
	int x;
	int y;
	cityInfo(int x,int y){
		this.x = x;
		this.y = y;
	}
}
public class BFS_2468 {
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[][] city = new int[N + 1][N + 1];
		boolean[] height = new boolean[101];

		boolean[][] used;
		boolean[][] cityCheck;
		Queue<cityInfo> queue = new LinkedList<cityInfo>();
		
		
		int ans = 1;

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				city[i][j] = sc.nextInt();
				height[city[i][j]] = true;
			}
		}

		for (int height_i = 1; height_i < 101; height_i++) {
			if (!height[height_i])
				continue;
			
			cityCheck = new boolean[N + 1][N + 1];
			used = new boolean[N + 1][N + 1];
			int groupCnt = 0;

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (city[i][j] <= height_i)
						cityCheck[i][j] = true;
				}
			}

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (!cityCheck[i][j] && !used[i][j]) {
						queue.add(new cityInfo(i,j));
						groupCnt++;
						used[i][j] = true;
						while(!queue.isEmpty()) {
							cityInfo ci = queue.poll();
							for(int k = 0; k<4; k++) {
								int ax = ci.x + dx[k];
								int ay = ci.y + dy[k];
								
								if(ax < 1 || ax > N || ay < 1 || ay > N) continue;
								if(!cityCheck[ax][ay] && !used[ax][ay]) {
									queue.add(new cityInfo(ax,ay));
									used[ax][ay] = true;
								}
							}
						}
					}

				}
			}
			ans = Math.max(ans, groupCnt);
		}
		System.out.println(ans);
		sc.close();
	}


}
