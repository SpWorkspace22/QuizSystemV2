package quiz;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import quizUtility.QuestionAnswer;
import quizUtility.Student;
// Quiz page will list the questions of the paper student has selected
public class QuizPage extends JFrame implements ActionListener{

	private JPanel contentPane;
	
	private JLabel headLabel;
	private JLabel questionLabel;
	private JRadioButton optionA;
	private JRadioButton optionB;
	private JRadioButton optionC;
	private JRadioButton optionD;
	
	private JButton nextQuestion;
	private JButton submitTest;
	private ButtonGroup btnGroup;
	
	
	private quizUtility.QuestionAnswer questionAnswers;
	private quizUtility.Student user;

	private Object questionList[];
	private ArrayList<String> optionList;
	private HashMap<String,String> userResponse;
	private int questionCounter;

	//Configuaring Screen elements
	public QuizPage(QuestionAnswer questionAnswers, Student user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1114, 543);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		headLabel = new JLabel();
		headLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		headLabel.setBounds(10, 0, 328, 68);
		contentPane.add(headLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 81, 1076, 2);
		contentPane.add(separator);
		
		questionLabel = new JLabel("Question 1");
		questionLabel.setFont(new Font("Monospaced", Font.BOLD, 16));
		questionLabel.setVerticalAlignment(SwingConstants.TOP);
		questionLabel.setBounds(10, 96, 1076, 128);
		contentPane.add(questionLabel);
		
		optionA = new JRadioButton("Option A");
		optionA.setFont(new Font("Tahoma", Font.PLAIN, 17));
		optionA.setBackground(new Color(255, 250, 250));
		optionA.setBounds(12, 260, 127, 25);
		contentPane.add(optionA);
		
		optionB = new JRadioButton("Option B");
		optionB.setFont(new Font("Tahoma", Font.PLAIN, 17));
		optionB.setBackground(new Color(255, 250, 250));
		optionB.setBounds(197, 260, 127, 25);
		contentPane.add(optionB);
		
		optionC = new JRadioButton("Option C");
		optionC.setFont(new Font("Tahoma", Font.PLAIN, 17));
		optionC.setBackground(new Color(255, 250, 250));
		optionC.setBounds(385, 260, 127, 25);
		contentPane.add(optionC);
		
		optionD = new JRadioButton("Option D");
		optionD.setFont(new Font("Tahoma", Font.PLAIN, 17));
		optionD.setBackground(new Color(255, 250, 250));
		optionD.setBounds(547, 260, 127, 25);
		contentPane.add(optionD);
		
		nextQuestion = new JButton("Next");
		nextQuestion.setBounds(848, 308, 238, 27);
		nextQuestion.addActionListener(this);
		contentPane.add(nextQuestion);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 348, 1076, 2);
		contentPane.add(separator_1);
		
		submitTest = new JButton("Submit Test");
		submitTest.setBounds(848, 414, 238, 25);
		submitTest.addActionListener(this);
		contentPane.add(submitTest);
	
		
		//initilizig questionAnswer Object to get option list of selected question ans 
		// perform check answer
		this.questionAnswers = questionAnswers;
		this.user = user;
		// List to store all user answers
		userResponse = new HashMap<String, String>();
		
		questionList = null;
		questionCounter = 0;   //counter to get next question from array
		
		initDataAndScreen();
	}
	
	// Displaying first question from list by default
	private void initDataAndScreen() {
		headLabel.setText("Welcome "+user.getUserName()+" !!!");
		
		btnGroup = new ButtonGroup();
		btnGroup.add(optionA);
		btnGroup.add(optionB);
		btnGroup.add(optionC);
		btnGroup.add(optionD);
		
		questionList = questionAnswers.getQuestionOptionLists().keySet().toArray();
		optionList = questionAnswers.getQuestionOptionLists().get(questionList[questionCounter]);
		
		questionLabel.setText(questionList[questionCounter].toString());
		optionA.setText(optionList.get(0));
		optionA.setActionCommand(optionList.get(0));
		optionB.setText(optionList.get(1));
		optionB.setActionCommand(optionList.get(1));
		optionC.setText(optionList.get(2));
		optionC.setActionCommand(optionList.get(2));
		optionD.setText(optionList.get(3));
		optionD.setActionCommand(optionList.get(3));
		
		//if the current question is last then  disable the next button
		if(questionCounter==(questionList.length-1)) {
			nextQuestion.setEnabled(false);
		}else {
			questionCounter++;
		}
	}

	//Displaying next question from list if any by moving counter
	private void setNextQuestion() {
		
			optionList.clear();
			optionList = questionAnswers.getQuestionOptionLists().get(questionList[questionCounter]);
			
			questionLabel.setText(questionList[questionCounter].toString());
			optionA.setText(optionList.get(0));
			optionA.setActionCommand(optionList.get(0));
			optionB.setText(optionList.get(1));
			optionB.setActionCommand(optionList.get(1));
			optionC.setText(optionList.get(2));
			optionC.setActionCommand(optionList.get(2));
			optionD.setText(optionList.get(3));
			optionD.setActionCommand(optionList.get(3));
			
			//if the current question is last then  disable the next button
			if(questionCounter==(questionList.length-1)) {
				nextQuestion.setEnabled(false);
			}

	}
	

	//Handling button actions
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() ==nextQuestion) {
			try{
			      userResponse.put(questionLabel.getText(),btnGroup.getSelection().getActionCommand());
			      btnGroup.clearSelection();

			}catch(NullPointerException ex) {
				userResponse.put(questionLabel.getText(),"");
			}finally {
				setNextQuestion();
			}
		}else {
		    userResponse.put(questionLabel.getText(),btnGroup.getSelection().getActionCommand());
		    int score = questionAnswers.check(userResponse);
			
		    this.setVisible(false);
		    new SummaryScreen(user.getUserName(), score, questionList.length).setVisible(true);;
		}
	}
	
}
