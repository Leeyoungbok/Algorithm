package Programmers;

import java.util.Arrays;

public class 전화번호목록 {

    public static void main(String[] args){
        String[] phoneBook = {"119", "97674223", "1195524421"};
        String[] phoneBook2 = {"123","456","789"};
        String[] phoneBook3 = {"12","123","1235","567","88"};
        String[] phoneBook4 = {"12","123","123456","12567","13"};
        System.out.println(solution(phoneBook));
        System.out.println(solution(phoneBook2));
        System.out.println(solution(phoneBook3));
        System.out.println(solution(phoneBook4));
    }

    public static boolean solution(String[] phoneBook){
        boolean answer = true;

        Arrays.sort(phoneBook);

        System.out.println(Arrays.toString(phoneBook));
        for(int i = 0 ; i < phoneBook.length - 1 ; i++){
            int len1 = phoneBook[i].length();
            int len2 = phoneBook[i + 1].length();
            if(len1 >= len2 && phoneBook[i].equals(phoneBook[i + 1].substring(0, len1))){
                return false;
            }
        }

        return answer;
    }
}
