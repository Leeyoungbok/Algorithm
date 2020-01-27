package SW_Expert;

import java.util.Scanner;

public class D3_9280 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[] r = new int[n + 1];
			int[] w = new int[m + 1];
			int[] checkCar = new int[n + 1];
			int[] allCar = new int[2 * m + 1];
			int totalCount = 0;
			int rem = 0;
			for (int i = 1; i <= n; i++) {
				r[i] = sc.nextInt();
			}
			for (int i = 1; i <= m; i++) {
				w[i] = sc.nextInt();
			}
			for (int i = 1; i < (2 * m+1); i++) {
				allCar[i] = sc.nextInt();
			}
			for (int i = 1; i < (2 * m+1); i++) {
				boolean emptyCheck = false;
				if(allCar[i] > 0) {
					for(int j = 1; j < n+1 ; j++) {
						if(checkCar[j] == 0) {
							checkCar[j] = allCar[i];
							emptyCheck = true;
							totalCount += r[j] * w[allCar[i]]; 
							rem = i;
							break;
						}
					}
				}
				if(emptyCheck == false || allCar[i] < 0) {
					for(int j = 1; j < n+1 ; j++) {
						if(checkCar[j] == (allCar[i] * -1)) {
							checkCar[j] = 0;
							i = rem;
							break;
						}
					}
				}
			}
			System.out.println("#" + tc + " " + totalCount);
		}
		sc.close();

	}

}

