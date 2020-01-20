package Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Greedy_11399 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ret = 0;
		int save = 0;
		int[] time = new int[n];
		
		for(int i = 0 ; i < n ; i++) {
			time[i] = sc.nextInt();
		}
//		==================================== ют╥б
		Arrays.sort(time);
		for(int i = 0 ; i < time.length; i++) {
			save += time[i];
			ret += save; 
		}
		System.out.println(ret);
		sc.close();
	}
}

