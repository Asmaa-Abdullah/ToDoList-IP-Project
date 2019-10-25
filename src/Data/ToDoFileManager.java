package Data;

import Data.TaskItem;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * A class which implemented two methods:
 * Write to a file & Read from file
 *
 * @author  Asmaa Abdullah
 *
 */

public class ToDoFileManager {

    TaskItem taskItem = new TaskItem();
    List<TaskItem> taskItemList = new ArrayList<TaskItem>();


    /**
     * Save a list to a file.
     * @param fileName
     * @param taskItemList
     * @return true if object saved otherwise return false.
     */
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
        }
        catch (Exception ex) {
            System.out.printf("ERROR: %s\n ", ex);
        } return result;
    }


    /**
     * Read an object from a file
     * @param fileName
     * @return The list of object which saved in file.
     */
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

            fileIn.close();
            objectIn.close();

        }
        catch (EOFException ex) {
            System.out.printf("The list is empty now \n");
        }
        catch (Exception ex) {
            System.out.printf("ERROR: %s\n ", ex);
        }
        return loadList;
    }
}





