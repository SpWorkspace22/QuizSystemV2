package quiz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import quizUtility.Faculty;
import quizUtility.FileOperations;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;

public class FacultyQuestionPaper extends JFrame  implements ActionListener{

	private JPanel contentPane;
	JTextArea question;
	private JTextField optionA,optionB,optionC,optionD,answer;
	private JButton submit,clear,addAndContinue,backToHome;

	
	private Faculty fac;
	private FileOperations fileOperation;
	private HashMap<String, ArrayList<String>> questionList;
	
	//Configuring screen elements 
	public FacultyQuestionPaper(Faculty faculty, FileOperations file) {
		this.fac =  faculty;
		this.fileOperation = file;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 987, 661);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hello "+fac.getUserName());
		lblNewLabel.setForeground(new Color(0, 153, 153));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(12, 0, 532, 60);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 58, 947, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("<html>\r\n" + 
				"Guidelies!!<br>\r\n" + 
				"1. Question will be added one at a time.<br><br>\r\n" + 
				"2. To add more question click add & continue.<br><br>\r\n" + 
				"3. Until Submit is clicked all question will belong to one papers only.<br><br>\r\n" + 
				"4. Click Submit when to save paper.<br><br>\r\n" + 
				"</html>");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_1.setBounds(12, 74, 945, 180);
		contentPane.add(lblNewLabel_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(12, 252, 947, 2);
		contentPane.add(separator_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 304, 935, 69);
		contentPane.add(scrollPane);
		
		JLabel lblNewLabel_1_1 = new JLabel("Question");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_1_1.setBounds(12, 267, 175, 36);
		contentPane.add(lblNewLabel_1_1);
		
		question = new JTextArea();
		scrollPane.setViewportView(question);
		question.setLineWrap(true);
		question.setText("");
		question.setFont(new Font("Monospaced", Font.BOLD, 16));
		
		
		optionA = new JTextField();
		optionA.setFont(new Font("Tahoma", Font.BOLD, 14));
		optionA.setBounds(108, 402, 284, 22);
		contentPane.add(optionA);
		optionA.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Option A");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(12, 404, 96, 16);
		contentPane.add(lblNewLabel_2);
		
		optionB = new JTextField();
		optionB.setFont(new Font("Tahoma", Font.BOLD, 14));
		optionB.setBounds(575, 403, 324, 22);
		contentPane.add(optionB);
		optionB.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Option B");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(448, 405, 96, 16);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Option C");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_2.setBounds(12, 466, 96, 16);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Option D");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_3.setBounds(448, 466, 96, 16);
		contentPane.add(lblNewLabel_2_3);
		
		optionC = new JTextField();
		optionC.setFont(new Font("Tahoma", Font.BOLD, 14));
		optionC.setColumns(10);
		optionC.setBounds(108, 464, 284, 22);
		contentPane.add(optionC);
		
		optionD = new JTextField();
		optionD.setFont(new Font("Tahoma", Font.BOLD, 14));
		optionD.setColumns(10);
		optionD.setBounds(575, 463, 324, 22);
		contentPane.add(optionD);
		
		answer = new JTextField();
		answer.setFont(new Font("Tahoma", Font.BOLD, 14));
		answer.setColumns(10);
		answer.setBounds(108, 524, 284, 22);
		contentPane.add(answer);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Answer");
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_2_1.setBounds(12, 527, 82, 16);
		contentPane.add(lblNewLabel_2_2_1);
		
		submit = new JButton("Submit");
		submit.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		submit.setBounds(794, 576, 175, 25);
		submit.setEnabled(false);
		submit.addActionListener(this);
		contentPane.add(submit);
		
		clear = new JButton("Clear");
		clear.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		clear.setBounds(605, 576, 175, 25);
		clear.addActionListener(this);
		contentPane.add(clear);
		
		addAndContinue = new JButton("Add & Continue");
		addAndContinue.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		addAndContinue.setBounds(403, 576, 184, 25);
		addAndContinue.addActionListener(this);
		contentPane.add(addAndContinue);
		
		backToHome = new JButton("Back");
		backToHome.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		backToHome.setBounds(823, 17, 134, 32);
		backToHome.addActionListener(this);
		contentPane.add(backToHome);
		
		questionList = new HashMap<String, ArrayList<String>>();
	}
	

	//Handling buttion oprtaions
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==addAndContinue) {
			if(!isEmpty()) {
				addQuestioninList();
				clearFields();
				submit.setEnabled(true);
			}else {
				System.out.println("In addAndContinue");
				JOptionPane.showMessageDialog(this, "please fill all options.");
			}
		}else if(e.getSource()==clear) {
			clearFields();
		}else if(e.getSource()==submit){
			String paperTitle = JOptionPane.showInputDialog("Enter Paper Title");
			fileOperation.makeQuestionPaper(questionList, fac.getDepartment(), paperTitle);
		}else {
			this.setVisible(false);
			new QuizMain().setVisible(true);
		}
	}
	
	//Adding question to temporary List
	public void addQuestioninList() {
		ArrayList<String> optionList = new ArrayList<String>();
		
		optionList.add(optionA.getText());
		optionList.add(optionB.getText());
		optionList.add(optionC.getText());
		optionList.add(optionD.getText());
		optionList.add(answer.getText());
		
		questionList.put(question.getText(), optionList);
		
	}
	
	//Clearing all text fields
	private void clearFields() {
		question.setText("");
		optionA.setText("");
		optionB.setText("");
		optionC.setText("");
		optionD.setText("");
		answer.setText("");
	}
	
	//Validating if any fields is empty
	private boolean isEmpty() {
		if((question.getText().length() < 1) || (optionA.getText().length() < 1) || (optionB.getText().length() < 1) 
				|| (optionC.getText().length() < 1) || (optionD.getText().length() < 1) 
				|| (answer.getText().length() < 1)) {
			
			return true;
		}else {
			return false;
		}
	}
}
