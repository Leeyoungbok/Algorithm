package Competition;

import java.util.Arrays;
import java.util.Scanner;

public class Hongik2019_나의학점은 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[50];
		
		for(int i = 0 ; i < 50 ; i ++) {
			arr[i] = sc.nextInt();
		}
		int n1 = sc.nextInt();
		
		int cnt = 1;
		
		for(int i = 1 ; i <= 50 ; i++) {
			if(n1 == arr[i-1]) {
				cnt = i;
				break;
			}
		}
		if(cnt <= 5) System.out.println("A+");
		else if(cnt <= 15) System.out.println("A0");
		else if(cnt <= 30) System.out.println("B+");
		else if(cnt <= 35) System.out.println("B0");
		else if(cnt <= 45) System.out.println("C+");
		else if(cnt <= 48) System.out.println("C0");
		else if(cnt <= 50) System.out.println("F");
	}
}
