package quizUtility;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileOperations {

	private String mainDir=null;
	private String department=null;
	private QuestionAnswer questionAnswer;
	
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
	
	public QuestionAnswer preparePapers(String departmentDir, String questionSet) {
		String path = this.mainDir+"/"+departmentDir+"/"+questionSet+".txt";
		File f = new File(path); 
		
		String question = null;
		String line =null;
		questionAnswer = new QuestionAnswer();
		
		
		try {
			Scanner sc = new Scanner(f);
			while(sc.hasNextLine()) {
				line = sc.nextLine();
				if(line.equalsIgnoreCase("<QB>")) {
					question = sc.nextLine();
				}
				
				if(line.equalsIgnoreCase("<OB>")) {	
					ArrayList<String> optionList = new ArrayList();
					line = sc.nextLine();
					while(!line.equalsIgnoreCase("<OE>")) {
				    	optionList.add(line);
				    	line=sc.nextLine();
					}
			    	questionAnswer.addQuestionOption(question, optionList);				
			}
				
				if(line.equalsIgnoreCase("<AB>")) {	
					line = sc.nextLine();
			    	questionAnswer.addQuestionAnswer(question, line);
				}
		 }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		Object[] questionO = questionAnswer.getQuestionOptionLists().keySet().toArray();
//		System.out.println(questionAnswer.getQuestionOptionLists().get(questionO[1]));
		
		return questionAnswer;
	}
	
}
