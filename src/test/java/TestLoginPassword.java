import Model.UserInformation;
import Model.Validation;
import View.Main;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLoginPassword {

    Main testFunctions;
    Validation validation;

    @Test
    @DisplayName("The password meets the complexity requirements")
    void testPasswordMeetsTheComplexityRequirements() {
        String testData = "Ch&&sec@ke99!!";

        validation = new Validation(new UserInformation(
                "PersonName",
                "PersonSurname",
                "kyl_1",
                testData));

        assertEquals(validation.getUser().getFirstName(), "PersonName");
        assertEquals(validation.getUser().getLastName(), "PersonSurname");
        assertEquals(validation.getUser().getUserName(), "kyl_1");
        assertEquals(validation.checkPasswordComplexity(testData), true);
        assertEquals("Welcome " + validation.getUser().getFirstName() + " ,"
                        + validation.getUser().getLastName() + " it is great to see you.",
                validation.registerUser()
        );
    }

    @Test
    @DisplayName("The password does no meet the complexity requirements")
    void testPasswordDoesNotMeetRequirements() {
        String testData = "password";

        validation = new Validation(new UserInformation(
                "HumanName",
                "HumanSurname",
                "kyl1_",
                testData));

        assertEquals(validation.getUser().getFirstName(), "HumanName");
        assertEquals(validation.getUser().getLastName(), "HumanSurname");
        assertEquals(validation.getUser().getUserName(), "kyl1_");
        assertEquals(validation.checkPasswordComplexity(testData), false);
        assertEquals(
                "Password is not " +
                        "correctly formatted, " +
                        "please ensure that " +
                        "the password " +
                        "contains at least 8 " +
                        "characters, a capital " +
                        "letter, a number and " +
                        "a special character.",
                validation.registerUser()
        );

    }
}
