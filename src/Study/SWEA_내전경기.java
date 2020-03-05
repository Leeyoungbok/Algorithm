package Study;

import java.util.ArrayList;
import java.util.Scanner;

class team{
	String name01, name02;
	team(String name01, String name02){
		this.name01 = name01;
		this.name02 = name02;
	}
}
public class SWEA_내전경기 {
	static int K, cnt;
	static boolean check;
	static boolean[] used;
	static ArrayList<String> set;
	static ArrayList<team> list;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for(int tc = 1 ; tc <= TC ; tc++) {
			set = new ArrayList<>();
			list = new ArrayList<>();
			K = sc.nextInt();
			
			for(int i = 0 ; i < K ; i++) {
				String str01 = sc.next();
				String str02 = sc.next();
				if(set.size() == 0) {
					set.add(str01);
					set.add(str02);
				}else {
					boolean str01Check = false;
					boolean str02Check = false;
					for(int s = 0 ; s < set.size(); s++) {
						if(set.get(s).equals(str01))
							str01Check = true;
						if(set.get(s).equals(str02))
							str02Check = true;
					}
					if(!str01Check)
						set.add(str01);
					if(!str02Check)
						set.add(str02);
				}
				list.add(new team(str01,str02));
			}
			
			check = false;
			cnt = 0;
			used = new boolean[set.size()+1];
			System.out.print("#" + tc + " ");
			solution(1);
			if(check)
				System.out.println("Yes");
			else
				System.out.println("No");
		}
		
	}
		
	static void solution(int idx) {
		if(check)
			return;
		if(idx == set.size()+1) {
			cnt++;
			if(cnt == 1 || cnt > Math.pow(2, set.size())/2)
				return;
			if(isTrue())
				check = true;
			return;
		}
		used[idx] = true;
		solution(idx+1);
		used[idx] = false;
		solution(idx+1);
	}
	
	static boolean isTrue() {
		int size = list.size();
		for(int s = 0 ; s < size ; s++) {
			if(used[set.indexOf(list.get(s).name01)] == used[set.indexOf(list.get(s).name02)])
				return false;
		}
		return true;
	}
}
