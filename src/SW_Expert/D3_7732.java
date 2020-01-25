package SW_Expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_7732 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), ":");
			int h1 = Integer.parseInt(st.nextToken());
			int m1 = Integer.parseInt(st.nextToken());
			int s1 = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine(), ":");
			int h2 = Integer.parseInt(st.nextToken());
			int m2 = Integer.parseInt(st.nextToken());
			int s2 = Integer.parseInt(st.nextToken());
			if(h2 == 0 && m2 == 0 && s2 == 0) h2 = 24;
			
			int s3;
			int m3;
			int h3;
			if(s2 < s1) {
				m2--;
				s3 = (60+s2) - s1;
			}else s3 = s2 - s1;
			if(m2 < m1) {
				h2--;
				m3 = (60+m2) - m1;
			}else m3 = m2 - m1;
			h3 = h2 - h1;
			if(h3 < 0) h3 = h3+24;
			System.out.printf("#%d %02d:%02d:%02d\n",tc,h3,m3,s3);
		}
	}

}
