using Day_7;
using File = Day_7.File;

public class Program
{
    public static int SumOfFolderSizes = 0;
    public static int MinimumFolderSizeBeingDeleted = int.MaxValue;
    public static int RootFolderSize = 0;
    public static void Main(string[] args)
    {
        var inputLines = System.IO.File.ReadAllLines("Input.txt");

        var rootFolder = new Folder
        {
            Name = "/"
        };

        var currentFolder = rootFolder;

        for (int i = 1; i < inputLines.Length; i++)
        {
            if (inputLines[i].StartsWith("$ cd"))
            {
                var folderName = inputLines[i].Split()[2];

                if (folderName == "..")
                {
                    currentFolder = currentFolder.ParentFolder;
                }
                else
                {
                    currentFolder = currentFolder.ChildFolders.First(x => x.Name == folderName);
                }
            }
            else if (inputLines[i].StartsWith("dir"))
            {
                var newFolder = new Folder
                {
                    Name = inputLines[i].Split()[1],
                    ParentFolder = currentFolder
                };

                currentFolder.ChildFolders.Add(newFolder);
            }
            else if (char.IsDigit(inputLines[i][0]))
            {
                currentFolder.Files.Add(new File
                {
                    Size = int.Parse(inputLines[i].Split()[0]),
                    Name = inputLines[i].Split()[1]
                });
            }
        }

        RootFolderSize = CalculateFolderSize(rootFolder);
        TraverseFolder(rootFolder);

        Console.WriteLine("Part one answer: " + SumOfFolderSizes);
        Console.WriteLine("Part two answer: " + MinimumFolderSizeBeingDeleted);
    }

    public static void TraverseFolder(Folder folder)
    {
        int folderSize = CalculateFolderSize(folder);
        
        if (folderSize <= 100_000)
            SumOfFolderSizes += folderSize;

        if (70_000_000 - RootFolderSize + folderSize >= 30_000_000)
        {
            MinimumFolderSizeBeingDeleted = Math.Min(MinimumFolderSizeBeingDeleted, folderSize);
        }

        foreach (var childFolder in folder.ChildFolders)
        {
            TraverseFolder(childFolder);
        }
    }

    public static int CalculateFolderSize(Folder folder)
    {
        if (folder == null)
            return 0;

        return folder.Files.Sum(x => x.Size) + folder.ChildFolders.Sum(x => CalculateFolderSize(x));
    }
}