import day_01.AdventOfCode_01;
import day_02.AdventOfCode_02;
import day_03.AdventOfCode_03;
import day_04.AdventOfCode_04;
import day_05.AdventOfCode_05;

/**
 * @author: Kodirov Hurshidbek
 * Date : 11.01.2023
 * Time : 09:00 PM
 */


public class Main {
    public static void main(String[] args) throws Exception {

        run(5);

    }

    public static void run(int day) throws Exception {
        String filePath = filePath(day);
        String answerPart1 = "";
        String answerPart2 = "";

        switch (day) {
            case 1:
                AdventOfCode_01 adventOfCode_01 = new AdventOfCode_01(3, filePath);
                answerPart1 = "" + adventOfCode_01.aoc1_1(1);
                answerPart2 = "" + adventOfCode_01.aoc1_2(3);
                break;
            case 2:
                AdventOfCode_02 adventOfCode_02 = new AdventOfCode_02(filePath);
                answerPart1 = "" + adventOfCode_02.aoc2_1();
                answerPart2 = "" + adventOfCode_02.aoc2_2();
                break;
            case 3:
                AdventOfCode_03 adventOfCode_03 = new AdventOfCode_03(filePath);
                answerPart1 = "" + adventOfCode_03.aoc3_1();
                answerPart2 = "" + adventOfCode_03.aoc3_2();
                break;
            case 4:
                AdventOfCode_04 adventOfCode_04 = new AdventOfCode_04(filePath);
                answerPart1 = "" + adventOfCode_04.aoc4_1();
                answerPart2 = "" + adventOfCode_04.aoc4_2();
                break;
            case 5:
                AdventOfCode_05 adventOfCode_05 = new AdventOfCode_05(filePath);
                answerPart1 = "" + adventOfCode_05.aoc5_1();
                answerPart2 = "" + adventOfCode_05.aoc5_2();
                break;

        }

        System.out.println(message(day, 1) + answerPart1);
        System.out.println(message(day, 2) + answerPart2 + "\n");

    }

    private static String message(int day, int part) {
        return "Advent Of Code -> day " + day + " -> part " + part + " -> ";
    }

    private static String filePath(int day) {
        return day < 9
                ? "2022\\Java\\Hurshidbek\\day_0" + day + "\\aoc_0" + day + ".txt"
                : "2022\\Java\\Hurshidbek\\day_" + day + "\\aoc_" + day + ".txt";
    }
}