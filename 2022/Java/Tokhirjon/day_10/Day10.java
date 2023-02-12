package day_10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Day10 {
    public int day10_1() throws IOException {
        File file = new File("C:\\Tokhirjon\\projects\\advent_of_code_uz\\2022\\Java\\Tokhirjon\\day_10\\originalInput");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        int cnt = 0, res = 0, sum = 1;
        Map<Integer, Integer> map = new HashMap<>();
        while ((st = br.readLine()) != null) {
            String[] str = st.split(" ");
            if (str[0].equals("noop")) {
                cnt++;
                map.put(cnt, sum);
            } else {
                map.put(cnt + 1, sum);
                cnt += 2;
                map.put(cnt, sum);
                sum += Integer.parseInt(str[1]);
            }
        }
        res += 20 * map.get(20) + map.get(60) * 60 + map.get(100) * 100 + map.get(140) * 140 + map.get(180) * 180 + map.get(220) * 220;

        return res;
    }

    public void day10_2() throws IOException {
        File file = new File("C:\\Tokhirjon\\projects\\advent_of_code_uz\\2022\\Java\\Tokhirjon\\day_10\\originalInput");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        int cnt = 0, res = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while ((st = br.readLine()) != null) {
            String[] str = st.split(" ");
            if (cnt >= 40) {
                System.out.println();
                cnt = 0;
            }
            if (str[0].equals("noop")) {
                if (sum == cnt || sum + 1 == cnt || sum + 2 == cnt) {
                    System.out.print("# ");
                } else {
                    System.out.print("  ");
                }
                cnt++;
            } else {
                if (sum == cnt || sum + 1 == cnt || sum + 2 == cnt) {
                    System.out.print("# ");
                } else {
                    System.out.print("  ");
                }
                cnt++;
                if (cnt >= 40) {
                    System.out.println();
                    cnt = 0;
                }
                if (sum == cnt || sum + 1 == cnt || sum + 2 == cnt) {
                    System.out.print("# ");
                } else {
                    System.out.print("  ");
                }
                cnt++;
                sum += Integer.parseInt(str[1]);
            }
        }
    }
}
