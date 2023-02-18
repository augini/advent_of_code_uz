package day_12;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Day12 {
    public int day12_1() throws IOException {
        File file = new File("C:\\Tokhirjon\\projects\\advent_of_code_uz\\2022\\Java\\Tokhirjon\\day_12\\originalInput");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        List<String> list = new ArrayList<>();

        while ((st = br.readLine()) != null) {
            list.add(st);
        }

        int startX = 0, startY = 0, endX = 0, endY = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).contains("S")) {
                startY = i;
                startX = list.get(i).indexOf("S");
            }
            if (list.get(i).contains("E")) {
                endY = i;
                endX = list.get(i).indexOf("E");
            }
        }

        int n = list.get(0).length(), m = list.size();
        Queue<List<Integer>> queue = new ArrayDeque<>();
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(List.of(startX, startY));
        queue.add(List.of(startX, startY));
        boolean b = true;
        int cnt = 0;
        while (b) {
            Queue<List<Integer>> newQueue = new ArrayDeque<>();
            for (List<Integer> list1 : queue) {
                Integer x = list1.get(0);
                Integer y = list1.get(1);
                if (((x - 1 == endX && y == endY) && (list.get(y).charAt(x) == 'z'))
                        || ((x + 1 == endX && y == endY) && (list.get(y).charAt(x) == 'z'))
                        || ((x == endX && y - 1 == endY) && (list.get(y).charAt(x) == 'z'))
                        || ((x == endX && y + 1 == endY) && (list.get(y).charAt(x) == 'z'))) {
                    b = false;
                }
                else {
                    if ((x - 1 >= 0)
                            && !lists.contains(List.of(x - 1, y))) {
                        if ((list.get(y).charAt(x) == 'S' && list.get(y).charAt(x - 1) == 'a')
                                || (list.get(y).charAt(x - 1) - list.get(y).charAt(x) <= 1)) {
                            newQueue.add(List.of(x - 1, y));
                            lists.add(List.of(x - 1, y));
                        }
                    }
                    if ((x + 1 < n)
                            && !lists.contains(List.of(x + 1, y))) {
                        if ((list.get(y).charAt(x) == 'S' && list.get(y).charAt(x + 1) == 'a')
                                || (list.get(y).charAt(x + 1) - list.get(y).charAt(x) <= 1)) {
                            newQueue.add(List.of(x + 1, y));
                            lists.add(List.of(x + 1, y));
                        }
                    }
                    if ((y - 1 >= 0)
                            && !lists.contains(List.of(x, y - 1))) {
                        if ((list.get(y).charAt(x) == 'S' && list.get(y - 1).charAt(x) == 'a')
                                || (list.get(y - 1).charAt(x) - list.get(y).charAt(x) <= 1)) {
                            newQueue.add(List.of(x, y - 1));
                            lists.add(List.of(x, y - 1));
                        }
                    }
                    if ((y + 1 < m)
                            && !lists.contains(List.of(x, y + 1))) {
                        if ((list.get(y).charAt(x) == 'S' && list.get(y + 1).charAt(x) == 'a')
                                || (list.get(y + 1).charAt(x) - list.get(y).charAt(x) <= 1)) {
                            newQueue.add(List.of(x, y + 1));
                            lists.add(List.of(x, y + 1));
                        }
                    }
                }
            }
            queue = newQueue;
            cnt++;
        }

        return cnt;
    }

    public int day12_2() throws IOException {
        File file = new File("C:\\Tokhirjon\\projects\\advent_of_code_uz\\2022\\Java\\Tokhirjon\\day_12\\originalInput");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        List<String> list = new ArrayList<>();

        while ((st = br.readLine()) != null) {
            list.add(st);
        }

        int startX = 0, startY = 0, endX = 0, endY = 0;
        List<List<Integer>> listList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).contains("S")) {
                startY = i;
                startX = list.get(i).indexOf("S");
            } else if (list.get(i).contains("a")) {
                startY = i;
                startX = list.get(i).indexOf("a");
            }
            if (list.get(i).contains("E")) {
                endY = i;
                endX = list.get(i).indexOf("E");
            }
            listList.add(List.of(startX, startY));
        }

        List<Integer> res = new ArrayList<>();
        int n = list.get(0).length(), m = list.size();
        for (List<Integer> integers : listList) {
            startX = integers.get(0);
            startY = integers.get(1);
            Queue<List<Integer>> queue = new ArrayDeque<>();
            List<List<Integer>> lists = new ArrayList<>();
            lists.add(List.of(startX, startY));
            queue.add(List.of(startX, startY));
            boolean b = true;
            int cnt = 0;
            while (b) {
                Queue<List<Integer>> newQueue = new ArrayDeque<>();
                for (List<Integer> list1 : queue) {
                    Integer x = list1.get(0);
                    Integer y = list1.get(1);
                    if (((x - 1 == endX && y == endY) && (list.get(y).charAt(x) == 'z'))
                            || ((x + 1 == endX && y == endY) && (list.get(y).charAt(x) == 'z'))
                            || ((x == endX && y - 1 == endY) && (list.get(y).charAt(x) == 'z'))
                            || ((x == endX && y + 1 == endY) && (list.get(y).charAt(x) == 'z'))) {
                        b = false;
                    }
                    else {
                        if ((x - 1 >= 0)
                                && !lists.contains(List.of(x - 1, y))) {
                            if ((list.get(y).charAt(x) == 'S' && list.get(y).charAt(x - 1) == 'a')
                                    || (list.get(y).charAt(x - 1) - list.get(y).charAt(x) <= 1)) {
                                newQueue.add(List.of(x - 1, y));
                                lists.add(List.of(x - 1, y));
                            }
                        }
                        if ((x + 1 < n)
                                && !lists.contains(List.of(x + 1, y))) {
                            if ((list.get(y).charAt(x) == 'S' && list.get(y).charAt(x + 1) == 'a')
                                    || (list.get(y).charAt(x + 1) - list.get(y).charAt(x) <= 1)) {
                                newQueue.add(List.of(x + 1, y));
                                lists.add(List.of(x + 1, y));
                            }
                        }
                        if ((y - 1 >= 0)
                                && !lists.contains(List.of(x, y - 1))) {
                            if ((list.get(y).charAt(x) == 'S' && list.get(y - 1).charAt(x) == 'a')
                                    || (list.get(y - 1).charAt(x) - list.get(y).charAt(x) <= 1)) {
                                newQueue.add(List.of(x, y - 1));
                                lists.add(List.of(x, y - 1));
                            }
                        }
                        if ((y + 1 < m)
                                && !lists.contains(List.of(x, y + 1))) {
                            if ((list.get(y).charAt(x) == 'S' && list.get(y + 1).charAt(x) == 'a')
                                    || (list.get(y + 1).charAt(x) - list.get(y).charAt(x) <= 1)) {
                                newQueue.add(List.of(x, y + 1));
                                lists.add(List.of(x, y + 1));
                            }
                        }
                    }
                }
                queue = newQueue;
                cnt++;
            }
            res.add(cnt);
        }

        Collections.sort(res);
        return res.get(0);
    }
}
