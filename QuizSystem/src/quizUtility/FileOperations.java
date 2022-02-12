package quizUtility;

import java.io.File;

public class FileOperations {

	private String mainDir=null;
	private String departmentDir=null;
	
	public FileOperations() {
		mainDir = "F:/QuizSystem";
	}
	
	public String[] listPapers(String departmentDir) {
		String path = mainDir+"/"+departmentDir;
		
		File f = new File(path);
		String list[];
		
		try {
		list = f.list();
		
		for(int i=0; i<list.length; i++) {
			list[i] =  list[i].substring(0, list[i].indexOf("."));
		}
		}catch(Exception ex) {
			list = new String[] {""};
		}
		return list;
	}
	
	
}
