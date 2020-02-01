package SW_Expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_3074 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc <= TC ; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int cnt = 0;
			int idx = 0;

			int[] t1 = new int[N];
			int[] t2 = new int[N];
			for(int i = 0 ;i < N ; i++) {
				t1[i] = Integer.parseInt(br.readLine());
			}
			while(cnt != M) {
				idx = 0;
				int min = t2[0] + t1[0];
				for(int i = 1 ; i < N ; i++) {
					if(min > t2[i] + t1[i]) {
						min = t2[i] + t1[i];
						idx = i;
					}
				}
				t2[idx] = t2[idx] + t1[idx];
				cnt++;
			}
			System.out.println("#" + tc + " " + t2[idx]);
		}
		
	}
}
