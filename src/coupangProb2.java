
public class coupangProb2 {

	public static void main(String[] args) {
		int n = 2;
		String[] customers = {"02/28 23:59:00 03","03/01 00:00:00 02", "03/01 00:05:00 01"};
		
		System.out.println(solution(n, customers));
		
	}
	
	public static int solution(int n, String[] customers) {
		int answer = 0;
		
		int[] month = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int[] k = new int[n];
		int[] kCnt = new int[n];
		for(String s : customers) {
			String[] strArr = new String[3];
			strArr = s.split(" ");
			String[] s1 = strArr[0].split("/");
			int n1 = Integer.parseInt(s1[0]);
			int n2 = Integer.parseInt(s1[1]);
			int memo = 0;
			for(int i = 0 ; i < n1 ; i++) {
				memo += month[i];
			}
			memo += n2;
			memo *= 86400;
			
			String[] s2 = strArr[1].split(":");
			n1 = Integer.parseInt(s2[0]);
			n2 = Integer.parseInt(s2[1]);
			int n3 = Integer.parseInt(s2[2]);
			memo += n1 * 3600;
			memo += n2 * 60;
			memo += n3;
			
			int time = Integer.parseInt(strArr[2]);
			System.out.println(memo);
			boolean check = false;
			for(int i = 0 ; i < n ; i++) {
				if(k[i] == 0) {
					System.out.println(i);
					kCnt[i]++;
					k[i] = memo + time*60;
					check = true;
					break;
				}
			}
			int max = Integer.MAX_VALUE;
			int memo2 = -1;
			if(!check) {
				boolean check2 = false;
				for(int i = 0 ; i < n ; i++) {
					int memo1 = k[i] - memo;
					if(memo1 < max) {
						memo2 = i;
						max = memo1;
					}
				}
				if(!check2) {
					System.out.println(memo2);
					k[memo2] += time*60;
					kCnt[memo2]++;
				}
			}
		}
		
		for(int i = 0 ; i < n ; i++) {
			System.out.println(kCnt[i]);
			answer = answer < kCnt[i] ? kCnt[i] : answer;
		}
		return answer;
	}

}
