package Samsung;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class array implements Comparable<array>{
	int num;
	int cnt;
	array(int num, int cnt){
		this.num = num;
		this.cnt = cnt;
	}
	@Override
	public int compareTo(array o) {
		if(this.cnt > o.cnt) return 1;
		if(this.cnt < o.cnt) return -1;
		if(this.num > o.num) return 1;
		else return -1;
	}
}
public class A형_이차원배열과연산{
	static int R, C, K, ans;
	static int rowCnt = 3;
	static int columnCnt = 3;
	static int[][] map = new int[101][101];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		R = sc.nextInt()-1;
		C = sc.nextInt()-1;
		K = sc.nextInt();
		
		for(int i = 0 ; i < 3 ; i++) {
			for(int j = 0 ; j < 3 ; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		//
		while(true) {
			if(map[R][C] == K) {
				System.out.println(ans);
				break;
			}
			
			if(ans == 100) {
				System.out.println(-1);
				break;
			}
			
			if(rowCnt >= columnCnt) {
				rOperation();
			}else
				cOperation();
			ans++;
		}
		//
		
		sc.close();
	}
	
	static void rOperation() {
		ArrayList<array> list01;
		int[] used;
		int ret = 0;
		
		for(int i = 0 ; i < rowCnt ; i++) {
			list01 = new ArrayList<>();
			used = new int[101];
			for(int j = 0 ; j < columnCnt+1 ; j++) {
				if(map[i][j] == 0) {
					if(j < columnCnt) continue;
					int maxIdx = j;
					int size = list01.size();
					for(int k = 0 ; k < size ; k++) {
						list01.get(k).cnt = used[list01.get(k).num];
					}
					Collections.sort(list01);
					int idx = 0;
					for(int ii = 0 ; ii < size ; ii++) {
						map[i][idx++] = list01.get(ii).num;
						map[i][idx++] = list01.get(ii).cnt; 
					}
					if(2*size < maxIdx) {
						for(int jj = 2*size; jj < maxIdx ; jj++) {
							map[i][jj] = 0;
						}
					}
					//�������� 0���� ä������
					ret = 2*size > ret ? 2*size : ret;
					break;
				}
				int n1 = map[i][j];
				if(used[n1] == 0) {
					list01.add(new array(n1,1));
				}
				used[n1]++;
			}
		}
		columnCnt = ret;
	}
	
	static void cOperation() {
		ArrayList<array> list01;
		int[] used;
		int ret = 0;
		for(int j = 0 ; j < columnCnt ; j++) {
			list01 = new ArrayList<>();
			used = new int[101];
				for(int i = 0 ; i < rowCnt+1 ; i++) {
				if(map[i][j] == 0) {
					if(i < rowCnt) continue;
					int maxIdx = i;
					int size = list01.size();
					for(int k = 0 ; k < size ; k++) {
						list01.get(k).cnt = used[list01.get(k).num];
					}
					Collections.sort(list01);
					int idx = 0;
					for(int ii = 0 ; ii < size ; ii++) {
						map[idx++][j] = list01.get(ii).num;
						map[idx++][j] = list01.get(ii).cnt; 
					}
					if(2*size < maxIdx) {
						for(int ii = 2*size; ii < maxIdx ; ii++) {
							map[ii][j] = 0;
						}
					}
					ret = 2*size > ret ? 2*size : ret;
					break;
				}
				int n1 = map[i][j];
				if(used[n1] == 0) {
					list01.add(new array(n1,1));
				}
				used[n1]++;
			}
		}
		rowCnt = ret;
	}
}

//6
//6
//3 1 1 3 0 0 
//3 1 1 5 0 0 
//1 1 2 3 0 0 
//2 1 1 3 0 0 
//3 1 0 0 0 0 
//1 1 0 0 0 0 
//�ش����̽� ��