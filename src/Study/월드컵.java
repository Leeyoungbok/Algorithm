package Study;

import java.util.Arrays;
import java.util.Scanner;

public class 월드컵 {
	static int[][] arr;
	static int[][] res;
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc = 0 ; tc < 4 ; tc++) {
			arr = new int[6][3];
			res = new int[6][3];
			ans = 0;
			for(int i = 0 ; i < 6 ; i++) {
				arr[i][0] = sc.nextInt();
				arr[i][1] = sc.nextInt();
				arr[i][2] = sc.nextInt();
			}
			
			solve(0, 1); // ����, ���, ī��Ʈ
			System.out.println(ans);
		}
	}
	
	static void solve(int idx, int idx2) {
		if(ans == 1)
			return;

		if(idx2%6 == 0) {
			idx++;
			idx2 = idx+1;
		}
		
		if(idx == 5 && idx2 == 6) {
//			if(res[0][0] == 0) {
				
//			}
			for(int i = 0 ; i < 6 ; i++) {
				for(int j = 0 ; j < 3 ; j++) {
					if(arr[i][j] != res[i][j])
						return;
				}
			}
//			System.out.print(Arrays.toString(res[0])+" ");
//			System.out.print(Arrays.toString(res[1])+" ");
//			System.out.print(Arrays.toString(res[2])+" ");
//			System.out.print(Arrays.toString(res[3])+" ");
//			System.out.print(Arrays.toString(res[4])+" ");
//			System.out.println(Arrays.toString(res[5]));
			ans = 1;
			return;
		}
		
		res[idx][0]++;
		res[idx2][2]++;
		solve(idx, idx2+1);
		res[idx][0]--;
		res[idx2][2]--;
		
		res[idx][1]++;
		res[idx2][1]++;
		solve(idx, idx2+1);
		res[idx][1]--;
		res[idx2][1]--;
		
		res[idx][2]++;
		res[idx2][0]++;
		solve(idx, idx2+1);
		res[idx][2]--;
		res[idx2][0]--;
		
	}

}
