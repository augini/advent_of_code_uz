namespace Day_7;

/// <summary>
/// Represents folder type
/// </summary>
public class Folder
{
    /// <summary>
    /// Folder name
    /// </summary>
    public string Name { get; set; } = null!;

    /// <summary>
    /// Child folders
    /// </summary>
    public List<Folder> ChildFolders { get; set; } = new();

    /// <summary>
    /// Files inside of this folder
    /// </summary>
    public List<File> Files { get; set; } = new();

    /// <summary>
    /// Parent folder 
    /// </summary>
    public Folder? ParentFolder { get; set; }
}
