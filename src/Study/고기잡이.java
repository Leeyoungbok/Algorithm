package Study;

import java.util.ArrayList;
import java.util.Scanner;

class fish{
	int x;
	int y;
	fish(int x, int y){
		this.x = x;
		this.y = y;
	}
}
public class 고기잡이 {
	static int N, I, M, ans;
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		I = sc.nextInt();
		M = sc.nextInt();
		
		map = new int[N+1][N+1];
		ArrayList<fish> list = new ArrayList<>();
		
		for(int i = 0 ; i < M ; i++) {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			list.add(new fish(n1, n2));
			map[n1][n2] = 1;
		}

		while(list.size() != 0) {
			fish f= list.remove(0);
			for(int k = 1 ; k < I/2 ; k++) {
				int cnt = 0;
				for(int i = 0; i <= k ; i++) {
					for(int j = 0 ; j <= I/2-k ; j++) {
						if((f.x + i) < 1 || (f.x + i) > N || (f.y + j) < 1 || (f.y + j) > N) continue;
						if(map[f.x + i][f.y + j] == 1) {
							cnt++;
						}
					}
				}
				ans = ans < cnt ? cnt : ans;
			}
		}
		System.out.println(ans);
		sc.close();
	}
}

