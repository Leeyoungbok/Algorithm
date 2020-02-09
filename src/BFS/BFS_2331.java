package BFS;

import java.util.ArrayList;
import java.util.Scanner;

public class BFS_2331 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(A);
		int idx = 0;
		while (true) {
			int n1 = list.get(idx);
			int nextNum = 0;
			while (n1 != 0) {
				nextNum += Math.pow(n1 % 10, B);
				n1 /= 10;
			}

			if (list.contains(nextNum)) {
				System.out.println(list.indexOf(nextNum));
				break;
			}
			list.add(nextNum);
			idx++;
		}
		sc.close();
	}

}
