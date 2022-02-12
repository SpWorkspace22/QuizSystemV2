package quiz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import quizUtility.FileOperations;
import quizUtility.QuestionAnswer;
import quizUtility.Student;
import quizUtility.User;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JSeparator;

public class StuentScreen extends JFrame implements ActionListener{

	private JComboBox paperList;
	
	private JPanel contentPane;
    private Student user;
    private FileOperations fileOp;
    private QuestionAnswer questionAnswer;
	/**
	 * Create the frame.
	 */
	public StuentScreen(Student userRef) {
		this.user = userRef;
	    fileOp = new FileOperations();
	    
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1116, 575);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel userNameLabel = new JLabel("Welcome "+user.getUserName()+" !!!!");
		userNameLabel.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 32));
		userNameLabel.setForeground(new Color(169, 169, 169));
		userNameLabel.setBounds(0, 0, 1098, 64);
		contentPane.add(userNameLabel);
		
		JLabel papaerListLabel = new JLabel("Please Select the Test");
		papaerListLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		papaerListLabel.setBounds(12, 317, 200, 22);
		contentPane.add(papaerListLabel);
		
		
		paperList = new JComboBox(fileOp.listPapers(user.getDepartment()));
		paperList.setFont(new Font("Tahoma", Font.BOLD, 16));
		paperList.setBounds(254, 317, 280, 22);
		contentPane.add(paperList);
		
		JButton btnNewButton = new JButton("Take Test");
		btnNewButton.setBackground(new Color(255, 250, 250));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(859, 474, 208, 25);
		btnNewButton.addActionListener(this);
		contentPane.add(btnNewButton);
		
		JLabel guidelies = new JLabel(guidelies());
		guidelies.setFont(new Font("Times New Roman", Font.BOLD, 18));
		guidelies.setBounds(12, 99, 1086, 177);
		contentPane.add(guidelies);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 77, 1076, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(12, 289, 1074, 15);
		contentPane.add(separator_1);
	}
	
	private String guidelies() {
		String guideline = "<html>Guidelines For Quiz<br><br>1: Each Question is of 1: Points<br><br>2: Next Button Will Show you the next question<br><br>"+
							"3: Going to previous question is not possible<br><br></html>";
		return guideline;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		questionAnswer = fileOp.preparePapers(user.getDepartment(),
				paperList.getItemAt(paperList.getSelectedIndex()).toString());
		
		this.setVisible(false);
		new QuizPage(questionAnswer,user).setVisible(true);
		
	}

}
