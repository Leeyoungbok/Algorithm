package Study;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_보호필름 {
	static int D,W,K,max,Ans;
	static boolean breakPoint;
	static int[][] map;
	static int[] res;
	static boolean[] type;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		for(int tc = 1 ; tc <= TC ; tc++) {
			D = sc.nextInt(); W = sc.nextInt(); K = sc.nextInt();
			breakPoint = false;
			Ans = 0;
			map = new int[D][W];
			type = new boolean[D];
			
			for(int i = 0 ; i < D ; i++) {
				for(int j = 0 ; j < W ; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			if(K == 1 || isTrue()) {
				System.out.println("#" + tc + " " + Ans);
			}else {
				for(max = 1 ; max < 20 ; max++) {
					res = new int[max];
					solve(0,0);
					if(breakPoint) {
						System.out.println("#" + tc + " " + Ans);
						break;
					}
				}
			}
		}
	}
	
	static void solve(int idx, int cnt) {
		if(breakPoint)
			return;
		if(cnt == max) {
			typeCheck(0);
			return;
		}else if(idx == D)
			return;
		
		res[cnt] = idx;
		solve(idx+1, cnt+1);
		solve(idx+1, cnt);
	}
	
	static boolean isTrue() {
		for(int j = 0 ; j < W ; j++) {
			int cnt = 1;
			boolean check = false;
			for(int i = 1 ; i < D ; i++) {
				if(map[i-1][j] == map[i][j]) {
					cnt++;
					if(cnt == K) {
						check = true;
						break;
					}
				}else
					cnt=1;
			}
			if(!check)
				return false;
		}
		return true;
	}
	
	static void typeCheck(int idx) {
		if(breakPoint)
			return;
		if(idx == res.length) {
			int[][] arr = new int[res.length][map[0].length]; 
			for(int i = 0 ; i < res.length; i++) {
				arr[i] = map[res[i]].clone();
				for (int j = 0; j < map[0].length; j++) {
					if(type[res[i]])
						map[res[i]][j] = 0;
					else
						map[res[i]][j] = 1;
				}
			}
			if(isTrue()) {
				breakPoint = true;
				Ans = res.length;
				return;
			}
			for(int i = 0 ; i < res.length ; i++) {
				map[res[i]] = arr[i].clone();
			}
			return;
		}
		
		type[res[idx]] = true;
		typeCheck(idx+1);
		type[res[idx]] = false;
		typeCheck(idx+1);
		
	}

}
