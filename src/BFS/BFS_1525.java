package BFS;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

class puzzle {
	int n;
	int idx;

	puzzle(int n, int idx) {
		this.n = n;
		this.idx = idx;
	}
}

public class BFS_1525 {
	static int[] map = new int[9];
	static boolean[] used = new boolean[87654322];
	static int[] dx = { -3, -1, 1, 3 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Deque<puzzle> queue = new LinkedList<>();
		int idx = 0;
		int cnt = 0;
		boolean ansCheck = false;
		for (int i = 0; i < 9; i++) {
			map[i] = sc.nextInt();
			if (map[i] == 0)
				idx = i;
		}
		int n1 = parseToInt(map);
		queue.add(new puzzle(n1, idx));
		used[isUsed(n1)] = true;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			for(int i = 0 ; i < size ; i++) {
				puzzle p = queue.poll();
				
				if(isUsed(p.n) == 12345678) {
					ansCheck = true;
					System.out.println(cnt);
					System.exit(0);
				}
				
				for(int k = 0 ; k < 4 ; k++) {
					int ax = p.idx + dx[k];
					
					if(ax < 0 || ax > 8) continue;
					if((p.idx == 2 || p.idx == 5) && k == 2) continue;
					if((p.idx == 3 || p.idx == 6) && k == 1) continue;
					int swapNum = swap(p.n, p.idx, ax);
					if(used[isUsed(swapNum)]) continue;
					used[isUsed(swapNum)] = true;
					queue.add(new puzzle(swapNum, ax));
				}
				
			}
			cnt++;
		}
		if(!ansCheck)
			System.out.println(-1);
		sc.close();
	}
	
	
	static int parseToInt(int[] map) { // o 
		String str = "";
		for(int i = 0 ; i < map.length ; i++) {
			str += map[i];
		}
		return Integer.parseInt(str);
	}
	
	static int isUsed(int n1) {
		return n1 / 10;
	}
	
	static int swap(int n1, int prevIdx, int nextIdx) {
		int[] arr = new int[9];
		for(int i = 8 ; i >= 0 ; i--) {
			arr[i] = n1%10;
			n1 /= 10;
		}
		int tmp = arr[prevIdx];
		arr[prevIdx] = arr[nextIdx];
		arr[nextIdx] = tmp;
		int ret = 0;
		int mul = 1;
		for(int i = 8 ; i >= 0 ; i--) {
			ret += arr[i] * mul;
			mul *= 10;
		}
		return ret;
	}
}
