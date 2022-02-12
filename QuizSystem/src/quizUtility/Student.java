package quizUtility;

public class Student extends User {

	 public Student(){}

	@Override
	public void initializeUser(String departmentName, String user) {
		this.department = departmentName;
		this.userName = user;
		
	}
	
	public String getUserName() {
	   return this.userName;	
	}
	
	public String getDepartment() {
	
		return this.department;
	}
	
}
