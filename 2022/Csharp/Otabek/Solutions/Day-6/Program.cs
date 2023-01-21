var input = File.ReadAllText("Input.txt");

Console.WriteLine("Part one answer: " + FindMarkerPosition(input, 4));
Console.WriteLine("Part two answer: " + FindMarkerPosition(input, 14));

int FindMarkerPosition(string input, int distCharsCount)
{
    var ans = -1;
    for (int i = distCharsCount - 1; i < input.Length; i++)
    {
        var dic = new Dictionary<char, bool>();

        var IsNonRepeating = true;

        for (int j = i - distCharsCount + 1; j <= i; j++)
        {
            if (dic.ContainsKey(input[j]))
            {
                IsNonRepeating = false;
                break;
            }
            else
            {
                dic.Add(input[j], true);
            }
        }

        if (IsNonRepeating)
        {
            ans = i + 1;
            break;
        }
    }

    return ans;
}