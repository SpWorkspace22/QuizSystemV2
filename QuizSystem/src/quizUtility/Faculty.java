package quizUtility;

public class Faculty extends User {

	public Faculty() {
		
	}
	
	public void initializeUser(String departmentName, String user) {
		this.department = departmentName;
		this.userName = user;
	}
}
