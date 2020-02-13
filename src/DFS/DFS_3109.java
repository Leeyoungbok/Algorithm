package DFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//class pipe {
//	int x;
//	int y;
//
//	pipe(int x, int y) {
//		this.x = x;
//		this.y = y;
//	}
//}

public class DFS_3109 {
	static char[][] map;
	static int Row, Column;
//	static boolean[][] used;
	static int[] dx = { -1, 0, 1 };
	static int[] dy = { 1, 1, 1 };
	static int ans = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Row = sc.nextInt();
		Column = sc.nextInt();
		sc.nextLine();
		map = new char[Row + 1][Column + 1];
//		used = new boolean[Row + 1][Column + 1];
//		Queue<pipe> queue = new LinkedList<pipe>();
		for (int i = 1; i <= Row; i++) {
			String str = sc.nextLine();
			for (int j = 1; j <= Column; j++) {
				map[i][j] = str.charAt(j - 1);
			}
		}

		for (int i = 1; i <= Row; i++) {
			dfs(i,0);
		}
		System.out.println(ans);
	}
	static boolean dfs(int x, int y) {
		if(y == Column) {
			ans++;
			return true;
		}
		
		
		
		
		for(int i = 0 ; i < 3; i++) {
			int ax = x + dx[i];
			int ay = y + dy[i];
			if(ax > 0&&ax <= Row && map[ax][ay] == '.') {
				map[ax][ay] = 'x';
				if(dfs(ax,ay))
					return true;
			}
		}
		return false;
	}
}

//for(int i = 1 ; i <= Row ; i++) {
//	for(int j = 1 ; j<= Column ; j++) {
//		System.out.print(map[i][j]);
//	}
//	System.out.println();
//}

//11
//����� : 11 1������ : 12 2
//����� : 12 2������ : 11 3
//����� : 11 3������ : 10 4
//����� : 10 4������ : 9 5
//����� : 9 5������ : 8 6
//����� : 8 6������ : 7 7
//����� : 7 7������ : 6 8
//����� : 6 8������ : 5 9
//����� : 5 9������ : 4 10
//����� : 4 10������ : 3 11
//0
//
