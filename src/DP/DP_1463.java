package DP;

import java.util.Scanner;

public class DP_1463 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] cnt = new int[1000001];
//		===================================Ã³¸®
//		while (n != 1) {
//			if ((n - 1) % 3 == 0)
//				n--;
//			else if (n % 3 == 0)
//				n /= 3;
//			else if (n % 2 == 0)
//				n /= 2;
//			else n--;
//			System.out.println(n);
//			cnt++;
//		}
//		===================================DP
		cnt[1] = 0;
		for(int i = 2 ;i <= n ; i++) {
			cnt[i] = cnt[i-1]+1;
			
			if(i % 2 == 0) cnt[i] = Math.min(cnt[i], cnt[i/2] +1);
			if(i % 3 == 0) cnt[i] = Math.min(cnt[i], cnt[i/3] +1);
		}
		
//		===================================
//		System.out.println(cnt);
//		===================================
		System.out.println(cnt[n]);
		sc.close();
	}
}