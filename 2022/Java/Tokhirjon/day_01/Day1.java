package day_01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Day1 {
    public int problem1() throws Exception {
        // solution method returns 3 max numbers in ascending order and
        // returning the biggest was asked, so I am returning the number in the last index
        return solution()[2];
    }

    public int problem2() throws Exception {
        // solution method returns 3 max numbers in ascending order and
        // returning the sum of those max numbers was asked,
        // so I am returning the sum of them
        int[] solution = solution();
        return solution[0] + solution[1] + solution[2];
    }


    private int[] solution() throws IOException {
        String filePath = "your file path";
        // constant space
        int[] arr = new int[3];

        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        String str;

        int sum = 0;
        // reading all lines from file takes O(N)
        while ((str = bufferedReader.readLine()) != null) {
            if (str.equals("")) {
                if (arr[0] < sum) {
                    arr[0] = sum;
                    // sorting array takes constant time
                    Arrays.sort(arr);
                }
                sum = 0;
            } else {
                sum += Integer.parseInt(str);
            }
        }
        bufferedReader.close();

        if (sum != 0 && arr[0] < sum) {
            arr[0] = sum;
            Arrays.sort(arr);
        }
        return arr;
    }

    /* Big O analyse
     Time Complexity: O(n) -> we have sorting in every loop iteration but
                             since it only contains constant number of items and
                             does not change depending on the input length,
                             it seems to be considered a constant operation
     Space Complexity: O(1) */
}
