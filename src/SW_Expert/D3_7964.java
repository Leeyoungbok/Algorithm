package SW_Expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_7964 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 1 ; tc <= TC ; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());
			int[] arr = new int[N+2];
			arr[0] = 1; arr[N+1] = 1;
			int cnt = 0;
			int total = 0;
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 1 ; i < N+1 ; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			for(int i = 0 ; i < N+2 ; i++) {
				if(arr[i] == 0) {
					cnt++;
				}
				if(cnt == D) {
					total++;
					cnt = 0;
				}
				if(arr[i] == 1 || ((i % D) == (D-1))) cnt = 0;
			}
			System.out.println("#" + tc + " " + total);
		}
	}

}
