
import java.io.Serializable;
import java.time.LocalDate;

public class TaskItem implements Comparable, Serializable {

    private String projectName;
    private String taskName;
    private LocalDate taskDate;
    private String taskStatus;
    private String taskDescription;

    public TaskItem(){}

    public TaskItem(String projectName, String taskName,
                    LocalDate taskDate, String taskStatus, String taskDescription)
    {
        this.projectName = projectName;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.taskDate = taskDate;
        this.taskStatus = taskStatus;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public LocalDate getTaskDate() {
        return taskDate;
    }

    public void setTaskDate(LocalDate taskDate) {
        this.taskDate = taskDate;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public boolean equals(TaskItem t) {
        return t.projectName.equals(projectName) && t.taskName.equals(taskName) && t.taskDate.equals(taskDate) && t.taskStatus.equals(taskStatus) && t.taskDescription.equals(taskDescription);
    }


    @Override
    public String toString() {
        return "   "+projectName + "     " + taskName + "     " + taskDate + "     " + taskStatus + "     "+  taskDescription  ;
    }

    @Override
    public int compareTo(Object o)
    {
        TaskItem other = (TaskItem) o;
        return this.getTaskDate().compareTo(other.getTaskDate());
    }
}
