package day_04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AdventOfCode_04 {

    int ans1 = 0;
    int ans2 = 0;

    public int aoc4_1(){
        return ans1;
    }

    public int aoc4_2(){
        return ans2;
    }

    public AdventOfCode_04(String filePath) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));

        String s;
        while ((s = bufferedReader.readLine()) != null){
            String[] str = s.split("[-,]+");

            int f1 = Integer.parseInt(str[0]);
            int l1 = Integer.parseInt(str[1]);
            int f2 = Integer.parseInt(str[2]);
            int l2 = Integer.parseInt(str[3]);

            if ((f1 <= f2 && l1 >= l2) || (f1 >= f2 && l1 <= l2)){
                ans1++;
            }

            if (!(f1 > l2 || l1 < f2)){
                ans2++;
            }
        }

        bufferedReader.close();

    }
}
