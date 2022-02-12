package quizUtility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

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
	
	public int check(HashMap<String,String> userResponse) {
		int count = 0;
		
		for(Map.Entry<String, String> entry : userResponse.entrySet()) {
			if(questionAnswer.get(entry.getKey()).equals(userResponse.get(entry.getKey()))){
				count++;
			}
		}
		return count;
	}
}

