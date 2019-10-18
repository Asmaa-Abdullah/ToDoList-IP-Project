
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class ToDoList
{
    List<TaskItem> taskItemList = new ArrayList<TaskItem>();        // create an arraylist to store the object of type TaskItem
    TaskItem taskItem = new TaskItem();
    Scanner input = new Scanner(System.in);

    public ToDoList()
    {

    }

    public List<TaskItem> getList() {
        return taskItemList;
    }

    public void setTaskItemList(List<TaskItem> list) {
        this.taskItemList = list;
    }



    /* Show all projects */
    public void showAll() {
        for (int i =0; i < taskItemList.size(); i++) {
            System.out.println(i + " " + taskItemList.get(i));
        }

    }

    /* Show all projects sorted by Date */
    public void showByDate() {
        Collections.sort(taskItemList);
        showAll();
    }

    /* Show all projects sort by project */
    public void showByProject(){
        List<TaskItem> sortedList = taskItemList.stream()
                .sorted(Comparator.comparing(TaskItem::getProjectName))
                .collect(Collectors.toList());

        for (TaskItem task: sortedList) {
            System.out.println(task);
        }
    }

    /* add new object to arrayList */
    public void addNewTask () throws ParseException {

        System.out.println("\nEnter project name : ");
        taskItem.setProjectName(input.nextLine()) ;

        System.out.println("Enter task name : ");
        taskItem.setTaskName(input.nextLine());

        System.out.println("Enter task date as dd-mm-yyyy: ");
        taskItem.setTaskDate(convertStringToDate(input.nextLine()));

        System.out.println("Enter task status (done or undone): ");
        taskItem.setTaskStatus(input.nextLine());

        System.out.println("Enter task description : ");
        taskItem.setTaskDescription(input.nextLine());

        taskItemList.add(taskItem);
        for (TaskItem taskItem1: taskItemList){
            System.out.println(taskItem1);
        }
    }

    /* convert taskDate As string to taskDate As Date */
    public LocalDate convertStringToDate(String dateString)
    {
        LocalDate date = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        while(true)
        {
            try{
                date = LocalDate.parse(dateString, formatter);
                //System.out.println(date);
                return date;
            }
            catch ( Exception e ){
                System.out.println("Invalid date. Please try again. ");
                dateString = input.nextLine();

            }
        }
    }

    private String getProjectToUpdate(String field)
    {
        System.out.print("Enter new "+ field );
        return input.nextLine();
    }

    /* choose the project index then choose either delete it or update it */
    public void chooseTaskIndex()
    {
        System.out.print("\nChoose the project index: ");
        String indexString = input.nextLine();
        int index = -1;
        while(true)
        {
            try {
                index = Integer.parseInt(indexString);
                System.out.println(taskItemList.get(index));
                break;
            } catch (Exception e){
                System.out.println("Invalid index. Please try again. ");
                indexString = input.nextLine();
            }
        }

        System.out.println("\n1 - Remove");
        System.out.println("2 - Edit");
        System.out.println("3 - Cancel");
        System.out.print("\nChoose option: ");

        int selection = input.nextInt();
        input.nextLine();
        switch (selection) {
            case 1:         // delete project
                taskItemList.remove(index);
                showAll();
                break;
            case 2:         //Edit project
                do{
                    System.out.println("\n1 - Edit project name");
                    System.out.println("2 - Edit task name");
                    System.out.println("3 - Edit task date");
                    System.out.println("4 - Edit task status (done or undone)");
                    System.out.println("5 - Edit task description");
                    System.out.println("6 - Cancel");
                    System.out.print("\nChoose option: ");
                    selection = input.nextInt();
                    input.nextLine();
                    switch (selection) {
                        case 1:   //Edit project name
                            String newProjectName = getProjectToUpdate("project name: ");
                            taskItemList.get(index).setProjectName(newProjectName);
                            break;
                        case 2:    //Edit task name
                            String newTaskName = getProjectToUpdate("task name: ");
                            taskItemList.get(index).setTaskName(newTaskName);
                            break;
                        case 3:    //Edit task Date
                            String newTaskDate = getProjectToUpdate("task date as dd-mm-yyyy: ");
                            taskItemList.get(index).setTaskDate(convertStringToDate(newTaskDate));
                            break;
                        case 4:    //Edit task status
                            String newTaskStatus = getProjectToUpdate("task status: ");
                            taskItemList.get(index).setTaskStatus(newTaskStatus);
                            break;
                        case 5:    //Edit task taskDescription
                            String newTaskDescription = getProjectToUpdate("task description: ");
                            taskItemList.get(index).setTaskDescription(newTaskDescription);
                            break;
                        case 6:    //Cancel and back to menu
                            break;
                        default:
                            System.out.println("Invalid selection. Please try again.");
                    }
                }while (selection != 6);
            case 3:
                break;    //Cancel and back to menu
            default:
                System.out.println("Invalid selection. Please try again.");
        }
    }
}


