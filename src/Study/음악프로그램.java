package Study;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class 음악프로그램 {
	static int N, M;
	static int[] arr;
	static ArrayList<int[]> list = new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N+1];
		for(int i = 0 ; i < M ; i++) {
			int n1 = sc.nextInt();
			int[] input = new int[n1];
			for(int j = 0 ; j < n1 ; j++) {
				input[j] = sc.nextInt();
			}
			list.add(input);
		}
		
		
		
		
	}

}
