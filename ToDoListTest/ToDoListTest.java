import Data.ToDoList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.time.Month;

/**
 * A class which tested convert date from String to LocalDate in Data.ToDoList class.
 *
 * @author  Asmaa Abdullah
 *
 */

public class ToDoListTest {

    @Test
    public void convertStringToDateTest() {
        ToDoList toDoListTest = new ToDoList();
        LocalDate result = toDoListTest.convertStringToDate("18-10-2019");
        assertEquals(result.getDayOfMonth(), 18);
        assertEquals(result.getMonth(), Month.OCTOBER);
        assertEquals(result.getYear(), 2019);
    }
}
