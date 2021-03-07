package SW_Expert;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_범준이의제주도여행계획 {
	static int N, M, ans, startEnd;
	static int[][] map, enjoy;
	static boolean[] checked;
	static char[] place;
	static int[] res;
	static int[] ans2;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		for(int tc = 1 ; tc <= TC ; tc++) {
			N = sc.nextInt(); M = sc.nextInt();
			ans = 0;
			map = new int[N+1][N+1];
			enjoy = new int[N+1][2];
			checked = new boolean[N+1];
			place = new char[N+1];
			res = new int[N];
			ans2 = new int[N];
			for(int i = 1; i < N ; i++) {
				for(int j = i+1 ; j <= N ; j++) {
					int n1 = sc.nextInt();
					map[i][j] = map[j][i] = n1;
				}
			}
			
//			for(int i = 1 ; i <= N ; i++) {
//				for(int j = 1 ; j <= N ; j++) {
//					System.out.print(map[i][j] + " ");
//				}System.out.println();
//			}
			startEnd = -1;
			
			sc.nextLine();
			for(int i = 1 ; i <= N ; i++) {
				String[] str = sc.nextLine().split(" ");
				place[i] = str[0].charAt(0);
				if(place[i] == 'A') {
					startEnd = i;
					checked[i] = true;
				}
				if(str.length > 1) {
					enjoy[i][0] = Integer.parseInt(str[1]);
					enjoy[i][1] = Integer.parseInt(str[2]);
				}
			}
			solve(startEnd,0, 1, 0, 0, false);
			System.out.print("#" + tc + " " + ans);
			for(int i = 0 ; i < N ; i++) {
				if(ans2[i] == 0) break;
				if(ans2[i] == 1) {
					System.out.print(" " + 1);
					break;
				}
				System.out.print(" " + ans2[i]);
			}
			System.out.println();
		}
	}
	static void solve(int idx, int memoIdx, int day, int time, int happyCnt, boolean endCheck) {
		if(endCheck) {
			if(ans <= happyCnt) {
				ans = happyCnt;
				ans2 = res.clone();
			}
			return;
		}
		
		for(int i = 1 ; i <= N ; i++) {
			if(idx == i) continue;
			if(day == M) {
				if(place[i] == 'H') continue;
				if(i == startEnd) {
					if(time + map[idx][i] <= 540) {
						res[memoIdx] = i;
						solve(i, memoIdx+1,day, time, happyCnt, true);
					}
				}else if(!checked[i] && time + map[idx][i] + enjoy[i][0] <= 540){
					checked[i] = true;
					res[memoIdx] = i;
					solve(i, memoIdx+1, day, time + map[idx][i] + enjoy[i][0], happyCnt + enjoy[i][1], false);
					res[memoIdx] = 0;
					checked[i] = false;
				}
			}else if(day < M && !checked[i]) {
				if(place[i] == 'H' && time + map[idx][i] <= 540) {
					res[memoIdx] = i;
					solve(i, memoIdx+1, day+1, 0, happyCnt, false);
					res[memoIdx] = 0;
				}else if(time + map[idx][i] + enjoy[i][0] <= 540) {
					checked[i] = true;
					res[memoIdx] = i;
					solve(i, memoIdx+1, day, time + map[idx][i] + enjoy[i][0], happyCnt + enjoy[i][1], false);
					res[memoIdx] = 0;
					checked[i] = false;
				}
			}
		}
	}
}
