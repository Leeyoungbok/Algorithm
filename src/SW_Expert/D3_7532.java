package SW_Expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_7532 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc <= TC ; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int S1 = Integer.parseInt(st.nextToken());
			int E1 = Integer.parseInt(st.nextToken());
			int M1 = Integer.parseInt(st.nextToken());
			int S2 = 0, E2 = 0, M2 = 0;
			int cnt = 0;
			while(true) {
				S2++;
				E2++;
				M2++;
				if(S2 > 365) S2 = 0;
				if(E2 > 24) E2 = 0;
				if(M2 > 29) M2 = 0;
				cnt++;
				if(S1 == S2 && E1 == E2 && M1 == M2) break;
			}
			System.out.println(cnt);
		}
	}

}
