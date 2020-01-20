package Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Greedy_10610 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextInt();
		long[] slice = new long[100001];
		int i = 0, total = 0;
		boolean check = false;
		while(n>0) {
			slice[i] = n%10;
			n/=10;
			i++;
		}
		for(int j = 0 ; j < i ; j++) {
			total += slice[j];
			if(slice[j] == 0) check = true;
		}
		if(total % 3 == 0 || check) {
			Arrays.sort(slice);
			for(int j = 100000 ; j >= 100001-i ; j--) {
				System.out.print(slice[j]);
			}
		}else System.out.println("-1");
		sc.close();
	}

}
