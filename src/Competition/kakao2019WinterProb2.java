package Competition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class kakao2019WinterProb2 {
	static class Len implements Comparable<Len>{
		String str;
		Len(String str){
			this.str = str;
		}
		@Override
		public int compareTo(Len o) {
			return this.str.length() - o.str.length();
		}
	}
	
	
	public static void main(String[] args) {
		String s = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
		ArrayList<Integer> list = new ArrayList<Integer>();
		PriorityQueue<Len> queue = new PriorityQueue<>();
		
		String s1 = s.substring(2, s.length() -1);
		String[] s2 = s1.split("}");
		boolean[] check = new boolean[100001];
		int length = s2.length;
		int idx = 0;
		queue.add(new Len(s2[0]));
		for(int k = 1 ; k < length ; k++) {
			queue.add(new Len(s2[k].substring(2)));
		}
		
		while(!queue.isEmpty()) {
			String[] arr = queue.poll().str.split(",");
			for(String str : arr) {
				int n1 = Integer.parseInt(str);
				if(!check[n1]) {
					check[n1] = true;
					list.add(n1);
					idx++;
				}
			}
		}
		
		int[] answer = new int[idx];
		int idx2 = 0;
		for(int n1 : list) {
			answer[idx2++] = n1;
		}
		
		System.out.println(Arrays.toString(answer));
		
	}

}
