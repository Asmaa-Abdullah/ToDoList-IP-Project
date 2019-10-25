import Data.TaskItem;
import Data.ToDoList;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * A class which tested all setter and getter methods in Data.TaskItem class.
 *
 * @author  Asmaa Abdullah
 *
 */

public class TaskItemTest {

    ToDoList toDoList = new ToDoList();
    String projectName = "project1";
    String taskName = "task1";
    LocalDate taskDate = toDoList.convertStringToDate("01-01-2019");
    String taskStatus = "done";
    String taskDescription = "Project1 has one task";
    TaskItem taskItem = new TaskItem(projectName, taskName, taskDate, taskStatus, taskDescription);

    @Test
    void getProjectName() {
        assertEquals(projectName, taskItem.getProjectName());
        assertEquals("project1", taskItem.getProjectName());
    }
    @Test
    void setProjectName() {
        String newProjectName = "NewProject";
        taskItem.setProjectName(newProjectName);
        assertEquals(newProjectName, taskItem.getProjectName());
    }
    @Test
    void getTaskName (){
        assertEquals(taskName, taskItem.getTaskName());
        assertEquals("task1", taskItem.getTaskName());
    }
    @Test
    void setTaskName() {
        String newTaskName = "NewTask";
        taskItem.setTaskName(newTaskName);
        assertEquals(newTaskName, taskItem.getTaskName());
    }
    @Test
    void getTaskDate (){
        assertEquals(taskDate, taskItem.getTaskDate());
        LocalDate falseDate = toDoList.convertStringToDate("22-09-2002");
        assertNotEquals(falseDate, taskItem.getTaskDate());
    }
    @Test
    void setTaskDate() {
        LocalDate newTaskDate = toDoList.convertStringToDate("22-09-2002");
        taskItem.setTaskDate(newTaskDate);
        assertEquals(newTaskDate, taskItem.getTaskDate());
    }
    @Test
    void getTaskStatus (){
        assertEquals(taskStatus, taskItem.getTaskStatus());
        assertEquals("done", taskItem.getTaskStatus());
    }
    @Test
    void setTaskStatus() {
        String newTaskStatus = "NewTaskStatus";
        taskItem.setTaskStatus(newTaskStatus);
        assertEquals(newTaskStatus, taskItem.getTaskStatus());
    }
    @Test
    void getTaskDescription (){
        assertEquals(taskDescription, taskItem.getTaskDescription());
        assertEquals("Project1 has one task", taskItem.getTaskDescription());
    }
    @Test
    void setTaskDescription() {
        String newTaskDescription = "NewTaskDescription";
        taskItem.setTaskDescription(newTaskDescription);
        assertEquals(newTaskDescription, taskItem.getTaskDescription());
    }
}


