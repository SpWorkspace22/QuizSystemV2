package quizUtility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FileOperations {

	private String mainDir=null;
	private String department=null;
	private QuestionAnswer questionAnswer;
	
	public FileOperations() {
		mainDir = "F:/QuizSystem";
		
	}
	
	// Extract the list of papers in the selected directory  
	// for student
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
	
	// Extract the questions , options and answers for selected question paper that is
	// from file selected by student
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
		
		return questionAnswer;
	}
	
	public void makeQuestionPaper(HashMap<String, ArrayList<String>> questionList, String departmentDir, String paperTitle) {
		String path = mainDir+"/"+departmentDir+"/"+paperTitle+".txt";
		
		File f = new File(path);
		FileWriter fw = null;
		try {
			fw = new FileWriter(f);
			
			for(Map.Entry<String, ArrayList<String>> questions : questionList.entrySet()) {
				String question = questions.getKey();
				ArrayList optionList = questions.getValue();
				
				fw.write("<QB>\n");
				fw.write(question+"\n");
				fw.write("<QE>\n");
				
				fw.write("<OB>\n");
				fw.write(optionList.get(0).toString()+"\n");
				fw.write(optionList.get(1).toString()+"\n");
				fw.write(optionList.get(2).toString()+"\n");
				fw.write(optionList.get(3).toString()+"\n");
				fw.write("<OE>\n");
				
				fw.write("<AB>\n");
				fw.write(optionList.get(4).toString()+"\n");
				fw.write("<AE>\n");
				fw.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(fw!=null) {
				try {
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
}
