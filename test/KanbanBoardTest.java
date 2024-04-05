import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KanbanBoardTest
{

    private KanbanBoard kanbanBoard;
    private Ticket toDoTicket;
    private Ticket anotherToDoTicket;
    private Ticket doingTicket;
    private Ticket anotherDoingTicket;
    private Ticket doneTicket;

    private Column todo;
    private Column doing;
    private Column done;

    @BeforeEach
    void setUp()
    {
        kanbanBoard = new KanbanBoard();
        toDoTicket = new Ticket("todo1", 1, 1, 4);
        anotherToDoTicket = new Ticket("todo2", 2, 3, 4);
        doingTicket = new Ticket("doing", 4, 3, 6);
        anotherDoingTicket = new Ticket("doing2", 1, 1, 4);
        doneTicket = new Ticket("done", 1, 1, 4);

        todo = kanbanBoard.getColumns().getFirst();
        doing = kanbanBoard.getColumns().get(1);
        done = kanbanBoard.getColumns().get(2);
    }

    @Test
    void getPercentageOfTicketsDoneOneDoneFourOtherShouldReturn20Percent()
    {
        // Arrange
        todo.addTicket(toDoTicket);
        todo.addTicket(anotherToDoTicket);
        doing.addTicket(doingTicket);
        doing.addTicket(anotherDoingTicket);
        done.addTicket(doneTicket);

        // Act
        double result = kanbanBoard.getPercentageOfTicketsDone();

        // Assert
        assertEquals(0.2, result);
    }

    @Test
    void getPercentageOfTicketsDoneTwoDoneThreeOtherShouldReturn40Percent()
    {
        // Arrange
        todo.addTicket(toDoTicket);
        todo.addTicket(anotherToDoTicket);
        doing.addTicket(doingTicket);
        done.addTicket(anotherDoingTicket);
        done.addTicket(doneTicket);

        // Act
        double result = kanbanBoard.getPercentageOfTicketsDone();

        // Assert
        assertEquals(0.4, result);
    }

    @Test
    void getPercentageOfTicketsDoneNoTicketsShouldReturn0Percent()
    {
        // Act
        double result = kanbanBoard.getPercentageOfTicketsDone();

        // Assert
        assertEquals(0, result);
    }
}