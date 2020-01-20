package Greedy;

import java.util.Scanner;

public class Greedy_1541 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		String[] strArr1 = input.split("\\-");
		int sum =  0;
		for(int i = 0 ; i < strArr1.length ; i++) {
			String[] strArr2 = strArr1[i].split("\\+");
			for(String str2 : strArr2) {
				if(i != 0) sum -= Integer.parseInt(str2);
				else sum+= Integer.parseInt(str2);
			}
		}
		System.out.println(sum);
		sc.close();
	}
}
