package day_01;

public class Main {
    public static void main(String[] args) {
        Day1 day1 = new Day1();
        try {
            System.out.println(day1.problem1());
            System.out.println(day1.problem2());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
