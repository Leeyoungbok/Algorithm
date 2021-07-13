package Programmers;

import java.util.*;

public class 메뉴리뉴얼 {
    static char[] memStrToCharArr;
    static char[] memCharArr;
    static Map<String, Integer> memMap;
    public static void main(String[] args) {
        String[] strArr = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        String[] strArr2 = {"XYZ", "XWY", "WXA"};

        int[] intArr = {2, 3, 4};
        System.out.println(Arrays.toString(solution(strArr2, intArr)));
    }

    public static String[] solution(String[] orders, int[] course) {
        List<String> answerList = new ArrayList<>();

        for(int i = 0 ; i < course.length ; i++){
            memMap = new HashMap<>();
            for(String str : orders){
                if(str.length() < course[i]) continue;
                memCharArr = new char[course[i]];
                memStrToCharArr = str.toCharArray();
                Arrays.sort(memStrToCharArr);
                solve(0, 0);
            }
            if(memMap.size() == 0) continue;

            List<String> keySetList = new ArrayList<>(memMap.keySet());

            Collections.sort(keySetList, (o1, o2) -> (memMap.get(o2).compareTo(memMap.get(o1))));
            int n1 = memMap.get(keySetList.get(0));
            if(n1 <= 1) continue;

            for(String str : keySetList) {
                if(n1 != memMap.get(str))
                    break;
                answerList.add(str);
            }

        }
        Collections.sort(answerList);
        String[] answer = answerList.toArray(new String[0]);
        return answer;
    }

    public static void solve(int charArrIdx, int strIdx){
        if(charArrIdx == memCharArr.length){
            String str = String.valueOf(memCharArr);
            if(memMap.containsKey(str)){
                memMap.put(str, memMap.get(str) + 1);
            }else{
                memMap.put(str, 1);
            }

            return;
        }

        if(strIdx == memStrToCharArr.length){
            return;
        }

        memCharArr[charArrIdx] = memStrToCharArr[strIdx];
        solve(charArrIdx + 1, strIdx + 1);
        solve(charArrIdx, strIdx + 1);
    }
}
