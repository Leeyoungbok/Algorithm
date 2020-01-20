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
				// start[0], end[0] �迭�� arr[][] �� ù��° ����(���۽ð�)�̴�.
				// start[1], end[0] �迭�� arr[][] �� �ι�° ����(����ð�)�̴�.
				if (start[1] == end[1]) {
					// ���� ���ϴ� ���� ����ð��� ���� ��� ���۽ð����� �����Ѵ�.
					return Integer.compare(start[0], end[0]);
				}
				// ����ð��� ���� �����Ѵ�.
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
