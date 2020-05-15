package Study;

import java.util.PriorityQueue;
import java.util.Scanner;

class NameSort implements Comparable<NameSort>{
	String name;
	int len;
	NameSort(String name, int len){
		this.name = name;
		this.len = len;
	}
	@Override
	public int compareTo(NameSort o) {
		if(this.len != o.len)
			return this.len - o.len;
		else {
			for(int i = 0 ; i < this.name.length() ; i++) {
				if(this.name.charAt(i) != o.name.charAt(i))
					return this.name.charAt(i) - o.name.charAt(i);
			}
		}
		return 1;
	}
}
public class SWEA_염라대왕의이름정렬 {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for(int tc = 1 ; tc <= TC ; tc++) {
			N = sc.nextInt();
			
			PriorityQueue<NameSort> queue = new PriorityQueue<>();
			for(int i = 0 ; i < N ; i++) {
				String str = sc.next();
				queue.add(new NameSort(str, str.length()));
			}

			System.out.print("#" + tc);
			while(!queue.isEmpty()) {
				NameSort ns = queue.poll();
				if(!queue.isEmpty() && queue.peek().name.equals(ns.name))
					continue;
				System.out.print("\n" + ns.name);
			}
			
		}
		sc.close();
	}

}
