package SW_Expert;

import java.util.Scanner;

public class D3_6190 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			int max = -1;
			for (int n = 0; n < N; n++)
				arr[n] = sc.nextInt();
			for(int i=0;i<N;i++){
                for(int k=i+1;k<N;k++){
                    // 결과 값보다 큰 값만 단조 증가 수 체크하자
                    if(max<arr[i]*arr[k])
                        if(solve(arr[i]*arr[k]))
                            max = arr[i]*arr[k];
                }
            }
			System.out.println("#" + tc + " " + max);

		}
		sc.close();
	}

	static boolean solve(int n) {
		int t = n % 10;
		n /= 10;
		while (n != 0) {
			if (n % 10 > t)
				return false;
			t = n % 10;
			n /= 10;
		}
		return true;
	}

}
