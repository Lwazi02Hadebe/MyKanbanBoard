import Model.UserInformation;
import Model.Validation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLoginUsername {

    Validation validation;

    @Test
    @DisplayName("Username is correctly formatted")
    void testUsernameContainsUnderscoreNoMoreThan5() {
        String testData = "kyl_1";

        validation = new Validation(new UserInformation(
                "HumanName",
                "HumanSurname",
                testData,
                "qU_3t1nc"));


        assertEquals(validation.getUser().getFirstName(), "HumanName");
        assertEquals(validation.getUser().getLastName(), "HumanSurname");
        assertEquals(validation.getUser().getUserName(), testData);
        assertEquals(validation.checkUserName(testData), true);
        assertEquals("Welcome " +
                        validation.getUser().getFirstName() + " ," +
                        validation.getUser().getLastName() + " it is great to see you.",
                validation.registerUser());
    }

    @Test
    @DisplayName("Username incorrectly formatted")
    void testUsernameIncorrectlyFormatted() {
        String testData = "kyle!!!!!!!";

        validation = new Validation(new UserInformation(
                "PersonName",
                "PersonSurname",
                testData,
                "qBit12@sds__D@!"));

        assertEquals(validation.getUser().getFirstName(), "PersonName");
        assertEquals(validation.getUser().getLastName(), "PersonSurname");
        assertEquals(validation.getUser().getUserName(), testData);
        assertEquals(validation.checkUserName(testData), false);
        assertEquals(
                "Username is not " +
                        "correctly formatted, " +
                        "please ensure that " +
                        "your username " +
                        "contains an " +
                        "underscore and is no " +
                        "more than 5 " +
                        "characters in length.",
                validation.registerUser());
    }
}
