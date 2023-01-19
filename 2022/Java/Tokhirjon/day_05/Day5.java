package day_05;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Day5 {
    protected String problem1() throws IOException {
        return calculate(1);
    }

    protected String problem2() throws IOException {
        return calculate(2);
    }

    private String calculate(int num) throws IOException {
        List<Stack<Character>> stacksFor1 = new ArrayList<>();
        List<Stack<Character>> stacksFor2 = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            stacksFor1.add(new Stack<>());
            stacksFor2.add(new Stack<>());
        }
        List<Stack<Character>> temp = new ArrayList<>();
        for (int i = 0; i < 9; i++) temp.add(new Stack<>());

        String filepath = "your file path";
        File file = new File(filepath);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String s;
        while ((s = br.readLine()) != null) {
            if (s.length() == 0 || s.charAt(1) == '1')
                break;

            for (int i = 1; i < s.length(); i += 4) {
                if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                    temp.get(i / 4).push(s.charAt(i));
                }
            }

        }

        for (int i = 0; i < stacksFor1.size(); i++) {
            while (!temp.get(i).isEmpty()) {
                char pop = temp.get(i).pop();
                stacksFor1.get(i).push(pop);
                stacksFor2.get(i).push(pop);
            }
        }


        int sum = 0;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filepath));
        String st;
        switch (num) {
            case 1: {
                while ((st = bufferedReader.readLine()) != null) {
                    if (st.length() > 0 && st.charAt(0) == 'm') {
                        String[] str = st.split(" ");

                        int count = Integer.parseInt(str[1]);
                        int from = Integer.parseInt(str[3]);
                        int to = Integer.parseInt(str[5]);

                        for (int i = 0; i < count; i++) {
                            stacksFor1.get(to - 1).push(stacksFor1.get(from - 1).pop());
                        }
                    }
                }

                String ans = "";
                for (Stack str : stacksFor1) {
                    ans += str.peek();
                }

                bufferedReader.close();

                return ans;
            }
            case 2: {
                while ((st = bufferedReader.readLine()) != null) {
                    if (st.length() > 0 && st.charAt(0) == 'm') {
                        String[] str = st.split(" ");

                        int count = Integer.parseInt(str[1]);
                        int from = Integer.parseInt(str[3]);
                        int to = Integer.parseInt(str[5]);

                        Stack<Character> stack = new Stack();

                        for (int i = 0; i < count; i++) {
                            stack.push(stacksFor2.get(from - 1).pop());
                        }

                        for (int i = 0; i < count; i++) {
                            stacksFor2.get(to - 1).push(stack.pop());
                        }
                    }
                }
                String ans = "";
                for (Stack stack : stacksFor2) {
                    ans += stack.peek();
                }

                bufferedReader.close();

                return ans;
            }
        }
        return "";
    }
}
