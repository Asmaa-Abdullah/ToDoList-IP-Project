import Data.TaskItem;
import Data.ToDoFileManager;
import Data.ToDoList;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * A class which tested write to file and read from file methods in Data.ToDoFileManager class.
 *
 * @author  Asmaa Abdullah
 *
 */

public class ToDoFileManagerTest {

    ToDoList toDoList = new ToDoList();
    String projectName = "project1";
    String taskName = "task1";
    LocalDate taskDate = toDoList.convertStringToDate("01-01-2019");
    String taskStatus = "done";
    String taskDescription = "Project1 has one task";

    TaskItem taskItem1 = new TaskItem(projectName, taskName, taskDate, taskStatus, taskDescription);
    List<TaskItem> taskItemList = toDoList.getList();
    String fileName = "ToDoListTest/ToDoTestFile.txt";
    ToDoFileManager toDoFileManager = new ToDoFileManager();

    @Test
    public void writeToFileTest() {

        taskItemList.add(taskItem1);     // Write testItem1 to file
        boolean testResult = ToDoFileManager.writeToFile(fileName, taskItemList);       // writeToFile method is static
        assertTrue(testResult);         // Assert that the write was a success

    }

    @Test
    public void readFromFileTest() {
        List<TaskItem> testResult = toDoFileManager.ReadFromFile(fileName);
        System.out.println(testResult);
        assertTrue(testResult.get(0).equals(taskItem1) );

    }
}


