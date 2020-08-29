package Competition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class kakao2019WinterProb4 {
	static Map<Long, Long> map = new HashMap<>();
	static long[] answer;
	static int idx = 0;

	public static void main(String[] args) {
		// Long
		long k = 10;
		long[] room_number = { 1, 3, 4, 1, 3, 1 };
		int len = room_number.length;
		answer = new long[len];

		for (long n1 : room_number) {
			answer[idx++] = solve(n1);
		}
		
		System.out.println(Arrays.toString(answer));
	}
	static long solve(long n1) {
		if(!map.containsKey(n1)) {
			map.put(n1, n1+1);
			return n1;
		}
		long a1 = map.get(n1);
		long a2 = solve(a1);
		map.put(n1, a2);
		return a2;
	}
}
