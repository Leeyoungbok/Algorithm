package Programmers;

import java.util.Locale;

public class 신규아이디추천 {
    public static void main(String[] args) {
        String new_id1 = "...!@BaT#*..y.abcdefghijklm";
        String new_id2 = "z-+.^.";
        String new_id3 = "=.=";
        String new_id4 = "123_.def";
        String new_id5 = "abcdefghijklmn.p";
        System.out.println(solution(new_id1));
        System.out.println(solution(new_id2));
        System.out.println(solution(new_id3));
        System.out.println(solution(new_id4));
        System.out.println(solution(new_id5));
    }

    public static String solution(String new_id) {
        StringBuffer answer = new StringBuffer();

        new_id = new_id.toLowerCase(Locale.ROOT); // step 1
//        System.out.println("step 1 :" + new_id);

        int len = new_id.length();

        for(int i = 0 ; i < len ; i++) { // step 2 & 3
            char ch = new_id.charAt(i);

            if (ch == '-' || ch == '_' ||
                    (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')) {
                answer.append(ch);
            } else if (ch == '.') {
                if(answer.length() != 0 && answer.charAt(answer.length() - 1) == '.')
                    continue;
                answer.append(ch);
            }
        }

//        System.out.println("step 2&3 :" + answer.toString());

        if(answer.length() != 0 && answer.charAt(0) == '.'){ // step 4
            answer.replace(0,1, "");
        }

//        System.out.println("step 4 :" + answer.toString());


        if(answer.length() != 0 && answer.charAt(answer.length() - 1) == '.'){
            answer.replace(answer.length() - 1, answer.length(), "");
        }

        if(answer.length() == 0){ // step 5
            answer.append('a');
        }

//        System.out.println("step 5 :" + answer.toString());

        if(answer.length() >= 16){ // step 6
            answer.replace(15, answer.length(), "");
            if(answer.charAt(14) == '.'){
                answer.replace(14, 15, "");
            }
        }

//        System.out.println("step 6 :" + answer.toString());
        if(answer.length() <= 2){ // step 7
            char ch = answer.charAt(answer.length() - 1);

            while(true){
                if(answer.length() == 3) break;

                answer.append(ch);
            }
        }

//        System.out.println("step 7 :" + answer.toString());
        return answer.toString();
    }
}
