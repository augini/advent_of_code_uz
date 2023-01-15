import day_01.AdventOfCode_1;
import day_02.AdventOfCode_2;
import day_03.AdventOfCode_3;

/**
 * @author: Kodirov Hurshidbek
 * Date : 11.01.2023
 * Time : 09:00 PM
 */


public class Main {
    public static void main(String[] args) throws Exception {

        run(1);
        run(2);
        run(3);

    }

    public static void run(int day) throws Exception {
        String answerPart1 = "";
        String answerPart2 = "";

        switch (day) {
            case 1:
                AdventOfCode_1 adventOfCode1 = new AdventOfCode_1(3, filePath(1));
                answerPart1 = "" + adventOfCode1.aoc1_1(1);
                answerPart2 = "" + adventOfCode1.aoc1_2(3);
                break;
            case 2:
                AdventOfCode_2 adventOfCode2 = new AdventOfCode_2(filePath(2));
                answerPart1 = "" + adventOfCode2.aoc2_1();
                answerPart2 = "" + adventOfCode2.aoc2_2();
                break;
            case 3:
                AdventOfCode_3 adventOfCode3 = new AdventOfCode_3(filePath(3));
                System.out.println(adventOfCode3.getClass().getName());
                answerPart1 = "" + adventOfCode3.aoc3_1();
                answerPart2 = "" + adventOfCode3.aoc3_2();
                break;

        }

        System.out.println(message(day, 1) + answerPart1);
        System.out.println(message(day, 2) + answerPart2 + "\n");

    }

    private static String message(int day, int part) {
        return "Advent Of Code -> day " + day + " -> part " + part + " -> ";
    }

    private static String filePath(int day){
        return day < 9
                ? "2022\\Java\\Hurshidbek\\day_0" + day + "\\aoc_0" + day + ".txt"
                : "2022\\Java\\Hurshidbek\\day_" + day + "\\aoc_" + day + ".txt" ;
    }
}