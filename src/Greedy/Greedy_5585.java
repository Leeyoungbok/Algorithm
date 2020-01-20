package Greedy;

import java.util.Scanner;

public class Greedy_5585 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int change = 0;
		int price = sc.nextInt();
		int nmg = 1000-price;
		
		if(nmg / 500 >=1) {
			change += nmg/500;
			nmg = nmg - 500*(nmg/500);	
		}
//		System.out.println(nmg);
		if(nmg / 100 >=1) {
			change += nmg/100;
			nmg = nmg - 100*(nmg/100);	
		}
		if(nmg / 50 >=1) {
			change += nmg/50;
			nmg = nmg - 50*(nmg/50);	
		}
		if(nmg / 10 >=1) {
			change += nmg/10;
			nmg = nmg - 10*(nmg/10);	
		}
		if(nmg / 5 >=1) {
			change += nmg/5;
			nmg = nmg - 5*(nmg/5);	
		}
		if(nmg / 1 >=1) {
			change += nmg/1;
			nmg = nmg - 1*(nmg/1);	
		}
		System.out.println(change);
		sc.close();
	}

}
