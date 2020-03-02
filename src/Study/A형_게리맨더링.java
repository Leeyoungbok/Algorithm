package Study;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class A형_게리맨더링 {
	static int N, cnt, ans = Integer.MAX_VALUE;
	static int[] arr;
	static boolean[] res;
	static boolean[][] map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		arr = new int[N+1];
		res = new boolean[N+1];
		map = new boolean[N+1][N+1];
		for(int i = 1 ; i <= N ; i++){
			arr[i] = sc.nextInt();
		}
		sc.nextLine();
		for(int i = 1 ; i <= N ; i++) {
			int cnt = sc.nextInt();
			if(cnt == 0)
				continue;
			for(int j = 0 ; j < cnt ; j++) {
				int n1 = sc.nextInt();
				map[i][n1] = map[n1][i] = true; 
			}
		}
		
		solve(1);
		if(ans == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(ans);
		sc.close();

	}
	
	static void solve(int idx) { // 경우의 수 - 반만 뽑아냄
		if(idx > N) {
			cnt++;
			if(cnt > Math.pow(2, N)/2)
				return;
			
			int min = bfs();
			ans = ans > min ? min : ans;
			
			return;
		}
		
		res[idx] = true;
		solve(idx+1);
		res[idx] = false;
		solve(idx+1);
		
	}
	
	static int bfs() {
		int[] memo = new int[2];
		memo[0] = memo[1] = 0;
		int idx = 0;
		int groupCnt = 0;
		boolean[] used = new boolean[N+1];
		Deque<Integer> queue = new LinkedList<>();	
		for(int i = 1 ; i <= N ; i++) {
			if(!used[i]) {
				groupCnt++;
				if(groupCnt == 3){
					return Integer.MAX_VALUE;
				}
				queue.add(i);
				used[i] = true;
				memo[idx] += arr[i];
				while(!queue.isEmpty()) {
					int n1 = queue.poll();
					for(int j = 1 ; j <= N ; j++) {
						if(used[j] || res[n1] != res[j] || !map[n1][j])
							continue;
						queue.add(j);
						used[j] = true;
						memo[idx] += arr[j];
					}
				}
				idx++;
			}
		}
		
		if(groupCnt == 1)
			return Integer.MAX_VALUE;
		return Math.abs(memo[0] - memo[1]);
	}
}

//for(int i = 1 ; i <= N ; i++) {
//	for(int j = 1 ; j <= N ; j++) {
//		System.out.print(map[i][j] + " ");
//	}System.out.println();
//}