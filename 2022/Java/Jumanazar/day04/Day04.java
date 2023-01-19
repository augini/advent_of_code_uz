/**
 * author: Jumanazar Said
 * email: jumanazarsaidov@gmail.com
 * date: 2023/01/19 17:52
 */

package day04;

import java.io.*;

public class Day04 {
    // Declaring a string variable
    String lineStr;
    String[] numberRange;
    String[] numsberList01;
    String[] numsberList02;
    BufferedReader br;


    public Day04() throws FileNotFoundException {
        File file = new File(
                "C:\\Users\\jimmy\\IdeaProjects\\advent_of_code_uz\\2022\\Java\\Jumanazar\\day04\\input.txt");
        // Creating an object of BufferedReader class
        br = new BufferedReader(new FileReader(file));
    }

    public int problem01() throws IOException {
        int result = 0;

        // Condition holds true till
        // there is character in a string

        // Q: In how many assignment pairs does one range fully contain the other?
        // to fully contain the other range of numbers, two conditions should hold true:
            // 1st: starting section number (of 1st Elf) should be smaller or equal to the 2nd Elf's starting section AND ending section number (of the 1st Elf) should be greater or equal to the ending section number of the 2nd Elf. Ex: 3-96, 25-96
            // 2nd: starting section number (of 2nd Elf) should be smaller or equal to the 1st Elf's starting section AND ending section number (of the 2nd Elf) should be greater or equal to the ending section number of the 1st Elf. Ex: 25-96, 3-96

        while ((lineStr = br.readLine()) != null){
            numberRange = lineStr.split(",");       // split line into two parts by comma
            numsberList01 = numberRange[0].split("-");  // split numbers by -
            numsberList02 = numberRange[1].split("-");  // split numbers by -

            if(Integer.parseInt(numsberList02[0]) <= Integer.parseInt(numsberList01[0]) &&
            Integer.parseInt(numsberList02[1]) >= Integer.parseInt(numsberList01[1])){
                result++;
            }
            else if(Integer.parseInt(numsberList01[0]) <= Integer.parseInt(numsberList02[0]) &&
                    Integer.parseInt(numsberList01[1]) >= Integer.parseInt(numsberList02[1])){
                result++;
            }
        }
        return result;
    }
    public int problem02() throws IOException {
        int result = 0;

        while ((lineStr = br.readLine()) != null) {
            numberRange = lineStr.split(",");       // split line into two parts by comma
            numsberList01 = numberRange[0].split("-");  // split numbers by -
            numsberList02 = numberRange[1].split("-");  // split numbers by -

//            5-7,7-9 overlaps in a single section, 7.
//            2-8,3-7 overlaps all of the sections 3 through 7.
//            6-6,4-6 overlaps in a single section, 6.
//            2-6,4-8 overlaps in sections 4, 5, and 6.

            if (Integer.parseInt(numsberList01[0]) <= Integer.parseInt(numsberList02[0])) {
                if (Integer.parseInt(numsberList01[1]) >= Integer.parseInt(numsberList02[1]) || Integer.parseInt(numsberList01[1]) >= Integer.parseInt(numsberList02[0])) {
                    result++;
                }
            } else if (Integer.parseInt(numsberList01[0]) >= Integer.parseInt(numsberList02[0])) {
                if (Integer.parseInt(numsberList01[0]) <= Integer.parseInt(numsberList02[1])) {
                    result++;
                }

            }
        }
        return result;
    }
}
