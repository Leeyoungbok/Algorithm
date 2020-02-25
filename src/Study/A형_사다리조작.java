package Study;

import java.util.ArrayList;
import java.util.Scanner;

class game{
	int row;
	int start;
	int end;
	game(int row, int start, int end){
		this.row = row;
		this.start = start;
		this.end = end;
	}
}

public class A형_사다리조작 {
	static int N, M, H;
	static ArrayList<game> list = new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		H = sc.nextInt();
		
		for(int i = 0 ; i < M ; i++) {
			int row = sc.nextInt();
			int start = sc.nextInt();
			int end = start + 1;
			list.add(new game(row, start, end));
		}
		
		solve();
	}
	static void solve() {
		
	}

	static void gameStart() {
		
	}
}
