package day_09;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Day9 {
    public int day9_1() throws IOException {
        File file = new File("C:\\Tokhirjon\\projects\\advent_of_code_uz\\2022\\Java\\Tokhirjon\\day_09\\originalInput");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        int sum = 0, hx = 0, hy = 0, tx = 0, ty = 0;
        Set<List<Integer>> set = new LinkedHashSet<>();
        while ((st = br.readLine()) != null) {
            String[] split = st.split(" ");
            if (split[0].equals("R")) {
                hx += Integer.parseInt(split[1]);
                int init = tx;
                if (hy - ty == 0) {
                    for (int i = init; i < hx; i++) {
                        List<Integer> list = new ArrayList<>();
                        tx = i;
                        list.add(tx);
                        list.add(ty);
                        set.add(list);
                    }
                } else {
                    if (hx > tx + 1) {
                        ty = hy;
                        init += 1;
                        for (int i = init; i < hx; i++) {
                            List<Integer> list = new ArrayList<>();
                            tx = i;
                            list.add(tx);
                            list.add(ty);
                            set.add(list);
                        }
                    }
                }
            } else if (split[0].equals("U")) {
                hy += Integer.parseInt(split[1]);
                int init = ty;
                if (hx - tx == 0) {
                    for (int i = init; i < hy; i++) {
                        List<Integer> list = new ArrayList<>();
                        ty = i;
                        list.add(tx);
                        list.add(ty);
                        set.add(list);
                    }
                } else {
                    if (hy > ty + 1) {
                        tx = hx;
                        init += 1;
                        for (int i = init; i < hy; i++) {
                            List<Integer> list = new ArrayList<>();
                            ty = i;
                            list.add(tx);
                            list.add(ty);
                            set.add(list);
                        }
                    }
                }
            } else if (split[0].equals("L")) {
                hx -= Integer.parseInt(split[1]);
                int init = tx;
                if (hy - ty == 0) {
                    for (int i = init; i > hx; i--) {
                        List<Integer> list = new ArrayList<>();
                        tx = i;
                        list.add(tx);
                        list.add(ty);
                        set.add(list);
                    }
                } else {
                    if (hx < tx - 1) {
                        ty = hy;
                        init -= 1;
                        for (int i = init; i > hx; i--) {
                            List<Integer> list = new ArrayList<>();
                            tx = i;
                            list.add(tx);
                            list.add(ty);
                            set.add(list);
                        }
                    }
                }
            } else {
                hy -= Integer.parseInt(split[1]);
                int init = ty;
                if (hx - tx == 0) {
                    for (int i = init; i > hy; i--) {
                        List<Integer> list = new ArrayList<>();
                        ty = i;
                        list.add(tx);
                        list.add(ty);
                        set.add(list);
                    }
                } else {
                    if (hy < ty - 1) {
                        tx = hx;
                        init -= 1;
                        for (int i = init; i > hy; i--) {
                            List<Integer> list = new ArrayList<>();
                            ty = i;
                            list.add(tx);
                            list.add(ty);
                            set.add(list);
                        }
                    }
                }
            }
        }
        return set.size();
    }
}
