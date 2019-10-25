package MainMenu;

import Data.ToDoFileManager;
import Data.ToDoList;

import java.text.ParseException;
import java.util.Scanner;
/**
 * A menu which the user can choose for adding, deleting, editing, display a task.
 *
 * @author  Asmaa Abdullah
 * @since   2019-09-31
 */

public class Menu {
    public Scanner input = new Scanner(System.in);
    public int selection = 0;
    ToDoList toDoList = new ToDoList();
    ToDoFileManager toDoFileManager = new ToDoFileManager();
    String fileName = "ToDoFileManager/ToDoFileManager.txt";

    public void mainMenu() throws ParseException {

        System.out.println("*********************************************************");
        System.out.println("\n**       Welcome to the ToDo List Application       **\n");
        System.out.println("*********************************************************");

        toDoList.setTaskItemList(toDoFileManager.ReadFromFile(fileName));

        printMenu();
    }

    public void printMenu() throws ParseException {
        do {
            System.out.println("\n1 - Show Task List ");
            System.out.println("2 - Add New Task ");
            System.out.println("3 - Edit Or Remove Task");
            System.out.println("4 - Save and Quit");
            System.out.print("\nSelect from the main menu:  ");

            selection = input.nextInt();
            switch (selection) {
                case 1:
                    showTaskList();
                    break;
                case 2:
                    toDoList.addNewTask();
                    break;
                case 3:
                    editTask();
                    break;
                case 4:
                    toDoFileManager. writeToFile(fileName, toDoList.getList());
                    System.out.println("\n        **** All tasks saved successfully **** ");
                    System.out.println("\n ********  Thanks for using the application!  ******** ");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid selection. Please try again.");
            }

        } while (selection != 4);
    }

    public void showTaskList() throws ParseException {
        do {
            System.out.println("\n1 - All Task ");           // everything
            System.out.println("2 - Sort by date ");         // everything but sorted ascending by date
            System.out.println("3 - Sort by project");       // everything but sorted ascending by project name
            System.out.println("4 - Back to main menu ");
            System.out.print("\nSelect from the menu:  ");

            selection = input.nextInt();
            switch (selection) {
                case 1:
                    toDoList.showAll();
                    break;
                case 2:
                    toDoList.showByDate();
                    break;
                case 3:
                    toDoList.showByProject();
                    break;
                case 4:
                    //return;
                    printMenu();
                    break;
                default:
                    System.out.println("Invalid selection. Please try again.");
            }
        } while (selection != 4);
    }

    public void editTask() throws ParseException {
        do {
            System.out.println("\n1 - Update and Remove");
            System.out.println("2 - Back to main menu ");
            System.out.print("\nSelect from the menu:  ");

            selection = input.nextInt();
            switch (selection) {
                case 1:
                    System.out.println("\n");
                    toDoList.showAll();
                    toDoList.chooseTaskIndex();
                    break;
                case 2:
                    printMenu();
                    break;
                default:
                    System.out.println("Invalid selection. Please try again.");
            }
        } while (selection != 2);
    }
}

