package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS_10451 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for(int tc = 1 ; tc<=TC ;tc++) {
			int N = sc.nextInt();
			int[] arr = new int[N+1];
			boolean[] arrCheck = new boolean[N+1];
			int groupCnt = 0;
			Queue<Integer> queue = new LinkedList<Integer>();
			for(int i = 1 ; i <= N ; i++) {
				arr[i] = sc.nextInt();
			}
			
			for(int i = 1 ; i <= N ; i++) {
				if(!arrCheck[i]) {
					queue.add(i);
					arrCheck[i] = true;
					groupCnt++;
					while(!queue.isEmpty()) {
						int a = queue.poll();
						if(!arrCheck[arr[a]]) {
							queue.add(arr[a]);
							arrCheck[arr[a]] = true;
						}
					}
				}
			}
			System.out.println(groupCnt);
			sc.close();
		}
	}

}
