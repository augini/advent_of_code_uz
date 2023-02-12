package day_07;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Day7 {
    public int day7_1() throws IOException {
        File file = new File("C:\\Tokhirjon\\projects\\advent_of_code_uz\\2022\\Java\\Tokhirjon\\day_07\\originalInput");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        String dir = "";
        List<Map<String, String>> map = new ArrayList<>();
        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        list.add("/");
        set.add("/");
        while ((st = br.readLine()) != null) {
            String[] str = st.split(" ");
            if (st.contains("$")) {
                if (str[1].equals("cd")) {
                    if (str[2].equals("/")) {
                        dir = "/";
                    } else if (str[2].equals("..")) {
                        int i = dir.lastIndexOf("$");
                        dir = dir.substring(0, i);
                    } else {
                        dir += "$" + str[2];
                        if (set.add(dir)) list.add(dir);
                    }
                }
            } else {
                Map<String, String> stringMap = new HashMap<>();
                if (str[0].equals("dir")) {
                    stringMap.put(dir, dir + "$" + str[1]);
                } else {
                    stringMap.put(dir, str[0]);
                }
                map.add(stringMap);
            }
        }
        Map<String, Long> longMap = new HashMap<>();
        while (longMap.size() != list.size()) {
            for (int i = list.size() - 1; i >= 0; i--) {
                long temp = 0;
                for (Map<String, String> stringMap : map) {
                    if (stringMap.containsKey(list.get(i))) {
                        boolean b = false;
                        for (char c1 : stringMap.get(list.get(i)).toCharArray()) {
                            if ((c1 >= 'a' && c1 <= 'z') || (c1 >= 'A' && c1 <= 'Z')) {
                                b = true;
                                break;
                            }
                        }
                        if (longMap.containsKey(stringMap.get(list.get(i)))) {
                            temp += longMap.get(stringMap.get(list.get(i)));
                        } else if (b) {
                            break;
                        } else {
                            temp += Long.parseLong(stringMap.get(list.get(i)));
                        }
                    }
                }
                longMap.put(list.get(i), temp);
            }
        }
        int sum = 0;
        for (Map.Entry<String, Long> entry : longMap.entrySet()) {
            if (entry.getValue() <= 100000) {
                sum += entry.getValue();
            }
        }

        return sum;
        // O(N^2 * M)
    }

    public int day7_2() throws IOException {
        File file = new File("C:\\Tokhirjon\\projects\\advent_of_code_uz\\2022\\Java\\Tokhirjon\\day_07\\originalInput");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        String dir = "";
        List<Map<String, String>> map = new ArrayList<>();
        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        list.add("/");
        set.add("/");
        while ((st = br.readLine()) != null) {
            String[] str = st.split(" ");
            if (st.contains("$")) {
                if (str[1].equals("cd")) {
                    if (str[2].equals("/")) {
                        dir = "/";
                    } else if (str[2].equals("..")) {
                        int i = dir.lastIndexOf("$");
                        dir = dir.substring(0, i);
                    } else {
                        dir += "$" + str[2];
                        if (set.add(dir)) list.add(dir);
                    }
                }
            } else {
                Map<String, String> stringMap = new HashMap<>();
                if (str[0].equals("dir")) {
                    stringMap.put(dir, dir + "$" + str[1]);
                } else {
                    stringMap.put(dir, str[0]);
                }
                map.add(stringMap);
            }
        }
        Map<String, Long> longMap = new HashMap<>();
        while (longMap.size() != list.size()) {
            for (int i = list.size() - 1; i >= 0; i--) {
                long temp = 0;
                for (Map<String, String> stringMap : map) {
                    if (stringMap.containsKey(list.get(i))) {
                        boolean b = false;
                        for (char c1 : stringMap.get(list.get(i)).toCharArray()) {
                            if ((c1 >= 'a' && c1 <= 'z') || (c1 >= 'A' && c1 <= 'Z')) {
                                b = true;
                                break;
                            }
                        }
                        if (longMap.containsKey(stringMap.get(list.get(i)))) {
                            temp += longMap.get(stringMap.get(list.get(i)));
                        } else if (b) {
                            break;
                        } else {
                            temp += Long.parseLong(stringMap.get(list.get(i)));
                        }
                    }
                }
                longMap.put(list.get(i), temp);
            }
        }
        long sum = 0;
        for (Map.Entry<String, Long> entry : longMap.entrySet()) {
            if (entry.getKey().equals("/")) {
                sum = entry.getValue();
                break;
            }
        }
        long temp = sum - 40000000;
        long min = Long.MAX_VALUE;
        List<Long> longs = new ArrayList<>();
        for (Map.Entry<String, Long> entry : longMap.entrySet()) {
            if (entry.getValue() >= temp) {
                min = Math.min(min, entry.getValue());
            }
        }
        return (int) min;
    }
}
