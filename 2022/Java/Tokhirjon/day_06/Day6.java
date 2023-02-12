package day_06;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Day6 {
    public int day6_1() throws IOException {
        File file = new File("C:\\Tokhirjon\\projects\\advent_of_code_uz\\2022\\Java\\Tokhirjon\\day_06\\originalInput");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st = br.readLine();
        int count = 0;
        StringBuilder win = new StringBuilder();
        for (int i = 0; i < st.toCharArray().length; i++) {
            int index = win.indexOf(String.valueOf(st.charAt(i)));
            if (index != -1) {
                for (int j = 0; j <= index; j++) {
                    win = new StringBuilder(win.substring(1));
                }
            }
            win.append(st.charAt(i));
            count++;

            if (win.length() == 4) {
                break;
            }
        }
        return count;
    }

    public int day6_2() throws IOException {
        File file = new File("C:\\Tokhirjon\\projects\\advent_of_code_uz\\2022\\Java\\Tokhirjon\\day_06\\originalInput");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st = br.readLine();
        int count = 0;
        StringBuilder win = new StringBuilder();
        for (int i = 0; i < st.toCharArray().length; i++) {
            int index = win.indexOf(String.valueOf(st.charAt(i)));
            if (index != -1) {
                for (int j = 0; j <= index; j++) {
                    win = new StringBuilder(win.substring(1));
                }
            }
            win.append(st.charAt(i));
            count++;

            if (win.length() == 14) {
                break;
            }
        }
        return count;
    }
}
