package Competition;

public class kakao2019WinterProb5 {
	public static void main(String[] args) {
		int[] stones = {2,4,5,3,2,1,4,2,5,1};
		int k = 3;
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for(int i = 0 ; i < stones.length ; i++) {
			min = min > stones[i] ? stones[i] : min;
			max = max < stones[i] ? stones[i] : max;
		}
		int avg = -1;
		int answer = -1;
		while(min <= max) {
			avg = (min + max) / 2;
			int cnt = 0;
			boolean check = false;
			for(int i = 0 ; i < stones.length ; i++) {
				if(avg >= stones[i]) {
					cnt++;
				}else {
					cnt = 0;
				}
				
				if(cnt >= k) {
					answer = avg;
					max = avg - 1;
					check = true;
					break;
				}
			}
			if(!check) {
				min = avg + 1;
			}
		}
		System.out.println(answer);
	}
}
