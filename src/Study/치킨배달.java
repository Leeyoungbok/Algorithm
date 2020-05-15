package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 치킨배달 {
	static int N, M, ans = Integer.MAX_VALUE;
	static int[][] map;
	static ArrayList<Chicken> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N+1][N+1];
		
		for(int i = 1 ; i <= N ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 1 ; j <= N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					list.add(new Chicken(i, j, false));
				}
			}
		}
		solve(0, 0);
		System.out.println(ans);
		
	}
	static void solve(int idx, int n) {
		if(n == M) {
			int max = cal();
			ans = ans > max ? max : ans;
			return;
		}else if(idx == list.size())
			return;
		
		list.get(idx).used = true;
		solve(idx+1, n+1);
		list.get(idx).used = false;
		solve(idx+1, n);
		
	}
	
	static int cal() {
		int ret = 0;

		for(int i = 1 ; i <= N ; i++) {
			for(int j = 1 ; j <= N ; j++) {
				if(map[i][j] == 1) {
					int n1 = Integer.MAX_VALUE;
					for(Chicken c : list) {
						if(!c.used) continue;
						int n2 = Math.abs(i-c.x) + Math.abs(j-c.y);
						n1 = n1 > n2 ? n2 : n1;
					}
					ret += n1;
				}
			}
		}
		return ret;
	}
	
	static class Chicken{
		int x, y;
		boolean used;
		Chicken(int x, int y, boolean used){
			this.x = x;
			this.y = y;
			this.used = used;
		}
	}

}
