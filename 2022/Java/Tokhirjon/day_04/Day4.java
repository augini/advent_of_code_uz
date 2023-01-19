package day_04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Day4 {
    protected int problem1() throws IOException {
        return calculate(1);
    }

    protected int problem2() throws IOException {
        return calculate(2);
    }

    private int calculate(int num) throws IOException {
        File file = new File("your file path");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        int sum = 0;
        switch (num) {
            case 1: {
                while ((st = br.readLine()) != null) {
                    String[] split = st.split(",");
                    String[] split1 = split[0].split("-");
                    String[] split2 = split[1].split("-");
                    int num1 = Integer.parseInt(split1[0]);
                    int num2 = Integer.parseInt(split1[1]);
                    int num3 = Integer.parseInt(split2[0]);
                    int num4 = Integer.parseInt(split2[1]);
                    if ((num1 <= num3 && num2 >= num4) || (num1 >= num3 && num2 <= num4)) sum++;
                }
                break;
            }
            case 2: {
                while ((st = br.readLine()) != null) {
                    String[] split = st.split(",");
                    String[] split1 = split[0].split("-");
                    String[] split2 = split[1].split("-");
                    int num1 = Integer.parseInt(split1[0]);
                    int num2 = Integer.parseInt(split1[1]);
                    int num3 = Integer.parseInt(split2[0]);
                    int num4 = Integer.parseInt(split2[1]);
                    if ((num1 <= num3 && num2 >= num4) || (num1 >= num3 && num2 <= num4) || (num1 <= num3 && num2 >= num3) || (num1 <= num4 && num2 >= num4))
                        sum++;
                }
                break;
            }
        }
        return sum;
    }
}
