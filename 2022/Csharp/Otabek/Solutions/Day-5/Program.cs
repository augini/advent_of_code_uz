using System.Diagnostics;

string[] inputLines = File.ReadAllLines("Input.txt");

var list = new List<List<char>>();

// Gets input of each stack
for(int i = 0; i < inputLines.Length; i++)
{
    if (inputLines[i].Length < 1)
        continue;

    if (inputLines[i][1] == '1')
    {
        int start = 1;
        while (start < inputLines[i].Length)
        {
            var charsList = new List<char>();
            int j = i - 1;
            while (j >= 0 && !char.IsWhiteSpace(inputLines[j][start]))
            {
                charsList.Add(inputLines[j][start]);
                j--;
            }
            list.Add(charsList);
            start += 4;
        }
    }
}

// Part 1
var stacksList1 = new List<Stack<char>>();
list.ForEach(x => stacksList1.Add(new Stack<char>(x)));

foreach (var inputLine in inputLines)
{
    if (!inputLine.Contains("move"))
        continue;

    int count = int.Parse(inputLine.Split()[1]);
    int from = int.Parse(inputLine.Split()[3]);
    int to = int.Parse(inputLine.Split()[5]);
    
    for (int i = 1; i <= count; i++)
    {
        stacksList1[to - 1].Push(stacksList1[from - 1].Pop());
    }
}

var ans1 = new List<char>();
stacksList1.ForEach(x => ans1.Add(x.Peek()));

Console.WriteLine("Part one answer: " + new String(ans1.ToArray()));

// Part 2
var stacksList2 = new List<Stack<char>>();
list.ForEach(x => stacksList2.Add(new Stack<char>(x)));

foreach (var inputLine in inputLines)
{
    if (!inputLine.Contains("move"))
        continue;

    int count = int.Parse(inputLine.Split()[1]);
    int from = int.Parse(inputLine.Split()[3]);
    int to = int.Parse(inputLine.Split()[5]);

    var stack = new Stack<char>();
    for (int i = 1; i <= count; i++)
    {
        stack.Push(stacksList2[from - 1].Pop());
    }

    while (stack.Count > 0)
    {
        stacksList2[to - 1].Push(stack.Pop());
    }
}

var ans2 = new List<char>();
stacksList2.ForEach(x => ans2.Add(x.Peek()));

Console.WriteLine("Part two answer: " + new String(ans2.ToArray()));