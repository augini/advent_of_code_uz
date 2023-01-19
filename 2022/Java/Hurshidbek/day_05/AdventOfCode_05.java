package day_05;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: Kodirov Hurshidbek
 * Date : 18.01.2023
 * Time : 23:00 PM
 */

public class AdventOfCode_05 {

    String filePath;
    List<Stack<Character>> stacksFor1 = new ArrayList<>();
    List<Stack<Character>> stacksFor2 = new ArrayList<>();


    public AdventOfCode_05(String filePath) throws IOException {
        this.filePath = filePath;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));

        for (int i = 0; i < 9; i++) {
            stacksFor1.add(new Stack<>());
            stacksFor2.add(new Stack<>());
        }

        List<Stack<Character>> temp = new ArrayList<>();
        for (int i = 0; i < 9; i++) temp.add(new Stack<>());

        String s;
        while ((s = bufferedReader.readLine()) != null) {
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

        bufferedReader.close();
    }

    public String aoc5_1() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        String s;
        while ((s = bufferedReader.readLine()) != null) {
            if (s.length() > 0 && s.charAt(0) == 'm'){
                String[] str = s.split(" ");

                int count = Integer.parseInt(str[1]);
                int from = Integer.parseInt(str[3]);
                int to = Integer.parseInt(str[5]);

                for (int i = 0; i < count; i++) {
                    stacksFor1.get(to - 1).push(stacksFor1.get(from - 1).pop());
                }
            }
        }

        String ans = "";
        for (Stack st : stacksFor1) {
            ans += st.peek();
        }

        bufferedReader.close();

        return ans;
    }

    public String aoc5_2() throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        String s;
        while ((s = bufferedReader.readLine()) != null) {
            if (s.length() > 0 && s.charAt(0) == 'm'){
                String[] str = s.split(" ");

                int count = Integer.parseInt(str[1]);
                int from = Integer.parseInt(str[3]);
                int to = Integer.parseInt(str[5]);

                Stack<Character> st = new Stack();

                for (int i = 0; i < count; i++) {
                    st.push(stacksFor2.get(from - 1).pop());
                }

                for (int i = 0; i < count; i++) {
                    stacksFor2.get(to - 1).push(st.pop());
                }
            }
        }
        String ans = "";
        for (Stack st : stacksFor2) {
            ans += st.peek();
        }

        bufferedReader.close();

        return ans;
    }

    /* Big O analyse
     Time Complexity:  ;
     Space Complexity:  */

}
