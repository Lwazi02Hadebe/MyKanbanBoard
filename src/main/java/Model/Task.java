/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Map;

import static View.AddTaskDetailsDialog.TASKS_DB;

/**
 * @author ME
 */
public final class Task {

    private String taskName;
    private String taskNumber;
    private String taskDescription;
    private DeveloperDetails taskDeveloperDetails;
    private Integer taskDuration;
    private String taskID;
    private String taskStatus;
    private boolean taskHoursRecorded;
    private Integer totalNumberOfHours;

    /**
     * @param taskName             The name of the task to be performed: “Add Login Feature”
     * @param taskNumber           Tasks start with the number 0, this number is
     *                             incremented and auto-generated as more
     *                             tasks are added .
     * @param taskDescription      A short description of the task, this description
     *                             should not exceed 50 characters in length. The following error message
     *                             should be displayed if the task description is too long:
     *                             “Please enter a task description of less than 50 characters”
     *                             OR
     *                             “Task successfully captured” if the message description
     *                             meets the requirements.
     * @param taskDeveloperDetails The first and last name of the developer
     *                             assigned to the task.
     * @param taskDuration         The estimated duration of the task in hours. This
     *                             number will be used for calculations and should make use of an
     *                             appropriate data type.
     * @param taskStatus           The user should be given a menu to select the following
     *                             task statuses from:
     *                             •To Do
     *                             •Done
     *                             •Doing
     * @throws java.lang.Exception
     */
    public Task(String taskName,
                String taskNumber,
                String taskDescription,
                DeveloperDetails taskDeveloperDetails,
                String taskDuration,
                String taskStatus) throws Exception {
        this.taskName = taskName;
        this.taskNumber = taskNumber;
        this.taskDescription = taskDescription;
        this.taskDeveloperDetails = taskDeveloperDetails;
        this.taskDuration = taskDuration.isEmpty() ? null :
                Integer.parseInt(taskDuration);
        this.taskID = this.createTaskID().toUpperCase();
        this.taskStatus = taskStatus;
        this.taskHoursRecorded = false;
        this.totalNumberOfHours = returnTotalHours();
    }

    /**
     * Gives a total sum of the hours recorded
     *
     * @return Integer which is the total sum of the hours recorded
     */
    public static int returnTotalHours() {
        return TASKS_DB.entrySet()
                .stream().map(e -> ((Task) e.getValue()).getTaskDuration())
                .reduce(0, Integer::sum);
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskNumber() {
        return taskNumber;
    }

    public void setTaskNumber(String taskNumber) {
        this.taskNumber = taskNumber;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public DeveloperDetails getTaskDeveloperDetails() {
        return taskDeveloperDetails;
    }

    public void setTaskDeveloperDetails(DeveloperDetails taskDeveloperDetails) {
        this.taskDeveloperDetails = taskDeveloperDetails;
    }

    public Integer getTaskDuration() {
        return taskDuration;
    }

    public void setTaskDuration(Integer taskDuration) {
        this.taskDuration = taskDuration;
    }

    public String getTaskID() {
        return taskID;
    }

    public void setTaskID(String taskID) {
        this.taskID = taskID;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public boolean isTaskHoursRecorded() {
        return taskHoursRecorded;
    }

    public void setTaskHoursRecorded(boolean taskHoursRecorded) {
        this.taskHoursRecorded = taskHoursRecorded;
    }

    public Integer getTotalNumberOfHours() {
        return totalNumberOfHours;
    }

    public void setTotalNumberOfHours(Integer totalNumberOfHours) {
        this.totalNumberOfHours = totalNumberOfHours;
    }

    /**
     * Checks if the length of the description is 50 or less than 50
     *
     * @return a true or false indicating whether the string 50 or less than 50
     */
    public boolean checkTaskDescription() {
        return taskDescription.length() <= 50;
    }

    public boolean checkExistenceOfTask() {
        return TASKS_DB
                .entrySet()
                .stream()
                .filter(e ->

                        this.taskName.toLowerCase().equals(((Task) e.getValue())
                                .taskName.toLowerCase()) &&
                                this.taskDescription.toLowerCase().equals(((Task) e.getValue())
                                        .taskDescription.toLowerCase()) &&
                                this.taskStatus.toLowerCase().equals(((Task) e.getValue())
                                        .taskStatus.toLowerCase()) &&
                                this.taskDeveloperDetails.devFirstName.toLowerCase()
                                        .equals(((Task) e.getValue())
                                                .taskDeveloperDetails.devFirstName
                                                .toLowerCase()) &&
                                this.taskDeveloperDetails.devLastName.toLowerCase().equals(
                                        ((Task) e.getValue())
                                                .taskDeveloperDetails.devLastName
                                                .toLowerCase()) &&
                                this.taskDuration.equals(((Task) e.getValue()).taskDuration)

                )
                .map(Map.Entry::getValue)
                .findFirst()
                .isPresent() == true;
    }

    /**
     * This method ensures that the task description is not more than 50
     * characters.
     *
     * @return true or false indicating whether the size of description is
     * more or less than 50
     */
    final String createTaskID() throws Exception {
        boolean isEmptyStrings =
                taskDeveloperDetails.devFirstName.isEmpty() ||
                        taskDeveloperDetails.devLastName.isEmpty() ||
                        taskDescription.isEmpty() ||
                        taskName.isEmpty() ||
                        taskDuration.equals(null);

        if (isEmptyStrings)
            throw new Exception("Please fill in all blanks");

        String devName = taskDeveloperDetails.getDevFirstName();
        String devLastName = taskDeveloperDetails.getDevLastName();
        String firstTwoLetters = taskDescription.substring(0, 2);
        String lastThreeLettersOfDev = taskDeveloperDetails.getDevFirstName()
                .substring(devName.length() - 3,
                        devName.length());

        return firstTwoLetters + ":" + taskNumber + ":" + lastThreeLettersOfDev;
    }

    /**
     * This method returns the task full task details of each task.
     *
     * @return String that contains details of the task
     */
    public String printTaskDetails() {
        return "Task name: " + taskName + "\n"
                + "Task number: " + taskNumber + "\n"
                + "Task description: " + taskDescription + "\n"
                + "Developer details: " + taskDeveloperDetails.devFirstName + " "
                + taskDeveloperDetails.devLastName + "\n"
                + "Task duration: " + taskDuration + "\n"
                + "Task ID: " + taskID + "\n"
                + "Task status: " + taskStatus + "\n";
    }

    public String printTaskAdditionResult() {
        boolean isTaskAlreadyExists = checkExistenceOfTask();
        boolean isTaskDescriptionWithinBounds = checkTaskDescription();
        if (isTaskAlreadyExists == true)
            return "Task already exists, cannot add the same task multiple"
                    + " times.";
        if (isTaskDescriptionWithinBounds == false)
            return "Please enter a task description of less than 50 characters";

        return "Task successfully captured";
    }
}