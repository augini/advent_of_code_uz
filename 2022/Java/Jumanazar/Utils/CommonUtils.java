/**
 * author: Jumanazar Said
 * email: jumanazarsaidov@gmail.com
 * date: 2023/01/19 18:14
 */

package Utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CommonUtils {

    public static List<List<Integer>> getListNumbers(String path) throws IOException {
        List<Integer> numberList = null;
        List<List<Integer>> result = new ArrayList<>();
        File file = new File(
                "C:\\Users\\jimmy\\IdeaProjects\\advent_of_code_uz\\2022\\Java\\Jumanazar\\day04\\input.txt");

        // Creating an object of BufferedReader class
        BufferedReader br
                = new BufferedReader(new FileReader(file));

        // Declaring a string variable
        String lineStr;
        String[] numberRange;
        String[] numbers;

        // Condition holds true till
        // there is character in a string
        while ((lineStr = br.readLine()) != null){
            numberRange = lineStr.split(",");
            numberList = new ArrayList<>();
            for (String range : numberRange) {
                numbers = range.split("-");
                for (String number : numbers) {
                    numberList.add(Integer.parseInt(number));
                }
            }
            result.add(numberList);
        }

        return result;
    }
}
