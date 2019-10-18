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
    /* To read an object from a file */
    public List<TaskItem> ReadFromFile(String fileName) {
        List<TaskItem> loadList = new ArrayList<>();
        try {
            FileInputStream fileIn = new FileInputStream(fileName);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            while (fileIn.available() > 0){         // check if the file stream is at the end
                TaskItem obj = (TaskItem) objectIn.readObject();        // read from the object stream, which wraps the file stream
                //System.out.println(obj.toString());
                loadList.add(obj);
            }

            //System.out.println("File has been read successfully");
            fileIn.close();
            objectIn.close();
            return loadList;

        } catch (Exception ex) {
            //ex.printStackTrace();
            System.out.printf("ERROR: %s\n ", ex);
            return loadList;
        }
    }
}





