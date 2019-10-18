import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ToDoFileManager {

    TaskItem taskItem = new TaskItem();
    List<TaskItem> taskItemList = new ArrayList<TaskItem>();

    /* To write an object to a file */
    public static boolean writeToFile (String fileName, List<TaskItem> taskItemList) {
        boolean result = false;
        try {
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            for (TaskItem taskItem : taskItemList) {
                objectOut.writeObject(taskItem);
            }
            fileOut.close();
            objectOut.close();
            result = true;
        } catch (Exception ex) {
            //ex.printStackTrace();
            System.out.printf("ERROR: %s\n ", ex);
        } return result;
    }
}





