package Greedy;

import java.util.Scanner;

public class Greedy_2875 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int woman = sc.nextInt();
		int man = sc.nextInt();
		int intern = sc.nextInt();
		int ret = 0;

		while (intern != 0) {
			if (woman > man * 2)
				woman--;
			else // if(woman/2 < man-1)
				man--;
			intern--;
		}
		while (woman >= 2 && man > 0) {
			woman -= 2;
			man -= 1;
			ret++;
		}

		System.out.println(ret);
		sc.close();
	}

}
