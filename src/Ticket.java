public class Ticket
{
    private String description;
    private int yearsOfExperienceRequired;
    private int priority;
    private int estimatedTimeToCompletionInHours;
    private Assignee assignee;

    public Ticket(String description, int yearsOfExperienceRequired, int priority, int estimatedTimeToCompletionInHours)
    {
        this.description = description;
        this.yearsOfExperienceRequired = yearsOfExperienceRequired;
        this.priority = priority;
        this.estimatedTimeToCompletionInHours = estimatedTimeToCompletionInHours;
    }

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public int getYearsOfExperienceRequired()
    {
        return this.yearsOfExperienceRequired;
    }

    public void setYearsOfExperienceRequired(int yearsOfExperienceRequired)
    {
        this.yearsOfExperienceRequired = yearsOfExperienceRequired;
    }

    public int getPriority()
    {
        return this.priority;
    }

    public void setPriority(int priority)
    {
        if (priority < 0 || priority > 5)
        {
            throw new IllegalArgumentException("Priority must be between 0 and 5.");
        }

        this.priority = priority;
    }

    public int getEstimatedTimeToCompletionInHours()
    {
        return this.estimatedTimeToCompletionInHours;
    }

    public void setEstimatedTimeToCompletionInHours(int estimatedTimeToCompletionInHours)
    {
        if (estimatedTimeToCompletionInHours < 0)
        {
            throw new IllegalArgumentException("Estimated time to completion must be greater than 0.");
        }

        this.estimatedTimeToCompletionInHours = estimatedTimeToCompletionInHours;
    }

    public Assignee getAssignee()
    {
        return this.assignee;
    }

    public void setAssignee(Assignee assignee)
    {
        if (assignee.getYearsWorking() < this.yearsOfExperienceRequired)
        {
            throw new IllegalArgumentException("Assignee does not have enough experience to work on this ticket.");
        }

        this.assignee = assignee;
    }
}
