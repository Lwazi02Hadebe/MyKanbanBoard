/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import Model.DeveloperDetails;
import Model.Task;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static View.AddTaskDetailsDialog.TASKS_DB;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author ME
 */
public class TestTask {

    static Task testTask1;
    static Task testTask2;
    static Task testTask3;
    static Task testTask4;
    static Task testTask5;
    Task testTask;
    Task testTaskDescription;

    @AfterAll
    static void clearData() {
        TASKS_DB.clear();
    }

    @BeforeEach()
    void init() {
        TASKS_DB.clear();
    }

    @Test
    void tesFirstTaskTotalHours() {
        try {
            TASKS_DB.put(TASKS_DB.size(), testTask1 = new Task("Login Feature",
                    String.valueOf(TASKS_DB.size()), "Create Login to authenticate users",
                    new DeveloperDetails("Robyn", "Harrison"),
                    "8", "To Do"));
            assertEquals(8, testTask1.returnTotalHours());
        } catch (Exception exc) {
            System.out.println("Error while testing: " + exc.getMessage());
        }
    }

    @Test
    void testSecondTasksTotalHours() {
        try {
            TASKS_DB.put(TASKS_DB.size(), testTask1 = new Task("Login Feature",
                    String.valueOf(TASKS_DB.size()), "Create Login to authenticate users",
                    new DeveloperDetails("Robyn", "Harrison"),
                    "8", "To Do"));
            TASKS_DB.put(TASKS_DB.size(), testTask2 = new Task("Add Task Feature"
                    , String.valueOf(TASKS_DB.size()), "Create Add Task feature to add task users",
                    new DeveloperDetails("Mike", "Smith"), "10", "In Progress"));

            assertEquals(18, testTask2.returnTotalHours());
        } catch (Exception exc) {
            System.out.println("Error while testing: " + exc.getMessage());
        }
    }

    @Test
    void testMultipleTasksTotalHours() {
        try {
            TASKS_DB.put(TASKS_DB.size(), testTask1 = new Task("Login Feature",
                    String.valueOf(TASKS_DB.size()), "Create Login to authenticate users",
                    new DeveloperDetails("Robyn", "Harrison"),
                    "10", "To Do"));
            TASKS_DB.put(TASKS_DB.size(), testTask2 = new Task("Add Task Feature"
                    , String.valueOf(TASKS_DB.size()), "Create Add Task feature to add task users",
                    new DeveloperDetails("Mike", "Smith"), "12", "In Progress"));
            TASKS_DB.put(TASKS_DB.size(), testTask3 = new Task("Add Other Dope Task Feature"
                    , String.valueOf(TASKS_DB.size()), "Create Other Dope Add Task feature to add task users",
                    new DeveloperDetails("Jameson", "Zachary"), "55", "In Progress"));
            TASKS_DB.put(TASKS_DB.size(), testTask4 = new Task("Add Some Other Dope Task Feature"
                    , String.valueOf(TASKS_DB.size()), "Create Some Dope Add Task feature to add task users",
                    new DeveloperDetails("Jake", "Smith"), "11", "In Progress"));
            TASKS_DB.put(TASKS_DB.size(), testTask5 = new Task("Add Some Other Other Dope Task Feature"
                    , String.valueOf(TASKS_DB.size()), "Create Some Other Dope Add Task feature to add task users",
                    new DeveloperDetails("Will", "Smith"), "1", "In Progress"));

            assertEquals(89, testTask5.returnTotalHours());
        } catch (Exception exc) {
            System.out.println("Error while testing: " + exc.getMessage());
        }
    }


    @Test
    void testSuccessfulTaskID() {
        try {
            TASKS_DB.put(TASKS_DB.size(), testTask1 = new Task("Login Feature",
                    String.valueOf(TASKS_DB.size()), "Create Login to authenticate users",
                    new DeveloperDetails("Robyn", "Harrison"),
                    "10", "To Do"));
            TASKS_DB.put(TASKS_DB.size(), testTask2 = new Task("Add Task Feature"
                    , String.valueOf(TASKS_DB.size()), "Create Add Task feature to add task users",
                    new DeveloperDetails("Mike", "Smith"), "12", "In Progress"));
            TASKS_DB.put(TASKS_DB.size(), testTask3 = new Task("Add Other Dope Task Feature"
                    , String.valueOf(TASKS_DB.size()), "Create Other Dope Add Task feature to add task users",
                    new DeveloperDetails("Jameson", "Zachary"), "55", "In Progress"));
            TASKS_DB.put(TASKS_DB.size(), testTask4 = new Task("Add Some Other Dope Task Feature"
                    , String.valueOf(TASKS_DB.size()), "Create Some Dope Add Task feature to add task users",
                    new DeveloperDetails("Jake", "Smith"), "11", "In Progress"));
            TASKS_DB.put(TASKS_DB.size(), testTask5 = new Task("Add Some Other Other Dope Task Feature"
                    , String.valueOf(TASKS_DB.size()), "Create Some Other Dope Add Task feature to add task users",
                    new DeveloperDetails("Will", "Smith"), "1", "In Progress"));

            assertEquals("CR:0:BYN", testTask1.getTaskID());
            assertEquals("CR:1:IKE", testTask2.getTaskID());
            assertEquals("CR:2:SON", testTask3.getTaskID());
            assertEquals("CR:3:AKE", testTask4.getTaskID());
            assertEquals("CR:4:ILL", testTask5.getTaskID());
        } catch (Exception exc) {
            System.out.println("Error while testing: " + exc.getMessage());
        }
    }


    @Test
    void testFailingTaskDescription() {
        try {

            assertEquals("Please enter a task description of less than 50 " +
                    "characters", new Task("Login Feature",
                    String.valueOf(TASKS_DB.size()), "Create Login to "
                    + "authenticate users that are trying to "
                    + "login and use the application",
                    new DeveloperDetails("Robyn", "Harrison"),
                    "8", "To Do").printTaskAdditionResult());
        } catch (Exception exc) {
            System.out.println("Error while testing: " + exc);
        }
    }

    @Test
    void testSuccessfulTaskDescription() {
        try {

            assertEquals("Task successfully captured", new Task("Login Feature",
                    String.valueOf(TASKS_DB.size()), "Create Login to "
                    + "authenticate",
                    new DeveloperDetails("Robyn", "Harrison"),
                    "8", "To Do").printTaskAdditionResult());
        } catch (Exception exc) {
            System.out.println("Error while testing: " + exc);
        }
    }
}
