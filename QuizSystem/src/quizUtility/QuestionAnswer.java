package quizUtility;

import java.util.ArrayList;
import java.util.HashMap;

public class QuestionAnswer {

	private HashMap<String,ArrayList<String>> questionOption; 
	private HashMap<String,String> questionAnswer;
	private ArrayList<String> optionList;
	public QuestionAnswer(){
		optionList = new ArrayList<String>();
		questionOption =  new HashMap<String,ArrayList<String>>();
		questionAnswer = new HashMap<String,String>();
	}
	
	public void addQuestionOption(String question,ArrayList<String> options) {
		questionOption.put(question, options);

	}
	
	public void addQuestionAnswer(String question,String answer) {
		questionAnswer.put(question, answer);
	}
	
	public HashMap<String, ArrayList<String>> getQuestionOptionLists() {
		return questionOption;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.valueOf(questionOption.size());
	}
	
	public String check() {
		return null;
	}
}

