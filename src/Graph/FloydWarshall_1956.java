package Graph;

import java.util.Scanner;

public class FloydWarshall_1956 {
	static int V, E, ans = Integer.MAX_VALUE;
	static int[][] map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		V = sc.nextInt();
		E = sc.nextInt();
		map = new int[V + 1][V + 1];
		
		for(int e = 0 ; e < E ; e++) {
			map[sc.nextInt()][sc.nextInt()] = sc.nextInt();
		}
		
		for (int k = 1; k <= V; k++) {
			for (int i = 1; i <= V; i++) {
				if(k == i) continue;
				for (int j = 1; j <= V; j++) {
					if(i==j) continue;
					if(map[i][k] == 0 || map[k][j] == 0) continue;
					map[i][j] = map[i][j] < map[i][k] + map[k][j] ? map[i][j] : map[i][k] + map[k][j];
				}
			}
		}
		
		for(int i = 1 ; i <= V ; i++) {
			for(int j = 1 ; j <= V ; j++) {
				if(map[i][j] == 0 || map[j][i] == 0) continue;
				int tmp = map[i][j] + map[j][i];
				ans = ans > tmp ? tmp : ans;
			}
		}
		
		if(ans == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(ans);
	}

}
