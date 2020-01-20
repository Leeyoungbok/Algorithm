package Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Greedy_1931 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt();
		int ret = 1;
		int rem;
		int[][] room = new int[cnt][2];
		for (int i = 0; i < cnt; i++) {
			room[i][0] = sc.nextInt();
			room[i][1] = sc.nextInt();
		}
		Arrays.sort(room, new Comparator<int[]>() {
			@Override
			public int compare(int[] start, int[] end) {
				// start[0], end[0] 배열은 arr[][] 의 첫번째 라인(시작시간)이다.
				// start[1], end[0] 배열은 arr[][] 의 두번째 라인(종료시간)이다.
				if (start[1] == end[1]) {
					// 만약 비교하는 값의 종료시간이 같을 경우 시작시간으로 정렬한다.
					return Integer.compare(start[0], end[0]);
				}
				// 종료시간에 따라 정렬한다.
				return Integer.compare(start[1], end[1]);
			}

		});
//		for(int i = 0 ; i < cnt ; i++) {
//			System.out.println(room[i][0]+"++++"+room[i][1]);
//		}
		rem = room[0][1];
		for (int i = 1; i < cnt; i++) {
			if(rem <= room[i][0]) {
				rem = room[i][1];
				ret++;
			}
		}
		System.out.println(ret);
		sc.close();
	}
}
