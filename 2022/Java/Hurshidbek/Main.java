import day_01.AdventOfCode_1;

/**
 * @author: Kodirov Hurshidbek
 * Date : 11.01.2023
 * Time : 09:00 PM
 */


public class Main {
    public static void main(String[] args) throws Exception {

        Run run = new Run();
        run.run(1);

    }
}

class Run {

    public void run(int day) throws Exception {
        String answerPart1 = "";
        String answerPart2 = "";

        switch (day) {
            case 1:
                AdventOfCode_1 adventOfCode1 = new AdventOfCode_1(3);
                answerPart1 = "" + adventOfCode1.aoc1_1(1);
                answerPart2 = "" + adventOfCode1.aoc1_2(3);
                break;
        }

        System.out.println(message(day, 1) + answerPart1);
        System.out.println(message(day, 2) + answerPart2);

    }

    private static String message(int day, int part) {
        return "Advent Of Code -> day " + day + " -> part " + part + " -> ";
    }
}

