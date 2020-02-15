package BruteForce;

import java.util.Scanner;

// N명이 참여하고 N은 무조건 짝수다
// 능력치는 각각 다르고 누구랑 팀하느냐에 따라 또 다르다.
public class BruteForce_14889 {
	static int[][] team;
	static boolean[] used;
	static int N;
	static int ans = -1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		team = new int[N + 1][N + 1];
		
		for(int i = 1 ; i <= N ; i++) {
			for(int j = 1 ; j <= N ; j++) {
				team[i][j] = sc.nextInt();
			}
		}
		used = new boolean[N + 1];

		solve(1, 1);
		System.out.println(ans);
		sc.close();
	}

	static void solve(int idx, int n) {
		if(idx == N/2 +1) {
			int teamA = 0;
			int teamB = 0;
			for(int i = 1 ; i <= N ; i++) {
				for(int j = 1 ; j <= N ; j++){
					if(used[i] && used[j]) 
						teamA += team[i][j];
					else if(!used[i] && !used[j])
						teamB += team[i][j];
				}	
			}
			
			int min = Math.abs(teamA - teamB);
			if(ans == -1)
				ans = min;
			else
				ans = ans > min ? min : ans;
			
			return;
		}else if(n == N+1)
			return;
		
		used[n] = true;
		solve(idx+1, n+1);
		used[n] = false;
		solve(idx, n+1);
	}

}
