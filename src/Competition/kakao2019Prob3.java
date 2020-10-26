package Competition;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class kakao2019Prob3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] arr = { { "100", "ryan", "music", "2" }, { "200", "apeach", "math", "2" },
				{ "300", "tube", "computer", "3" }, { "400", "con", "computer", "4" }, { "500", "muzi", "music", "3" },
				{ "600", "apeach", "music", "2" } };

		System.out.println(solution(arr));
	}

	static boolean[] check;
	static ArrayList<boolean[]> list = new ArrayList<>();
	static int len;
	static int cnt;
	static int answer;
	static String[][] str;

	static int solution(String[][] relation) {
		answer = 0;
		str = relation;
		len = relation.length;
		cnt = relation[0].length;
		check = new boolean[cnt];
		solve(0);

		return answer;
	}

	static void solve(int idx) {
		if (idx == cnt) {
			Set<String> set = new HashSet<>();
			for (int i = 0; i < len; i++) {
				String str1 = "";
				for (int j = 0; j < cnt; j++) {
					if(!check[j])
						str1 += str[i][j];
				}
				if(set.contains(str1)) {
					return;
				}
				set.add(str1);
			}
			for(boolean[] bArr : list) {
				int count = 0;
				for(int k = 0 ; k < cnt ; k++) {
					if(!bArr[k] && bArr[k] != check[k])
						count++;
				}
				if(count == 0)
					return;
			}
			boolean[] newList = new boolean[cnt];
			for(int k = 0 ; k < cnt ; k++) {
				newList[k] = check[k];
			}
				
			list.add(newList);
			answer++;
			return;
		}
		check[idx] = true;
		solve(idx + 1);
		check[idx] = false;
		solve(idx + 1);
	}

}
