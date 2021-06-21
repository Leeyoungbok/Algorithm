package Programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 로또의최고순위최저순위 {
    public static void main(String[] args){
        int[] a = {31, 10, 45, 1, 6, 19};
        int[] b = {31, 0, 44, 1, 0, 25};
        Arrays.toString(solution(a, b));
    }

    public static int[] solution(int[] lottos, int[] win_nums){
        Map<Integer, Boolean> map = new HashMap<>();
        for(int i = 0 ; i < win_nums.length ; i++){
            map.put(win_nums[i], true);
        }

        int zeroCnt = 0;
        int hitCnt = 0;
        for(int i = 0 ; i < lottos.length ; i++){
            if(lottos[i] == 0){
                zeroCnt++;
            }else if(map.containsKey(lottos[i])){
                hitCnt++;
            }
        }

        System.out.println(getRank(zeroCnt + hitCnt));
        System.out.println(getRank(hitCnt));
        return new int[]{getRank(zeroCnt + hitCnt), getRank(hitCnt)};
    }

    public static int getRank(int n){
        if(n == 6)
            return 1;
        else if(n == 5)
            return 2;
        else if(n == 4)
            return 3;
        else if(n == 3)
            return 4;
        else if(n == 2)
            return 5;
        else
            return 6;
    }
}
