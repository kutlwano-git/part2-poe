import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginTaskTests {
 Login login = new Login();

   

    @Test
    public void testCheckUserName_Valid() {
        String username = "kyl_1";
        boolean result = login.checkUsername;
        Assertions.assertTrue(result);
    }

    @Test
    public void testCheckUserName_Invalid() {
        String username = "kyle!!!!!!!";
        boolean result = login.checkUserName();
        Assertions.assertFalse(result);
    }

    @Test
    public void testCheckPasswordComplexity_Valid() {
        String password = "Ch&&sec@ke99!";
        boolean result = login.checkPasswordComplexity();
        Assertions.assertTrue(result);
    }

    @Test
    public void testCheckPasswordComplexity_Invalid() {
        String password = "password";
        boolean result = login.checkPasswordComplexity();
        Assertions.assertFalse(result);
    }

    @Test
    public void testRegisterUser_ValidCredentials() {
        String username = "kyl_1";
        String password = "Ch&&sec@ke99!";
        String firstName = "John";
        String lastName = "Doe";
        String result = login.registerUser(username, password, firstName, lastName);
        Assertions.assertEquals("Registration successful", result);
    }

    @Test
    public void testRegisterUser_InvalidUsername() {
        String username = "kyle!!!!!!!";
        String password = "Ch&&sec@ke99!";
        String firstName = "John";
        String lastName = "Doe";
        String result = login.registerUser();
        Assertions.assertEquals("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.", result);
    }

    @Test
    public void testRegisterUser_InvalidPassword() {
        String username = "kyl_1";
        String password = "password";
        String firstName = "John";
        String lastName = "Doe";
        String result = login.registerUser();
        Assertions.assertEquals("Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.", result);
    }

    @Test
    public void testLoginUser_ValidCredentials() {
        String username = "kyl_1";
        String password = "Ch&&sec@ke99!";
        boolean result = login.loginUser();
        Assertions.assertTrue(result);
    }

    @Test
    public void testLoginUser_InvalidCredentials() {
        String username = "kyl_1";
        String password = "wrong_password";
        boolean result = login.loginUser();
        Assertions.assertFalse(result);
    }

    @Test
    Task task = new Task();
    public void testCheckTaskDescription_Valid() {
        String taskDescription = "Create Login to authenticate users";
        boolean result = task.checkTaskDescription(taskDescription);
        Assertions.assertTrue(result);
    }

    @Test
    public void testCheckTaskDescription_Invalid() {
        String taskDescription = "This is a very long task description that exceeds the maximum character limit of 50";
        boolean result = task.checkTaskDescription(taskDescription);
        Assertions.assertFalse(result);
    }

    @Test
    public void testCreateTaskID() {
        String taskName = "Login Feature";
        int taskNumber = 0;
        String developerLastName = "Harrison";
        String result = task.createTaskID(taskName, taskNumber, developerLastName);
        Assertions.assertEquals("LO:0:SON", result);
    }

    @Test
    public void testPrintTaskDetails() {
        String taskStatus = "To Do";
        String developerFirstName = "Robyn";
        String developerLastName = "Harrison";
        int taskNumber = 0;
        String taskName = "Login Feature";
        String taskDescription = "Create Login to authenticate users";
        String taskID = "LO:0:SON";
        int taskDuration = 8;
        String result = task.printTaskDetails(taskStatus, developerFirstName, developerLastName, taskNumber, taskName, taskDescription, taskID, taskDuration);
        String expectedDetails = "Task Status: To Do\nDeveloper: Robyn Harrison\nTask Number: 0\nTask Name: Login Feature\nTask Description: Create Login to authenticate users\nTask ID: LO:0:SON\nTask Duration: 8 hours";
        Assertions.assertEquals(expectedDetails, result);
    }

    @Test
    public void testReturnTotalHours() {
        int totalHours = task.returnTotalHours(8, 10, 5, 7);
        Assertions.assertEquals(30, totalHours);
    }
}