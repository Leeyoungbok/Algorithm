package Study;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class 비드맨 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		List<Integer> list = new LinkedList<>();
		for(int i = 0 ; i < n ; i++) {
			list.add(sc.nextInt());
		}
		
		Collections.sort(list);
		long cnt = list.get(n - 1);
		for(int i = n - 2 ; i >= 0 ; i--) {
			cnt -= list.get(i);
			cnt = cnt < 0 ? cnt * (-1) : cnt;
		}
		System.out.println(cnt);
	}
}
