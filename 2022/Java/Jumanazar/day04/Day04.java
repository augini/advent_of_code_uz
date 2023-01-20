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
    String[] numbersRange;
    BufferedReader br;
    int result = 0;
    int num1=0,num2=0,num3=0,num4=0;



    public Day04() throws FileNotFoundException {
        File file = new File(
                "C:\\Users\\jimmy\\IdeaProjects\\advent_of_code_uz\\2022\\Java\\Jumanazar\\day04\\input.txt");
        // Creating an object of BufferedReader class
        br = new BufferedReader(new FileReader(file));
    }

    public int problem01() throws IOException {
            result = 0;
        // Condition holds true till
        // there is character in a string

        // Q: In how many assignment pairs does one range fully contain the other?
        // to fully contain the other range of numbers, two conditions should hold true:
            // 1st: starting section number (of 1st Elf) should be smaller or equal to the 2nd Elf's starting section AND ending section number (of the 1st Elf) should be greater or equal to the ending section number of the 2nd Elf. Ex: 3-96, 25-96
            // 2nd: starting section number (of 2nd Elf) should be smaller or equal to the 1st Elf's starting section AND ending section number (of the 2nd Elf) should be greater or equal to the ending section number of the 1st Elf. Ex: 25-96, 3-96

        while ((lineStr = br.readLine()) != null){
            numbersRange = lineStr.split("[-,]");
            num1 = Integer.parseInt(numbersRange[0]);
            num2 = Integer.parseInt(numbersRange[1]);
            num3 = Integer.parseInt(numbersRange[2]);
            num4 = Integer.parseInt(numbersRange[3]);

            if(num3 <= num1 && num3 >= num2){
                System.out.println(lineStr + " FULLY OVERLAPS");
                result++;
            }
            else if(num1 <= num2 && num2 >= num4){
                System.out.println(lineStr + " FULLY OVERLAPS");
                result++;
            }
            else {
                System.out.println(lineStr + " NOT OVERLAPS");
            }
        }
        return result;
    }
    public int problem02() throws IOException {
        result = 0;
        while ((lineStr = br.readLine()) != null) {
            numbersRange = lineStr.split("[-,]");       // split line into two parts by comma
            num1=Integer.parseInt(numbersRange[0]);
            num2=Integer.parseInt(numbersRange[1]);
            num3=Integer.parseInt(numbersRange[2]);
            num4=Integer.parseInt(numbersRange[3]);

// strategy: Check the cases when it does not overlap at all, and count the overlapping ones in else condition!
            // two non-overlapping cases:
            // 2-3, 4-5
            //4-5, 2-3

            if (num2 < num3 || num1 > num4) {
                System.out.println(lineStr + " NOT OVERLAPPING");
                continue;
            }
            else{
                result++;
                System.out.println(lineStr + " OVERLAPS");
            }
        }
        return result;
    }
}
