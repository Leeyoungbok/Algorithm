package Study;

import java.util.*;

public class 가르침 {
	static int N, K, Ans = 0;
	static String[] input;
	static char[] result;
	static ArrayList<Character> list = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		input = new String[N];
		list.add('a'); list.add('n'); list.add('t'); list.add('i'); list.add('c');
		for(int i = 0 ; i < N ; i++) {
			input[i] = sc.next();
			input[i] = input[i].substring(4, input[i].length()-4);
			for(int j = 0 ; j < input[i].length() ; j++) {
				char ch = input[i].charAt(j);
				if(!list.contains(ch))
					list.add(ch);
			}
		}
		
		if(K == 26) {
			System.out.println(N);
			return;
		}
		if(K < 5) {
			System.out.println(0);
			return;
		}
//		System.out.println(list.toString());
		if(K > list.size()) K = list.size();
		result = new char[K];
		result[0] = 'a'; result[1] = 'n'; result[2] = 't'; result[3] = 'i'; result[4] = 'c';
		solve(5, 5);
		System.out.println(Ans);
	}

	static void solve(int idx, int cnt) {
		if(cnt == K ) {
//			System.out.println(Arrays.toString(result));
			int canEduCnt = 0;
			for(int i = 0 ; i < N ; i++) {
				if(Ans - canEduCnt >= N - i)
					return;
				boolean canPlus = false;
				for(int j = 0 ; j < input[i].length() ; j++) {
					boolean check = false;
					for(int k = 0 ; k < K ; k++) {
						if(input[i].charAt(j) == result[k]) {
							check = true;
							break;
						}
					}
					if(!check) {
						canPlus = true;
						break;
					}
				}
				if(!canPlus)
					canEduCnt++;
			}
			Ans = Ans < canEduCnt ? canEduCnt : Ans;
			return;
		}else if(idx == list.size()) {
			return;
		}
		
		result[cnt] = list.get(idx);
		solve(idx+1, cnt+1);
		solve(idx+1, cnt);
	}
}
