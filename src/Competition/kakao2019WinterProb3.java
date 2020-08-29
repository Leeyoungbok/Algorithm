package Competition;

import java.util.ArrayList;
import java.util.HashSet;

public class kakao2019WinterProb3 {

	static int userCnt, bannedCnt, answer, a1;
	static boolean[] userUsed, bannedUsed;
	static HashSet<String> set = new HashSet<>();
	static ArrayList<HashSet<String>> list = new ArrayList<>();

	public static void main(String[] args) {
		String[] user_id = { "frodo", "fradi", "crodo", "abc123", "frodoc" };
		String[] banned_id = { "fr*d*", "*rodo", "******", "******" };

		userCnt = user_id.length;
		bannedCnt = banned_id.length;

		userUsed = new boolean[userCnt];
		bannedUsed = new boolean[bannedCnt];
		solve(0, user_id, banned_id);
		System.out.println(answer);
	}

	static void solve(int match, String[] user_id, String[] banned_id) {
		if (match == bannedCnt) {
			boolean check = false;
			if (list.isEmpty()) {
				check = true;
			} else {
				for (HashSet<String> hs : list) {
					boolean check2 = false;
					for(String str : hs) {
						if(!set.contains(str)) {
							check2 = true;
						}
					}
					if(!check2) return;
					else check = true;
				}
			}
			if (check) {
				HashSet<String> set2 = new HashSet<>();
				for(String str : set)
					set2.add(str);
				list.add(set2);
				answer++;
			}
			return;
		}
		for (int i = 0; i < userCnt; i++) {
			if (userUsed[i])
				continue;
			for (int j = 0; j < bannedCnt; j++) {
				if (bannedUsed[j])
					continue;
				if (compare(user_id[i], banned_id[j])) {
					bannedUsed[j] = true;
					userUsed[i] = true;
					set.add(user_id[i]);
					solve(match + 1, user_id, banned_id);
					set.remove(user_id[i]);
					userUsed[i] = false;
					bannedUsed[j] = false;
				}
			}
		}

	}

	static boolean compare(String str1, String str2) {
		if (str1.length() != str2.length())
			return false;
		for (int i = 0; i < str1.length(); i++) {
			if (str2.charAt(i) == '*')
				continue;
			if (str1.charAt(i) != str2.charAt(i))
				return false;
		}
		return true;
	}
}
