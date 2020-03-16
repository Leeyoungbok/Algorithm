package Study;

import java.util.Scanner;

public class 선발명단 {
	static int ans;
	static int[][] arr;
	static int[] res;
	static boolean[] used;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for(int tc = 0 ; tc < TC ; tc++) {
			ans = 0;
			arr = new int[11][11];
			res = new int[11];
			used = new boolean[11];
			for(int i = 0 ; i < 11 ; i++) {
				for(int j = 0 ; j < 11 ; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			solve(0, 0);
			System.out.println(ans);
		}
		sc.close();
	}
	
	static void solve(int idx, int score) {
		if(idx == 11) {
			ans = ans < score ? score : ans;
			return;
		}
		
//		if((10 - idx) * 100 + score <= ans)
//			return;
		
		for(int i = 0 ; i < 11 ; i++) {
			if(!used[i] && arr[idx][i] != 0) {
				used[i] = true;
				solve(idx+1, score+arr[idx][i]);
				used[i] = false;
			}
		}
		return;
	}
}
