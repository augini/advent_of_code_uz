package day_02;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: Kodirov Hurshidbek
 * Date : 14.01.2023
 * Time : 22:00 PM
 */


public class AdventOfCode_2 {

    Map<Character, Integer> map = new HashMap<>();
    char[] car = {'Z','X', 'Y', 'Z', 'X'};

    int score1 = 0;
    int score2 = 0;

    public int aoc2_1(){
        return score1;
    }

    public int aoc2_2(){
        return score2;
    }

    public AdventOfCode_2(String filePath) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));

        uploadMap();

        String s;
        while ((s = bufferedReader.readLine()) != null) {
            char opp = s.charAt(0);
            char me = s.charAt(2);

            score1 += win1(opp, me) * 3 + map.get(me);
            score2 += win2(opp, me);
        }

        bufferedReader.close();
    }

    private void uploadMap() {
        map.put('A', 1);
        map.put('B', 2);
        map.put('C', 3);

        map.put('X', 1);
        map.put('Y', 2);
        map.put('Z', 3);
    }

    private int win1(char opp, char me) {
        if (opp == 'A' && me == 'Y') {
            return 2;
        } else if (opp == 'B' && me == 'Z') {
            return 2;
        } else if (opp == 'C' && me == 'X') {
            return 2;
        } else if (opp == 'A' && me == 'X') {
            return 1;
        } else if (opp == 'B' && me == 'Y') {
            return 1;
        } else if (opp == 'C' && me == 'Z') {
            return 1;
        } else {
            return 0;
        }
    }

    private int win2(char opp, char me) {

        if (me == 'X') {
            return map.get( car[ map.get(opp) - 1 ] );
        }
        else if (me == 'Y') {
            return 3 + map.get( car[ map.get(opp) ] );
        }
        else {
            return 6 + map.get( car[ map.get(opp) + 1 ] );
        }

    }

    /* Big O analyse
     Time Complexity: O(n) ;
     Space Complexity:  */

}
