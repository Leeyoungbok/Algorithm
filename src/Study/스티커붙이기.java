package Study;

import java.util.Scanner;

public class 스티커붙이기 {
	static int N, M, K, R, C;
	static int[] rMemo;
	static int[] cMemo;
	static int[][][] sticker;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		
		sticker = new int[K][][];
		rMemo = new int[K]; // r 크기 기록
		cMemo = new int[K]; // c 크기 기록
		for(int k = 0 ; k < K ; k++) {
			R = sc.nextInt();
			C = sc.nextInt();
			rMemo[k] = R;
			cMemo[k] = C;
			sticker[k] = new int[R][C];
			for(int r = 0 ; r < R ; r++) {
				for(int c = 0 ; c < C ; c++) {
					sticker[k][r][c] = sc.nextInt();
				}
			}
		}
		
		solve();
		
		
	}
	
	static void solve() {
		
	}

	static int[][] getSticker(int[][][] sticker, int r, int c){
		int[][] ret = new int[r][c];
		
		
		return ret;
	}
}
