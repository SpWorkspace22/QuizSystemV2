package quiz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import quizUtility.QuestionAnswer;
import quizUtility.Student;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.HeadlessException;
import java.util.ArrayList;

import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Color;

public class QuizPage extends JFrame {

	private JPanel contentPane;
	
	private JLabel headLabel;
	private JLabel questionLabel;
	private JRadioButton optionA;
	private JRadioButton optionB;
	private JRadioButton optionC;
	private JRadioButton optionD;
	
	private JButton nextQuestion;
	private JButton submitTest;
	
	
	private QuestionAnswer questionAnswers;
	private Student user;

	private Object questionList[];
	private ArrayList<String> optionList;
	/**
	 * Create the frame.
	 */
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
		contentPane.add(nextQuestion);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 348, 1076, 2);
		contentPane.add(separator_1);
		
		submitTest = new JButton("Submit Test");
		submitTest.setBounds(848, 414, 238, 25);
		contentPane.add(submitTest);
	
		
		this.questionAnswers = questionAnswers;
		this.user = user;
		
		questionList = null;
		
		initDataAndScreen();
	}
	
	private void initDataAndScreen() {
		headLabel.setText("Welcome "+user.getUserName()+" !!!");
		
		ButtonGroup btnGroup = new ButtonGroup();
		btnGroup.add(optionA);
		btnGroup.add(optionB);
		btnGroup.add(optionC);
		btnGroup.add(optionD);
		
		questionList = questionAnswers.getQuestionOptionLists().keySet().toArray();
		optionList = questionAnswers.getQuestionOptionLists().get(questionList[0]);
		
		questionLabel.setText(questionList[0].toString());
		optionA.setText(optionList.get(0));
		optionB.setText(optionList.get(1));
		optionC.setText(optionList.get(2));
		optionD.setText(optionList.get(3));
	}
	
}
