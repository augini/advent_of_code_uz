package day_01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author: Kodirov Hurshidbek
 * Date : 11.01.2023
 * Time : 09:09 PM
 */


public class AdventOfCode_01 {

    int[] ans; // new int[]{max1, max2, max3};

    public int aoc1_1(int maxCount) throws Exception {
        return sum(maxCount);
    }

    public int aoc1_2(int maxCount) throws Exception {
        return sum(maxCount);
    }

    private int sum(int count){
        int sum = 0;
        for (int i = 0; i < count; i++) sum += ans[i];
        return sum;
    }


    public AdventOfCode_01(int maxCount, String filePath) throws IOException {
        ans = new int[maxCount];
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));

        String str;
        int newSum = 0;

        while ((str = bufferedReader.readLine()) != null) {
            if (str.equals("")) {
                helper(newSum, 0);
                newSum = 0;
            }
            else {
                newSum += Integer.parseInt(str);
            }
        }
        bufferedReader.close();
    }

    private void helper(int newSum, int ind) {
        if (ind == ans.length) return;

        int temp = newSum;

        if (newSum > ans[ind]){
            temp = ans[ind];
            ans[ind] = newSum;
        }
        helper(temp, ++ind);
    }

    /* Big O analyse
     Time Complexity: O(n) ;
     Space Complexity: O(1) */

}
