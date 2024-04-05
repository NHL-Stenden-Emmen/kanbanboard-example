import java.util.ArrayList;
import java.util.List;

public class KanbanBoard
{
    private ArrayList<Column> columns;

    public KanbanBoard()
    {
        this.columns = new ArrayList<>();
        this.columns.add(new Column("To Do"));
        this.columns.add(new Column("In Progress"));
        this.columns.add(new Column("Done"));
    }

    public List<Column> getColumns()
    {
        return this.columns;
    }

    public void addColumn(Column column)
    {
        this.columns.add(column);
    }

    public List<Ticket> getTicketsForAssignee(String assignee)
    {
        ArrayList<Ticket> ticketsForAssignee = new ArrayList<>();

        for (Column column : this.columns)
        {
            ticketsForAssignee.addAll(column.getTicketsForAssignee(assignee));
        }

        return ticketsForAssignee;
    }

    public double getPercentageOfTicketsDone()
    {
        int totalTickets = 0;
        int totalTicketsDone = 0;

        for (Column column : this.columns)
        {
            totalTickets += column.getTickets().size();

            if (column.getTitle().equals("Done"))
            {
                totalTicketsDone = column.getTickets().size();
            }
        }

        if (totalTickets == 0)
        {
            return 0;
        }

        return (double) totalTicketsDone / totalTickets;
    }
}
