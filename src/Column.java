import java.util.ArrayList;
import java.util.List;

public class Column
{
    private String title;
    private ArrayList<Ticket> tickets;

    public Column(String title)
    {
        this.title = title;
        this.tickets = new ArrayList<>();
    }

    public String getTitle()
    {
        return this.title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public List<Ticket> getTickets()
    {
        return this.tickets;
    }

    public void addTicket(Ticket ticket)
    {
        this.tickets.add(ticket);
    }

    public List<Ticket> getTicketsForAssignee(String assignee)
    {
        ArrayList<Ticket> ticketsForAssignee = new ArrayList<>();

        for (Ticket ticket : this.tickets)
        {
            if (ticket.getAssignee().getName().equals(assignee))
            {
                ticketsForAssignee.add(ticket);
            }
        }

        return ticketsForAssignee;
    }
}
