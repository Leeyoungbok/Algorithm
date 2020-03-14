package NextPermu;

import java.util.Scanner;

public class NP_10972 {
	static int N;
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		nextPermu();
		sc.close();
	}

	static void nextPermu() {
		int idx = -1;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] < arr[i + 1])
				idx = i;
		}
		if(idx == -1) {
			System.out.println(idx);
			return;
		}
		
		for(int i = arr.length -1 ; i > idx ; i--) {
			if(arr[idx] < arr[i]) {
				int temp = arr[idx];
				arr[idx] = arr[i];
				arr[i] = temp;
				break;
			}
		}
		int idx2 = N-1;
		idx++;
		while(idx < idx2) {
			int temp = arr[idx];
			arr[idx] = arr[idx2];
			arr[idx2] = temp;
			idx++;
			idx2--;
		}
		
		for(int n1 : arr)
			System.out.print(n1 + " ");
	}
}
