package DisjointSet;

import java.util.Scanner;

public class 종교 {
	static int[] religion;
	static int cnt;
	static int N;
	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			
			N = sc.nextInt();
			cnt = N;
			int M = sc.nextInt();
			religion = new int[N+1];
			init();
			for(int i =0 ; i < M ; i++) {
				int n1 = sc.nextInt();
				int n2 = sc.nextInt();
				union(n1,n2);
			}
			System.out.println(cnt);
			sc.close();
	}
	
	static void init() {
		for(int i = 1 ; i <= N ; i++)
			religion[i] = i;
	}
	
	static int find(int n1) {
		if(religion[n1] == n1) {
			return n1;
		}
		
		int p = find(religion[n1]); // ���������� ��ǥ�� ã����,
		religion[n1]=p; // �ѹ� p�� �����س��� �ٽ� �� ��͸� �� �ٽ� ������ �ʵ���.
		return p;
	}
	
	static void union(int n1, int n2) {
		int a1 = find(n1);
		int a2 = find(n2);
		
		if(a1 != a2) {
			religion[a2] = a1;
			cnt--;
		}
	}
}
