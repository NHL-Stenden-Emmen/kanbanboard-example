import java.time.LocalDate;

public class Assignee
{
    private String name;
    private LocalDate hireDate;

    public Assignee(String name, LocalDate hireDate)
    {
        this.name = name;
        this.hireDate = hireDate;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public LocalDate getHireDate()
    {
        return this.hireDate;
    }

    public void setHireDate(LocalDate hireDate)
    {
        this.hireDate = hireDate;
    }

    public int getYearsWorking()
    {
        return LocalDate.now().getYear() - this.hireDate.getYear();
    }
}
