// Reads all lines in input file
string[] inputLines = File.ReadAllLines("Input.txt");

// Current elf calories 
int currentElfCalories = 0;

// List of all elfs calories
List<int> elfCalories = new List<int>();

foreach (string inputLine in inputLines)
{
    if (string.IsNullOrEmpty(inputLine))
    {
        // input line is empty which means we no longer add value of input line to currentElfCalories
        // We add the value of currentElfCalories to elfCalories list
        elfCalories.Add(currentElfCalories);

        // We start gathering the calories of the new elf and set the value of the current elf calories to 0.
        currentElfCalories = 0;
    }
    else
    {
        // input line has value which means we should add value of input line to currentElfCalories
        currentElfCalories += int.Parse(inputLine);
    }
}

// Sorting elf calories list
elfCalories.Sort();

Console.Write("Answer of part one: ");
Console.WriteLine(elfCalories[elfCalories.Count - 1]);

Console.Write("Answer of part two: ");
Console.WriteLine(elfCalories[elfCalories.Count - 1] + elfCalories[elfCalories.Count - 2] + elfCalories[elfCalories.Count - 3]);