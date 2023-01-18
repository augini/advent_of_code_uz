string[] inputLines = File.ReadAllLines("Input.txt");

// Part 1
var count1 = 0;
foreach(var inputLine in inputLines)
{
    var part1 = inputLine.Split(',')[0];
    var part2 = inputLine.Split(',')[1];

    var a1 = int.Parse(part1.Split('-')[0]);
    var b1 = int.Parse(part1.Split('-')[1]);

    var a2 = int.Parse(part2.Split('-')[0]);
    var b2 = int.Parse(part2.Split('-')[1]);

    if ((a1 <= a2 && b2 <= b1) || (a2 <= a1 && b1 <= b2))
        count1++;
}
Console.WriteLine("Part one answer: " + count1);

// Part 2
var count2 = 0;
foreach (var inputLine in inputLines)
{
    var part1 = inputLine.Split(',')[0];
    var part2 = inputLine.Split(',')[1];

    var a1 = int.Parse(part1.Split('-')[0]);
    var b1 = int.Parse(part1.Split('-')[1]);

    var a2 = int.Parse(part2.Split('-')[0]);
    var b2 = int.Parse(part2.Split('-')[1]);

    if ((a1 <= a2 && a2 <= b1) || (a1 <= b2 && b2 <= b1) || (a2 <= a1 && a1 <= b2) || (a2 <= b1 && b1 <= b2))
        count2++;
}
Console.WriteLine("Part two answer: " + count2);