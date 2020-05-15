package Competition;

public class Programmers_폰켓몬 {
	public static void main(String[] args) {
		int[] nums = new int[6];
		int len = nums.length;
		int resLen = len/2;
		int answer = 0;
		boolean[] check = new boolean[len];
		for(int i = 0 ; i < len ; i++) {
			if(resLen == 0)
				break;
			resLen--;
			if(check[nums[i]])continue;
			check[nums[i]] = true;
			answer++;
		}
		System.out.println(answer);
	}
}
