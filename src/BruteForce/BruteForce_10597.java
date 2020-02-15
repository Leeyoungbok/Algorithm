package BruteForce;

import java.util.Scanner;

public class BruteForce_10597 {
	static int[] arr;
	static String str;
	static boolean[] check = new boolean[51];
	static int len;
	static int max_value;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		str = sc.next();
		len = str.length();
		if(len < 10){
	        max_value = len;
	    }else{
	        max_value = (len - 9) / 2 + 9;
	    }
		System.out.println(max_value);
		arr = new int[str.length()];

		solve(0, 0);
		sc.close();
	}

	static void solve(int idx, int n) {
		if (idx == max_value) {
			for (int i = 0; i < idx; i++) {
				if (arr[i] == 0)
					break;
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			System.exit(0);
		} else if( n == str.length())
			return;

		if ((n + 1) < str.length()) {
			if(Integer.parseInt(str.substring(n, n + 1)) == 0) return;
			int n2 = Integer.parseInt(str.substring(n, n + 2));
			if (n2 > 0 && n2 < 51 && !check[n2]) {
				arr[idx] = n2;
				check[n2] = true;
				solve(idx + 1, n + 2);
				check[n2] = false;
			}
		}
		int n1 = Integer.parseInt(str.substring(n, n + 1));
		if(n1 == 0) return;
		if (n1 < 51 && !check[n1]) {
			arr[idx] = n1;
			check[n1] = true;
			solve(idx + 1, n + 1);
			check[n1] = false;
		}
		return;

	}
}
