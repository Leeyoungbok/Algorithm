package SW_Expert;

import java.util.Arrays;
import java.util.Scanner;

public class D2_1984 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for(int tc = 1 ; tc <= TC ; tc++) {
			int[] input = new int[10];
			int total = 0;
			for(int i = 0 ; i < 10; i++) {
				input[i] = sc.nextInt();
			}
			
			Arrays.sort(input);
			for(int i = 1; i < 9;i++) {
				total += input[i];
			}
			System.out.println("#" + tc + " " + Math.round(total/8.0));
		}
		sc.close();
	}

}
