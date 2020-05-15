package Study;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class 줄세우기_ver2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] cnt = new int[N+1];
		int[] res = new int[N+1];
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		Deque<Integer> queue = new LinkedList<>();
		for(int i = 0 ; i <= N ; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i = 0 ; i < M ; i++) {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			cnt[n2]++;
			list.get(n1).add(n2);
		}
		
		for(int i = 1 ; i <= N ; i++) {
			if(cnt[i] == 0)
				queue.add(i);
		}
		for(int i = 1 ; i <= N ; i++) {
			if(queue.isEmpty()) return;
			
			res[i] = queue.poll();
			for(int n1 : list.get(res[i])) {
				cnt[n1]--;
				if(cnt[n1] == 0)
					queue.add(n1);
			}
			System.out.print(res[i] + " ");
		}
	}
}
