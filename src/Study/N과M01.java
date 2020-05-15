package Study;


import java.util.Scanner;

public class N과M01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = i + 1;
		int[] res = new int[m];
		boolean[] check = new boolean[n];
		solve(arr, res, check, 0);
		sc.close();
	}

	static void solve(int[] arr, int[] res, boolean[] check, int idx) {
		if (idx == res.length) {
			for (int i = 0; i < res.length; i++)
				System.out.print(res[i] + " ");
			System.out.println();
			return;
		}
		
		for (int i = 0; i < arr.length; i++) {
			if (!check[i]) {
				res[idx] = arr[i];
				check[i] = true;
				solve(arr, res, check, idx + 1);
				check[i] = false;
			}
		}
	}
}
