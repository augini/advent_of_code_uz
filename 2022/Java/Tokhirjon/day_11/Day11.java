package day_11;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Day11 {
    public void day11_1() throws IOException {
        File file = new File("C:\\Tokhirjon\\projects\\advent_of_code_uz\\2022\\Java\\Tokhirjon\\day_11\\sampleInput");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        List<Queue<Integer>> queues = new ArrayList<>();
        List<Stack<Integer>> stacks = new ArrayList<>();
        List<String> operation = new ArrayList<>();
        List<Integer> test = new ArrayList<>();
        List<Integer> ifTrue = new ArrayList<>();
        List<Integer> ifFalse = new ArrayList<>();
        int pos = 0;
        while ((st = br.readLine()) != null) {
            String[] s = st.trim().split(" ");
            if (s.length == 2) {
                pos = Integer.parseInt(s[1].substring(0, 1));
            } else {
                switch (s[0]) {
                    case "Starting": {
                        Queue<Integer> queue = new ArrayDeque<>();
                        Stack<Integer> stack = new Stack<>();
                        for (int i = 2; i < s.length; i++) {
                            if (s[i].endsWith(",")) {
                                queue.add(Integer.valueOf(s[i].substring(0, s[i].length() - 1)));
                                stack.add(Integer.valueOf(s[i].substring(0, s[i].length() - 1)));
                            } else {
                                queue.add(Integer.valueOf(s[i]));
                                stack.add(Integer.valueOf(s[i]));
                            }
                        }
                        stacks.add(stack);
                        queues.add(queue);
                        break;
                    }
                    case "Operation:": {
                        operation.add(s[4] + s[5]);
                        break;
                    }
                    case "Test:": {
                        test.add(Integer.valueOf(s[3]));
                        break;
                    }
                    case "If": {
                        if (s[1].equals("true:")) {
                            ifTrue.add(Integer.valueOf(s[5]));
                        } else {
                            ifFalse.add(Integer.valueOf(s[5]));
                        }
                    }
                }
            }
        }
        int sum = 1;
        for (Integer integer : test) {
            sum *= integer;
        }
        System.out.println(sum);
        int cnt = 0;
        while (cnt != 10000) {
            for (int i = 0; i < queues.size(); i++) {
                Queue<Integer> queue = queues.get(i);
                while (!queue.isEmpty()) {
                    Integer remove = queue.remove();
                    if (operation.get(i).substring(1).equals("old")) {
                        remove *= remove;
                    } else {
                        if (operation.get(i).charAt(0) == '*') {
                            remove *= Integer.parseInt(operation.get(i).substring(1));
                        } else {
                            remove += Integer.parseInt(operation.get(i).substring(1));
                        }
                    }
//                    remove /= 3;
                    remove = remove % sum;
                    if (remove % test.get(i) == 0) {
                        queues.get(ifTrue.get(i)).add(remove);
                        if (cnt == 9999 && i > ifTrue.get(i)) {
                            continue;
                        }
                        stacks.get(ifTrue.get(i)).add(remove);
                    } else {
                        queues.get(ifFalse.get(i)).add(remove);
                        if (cnt == 9999 && i > ifFalse.get(i)) {
                            continue;
                        }
                        stacks.get(ifFalse.get(i)).add(remove);
                    }
                }
            }
            cnt++;
        }
        for (Stack<Integer> stack : stacks) {
            System.out.println(stack.size());
        }
    }

    public void day11_2() throws IOException {
        File file = new File("C:\\Tokhirjon\\projects\\advent_of_code_uz\\2022\\Java\\Tokhirjon\\day_11\\originalInput");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        List<Queue<String>> queues = new ArrayList<>();
        List<Stack<String>> stacks = new ArrayList<>();
        List<String> operation = new ArrayList<>();
        List<Integer> test = new ArrayList<>();
        List<Integer> ifTrue = new ArrayList<>();
        List<Integer> ifFalse = new ArrayList<>();
        int pos = 0;
        while ((st = br.readLine()) != null) {
            String[] s = st.trim().split(" ");
            if (s.length == 2) {
                pos = Integer.parseInt(s[1].substring(0, 1));
            } else {
                switch (s[0]) {
                    case "Starting": {
                        Queue<String> queue = new ArrayDeque<>();
                        Stack<String> stack = new Stack<>();
                        for (int i = 2; i < s.length; i++) {
                            if (s[i].endsWith(",")) {
                                queue.add(s[i].substring(0, s[i].length() - 1));
                                stack.add(s[i].substring(0, s[i].length() - 1));
                            } else {
                                queue.add(s[i]);
                                stack.add(s[i]);
                            }
                        }
                        stacks.add(stack);
                        queues.add(queue);
                        break;
                    }
                    case "Operation:": {
                        operation.add(s[4] + s[5]);
                        break;
                    }
                    case "Test:": {
                        test.add(Integer.valueOf(s[3]));
                        break;
                    }
                    case "If": {
                        if (s[1].equals("true:")) {
                            ifTrue.add(Integer.valueOf(s[5]));
                        } else {
                            ifFalse.add(Integer.valueOf(s[5]));
                        }
                    }
                }
            }
        }
        int sum = 1;
        for (Integer integer : test) {
            sum *= integer;
        }
        int cnt = 0;
        while (cnt != 10000) {
            for (int i = 0; i < queues.size(); i++) {
                Queue<String> queue = queues.get(i);
                while (!queue.isEmpty()) {
                    String remove = queue.remove();
                    if (operation.get(i).substring(1).equals("old")) {
                        remove = multiply(remove, remove);
                    } else {
                        if (operation.get(i).charAt(0) == '*') {
                            remove = multiply(remove, operation.get(i).substring(1));
                        } else {
                            remove = add(remove, operation.get(i).substring(1));
                        }
                    }

                    if (isDivisible(remove, test.get(i))) {
                        queues.get(ifTrue.get(i)).add(remove);
                        if (cnt == 9999 && i > ifTrue.get(i)) {
                            continue;
                        }
                        stacks.get(ifTrue.get(i)).add(remove);
                    } else {
                        queues.get(ifFalse.get(i)).add(remove);
                        if (cnt == 9999 && i > ifFalse.get(i)) {
                            continue;
                        }
                        stacks.get(ifFalse.get(i)).add(remove);
                    }
                }
            }
            cnt++;
        }
        for (Stack<String> stack : stacks) {
            System.out.println(stack.size());
        }
    }

    public boolean isDivisible(String number, int divider) {
        boolean b = false;
        switch (divider) {
            case 2: {
                char c = number.charAt(number.length() - 1);
                if ((c - '0') % 2 == 0) b = true;
                break;
            }
            case 3: {
                long sum = 0;
                for (char c : number.toCharArray()) {
                    sum += c - '0';
                }
                if (sum % 3 == 0) b = true;
                break;
            }
            case 5: {
                char c = number.charAt(number.length() - 1);
                if ((c - '0') % 5 == 0) b = true;
                break;
            }
            case 7: {
                boolean b1 = true;
                while (b1) {
                    char c = number.charAt(number.length() - 1);
                    number = number.substring(0, number.length() - 1);
                    String res = findDiff(number, String.valueOf((c - '0') * 2));
                    if (res.length() <= 5) {
                        if (Integer.parseInt(res) % 7 == 0) {
                            b = true;
                        }
                        b1 = false;
                    } else {
                        number = res;
                    }
                }
                break;
            }
            case 11: {
                long odd = 0;
                long even = 0;
                for (int i = 0; i < number.length(); i += 2) {
                    even += number.charAt(i) - '0';
                }
                for (int i = 1; i < number.length(); i += 2) {
                    odd += number.charAt(i) - '0';
                }
                if (Math.abs(even - odd) % 11 == 0) b = true;
                break;
            }
            case 13: {
                List<Long> longs = new ArrayList<>();
                long sum = 0;
                String s = "";
                int count = 0;
                for (int i = number.length() - 1; i >= 0; i--) {
                    s += number.charAt(i);
                    count++;
                    if (count == 3) {
                        longs.add(Long.parseLong(s));
                        s = "";
                        count = 0;
                    }
                }
                boolean b1 = true;
                for (Long aLong : longs) {
                    if (b1) {
                        sum += aLong;
                        b1 = false;
                    } else {
                        sum -= aLong;
                        b1 = true;
                    }
                }
                if (sum % 13 == 0) b = true;
                break;
            }
            case 17: {
                boolean b1 = true;
                while (b1) {
                    char c = number.charAt(number.length() - 1);
                    number = number.substring(0, number.length() - 1);
                    String res = findDiff(number, String.valueOf((c - '0') * 5));
                    if (res.length() <= 5) {
                        if (Integer.parseInt(res) % 17 == 0) {
                            b = true;
                        }
                        b1 = false;
                    } else {
                        number = res;
                    }
                }
                break;
            }
            case 19: {
                boolean b1 = true;
                while (b1) {
                    char c = number.charAt(number.length() - 1);
                    number = number.substring(0, number.length() - 1);
                    String res = add(number, String.valueOf((c - '0') * 2));
                    if (res.length() <= 5) {
                        if (Integer.parseInt(res) % 19 == 0) {
                            b = true;
                        }
                        b1 = false;
                    } else {
                        number = res;
                    }
                }
                break;
            }
        }
        return b;
    }

    public boolean isSmaller(String str1, String str2) {
        // Calculate lengths of both string
        int n1 = str1.length(), n2 = str2.length();

        if (n1 < n2)
            return true;
        if (n2 < n1)
            return false;

        for (int i = 0; i < n1; i++) {
            if (str1.charAt(i) < str2.charAt(i))
                return true;
            else if (str1.charAt(i) > str2.charAt(i))
                return false;
        }
        return false;
    }

    public String findDiff(String str1, String str2) {
        // Before proceeding further, make sure str1
        // is not smaller
        if (isSmaller(str1, str2)) {
            String t = str1;
            str1 = str2;
            str2 = t;
        }

        // Take an empty string for storing result
        String str = "";

        // Calculate lengths of both string
        int n1 = str1.length(), n2 = str2.length();
        int diff = n1 - n2;

        // Initially take carry zero
        int carry = 0;

        // Traverse from end of both strings
        for (int i = n2 - 1; i >= 0; i--) {
            // Do school mathematics, compute difference of
            // current digits and carry
            int sub
                    = (((int) str1.charAt(i + diff) - (int) '0')
                    - ((int) str2.charAt(i) - (int) '0')
                    - carry);
            if (sub < 0) {
                sub = sub + 10;
                carry = 1;
            } else
                carry = 0;

            str += String.valueOf(sub);
        }

        // subtract remaining digits of str1[]
        for (int i = n1 - n2 - 1; i >= 0; i--) {
            if (str1.charAt(i) == '0' && carry > 0) {
                str += "9";
                continue;
            }
            int sub = (((int) str1.charAt(i) - (int) '0')
                    - carry);
            if (i > 0 || sub > 0) // remove preceding 0's
                str += String.valueOf(sub);
            carry = 0;
        }

        // reverse resultant string
        return new StringBuilder(str).reverse().toString();
    }

    public String add(String f, String s) {

        if (f.length() < s.length()) return add(s, f);

        int fi = f.length() - 1;
        int si = s.length() - 1;

        int rem = 0;
        StringBuilder sb = new StringBuilder();

        while (fi >= 0 && si >= 0) {
            char fc = f.charAt(fi);
            char sc = s.charAt(si);

            int i = (fc - '0') + (sc - '0') + rem;

            sb.append((i % 10));
            rem = i / 10;

            fi--;
            si--;
        }

        while (fi >= 0) {
            char fc = f.charAt(fi);

            int i = (fc - '0') + rem;

            sb.append((i % 10));
            rem = i / 10;

            fi--;
        }

        if (rem == 1) sb.append(rem);

        return sb.reverse().toString();
    }

    public String multiply(String f, String s) {

        if (f.length() < s.length()) add(s, f);

        List<String> list = new ArrayList<>();

        int count = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int rem = 0;
            StringBuilder temp = new StringBuilder();

            for (int j = 0; j < count; j++) temp.append('0');

            count++;

            for (int j = f.length() - 1; j >= 0; j--) {
                int a = (s.charAt(i) - '0') * (f.charAt(j) - '0') + rem;
                temp.append(a % 10);
                rem = a / 10;
            }
            if (rem != 0) temp.append(rem);

            list.add(temp.reverse().toString());
        }

        String temp = list.get(0);

        for (int i = 1; i < list.size(); i++) {
            temp = add(temp, list.get(i));
        }

        return temp;
    }
}
