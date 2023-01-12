package day_02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Day2 {
    public int day2_1() throws IOException {
        return solution(1);
    }

    public int day2_2() throws IOException {
        return solution(2);
    }

    private int solution(int num) throws IOException {
        File file = new File("your file path");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        int sum = 0;
        // A-rock, B-Paper, C-Scissors
        // X-rock, Y-Paper, Z-Scissors
        //Rock defeats Scissors, Scissors defeats Paper, and Paper defeats Rock
        if (num == 1) {
            while ((st = br.readLine()) != null) {
                String[] s = st.split(" ");
                sum = getSumOfProblem1(sum, s);
            }
        } else if (num == 2) {
            while ((st = br.readLine()) != null) {
                String[] s = st.split(" ");
                sum = getSumOfProblem2(sum, s);
            }
        }
        return sum;
    }

    private int getSumOfProblem1(int sum, String[] s) {
        if (s[0].equals("A")) {
            if (s[1].equals("X")) {
                sum += 1;
                sum += 3;
            } else if (s[1].equals("Y")) {
                sum += 2;
                sum += 6;
            } else {
                sum += 3;
            }
        } else if (s[0].equals("B")) {
            if (s[1].equals("X")) {
                sum += 1;
            } else if (s[1].equals("Y")) {
                sum += 2;
                sum += 3;
            } else {
                sum += 3;
                sum += 6;
            }
        } else {
            if (s[1].equals("X")) {
                sum += 1;
                sum += 6;
            } else if (s[1].equals("Y")) {
                sum += 2;
            } else {
                sum += 3;
                sum += 3;
            }
        }
        return sum;
    }

    private int getSumOfProblem2(int sum, String[] s) {
        if (s[0].equals("A")) {
            if (s[1].equals("X")) {
                sum += 3;
            } else if (s[1].equals("Y")) {
                sum += 1;
                sum += 3;
            } else {
                sum += 2;
                sum += 6;
            }
        } else if (s[0].equals("B")) {
            if (s[1].equals("X")) {
                sum += 1;
            } else if (s[1].equals("Y")) {
                sum += 2;
                sum += 3;
            } else {
                sum += 3;
                sum += 6;
            }
        } else {
            if (s[1].equals("X")) {
                sum += 2;
            } else if (s[1].equals("Y")) {
                sum += 3;
                sum += 3;
            } else {
                sum += 1;
                sum += 6;
            }
        }
        return sum;
    }
}
