package Study;

import java.util.Arrays;
import java.util.Scanner;

public class AÇü_Ä³½½µðÆæ½º {
	static int N, M, D;
	static int[][] map;
	static int res[] = new int[5];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		D = sc.nextInt();
		
		map = new int[N+2][M+1]; // ¸Ç À­Ä­¿¡´Â 0 ³»·Á¿È
		
		
		solve(0, 0);
		sc.close();
	}
	
	static void solve(int idx, int k) {
		if(idx == 3) {
			System.out.println(Arrays.toString(res));
			return;
		}
		
		for(int i = k ; i < 5 ; i++) {
				res[i] = 1;
				solve(idx+1, i+1);
				res[i] = 0;
		}
	}

}
