package DisjointSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class DisjoinSet_4195 {
	static int N, M;
	static int[] cnt, dj;
	
	static int find(int n1) {
		if(dj[n1] == n1)
			return n1;
		
		return dj[n1] = find(dj[n1]);
	}
	
	static int union(int n1, int n2) {
		int p1 = find(n1);
		int p2 = find(n2);
		
		if(p1 != p2) {
			if(p1 < p2) {
				dj[p2] = p1;
				cnt[p1] += cnt[p2];
				return cnt[p1];
			}else {
				dj[p1] = p2;
				cnt[p2] += cnt[p1];
				return cnt[p2];
			}
		}
		return cnt[p1];
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for(int n = 0 ; n < N ; n++) {
			M = Integer.parseInt(br.readLine());
			HashMap<String, Integer> map = new HashMap<>();
			dj = new int[2*M+1];
			cnt = new int[2*M+1];
			
			for(int i = 0 ; i <= 2*M ; i++) {
				dj[i] = i;
				cnt[i] = 1;
			}
			StringTokenizer st;
			int idx = 0;
			for(int i = 0 ; i < M ; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				String str1 = st.nextToken();
				String str2 = st.nextToken();
				if(!map.containsKey(str1))
					map.put(str1, idx++);
				if(!map.containsKey(str2)) {
					map.put(str2, idx++);
				}
				int idx1 = map.get(str1);
				int idx2 = map.get(str2);
				System.out.println(union(idx1,idx2));
			}
		}
	}
}
