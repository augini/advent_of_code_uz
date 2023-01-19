package day_03;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day3 {
    protected int problem1() throws IOException {
        return solution(1);
    }

    protected int problem2() throws IOException {
        return solution(2);
    }

    private int solution(int num) throws IOException {
        File file = new File("your file path");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        int sum = 0;
        Map<Character, Integer> map = new HashMap<>();
        char c = 'a';
        for (int i = 1; i <= 26; i++) {
            map.put(c++, i);
        }
        c = 'A';
        for (int i = 27; i <= 52; i++) {
            map.put(c++, i);
        }
        if (num == 1) {
            while ((st = br.readLine()) != null) {
                String str1 = st.substring(0, st.length() / 2);
                String str2 = st.substring(st.length() / 2);
                char ch = 'a';
                for (char c1 : str1.toCharArray()) {
                    if (str2.contains(String.valueOf(c1))) {
                        ch = c1;
                        break;
                    }
                }
                sum += map.get(ch);
            }
        } else if (num == 2) {
            List<List<String>> lists = new ArrayList<>();
            List<String> list = new ArrayList<>();
            while ((st = br.readLine()) != null) {
                list.add(st);
                if (list.size() == 3) {
                    lists.add(list);
                    list = new ArrayList<>();
                }
            }
            char ch = 'a';
            for (List<String> strings : lists) {
                String s = strings.get(0);
                String s1 = strings.get(1);
                String s2 = strings.get(2);
                for (char c1 : s.toCharArray()) {
                    if (s1.contains(String.valueOf(c1)) && s2.contains(String.valueOf(c1))) {
                        ch = c1;
                        break;
                    }
                }
                sum += map.get(ch);
            }
        }

        return sum;
    }
}
