import java.util.ArrayList;
import java.util.PriorityQueue;

public class coupangProb3 {

	public static void main(String[] args) {
		int[] arr1 = {24,22,20,10,5,3,2,1};
		int[] arr2 = {1300000000,700000000,668239490,618239490,568239490,568239486,518239486,157658638,157658634,100000000,100};
		System.out.println(solution(3, arr1));
		System.out.println(solution(2, arr2));
	}
	public static int solution(int k, int[] score) {
		int answer = score.length;
		
		boolean[] boolArr = new boolean[score.length];
		PriorityQueue<Num> pq = new PriorityQueue<>();
		
		for(int i = 0 ; i < score.length - 1 ; i++) {
			pq.add(new Num(i, score[i] - score[i+1]));
		}
		
		int memo = 0;
		long prev = -1;
		ArrayList<Integer> list = new ArrayList<>();
		while(!pq.isEmpty()) {
			Num num = pq.poll();
			System.out.println(num.n+" " +num.sub);
			if(memo == 0)
				prev = num.sub;
			
			if(prev == num.sub) {
				memo++;
				list.add(num.n);
			}
			if(memo < k && prev != num.sub) {
				memo = 1;
				prev = num.sub;
				list.clear();
				list.add(num.n);
			}
			if(memo >= k && prev != num.sub) {
				for(int n1 : list) {
					if(!boolArr[n1]) {
						boolArr[n1] = true;
						answer--;
					}
					if(!boolArr[n1+1]) {
						boolArr[n1 + 1] = true;
						answer--;
					}
				}
				memo = 0;
				prev = -1;
				list.clear();
				continue;
			}
		}
		return answer;
	}
	
	static class Num implements Comparable<Num>{
		int n;
		long sub;
		Num(int n, long sub){
			this.n = n;
			this.sub = sub;
		}
		
		@Override
		public int compareTo(Num o) {
			if(this.sub > o.sub)
				return 1;
			else if(this.sub < o.sub)
				return -1;
			else
				return 0;
		}
		
		
	}

}
