package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_햄스터 {
	static int N, X, M, sum;
	static int[][] memo;
	static int[] res;
	static int[] ret;
	static boolean check;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc <= TC ; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			memo = new int[M][3];
			res = new int[N+1];
			ret = new int[N+1];
			
			for(int m = 0 ; m < M ; m++) {
				st = new StringTokenizer(br.readLine(), " ");
				memo[m][0] = Integer.parseInt(st.nextToken());
				memo[m][1] = Integer.parseInt(st.nextToken());
				memo[m][2] = Integer.parseInt(st.nextToken());
			}
			check = false;
			sum = -1;
			System.out.print("#" + tc);
			solution(1);
			if(sum == -1)
				System.out.println(" "+ -1);
			else {
				for(int i = 1 ; i <= N ; i++) {
					System.out.print(" " + ret[i]);
				}
				System.out.println();
			}
		}
		
	}
	
	static void solution(int idx) {
		if(!isContinue(idx-1)) {
			return;
		}
		
		if(idx == N+1) {
			retMemo();
			return;
		}
		
		for(int i = 0 ; i <= X ; i++) {
			res[idx] = i;
			solution(idx+1);
		}
	}
	
	
	static boolean isContinue(int idx) {
		for(int i = 0 ; i < memo.length ; i++) {
			if(idx < memo[i][1])
				continue;
			int sum = 0;
			for(int j = memo[i][0] ; j <= memo[i][1] ; j++) {
				sum += res[j];
			}
			if(sum != memo[i][2])
				return false;
		}
		return true;
	}

	static void retMemo() {
		int n1 = 0;
		for(int i = 1 ; i <= N ; i++) {
			n1 += res[i];
		}
		if(n1 > sum) {
			ret = res.clone();
			sum = n1;
		}
			
	}
}
