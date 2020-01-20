package Greedy;

import java.util.Scanner;

public class Greedy_1120 {
	public static int solution(String a, String b) {
		int len = b.length() - a.length();
		int ret = a.length();
		
        for(int i=0; i<=len; i++) {
            int cnt = 0;
            for(int j=0; j<a.length(); j++) {
                if(a.charAt(j) != b.charAt(i+j))
                    cnt++;
            }
            ret = Math.min(cnt, ret);
        }
		return ret;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input_a = sc.next();
		String input_b = sc.next();

		System.out.println(Greedy_1120.solution(input_a, input_b));
		sc.close();
	}

}
