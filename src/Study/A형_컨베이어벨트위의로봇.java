package Study;

import java.util.ArrayList;
import java.util.Scanner;

public class A형_컨베이어벨트위의로봇 {
	static int N, K, tmpK;
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		arr = new int[2 * N];
		ArrayList<Belt> beltList = new ArrayList<>();
		for (int i = 0; i < 2 * N; i++) {
			beltList.add(new Belt(sc.nextInt(), false));
		}
		int ret = 1;
		while (true) {
			// 1번
			Belt belt = beltList.remove(2 * N - 1);
			beltList.add(0, belt);

//			for (int i = N - 1; i > 0; i--) {
//				beltList.get(i).isRobot = beltList.get(i - 1).isRobot;
//				beltList.get(i - 1).isRobot = false;
//			}
//			for(int i = 0 ; i < beltList.size() ; i++) {
//				System.out.print(beltList.get(i).isRobot +" ");
//			}
//			System.out.println();
			if(beltList.get(N - 1).isRobot)
				beltList.get(N - 1).isRobot = false;

			// 2번
			for (int i = N - 1; i > 0; i--) {
				if (!beltList.get(i).isRobot && beltList.get(i).cost > 0 && beltList.get(i - 1).isRobot) {
					beltList.get(i).isRobot = true;
					beltList.get(i).cost--;
					beltList.get(i - 1).isRobot = false;
				}
			}
			
			if(beltList.get(N - 1).isRobot)
				beltList.get(N - 1).isRobot = false;
			
			// 3번
			if (beltList.get(0).cost > 0) {
				beltList.get(0).cost--;
				beltList.get(0).isRobot = true;
			}
//			for(int i = 0 ; i < beltList.size() ; i++) {
//				System.out.print(beltList.get(i).isRobot +" ");
//			}
//			System.out.println();

			// 4번
			tmpK = 0;
			for (int i = 0; i < beltList.size(); i++) {
//				System.out.print(beltList.get(i).cost + " ");
				if (beltList.get(i).cost == 0)
					tmpK++;
			}
//			System.out.println();
			if (tmpK >= K) {
				System.out.println(ret);
				break;
			}
			ret++;
		}

	}

	static class Belt {
		int cost;
		boolean isRobot;

		public Belt(int cost, boolean isRobot) {
			this.cost = cost;
			this.isRobot = isRobot;
		}
	}

}
