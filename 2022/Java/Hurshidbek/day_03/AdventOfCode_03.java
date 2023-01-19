package day_03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: Kodirov Hurshidbek
 * Date : 14.01.2023
 * Time : 23:00 PM
 */


public class AdventOfCode_03 {

    HashMap<Character, Integer> alp = new HashMap<>();
    String filePath;

    public int aoc3_1() throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));

        String s;
        int sum = 0;

        while ((s = bufferedReader.readLine()) != null) {
            Map<Character, Integer> map = new HashMap<>();

            int ind = 0;
            for(char c: s.toCharArray()){
                if (ind++ < s.length() / 2){
                    map.put(c, 1);
                }
                else if (map.get(c) != null){
                    sum += alp.get(c);
                    break;
                }
            }

        }

        bufferedReader.close();
        return sum;
    }


    public int aoc3_2() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));

        String s1;
        String s2;
        String s3;
        int sum = 0;

        while ((s1 = bufferedReader.readLine()) != null) {
            Map<Character, Integer> map = new HashMap<>();

            s2 = bufferedReader.readLine();
            s3 = bufferedReader.readLine();

            for(char c: s1.toCharArray()) {
                map.put(c, 1);
            }

            for(char c: s2.toCharArray()){
                if (map.get(c) != null && map.get(c) == 1){
                    map.put(c, 2);
                }
            }

            for(char c: s3.toCharArray()){
                if (map.get(c) != null && map.get(c) == 2){
                    sum += alp.get(c);
                    break;
                }
            }
        }

        bufferedReader.close();
        return sum;
    }

    public AdventOfCode_03(String filePath) {
        this.filePath = filePath;
        for (int i = 0; i < 26; i++) {
            alp.put((char)(i+'a'), i+1);
            alp.put((char) (i+'A'), i + 27);
        }
    }

    /* Big O analyse
     Time Complexity:  ;
     Space Complexity:  */

}
