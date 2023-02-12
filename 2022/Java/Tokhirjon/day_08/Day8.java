package day_08;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Day8 {
    public int day8_1() throws IOException {
        File file = new File("C:\\Tokhirjon\\projects\\advent_of_code_uz\\2022\\Java\\Tokhirjon\\day_08\\originalInput");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        List<String> list = new ArrayList<>();
        while ((st = br.readLine()) != null) {
            list.add(st);
        }
        int sum = list.size() * 2 + list.get(0).length() + list.get(list.size() - 1).length() - 4;
        for (int i = 1; i < list.size() - 1; i++) { // N
            for (int i1 = 1; i1 < list.get(i).toCharArray().length - 1; i1++) { // M=line.length()
                boolean b1 = true;
                boolean b2 = true;
                boolean b3 = true;
                boolean b4 = true;
                for (int i2 = i1 + 1; i2 < list.get(i).toCharArray().length; i2++) { // M=line.length()
                    if (list.get(i).charAt(i2) >= list.get(i).charAt(i1)) b1 = false;
                }
                for (int i2 = 0; i2 < i1; i2++) { //M=line.length()
                    if (list.get(i).charAt(i2) >= list.get(i).charAt(i1)) b2 = false;
                }
                for (int i2 = 0; i2 < i; i2++) { // N
                    if (list.get(i2).charAt(i1) >= list.get(i).charAt(i1)) b3 = false;
                }
                for (int i2 = i + 1; i2 < list.size(); i2++) { //N
                    if (list.get(i2).charAt(i1) >= list.get(i).charAt(i1)) b4 = false;
                }
                if (b1 || b2 || b3 || b4) sum++;
            }
            // O(N * M * (N+M))
        }
        return sum;
    }

    public int day8_2() throws IOException {
        File file = new File("C:\\Tokhirjon\\projects\\advent_of_code_uz\\2022\\Java\\Tokhirjon\\day_08\\originalInput");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        List<String> list = new ArrayList<>();
        while ((st = br.readLine()) != null) {
            list.add(st);
        }
        Set<Integer> set = new TreeSet<>();
        for (int i = 1; i < list.size() - 1; i++) {
            for (int i1 = 1; i1 < list.get(i).toCharArray().length - 1; i1++) {
                int cnt1 = 0, cnt2 = 0, cnt3 = 0, cnt4 = 0;
                for (int i2 = i1 + 1; i2 < list.get(i).toCharArray().length; i2++) {
                    cnt1++;
                    if (list.get(i).charAt(i2) >= list.get(i).charAt(i1)) {
                        break;
                    }
                }
                for (int i2 = i1 - 1; i2 >= 0; i2--) {
                    cnt2++;
                    if (list.get(i).charAt(i2) >= list.get(i).charAt(i1)) {
                        break;
                    }
                }
                for (int i2 = i - 1; i2 >= 0; i2--) {
                    cnt3++;
                    if (list.get(i2).charAt(i1) >= list.get(i).charAt(i1)) {
                        break;
                    }
                }
                for (int i2 = i + 1; i2 < list.size(); i2++) {
                    cnt4++;
                    if (list.get(i2).charAt(i1) >= list.get(i).charAt(i1)) {
                        break;
                    }
                }
                set.add(cnt1 * cnt2 * cnt3 * cnt4);
            }
        }
        int sum = 0;
        for (Integer integer : set) {
            sum = integer;
        }
        return sum;
    }
}
