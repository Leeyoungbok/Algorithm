package DP;
/*
*7
*10 15
*18 11 15
*/
import java.util.Scanner;

public class DP_1932 {
	public static int solution(int[][] input, int n) {
		int ret = 0;
		
		for(int i = 1 ; i < n ; i++) {
			for(int j = 0 ; j <= i ; j++) {
				// 1. 0 또는 j == i 일때는 위에꺼 하나만 받음
				// 2. 중간에 있는거는 위에꺼. 위에꺼+1 두개 max 값 비교
				// 3. 최종값들 전부 비교해서 가장 큰 값 
				if(j == 0)
					input[i][j] += input[i-1][j];
				else if(j == i)
					input[i][j] += input[i-1][j-1];
				else
					input[i][j] += Math.max(input[i-1][j-1], input[i-1][j]);
				ret = Math.max(ret, input[i][j]);
			}
		}
		return ret;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] input = new int[n][n];
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j <= i ; j++) {
				input[i][j] = sc.nextInt();
			}
		}
		
		System.out.println(DP_1932.solution(input, n));
		sc.close();
	}

}

