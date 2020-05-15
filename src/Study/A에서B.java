package Study;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

public class A에서B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		Set<Integer> set = new HashSet<>();
		int cnt = 1;
		set.add(a);
		
		Deque<Integer> queue = new LinkedList<>();
		
		queue.add(a);
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			cnt++;
			for(int s = 0 ; s < size ; s++) {
				int n1 = queue.poll();
				
				if(n1*2 <= b && !set.contains(n1*2)) {
					if(n1*2 == b) {
						System.out.println(cnt);
						return;
					}
					queue.add(n1*2);
					set.add(n1*2);
				}
				
				if(n1*10+1 <= b && !set.contains(n1*10+1)) {
					if(n1*10+1 == b) {
						System.out.println(cnt);
						return;
					}
					queue.add(n1*10+1);
					set.add(n1*10+1);
				}
				
			}
		}
		System.out.println(-1);
	}

}
