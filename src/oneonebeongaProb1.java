
public class oneonebeongaProb1 {

	public static void main(String[] args) {
		System.out.println(solution("aabab"));
		System.out.println(solution("dog"));
		System.out.println(solution("a"));
		System.out.println(solution("baaaa"));
		System.out.println(solution("ba"));
		System.out.println(solution("aa"));
	}

	public static int solution(String S) {
		int ret = 0;

		if (S.contains("aaa"))
			return -1;

		for(int i = 0 ; i < S.length() ; i++) {
			if(S.charAt(i) == 'a') {
				if(i+1 < S.length() && S.charAt(i+1) != 'a') { // a 일떄 그 다음껄 보고 앞에 붙힐지 안붙힐지 
					ret++;
				}else if(i+1 < S.length() && S.charAt(i+1) == 'a') { // 뒤에도 a면 그냥 두개 넘김
					i++;
				} 
			}else {
				if(i == 0) { // 첫번쨰글자가 a가 아니면 앞에 2개 추가
					ret+=2;
				}else if(i != 0 && S.charAt(i-1) != 'a') { // 0이 아니고 앞에꺼가 a도 아니면 2개 추가 - 위에서 두개를 넘겼기떄문에 여기서 바로 앞걸 확인해야함 
					ret+=2;
				}else if(i != 0 && S.charAt(i-1) == 'a') { // 앞에꺼가 a면 그 전 a에서 이미 판별했기때문에 넘김
					continue;
				}
			}
		}
		
		// 나는 앞에걸 기준으로 했기떄문에 맨 마지막에 붙힐걸 고려해야함.
		if(S.charAt(S.length()-1) != 'a')
			ret+=2;

		return ret;
	}
	
	public static int solution2(String S) {
		int ret = 0;

		if (S.contains("aaa"))
			return -1;
		
		for(int i = 0 ; i < S.length() ; i++) {
			if(S.charAt(i) == 'a') {
				if(i+1 < S.length() && S.charAt(i+1) != 'a') {
					ret++;
				}else if(i+1 < S.length() && S.charAt(i+1) == 'a') {
					i++;
				} 
			}else {
				if(i == 0) {
					ret+=2;
				}else if(i != 0 && S.charAt(i-1) != 'a') {
					ret+=2;
				}else if(i != 0 && S.charAt(i-1) == 'a') {
					continue;
				}
			}
		}
		
		if(S.charAt(S.length()-1) != 'a')
			ret+=2;

		return ret;
	}
}
