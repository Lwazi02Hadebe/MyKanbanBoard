/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import Model.UserInformation;
import Model.Validation;
import View.Main;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author ME
 */
public class TestLoginDetails {

    Validation validation;

    @AfterAll
    static void clearData() {
        Main.savedDetailsDatabase.clear();
    }

    @BeforeEach
    void initDatabase() {

//        (String firstName, String lastName, String userName, String userPassword)
        Main.savedDetailsDatabase.put(0,
                new UserInformation("Walter", "White", "H5bg_", "w@lt3rWh1t3"));
        Main.savedDetailsDatabase.put(1,
                new UserInformation("Pablo", "Escobar", "Em1l_", "P@bL0M@n"));
        Main.savedDetailsDatabase.put(2,
                new UserInformation("HumanName", "HumanSurname", "kyl_1",
                        "qU_3t1nc"));
    }

    @Test
    @DisplayName("Login Successful")
    void testSuccessfulLogin() {
        String testData = "P@bL0M@n";

        UserInformation user;
        validation = new Validation(user = new UserInformation(
                "Pablo",
                "Escobar",
                "Em1l_",
                testData));

        assertEquals(validation.getUser().getFirstName(), "Pablo");
        assertEquals(validation.getUser().getLastName(), "Escobar");
        assertEquals(validation.getUser().getUserName(), "Em1l_");
        assertEquals(validation.getUser().getUserPassword(), testData);


        System.out.println("show me is this working: " + validation.registerUser());
        assertEquals(validation.loginUser(user), true);
        System.out.println("show me the result of the data saved: " + validation.loginUser(user));
    }

    @Test
    @DisplayName("Login Failed")
    void testFailedLogin() {
        String testData = "w@lterWhite";

        UserInformation user;
        validation = new Validation(user = new UserInformation(
                "Walter",
                "White",
                "H5bg_",
                testData));

        assertEquals(validation.getUser().getFirstName(), "Walter");
        assertEquals(validation.getUser().getLastName(), "White");
        assertEquals(validation.getUser().getUserName(), "H5bg_");
        assertEquals(validation.getUser().getUserPassword(), testData);


        System.out.println("show me is this working: " + validation.registerUser());
        assertEquals(validation.loginUser(user), false);
        System.out.println("show me the result of the data saved: " + validation.loginUser(user));
    }

    @Test
    @DisplayName("Username correctly formatted")
    void testUsernameCorrectlyFormattedLogin() {
        String testData = "kyl_1";

        UserInformation user;
        validation = new Validation(user = new UserInformation(
                "HumanName",
                "HumanSurname",
                testData,
                "qU_3t1nc"));


        assertEquals(validation.getUser().getFirstName(), "HumanName");
        assertEquals(validation.getUser().getLastName(), "HumanSurname");

        System.out.println("show me is this working: " + validation.registerUser());
        assertEquals(validation.loginUser(user), true);
        System.out.println("show me the result of the data saved: " + validation.loginUser(user));
    }

    @Test
    @DisplayName("Username incorrectly formatted")
    void testUsernameIncorrectlyFormattedLogin() {
        String testData = "kyle2";

        UserInformation user;
        validation = new Validation(user = new UserInformation(
                "HumanName",
                "HumanSurname",
                testData,
                "qU_3t1nc"));

        assertEquals(validation.getUser().getFirstName(), "HumanName");
        assertEquals(validation.getUser().getLastName(), "HumanSurname");
        assertEquals(validation.getUser().getUserName(), testData);
        assertEquals(validation.checkUserName(testData), false);

        System.out.println("show me is this working: " +
                validation.registerUser());
        assertEquals(validation.loginUser(user), false);
        System.out.println("show me the result of the data saved: " +
                validation.loginUser(user));
    }

    @Test //Password meets complexity requirements The system returns: THIS IS WEHERE WE CONTINUE WORKING FROM!!!
    @DisplayName("Password meets complexity requirements")
    void testPasswordMeetsComplexityLoginRequirements() {
        String testData = "kyl_1";

        UserInformation user;
        validation = new Validation(user = new UserInformation(
                "HumanName",
                "HumanSurname",
                testData,
                "qU_3t1nc"));


        assertEquals("HumanName", validation.getUser().getFirstName());
        assertEquals("HumanSurname", validation.getUser().getLastName());

        System.out.println("show me is this working: " + validation.registerUser());
        assertEquals(true, validation.loginUser(user));
        System.out.println("show me the result of the data saved: " + validation.loginUser(user));
    }

    @Test
    @DisplayName("Password does not meet complexity requirements")
    void testPasswordDoesNotMeetComplexityLoginRequirements() {
        String testData = "kyl_1";

        UserInformation user;
        validation = new Validation(user = new UserInformation(
                "HumanName",
                "HumanSurname",
                testData,
                "qUesto1n"));

        assertEquals("HumanName", validation.getUser().getFirstName());
        assertEquals("HumanSurname", validation.getUser().getLastName());
        assertEquals(testData, validation.getUser().getUserName());

        System.out.println("show me is this working: " + validation.registerUser());
        assertEquals(false, validation.loginUser(user));
        System.out.println("show me the result of the data saved: " + validation.loginUser(user));
    }

}
