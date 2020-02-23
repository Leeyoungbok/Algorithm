package BFS;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

class puzzle {
	int pu;
	int n;

	puzzle(int pu, int n) {
		this.pu = pu;
		this.n = n;
	}
}

public class BFS_1525 {
	static int[] map = new int[9];
	static boolean[] used = new boolean[87654322];
	static int[] d = { -3, -1, 1, 3 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Deque<puzzle> queue = new LinkedList<>();
		int n = 0;
		for (int i = 0; i < 9; i++) {
			map[i] = sc.nextInt();
			if (map[i] == 0)
				n = i;
		}
		int cnt = 0;
		
		queue.add(new puzzle(parseToInt2(map), n));
		used[parseToInt(map)] = true;
		boolean check01 = false;
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i = 0 ; i < size ; i++) {
				puzzle p = queue.poll();
				if(parseToInt(p.pu) == 12345678) {
					System.out.println(cnt);
					check01 = true;
					System.exit(0);
				}
				for(int k = 0 ; k < 4 ; k++) {
					int an = p.n + d[k];
					if(an < 0 || an > 8) continue;
					int[] mapCopy = copy(p.pu);
					
					swap(mapCopy, p.n, an);
					int copyNum = parseToInt(mapCopy);
					if(used[copyNum]) continue;
					used[copyNum] = true;
					queue.add(new puzzle(mapCopy, an));
				}
			}
			cnt++;
		}
		if(!check01)
			System.out.println(-1);
	}

	static int[] swap(int[] map, int n, int an) {
		int tmp = map[n];
		map[n] = map[an];
		map[an] = tmp;
		return map;
	}

	static int[] copy(int[] map) {
		int[] c = new int[9];
		for (int i = 0; i < 9; i++) {
			c[i] = map[i];
		}
		return c;
	}
	
	static int parseToInt(int[] map) {
		String str = "";
		for(int i = 0 ; i < map.length-1 ; i++) {
			str += map[i];
		}
		return Integer.parseInt(str);
	}

	static int parseToInt2(int[] map) {
		String str = "";
		for(int i = 0 ; i < map.length ; i++) {
			str += map[i];
		}
		return Integer.parseInt(str);
	}
}
