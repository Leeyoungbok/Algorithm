package Study;

import java.util.Scanner;

public class A형_배열돌리기4 {
	static int N, M, K, ans = Integer.MAX_VALUE;
	static int[] r, c, s, res;
	static boolean[] workOrder;
	static int[][] matrix;
	static int[][] matrixCopy;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		r = new int[K];
		c = new int[K];
		s = new int[K];
		res = new int[K];
		matrix = new int[N+1][M+1];
		matrixCopy = new int[N+1][M+1];
		workOrder = new boolean[K];
		for(int i = 1 ; i <= N ; i++) {
			for(int j = 1 ; j <= M ; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		
		for(int k = 0 ; k < K ; k++) {
			r[k] = sc.nextInt();
			c[k]= sc.nextInt();
			s[k] = sc.nextInt();
		}
		
		solve(0);
		System.out.println(ans);
		sc.close();
	}
	
	static void solve(int idx) {
		if(idx == K) {
//			System.out.println(Arrays.toString(res));
			copy();
			operation();
			getAnswer();
			return;
		}
		
		for(int i = 0 ; i < K ; i++) {
			if(!workOrder[i]) {
				res[idx] = i;
				workOrder[i] = true;
				solve(idx+1);
				workOrder[i] = false;
			}
		}
	}
	
	static void operation() {
		for(int k = 0 ; k < K ; k++) {
			int rowStart = r[res[k]]-s[res[k]];
			int rowEnd = r[res[k]]+s[res[k]];
			int columnStart = c[res[k]]-s[res[k]];
			int columnEnd = c[res[k]]+s[res[k]];
			
			while(rowEnd != rowStart) {
				int rightTop = matrixCopy[rowStart][columnEnd];
				int leftBottom = matrixCopy[rowEnd][columnStart];
				int rightBottom = matrixCopy[rowEnd][columnEnd];
				
				for(int j = columnEnd ; j > columnStart ; j-- ) {
					matrixCopy[rowStart][j] = matrixCopy[rowStart][j-1];
				}
				
				for(int i = rowEnd ; i > rowStart ; i--) {
					matrixCopy[i][columnEnd] = matrixCopy[i-1][columnEnd];
				}
				matrixCopy[rowStart+1][columnEnd] = rightTop;
				
				for(int j = columnStart ; j < columnEnd ; j++ ) {
					matrixCopy[rowEnd][j] = matrixCopy[rowEnd][j+1];
				}
				matrixCopy[rowEnd][columnEnd-1] = rightBottom;
				
				
				for(int i = rowStart ; i < rowEnd ; i++) {
					matrixCopy[i][columnStart] = matrixCopy[i+1][columnStart];
				}
				matrixCopy[rowEnd-1][columnStart] = leftBottom;
//				for(int i = 1 ; i <= N ; i++) {
//					for(int j = 1 ; j <= M ; j++) {
//						System.out.print(matrixCopy[i][j] + " ");
//					}
//					System.out.println();
//				}
//				System.out.println();
//				System.out.println();
				
				rowStart++;
				rowEnd--;
				columnStart++;
				columnEnd--;
			}
		}
	}
	
	static void copy() {
		for(int i = 1 ; i <= N ; i++) {
			for(int j = 1 ; j <= M ; j++) {
				matrixCopy[i][j] = matrix[i][j];
			}
		}
	}
	
	static void getAnswer() {
		for(int i = 1 ; i <= N ; i++) {
			int sum = 0;
			for(int j = 1 ; j <= M ; j++) {
				sum += matrixCopy[i][j];
			}
			ans = ans > sum ? sum : ans;
		}
	}
}
