package Competition;

import java.util.Scanner;

public class Programmers_사칙연산 {

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		String[] str = new String[9];
//		for(int i = 0 ; i < 9 ; i++) {
//			str[i] = sc.nextLine();
//		}
//		String[] str2 =new String[str.length];
//		int idx = 0;
//		str2[0] = str[0];
//		for(int i = 1 ; i < str.length ; i += 2) {
//			if(str[i].equals("+")) {
//				int n1 = Integer.parseInt(str[i+1]);
//				if(idx > 2 && str2[idx-1].equals("-")){
//					int a = Integer.parseInt(str2[idx]);
//					if(a > n1) {
//						a -= n1;
//						str2[idx] = a + "";
//					}else {
//						a = n1 - a;
//						str2[idx] = (a*-1) + "";
//					}
//				}else {
//					str2[idx] = (Integer.parseInt(str2[idx])+n1) + "";
//				}
//			}else if(str[i].equals("-")) {
//				int n1 = Integer.parseInt(str[i+1]);
//				if(idx > 2 && str2[idx-1].equals("-")){
//					int a = Integer.parseInt(str2[idx]);
//					if(a > n1) {
//						a -= n1;
//						str2[idx] = (a*-1) + "";
//					}else {
//						a = n1 - a;
//						str2[idx] = (a) + "";
//					}
//				}else {
//					str2[++idx] = "-";
//					str2[++idx] = n1+"";
//				}
//			}
//		}
//		for(String s : str2)
//			System.out.println(s);
//		System.out.println(idx);
//		
//		int n1 = Integer.parseInt(str2[0]);
//		if(idx >= 2) {
//			int n2  = Integer.parseInt(str2[2]);
//			for(int i = 4 ; i <= idx ; i+=2) {
//				int n3 = Integer.parseInt(str2[i]);
//				n2 -= n3;
//			}
//			if(n2 < 0) {
//				int answer = n1+n2;
//				System.out.println(answer);
//			}else {
//				int answer = n1-n2;
//				System.out.println(answer);
//			}
//		}else
//			System.out.println(n1);
		
	}

}
