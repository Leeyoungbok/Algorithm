package Competition;

import java.util.ArrayList;
import java.util.Scanner;
// �Է� ����
// 2���� �迭 �ȿ� �ְ� �־. �ȵ�? ������. 
// �ȵ�? �׷� ������
// �̷��� 4�� �ݺ� ������ �Ǵ� ��������
// ��͸� ���� ��Ž�� ���� �ʿ䰡 ���� ����
public class BarkingDog_스티커붙이기 {
	static int N, M, K, ans = 0;
	static int[][] map;
	static int[] cnt;
	static boolean[] used;
	static ArrayList<int[][]> list = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		map = new int[N][M];
		cnt = new int[K];
		used = new boolean[K];
		
		for (int k = 0; k < K; k++) {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			int n3 = 0;
			int n4 = n1 < n2 ? n2 : n1;
			int[][] sample = new int[n4][n4];
			for (int i = 0; i < n1; i++) {
				for (int j = 0; j < n2; j++) {
					sample[i][j] = sc.nextInt();
					if (sample[i][j] == 1)
						n3++;
				}
			}
			cnt[k] = n3;
			for(int i = 0 ; i < 4 ; i++) {
				list.add(sample);
				sample = rotate(sample);
			}
		}
		for(int i = 0 ; i < N*N ; i++) {
			solve(0, i, 0);
		}
	}

	static void solve(int idx, int xy, int totalCnt) {
		if(idx == list.size()) {
			ans = ans < totalCnt ? totalCnt : ans;
			return;
		}
		
		if(xy == N*N) {
			solve(idx+1, 0, totalCnt);
		}
		
		int n1 = plus(idx, xy/N, xy%N, list.get(idx));
		if(n1 != 0) {
			solve((idx/K+1)*4, 0,  totalCnt+n1);
		}else if(n1 == 0) {
			solve(idx, xy+1, totalCnt);
		}
		
	}

	static int plus(int n1, int iStart, int jStart, int[][] copy) {
		boolean check = false;
		int iEnd = iStart + copy.length;
		int jEnd = jStart + copy[0].length;
		loop : for (int i = iStart; i < iEnd ; i++) {
			for (int j = jStart; j < jEnd ; j++) {
				if(copy[i][j] == 1 && map[i][j] == 0) {
					map[i][j] = 1;
				}else if(copy[i][j] == 1 && map[i][j] == 1) {
					check = true;
					break loop;
				}
			}
		}
		if(check) {
			for (int i = iStart; i < iEnd ; i++) {
				for (int j = jStart; j < jEnd ; j++) {
					if(copy[i][j] == 1 && map[i][j] == 1) {
						map[i][j] = 0;
					}else if(copy[i][j] == 1 && map[i][j] == 0) {
						return 0;
					}
				}
			}
		}
		return cnt[n1/K];
	}
	
	static void minus(int n1, int iStart, int jStart, int[][] copy) {
		int iEnd = iStart + copy.length;
		int jEnd = jStart + copy[0].length;
		for (int i = iStart; i < iEnd ; i++) {
			for (int j = jStart; j < jEnd ; j++) {
				if(copy[i][j] == 1 && map[i][j] == 1) 
					map[i][j] = 0;
			}
		}
	}

	static int[][] rotate(int[][] map) {
		int n1 = map.length;
		int[][] ret = new int[n1][n1];
		for (int i = 0; i < n1; i++) {
			for (int j = 0; j < n1; j++) {
				ret[i][j] = map[n1 - j -1][i];
			}
		}
		for(int ii = 0 ; ii < ret.length ; ii ++) {
			for(int jj = 0 ; jj < ret[0].length ; jj++) {
				System.out.print(ret[ii][jj] +" " );
			}System.out.println();
		}System.out.println();
		return ret;
	}
}
// 00 01 02 03 04		10 00 
// 10 11 12 13 14		
