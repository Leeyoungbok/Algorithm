package Study;

import java.util.Scanner;

public class A형_톱니바퀴 {
	static int[][] gear = new int[4][8];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 4; i++) {
			String str = sc.nextLine();
			for (int j = 0; j < 8; j++) {
				gear[i][j] = Integer.parseInt(str.charAt(j) + "");
			}
		}

		int N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			int n1 = sc.nextInt() - 1;
			int n2 = sc.nextInt();

			change(n1, n2);

		}

		int sum = 0;

		for (int i = 0; i < 4; i++) {
			if (gear[i][0] == 1) {
				sum += Math.pow(2, i);
			}
		}
		System.out.println(sum);
		sc.close();
	}

	static void foward(int n1) {
		int tmp = gear[n1][7];
		for (int i = 7; i > 0; i--) {
			gear[n1][i] = gear[n1][i - 1];
		}
		gear[n1][0] = tmp;
	}

	static void reverse(int n1) {
		int tmp = gear[n1][0];
		for (int i = 0; i < 7; i++) {
			gear[n1][i] = gear[n1][i + 1];
		}
		gear[n1][7] = tmp;
	}

	static void change(int n1, int n2) {
		int[] check = new int[4];
		check[n1] = n2;
		int left = n1-1;
		int right = n1+1;
		while(true) {
			if(left == -1 && right == 4)
				break;
			if(left > -1) {
				if(gear[left][2] != gear[left+1][6]) {
					if(check[left+1] == 1)
						check[left] = -1;
					else if(check[left+1] == -1)
						check[left] = 1;
					else 
						check[left] = 0;
				} else
					check[left] = 0;
				left--;
			}
			if(right < 4) {
				if(gear[right][6] != gear[right-1][2]) {
					if(check[right-1] == 1)
						check[right] = -1;
					else if(check[right-1] == -1)
						check[right] = 1;
					else 
						check[right] = 0;
				} else
					check[right] = 0;
				right++;
			}
		}
		
		for(int i =0 ; i < 4 ; i ++) {
			if(check[i] == 1)
				foward(i);
			else if(check[i] == -1)
				reverse(i);
		}
	}

}
