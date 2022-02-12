package quizUtility;

public abstract class User {
    String department;
    String userName;
    
    public abstract void initializeUser(String departmentName, String user);
}
