package level3;

public class tasks 
{
    private String title;
    private String description;

    public tasks(String title, String description) 
    {
        this.title = title;
        this.description = description;
    }

    public String getTitle() 
    {
        return title;
    }

    public String getDescription() 
    {
        return description;
    }

    public String toString() 
    {
        return title + ":" + description;
    }
}
