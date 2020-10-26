package Competition;

import java.util.Arrays;

public class kakao2019Prob2 {
	static class A implements Comparable<A> {
		int n;
		double d;

		A(int n, double d) {
			this.n = n;
			this.d = d;
		}

		@Override
		public int compareTo(A o) {
			if (this.d < o.d)
				return 1;
			else if (this.d > o.d)
				return -1;
			else {
				return this.n - o.n;
			}
		}
	}

	public static void main(String[] args) {
		int[] a = { 2, 1, 2, 6, 2, 4, 3, 3 };
		int[] ans = solution(5, a);
		System.out.println(Arrays.toString(ans));
	}

	private static int[] solution(int N, int[] stages) {
		int[] answer = new int[N];
		int[] stage = new int[N + 2];
		int len = stages.length;
		for (int n1 : stages) {
			stage[n1]++;
		}

		A[] a = new A[N+1];
		for(int i = 0 ; i < N+1 ; i++) {
			a[i] = new A(0,0);
		}
		
		
		for (int i = 1; i < stage.length - 1; i++) {
			a[i].n = i;
//			System.out.println(stage[i] + " " + len);
//			System.out.println(stage[i] / (double)len);
			a[i].d = stage[i] / (double)len;
			
			len -= stage[i];
		}
		
		Arrays.sort(a);
		int idx = 0;
		for(int i = 0 ; i < N+1 ; i++) {
			if(a[i].n == 0) continue;
			answer[idx++] = a[i].n;
		}
		return answer;
	}

}
