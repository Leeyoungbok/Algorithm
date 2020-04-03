package Study;

import java.util.Scanner;

public class SWEA_PokerGame {
	static boolean[] S;
	static boolean[] H;
	static boolean[] D;
	static boolean[] C;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for(int tc = 1 ; tc <= TC ; tc++) {
			S = new boolean[14];
			H = new boolean[14];
			D = new boolean[14];
			C = new boolean[14];
			for(int i = 0 ; i < 5 ; i++) {
				String str = sc.next();
				char ch = str.charAt(0);
				char num = str.charAt(1);
				int n1 = -1;
				if(num == 'A') n1 = 1;
				else if(num == 'T') n1 = 10;
				else if(num == 'J') n1 = 11;
				else if(num == 'Q') n1 = 12;
				else if(num == 'K') n1 = 13;
				else n1 = Integer.parseInt(num + "");
				
				if(ch == 'S') S[n1] = true;
				else if(ch == 'D') D[n1] = true;
				else if(ch == 'H') H[n1] = true;
				else if(ch == 'C') C[n1] = true;
			}
			System.out.print("#" + tc);
			if(SF()) {
				System.out.println(" Straight Flush");
			}else if(FK()) {
				System.out.println(" Four of a Kind");
			}else if(FH()) {
				System.out.println(" Full House");
			}else if(F()) {
				System.out.println(" Flush");
			}else if(S()) {
				System.out.println(" Straight");
			}else if(TK()) {
				System.out.println(" Three of a kind");
			}else if(T()) {
				System.out.println(" Two pair");
			}else if(O()) {
				System.out.println(" One pair");
			}else {
				System.out.println(" High card");
			}
		}
		
	}
	static boolean SF() {
		int h,d,c,s;
		h = d = c = s = 0;
		boolean check = true;
		int k = 0; // 몇개까지 연속인지
		if(S[1] || H[1] || D[1] || C[1]) {
			if(S[1] && S[10] && S[11] && S[12] && S[13]) return true;
			if(H[1] && H[10] && H[11] && H[12] && H[13]) return true;
			if(D[1] && D[10] && D[11] && D[12] && D[13]) return true;
			if(C[1] && C[10] && C[11] && C[12] && C[13]) return true;
		}
		for(int i = 1 ; i <= 13 ; i++) {
			if(S[i]) {
				check = true;
				s++;
			}
			else if(H[i]) {
				check = true;
				h++;
			}
			else if(D[i]) {
				check = true;
				d++;
			}
			else if(C[i])  {
				check = true;
				c++;
			}
			else {
				if((s>0 || h>0 || d>0 || c>0) && check)
					return false;
			}
			
			if(s==5 || h==5 || d==5 || c==5) return true;
		}
		return false;
	}
	static boolean FK() {
		for(int i = 1 ; i <= 13 ; i++) {
			int k = 0;
			if(S[i]) k++;
			if(H[i]) k++;
			if(D[i]) k++;
			if(C[i]) k++;
			if(k==4) return true;
		}
		return false;
	}
	static boolean FH() {
		boolean check1 = false;
		boolean check2 = false;
		for(int i = 1 ; i <= 13 ; i++) {
			int k = 0;
			if(S[i]) k++;
			if(H[i]) k++;
			if(D[i]) k++;
			if(C[i]) k++;
			if(k==2) check1 = true;
			if(k==3) check2 = true;
		}
		if(check1 && check2) return true;
		return false;
	}
	static boolean F() {
		int h,d,c,s;
		h = d = c = s = 0;
		for(int i = 1 ; i <= 13 ; i++) {
			if(S[i]) s++;
			else if(H[i]) h++;
			else if(D[i]) d++;
			else if(C[i]) c++;
			if(s == 5 || c == 5 || d == 5 || h == 5)
				return true;
		}
		return false;
	}
	static boolean S() {
		boolean check = true;
		int k = 0; // 몇개까지 연속인지
		for(int i = 1 ; i <= 13 ; i++) {
			if(S[i]) {
				check = true;
				k++;
			}
			else if(H[i]) {
				check = true;
				k++;
			}
			else if(D[i]) {
				check = true;
				k++;
			}
			else if(C[i])  {
				check = true;
				k++;
			}
			else {
				if(k>0 && check)
					return false;
			}
			if(k==5) return true;
		}
		return false;
	}
	static boolean TK() {
		for(int i = 1 ; i <= 13 ; i++) {
			int k = 0;
			if(S[i]) k++;
			if(H[i]) k++;
			if(D[i]) k++;
			if(C[i]) k++;
			if(k==3) return true;
		}
		return false;
	}
	static boolean T() {
		int n1 = 0;
		for(int i = 1 ; i <= 13 ; i++) {
			int k = 0;
			if(S[i]) k++;
			if(H[i]) k++;
			if(D[i]) k++;
			if(C[i]) k++;
			if(k==2) n1++;
			if(n1==2) return true;
		}
		return false;
	}
	static boolean O() {
		for(int i = 1 ; i <= 13 ; i++) {
			int k = 0;
			if(S[i]) k++;
			if(H[i]) k++;
			if(D[i]) k++;
			if(C[i]) k++;
			if(k==2) return true;
		}
		return false;
	}
}
