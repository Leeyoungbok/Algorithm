package Competition;

import java.util.HashMap;
import java.util.Map;

public class kakao2019Prob1 {

	public static void main(String[] args) {
		String[] input = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		String[] strArr = solution(input);
		for(String str : strArr) {
			System.out.println(str);
		}
	}
	private static String[] solution(String[] record) {
        int len = record.length;
        int cnt = len;
        Map<String, String> map = new HashMap<>();
        for(int i = 0 ; i < len ; i++) {
        	String[] str1 = record[i].split(" ");
        	if(str1[0].equals("Enter")) {
        		map.put(str1[1], str1[2]);
        	}
        	if(str1[0].equals("Change")) {
        		map.put(str1[1], str1[2]);
        		cnt--;
        	}
        }
        String[] answer = new String[cnt];
        int k = 0;
        for(int i = 0 ; i < len ; i++) {
        	String[] str1 = record[i].split(" ");
        	if(str1[0].equals("Change")) continue;
        	if(str1[0].equals("Enter")) {
        		String a = map.get(str1[1]);
        		answer[k++] = a + "님이 들어왔습니다.";
        	}else if(str1[0].equals("Leave")) {
        		String a = map.get(str1[1]);
        		answer[k++] = a + "님이 나갔습니다.";
        	}
        }
        
        return answer;
    }
}
