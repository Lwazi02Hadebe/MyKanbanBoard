package Model;

import View.Main;

import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    private static final String REGEX_PATTERN_PASSWORD =
            "^(?=.*[A-Za-z])" +
                    "(?=.*\\d)(?=.*[@$!%*#?&_])" +
                    "[A-Za-z\\d@$!%*#?&_]{8,}$";
    private static final String REGEX_PATTERN_USERNAME =
            "^(?=.*[0-5])(?=.*[a-zA-Z])"
                    + "(?=.*_).{0,5}$";
    UserInformation user;
    boolean isSuccessfulRegistration;

    public Validation(UserInformation user) {
        this.user = user;
        this.isSuccessfulRegistration = false;
    }

    public UserInformation getUser() {
        return user;
    }

    public void setUser(UserInformation user) {
        this.user = user;
    }

    public boolean getIsSuccessfulRegistration() {
        return this.isSuccessfulRegistration;
    }

    public boolean checkUserName(String userName) {
        if (userName.length() == 0)
            return false;

        Pattern usernamePattern = Pattern.compile(REGEX_PATTERN_USERNAME);
        Matcher usernameMatcher = usernamePattern.matcher(userName);
        return usernameMatcher.matches();
    }

    public boolean checkPasswordComplexity(String passWord) {
        if (passWord.length() == 0)
            return false;

        Pattern passwordPattern = Pattern.compile(REGEX_PATTERN_PASSWORD);
        Matcher passwordMatcher = passwordPattern.matcher(passWord);
        return passwordMatcher.matches();
    }

    public String registerUser() {
        String userName = this.user.getUserName().trim(); //this is for the username
        String password = this.user.getUserPassword().trim(); // This is for the password
        String firstName = this.user.getFirstName().trim(); //this is for the username
        String lastName = this.user.getLastName().trim(); // This is for the password

        boolean isBothEmpty = userName.length() == 0 && password.length() == 0;
        boolean isUsernameValid =
                userName.length() <= 5 && checkUserName(userName);
        boolean isPasswordValid =
                checkPasswordComplexity(password) && password.length() >= 8;
        boolean isBothCorrect =
                userName.length() <= 5 && checkUserName(userName)
                        && checkPasswordComplexity(password) && password.length() >= 8;

        //This section is for the code, the code bellow is for the Validation

        if (isBothEmpty)// If both username and password are both empty, then the following
            return "Please enter Username and password";
            //Case 2: This section is for if the user is entered and the password is blank
        else if (!isPasswordValid)
            return "Password is not " +
                    "correctly formatted, " +
                    "please ensure that " +
                    "the password " +
                    "contains at least 8 " +
                    "characters, a capital " +
                    "letter, a number and " +
                    "a special character.";
            //Case 3: This section is for if the Username us null and the Password is entered
        else if (!isUsernameValid)
            return "Username is not " +
                    "correctly formatted, " +
                    "please ensure that " +
                    "your username " +
                    "contains an " +
                    "underscore and is no " +
                    "more than 5 " +
                    "characters in length.";
            //Case 4: What must happen is the user enters all the parts of the form
        else if (isBothCorrect) {
            this.isSuccessfulRegistration = true;
            return "Welcome " + firstName + " ," + lastName + " " + "it is great to see you.";
        } else {
            return "Username or Password incorrect, please try again.";
        }
    }

    public boolean isUserPresentInDb(UserInformation user) {
        return Main
                .savedDetailsDatabase.entrySet()
                .stream()
                .filter(e -> user.getUserName()
                        .equals(((UserInformation) e.getValue())
                                .getUserName()) &&
                        user.getUserPassword()
                                .equals(((UserInformation) e.getValue())
                                        .getUserPassword()))
                .map(Map.Entry::getValue)
                .findFirst()
                .isPresent();
    }

    public String loginUserValidationMessages(UserInformation user) {

        boolean result = loginUser(user);
        if (!isUserPresentInDb(user))
            return "User does not exist, register a new account";
        if (result) {
            Optional<Object> loggedInUser = Main
                    .savedDetailsDatabase.entrySet()
                    .stream()
                    .filter(e -> user.getUserName()
                            .equals(((UserInformation) e.getValue())
                                    .getUserName()) &&
                            user.getUserPassword()
                                    .equals(((UserInformation) e.getValue())
                                            .getUserPassword()))
                    .map(Map.Entry::getValue)
                    .findFirst();
            return "Welcome " +
                    ((UserInformation) loggedInUser.get()).getFirstName() + " ," +
                    ((UserInformation) loggedInUser.get()).getLastName() + " "
                    + "it is great to see you.";
        } else {
            return "Username or Password incorrect, please try again.";
        }
    }

    public boolean loginUser(UserInformation user) {
        String userName = user.getUserName().trim();
        //this is for the username
        String password = user.getUserPassword().trim();
        // This is for the password

        boolean isBothEmpty = userName.length() == 0 && password.length() == 0;
        boolean isUsernameValid =
                userName.length() <= 5 && checkUserName(userName);
        boolean isPasswordValid =
                checkPasswordComplexity(password) && password.length() >= 8;
        boolean isBothCorrect = isUsernameValid && isPasswordValid;
        boolean isUserInDatabase = Main
                .savedDetailsDatabase.entrySet()
                .stream()
                .filter(e -> userName
                        .equals(((UserInformation) e.getValue())
                                .getUserName()) &&
                        password
                                .equals(((UserInformation) e.getValue())
                                        .getUserPassword()))
                .map(Map.Entry::getKey)
                .findFirst()
                .isPresent();
        boolean isBothCorrectAndInDB = isBothCorrect && isUserInDatabase;

        if (isBothEmpty) return false;
        else if (!isUsernameValid) return false;
        else if (!isPasswordValid) return false;
        else return isBothCorrectAndInDB;
    }

    public static enum VALIDATION_STATES {
        LOGIN_SUCCESSFUL,
        LOGIN_FAILED,
        LOGIN_INVALID,
    }

}
