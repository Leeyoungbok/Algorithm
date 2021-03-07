package SW_Expert;

import java.util.*;

public class SWEA_정식이의은행업무 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();

		for (int tc = 1; tc <= TC; tc++) {
			String str1 = sc.next();
			String str2 = sc.next();

			ArrayList<Long> list = new ArrayList<>();

			for (int i = str1.length() - 1; i >= 0; i--) {
				if (str1.charAt(i) == '0') {
					list.add(Long.parseLong(str1, 2) + (long) Math.pow(2, str1.length() - 1 - i));
				} else {
					list.add(Long.parseLong(str1, 2) - (long) Math.pow(2, str1.length() - 1 - i));
				}
			}
			System.out.print("#" + tc + " ");
			for (int i = str2.length() - 1; i >= 0; i--) {
				if (str2.charAt(i) == '0') {
					if(list.contains(Long.parseLong(str2, 3) + (long) Math.pow(3, str2.length() - 1 - i))) {
						System.out.println(Long.parseLong(str2, 3) + (long) Math.pow(3, str2.length() - 1 - i));
						break;
					}
					if(list.contains(Long.parseLong(str2, 3) + (long) Math.pow(3, str2.length() - 1 - i)*2)) {
						System.out.println(Long.parseLong(str2, 3) + (long) Math.pow(3, str2.length() - 1 - i)*2);
						break;
					}
				} else if (str2.charAt(i) == '1') {
					if(list.contains(Long.parseLong(str2, 3) - (long) Math.pow(3, str2.length() - 1 - i))) {
						System.out.println(Long.parseLong(str2, 3) - (long) Math.pow(3, str2.length() - 1 - i));
						break;
					}
					if(list.contains(Long.parseLong(str2, 3) + (long) Math.pow(3, str2.length() - 1 - i))) {
						System.out.println(Long.parseLong(str2, 3) + (long) Math.pow(3, str2.length() - 1 - i));
						break;
					}
				} else if (str2.charAt(i) == '2') {
					if(list.contains(Long.parseLong(str2, 3) - (long) Math.pow(3, str2.length() - 1 - i))) {
						System.out.println(Long.parseLong(str2, 3) - (long) Math.pow(3, str2.length() - 1 - i));
						break;
					}
					if(list.contains(Long.parseLong(str2, 3) - (long) Math.pow(3, str2.length() - 1 - i)*2)) {
						System.out.println(Long.parseLong(str2, 3) - (long) Math.pow(3, str2.length() - 1 - i)*2);
						break;
					}
				}
			}

		}
	}
}
