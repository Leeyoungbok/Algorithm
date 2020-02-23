package BFS;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

class DSLR {
	int n1;
	String oper;

	DSLR(int n1, String oper) {
		this.n1 = n1;
		this.oper = oper;
	}
}

public class BFS_9019 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Deque<DSLR> queue = new LinkedList<DSLR>();

		int TC = sc.nextInt();

		for (int tc = 0; tc < TC; tc++) {
			boolean[] used = new boolean[10010];
			int n1 = sc.nextInt();
			int input = sc.nextInt();
			used[n1] = true;

			String oper = "";
			
			queue.add(new DSLR(n1, oper));
			
			loop: while (!queue.isEmpty()) {
				int size = queue.size();
				
				for (int i = 0; i < size; i++) {
					
					DSLR dslr = queue.poll();
					if (dslr.n1 == input) {
						queue.clear();
						System.out.println(dslr.oper);
						break loop;
					}
					
					int n = D_Operation(dslr.n1);
					if(!used[n]) {
						queue.add(new DSLR(n, dslr.oper + "D"));
						used[n] = true;
					}
					n = S_Operation(dslr.n1);
					if(!used[n]) {
						queue.add(new DSLR(n, dslr.oper + "S"));
						used[n] = true;
					}
					n = L_Operation(dslr.n1);
					if(!used[n]) {
						queue.add(new DSLR(n, dslr.oper + "L"));
						used[n] = true;
					}
					n = R_Operation(dslr.n1);
					if(!used[n]) {
						queue.add(new DSLR(n, dslr.oper + "R"));
						used[n] = true;
					}
				}
			}
		}
		sc.close();
	}


	static int D_Operation(int n1) {
		return (n1 * 2) % 10000;
	}

	static int S_Operation(int n1) {
		int n = n1 - 1;
		n = n == -1 ? 9999 : n;
		return n;
	}

	static int L_Operation(int n1) {
		int n = n1 * 10;
		if(n >= 10000) {
			int a = n % 10000;
			a += n/10000;
			return a;
		}
		return n;
	}

	static int R_Operation(int n1) {
		int n = n1 / 10;
		n += (n1 % 10) * 1000;
		return n;
	}

}
