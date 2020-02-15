package BruteForce;

import java.util.Scanner;

public class BruteForce_14888 {
	static int N;
	static int[] arr;
	static int[] operatorCnt;
	static char[] operator = { '+', '-', '*', '/' };
	static char[] res;
	static long max=-1000000001;
	static long min=1000000000;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		arr = new int[N];
		operatorCnt = new int[4];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		if (N == 1)
			System.out.println(arr[0]);
		else {
			int cnt = 0;
			for (int i = 0; i < 4; i++) {
				operatorCnt[i] = sc.nextInt();
				cnt += operatorCnt[i];
			}
			res = new char[cnt];
			solve(0);
			System.out.println(max + " " + min);
			sc.close();
		}
	}

	static void solve(int idx) {
		if (idx == res.length) {
			long result = cal();
			min = min > result ? result : min;
			max = max < result ? result : max;
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (operatorCnt[i] != 0) {
				res[idx] = operator[i];
				operatorCnt[i]--;
				solve(idx + 1);
				operatorCnt[i]++;
			}
		}
	}

	static long cal() {
		int idx1 = 0;
		int idx2 = 0;
		long n1 = arr[idx1++];
		
		while(idx1 != N) {
			n1 = calculate(n1, arr[idx1++], res[idx2++]);
		}
		return n1;
	}

	static long calculate(long n1, long n2, char ch) {
		if (ch == '+')
			return n1 + n2;
		else if (ch == '-')
			return n1 - n2;
		else if (ch == '*')
			return n1 * n2;
		else
			return n1 / n2;

	}
}
