package Samsung;

import java.util.Scanner;

public class A형_게리맨더링2 {
	static int N, answer = Integer.MAX_VALUE;
	static int[][] map;
	static boolean[][] used;

	public static void main(String[] args) {
		// input
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		map = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		// solution
		for (int i = 1; i <= N - 2; i++) {
			for (int j = 2; j <= N - 1; j++) {
				if(i == 1 && (j == 1 || j == N)) continue;
				
				for(int k = 1 ; k < N ; k++) {
					for(int l = 1 ; l < N ; l++) {
						if(i + k + l > N) break;
						if(j + l > N) break;
						if(j - k < 1) break;
						
						int tmpRet = bfs(i, j, k, l); // k는 오른쪽, l은 왼쪽으로 경계 기준
						answer = answer < tmpRet ? answer : tmpRet;
					}
				}
			}
		}
		
		System.out.println(answer);
	}

	private static int bfs(int x, int y, int d1, int d2) {
		used = new boolean[N + 1][N + 1];
		int[] arr = new int[5];
		arr[0] = getAreaTypeOne(x, y, d1, d2);
		arr[1] = getAreaTypeTwo(x, y, d1, d2);
		arr[2] = getAreaTypeThree(x, y, d1, d2);
		arr[3] = getAreaTypeFour(x, y, d1, d2);
		arr[4] = getAreaTypeFive(x, y, d1, d2);
//		System.out.println("------------------");
//		System.out.println(x + " " + y + " " + d1 +  " " + d2 );
//		for(int i = 0 ; i < 5 ; i++) {
//			System.out.print(arr[i] + " ");
//		}
//		System.out.println();
		
//		for(int i = 1 ; i <= N ; i++) {
//			for(int j = 1 ; j <= N ; j++) {
//				System.out.print(used[i][j] + " ");
//			}System.out.println();
//		}
		
		int n1 = getMinAnswer(arr);
		return n1;
	}
	
	private static int getMinAnswer(int[] arr) { // max 값, min 값 구하고 다시 빼줌
		int min = Integer.MAX_VALUE;
		int max = 0;
		
		for(int i = 0 ; i < 5 ; i++) {
			min = min < arr[i] ? min : arr[i];
			max = max > arr[i] ? max : arr[i];
		}
		
		return max - min; 
	}
	
	private static int getAreaTypeOne(int x, int y, int d1, int d2) { // 1번 선거구 구하는것
		int ret = 0;
		int yIdx = y;
		
		for(int i = 1 ; i < x + d1 ; i++) {
			if(i >= x) yIdx--;
			for(int j = 1 ; j <= yIdx ; j++) {
				ret += map[i][j];
				used[i][j] = true;
			}
		}
		
		return ret;
	}
	private static int getAreaTypeTwo(int x, int y, int d1, int d2) {
		int ret = 0;
		int yIdx = y - d1 + d2;
		
		for(int i = N ; i >= x + d1; i--) {
			if(i < x + d1 + d2) yIdx--;
			for(int j = 1 ; j < yIdx ; j++) {
				ret += map[i][j];
				used[i][j] = true;
			}
		}
		
		return ret;
	}
	private static int getAreaTypeThree(int x, int y, int d1, int d2) {
		int ret = 0;
		int yIdx = y + 1;
		
		for(int i = 1 ; i <= x + d2 ; i++) {
			if(i > x) yIdx++;
			for(int j = N ; j >= yIdx ; j--) {
				ret += map[i][j];
				used[i][j] = true;
			}
		}
		
		return ret;
	}
	
	private static int getAreaTypeFour(int x, int y, int d1, int d2) {
		int ret = 0;
		int yIdx = y - d1 + d2;
		
		for(int i = N ; i > x + d2 ; i--) {
			if(i <= x + d1 + d2) yIdx++;
			for(int j = N ; j >= yIdx ; j--) {
				ret += map[i][j];
				used[i][j] = true;
			}
		}
		
		return ret;
	}
	private static int getAreaTypeFive(int x, int y, int d1, int d2) {
		int ret = 0;
		
		for(int i = 1 ; i <= N ; i++) {
			for(int j = 1 ; j <= N ; j++) {
				if(!used[i][j]) ret += map[i][j];
			}
		}
		
		return ret;
	}
}
