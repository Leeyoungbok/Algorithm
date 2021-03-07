package SW_Expert;

import java.util.HashMap;
import java.util.Scanner;

public class SWEA_숫자만들기게임 {
	static int N, Ans;
	static HashMap<Integer, Integer> hash = new HashMap<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for(int tc = 1 ; tc <= TC ; tc++) {
			N = sc.nextInt();
			Ans = 0;
			solve(N, 0);
			System.out.println("#" + tc + " " + Ans);
		}
	}
	
	static void solve(int n, int cnt){
		if(n <= 9) {
			Ans = Ans < cnt ? cnt : Ans;
			return;
		}
		
		// 실행이 끝난다음에 memo 해주고 
		if(hash.containsKey(n)) {
			if(hash.get(n) > cnt)
				return;
		}
		
		hash.put(n, cnt);
		
		int n1 = (n+"").length();
		
		
		
		/*
		 * 5 자리에서 발생 가능한 경우의 수
		 * 1 1 1 1 1
		 * 2 1 1 1 
		 * 1 2 1 1
		 * 1 1 2 1
		 * 1 1 1 2
		 * 2 2 1 
		 * 2 1 2
		 * 1 2 2
		 * 3 1 1
		 * 1 3 1
		 * 1 1 3
		 * 4 1 
		 * 1 4
		 * 
		 * 4자리에서 발생 가능한 경우의 수 
		 * 1 1 1 1 
		 * 2 1 1 
		 * 1 2 1
		 * 1 1 2
		 * 2 2
		 * 3 1
		 * 1 3
		 * 
		 */
		for(int i = 1 ; i <= n1 ; i++) {
			
		}
		
		
		
		
		// memo -> hash.put(n, memoCnt -cnt);
	}

}
