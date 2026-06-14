/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import Model.DeveloperDetails;
import Model.Task;
import View.TaskReport;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static View.AddTaskDetailsDialog.TASKS_DB;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author ME
 */
public class TestTaskReport {

    @BeforeAll
    static void init() {
        TASKS_DB.clear();
        try {

            TASKS_DB.put(TASKS_DB.size(), new Task("Create Login",
                    String.valueOf(TASKS_DB.size()), "Create Login to "
                    + "authenticate users",
                    new DeveloperDetails("Mike", "Smith"), "5", "To Do"));

            TASKS_DB.put(TASKS_DB.size(), new Task("Create Add Features",
                    String.valueOf(TASKS_DB.size()), "Create Add Features",
                    new DeveloperDetails("Edward", "Harrington"),
                    "8", "In Progress"));

            TASKS_DB.put(TASKS_DB.size(), new Task("Create Reports"
                    , String.valueOf(TASKS_DB.size()), "Create Reports for "
                    + "summary of all tasks",
                    new DeveloperDetails("Samantha", "Paulson"), "2", "Done"));

            TASKS_DB.put(TASKS_DB.size(), new Task("Add Arrays"
                    , String.valueOf(TASKS_DB.size()), "Add Arrays",
                    new DeveloperDetails("Glenda", "Oberholzer"), "11", "To Do"));
        } catch (Exception exc) {
            System.out.println("Show me the exception: " + exc);
        }
    }

    @Test
    void testDeveloperArrayCorrectlyPopulated() {
        assertEquals(4, TASKS_DB.size(), "Has to return 4 as the size of the "
                + "array");
        String[] developers = {"Mike Smith", "Edward Harrington",
                "Samantha Paulson", "Glenda Oberholzer"};

        TASKS_DB.entrySet().stream().forEach(e -> {
            DeveloperDetails developer = ((Task) e.getValue()).getTaskDeveloperDetails();
            assertEquals(developers[e.getKey()], developer.getDevFirstName() + " "
                    + developer.getDevLastName(), "Results have to be: "
                    + developers[e.getKey()] + " for each iteration");
        });
    }

    @Test
    void testDisplayDeveloperAndDurationForTaskWithLongestDuration() {
        assertEquals(4, TASKS_DB.size(), "Has to return 4 as the size of the "
                + "array");
        TaskReport.findDeveloperWithTheLongestDuration();
        assertEquals("Name: Glenda Surname: Oberholzer",
                TaskReport.findDeveloperWithTheLongestDuration()
                        .getTaskDeveloperDetails().toString());
    }

    @Test
    void testSuccessfulSearchForTasks() {
        assertEquals(4, TASKS_DB.size(), "Has to return 4 as the size of the "
                + "array");

        List<Object> testResults = TaskReport.searchForTasks("Create Login");

        Task item = (Task) testResults.get(0);
        assertEquals("Name: Mike Surname: Smith, Create Login",
                item.getTaskDeveloperDetails().toString() + ", " +
                        item.getTaskName());
    }

    @Test
    void testSuccessfulSearchForAllTasksAssignedToDeveloper() {
        assertEquals(4, TASKS_DB.size(), "Has to return 4 as the size of the "
                + "array");
        List<Object> testResults = TaskReport
                .searchTaskWithDeveloper("Samantha,Paulson", "");

        Task item = (Task) testResults.get(0);
        assertEquals("Create Reports", item.getTaskName());
    }

    @Test
    void testSuccessfulDeletionOfTask() {
        assertEquals(4, TASKS_DB.size(), "Has to return 4 as the size of the "
                + "array");
        boolean testResults = TaskReport.deleteTask("Create reports");
        assertEquals(true, testResults);

        assertEquals(false, TaskReport.deleteTask("Create report"));
    }

    @Test
    void testSuccessfulDisplayOfReport() {
        assertEquals(4, TASKS_DB.size(), "Has to return 4 as the size of the "
                + "array");

        String[] developers = {"Mike,Smith", "Edward,Harrington",
                "Samantha,Paulson", "Glenda,Oberholzer"};
        String[] tasks = {"Create Login", "Create Add Features",
                "Create Reports", "Add Arrays"};
        String[] hours = {"5", "8", "2", "11"};
        String[] status = {"To Do", "In Progress", "Done", "To Do"};

        List<Object> testResults = TaskReport.fullDetailsOfTasks();

        IntStream.range(0, testResults.size()).forEach(index -> {
            Task task = (Task) testResults.get(index);
            assertEquals(developers[index],
                    task.getTaskDeveloperDetails().getDevFirstName() + "," +
                            task.getTaskDeveloperDetails().getDevLastName());
            assertEquals(tasks[index], task.getTaskName());
            assertEquals(hours[index], task.getTaskDuration().toString());
            assertEquals(status[index], task.getTaskStatus());

        });

//        assertEquals(false, taskReport.deleteTask("Create report"));
    }
}
