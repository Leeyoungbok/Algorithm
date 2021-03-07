package Competition;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class kyeonginProb1 {
	static int N, T, P, answer = 0, cnt = 0;
	static int[] table;
	static int[][] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		T = sc.nextInt();
		P = sc.nextInt();

		table = new int[N + 1];
		arr = new int[T][2];

		for (int t = 0; t < T; t++) {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			int startTime = (n1 / 100) * 60 + (n1 % 100);
			int endTime = (n2 / 100) * 60 + (n2 % 100);

			arr[t][0] = startTime;
			arr[t][1] = endTime;
		}

		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] t1, int[] t2) {
				if (t1[0] > t2[0])
					return 1;
				else if (t1[0] < t2[0])
					return -1;
				else
					return t1[1] - t2[1];
			}
		});
		
		for(int i = 0 ; i < T ; i ++) {
			System.out.println(arr[i][0] + "  " + arr[i][1]);
		}
		int idx = 0;
		for (int i = 540; i < 1260; i++) {

			if (cnt != 0) {
				for (int j = 1; j <= N; j++) {
					if (table[j] == i) { // 빼줌
						table[j] = 0;
						cnt--;
					}
				}
			}

			while (idx < T && arr[idx][0] == i) {
				if(cnt == 0) {
					table[1] = arr[idx][1];
				}else {
					int left = 1;
					int right = 1;
					int dist = 0;
					int tmp = -1;
					int max = 0;

					if(table[1] != 0 && table[N] == 0) {
						int n1 = 0;
						for(int j = N-1 ; j >= 1 ; j--) {
							if(table[j] != 0) {
								
							}
							
							max++;
						}
						tmp = N;
					}
					if(table[N] != 0 && table[1] == 0) {
						for(int j = 1 ; j <= N ; j++) {
							
						}
					}
					for(int j = 2 ; j <= N ; j++) {
//						if(i == 1244) {
//							System.out.println(j + " " + "left : " + left + " right " + right + " tmp " + tmp + " dist " + dist);
//						}
						if(table[j] == 0) {
							right++;
							dist++;
						}else if(table[j] != 0){
							right++;
							dist++;
							if(max < dist) {
								tmp = (left + right) / 2;
								max = dist;
							}
							left = j;
							right = j;
							dist = 0;
						}
					}
//					if(i == 1244) {
//						System.out.println(tmp);
//					}
					if(tmp != -1) {
						table[tmp] = arr[idx][1];
					}
				}
				idx++;
				cnt++;
			}
			
			if (table[P] == 0) {
				System.out.print(i + " : ");
				for(int j = 1 ; j <= N ; j++) {
					System.out.print(table[j] + " ");
				}
				System.out.println();
				answer++;
			} else {
				System.out.print(i + " : ");
				for(int j = 1 ; j <= N ; j++) {
					System.out.print(table[j] + " ");
				}
				System.out.println();
			}
		}

		System.out.println(answer);
	}

}

/*
 * 
 * 0900 : 60 * 9 + 뒤에꺼 : 540 2100 : 60 * 21 + 뒤에꺼 : 1260 540
 * 
 * 5 6 1 0915 0930 0940 2040 0915 0920 2040 2050 2043 2047 2044 2046
 */

