package Samsung;

import java.util.Scanner;

public class A형_사다리조작 {
	static int N, M, H;
	static boolean[][] line;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		N = sc.nextInt();
		M = sc.nextInt();
		H = sc.nextInt();
		
		line = new boolean[H + 1][N + 1]; // 사다리 2차원 배열
		
		for(int i = 0; i < M ; i++) {
			line[sc.nextInt()][sc.nextInt()] = true;
		}
		
		// input 
		
		if(search()) {
			System.out.println(0);
			System.exit(0);
		}else {
			for(int i = 1 ; i <= 3 ; i ++) {
				solution(1,0,i);
			}
		}
		System.out.println(-1);
	}
	
	private static void solution(int x, int cnt, int max) {
		if(cnt > max) return;

		if(cnt <= max) { 
			if(search()) {
				System.out.println(cnt);
				System.exit(0);
			}
		}
		
		for(int i = x ; i <= H ; i++) {
			for(int j = 1 ; j < N ; j++) {
				if(line[i][j]) continue;
				if((j - 1 == 0 || !line[i][j-1]) && (j + 1 == N || !line[i][j+1])) {
					line[i][j] = true;
					solution(i, cnt+1, max);
					line[i][j] = false;
				}
			}
		}
	}
	
	private static boolean search() {
		for(int i = 1 ; i <= N ; i++) {
			int tmp = i;
			for(int j = 1 ; j <= H ; j++) {
				if(tmp - 1 != 0 && line[j][tmp - 1]) {
					tmp --;
				}else if(tmp != N && line[j][tmp]) {
					tmp++;
				}
			}
			if(tmp != i)
				return false;
		}
		return true;
	}
}
