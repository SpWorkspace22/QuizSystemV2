package quiz;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import quizUtility.Student;
import quizUtility.User;


public class QuizMain extends JFrame  implements ActionListener{

	private JPanel contentPane;
	private JTextField userName;
	private JComboBox departmnetChooser;
	private JButton student;
	private JButton faculty;

	private User quizUser;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuizMain frame = new QuizMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public QuizMain() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1116, 575);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(248, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ImageIcon icon = new ImageIcon("src/icons/quiz-img.png");
		JLabel imageLabel = new JLabel(icon);
		imageLabel.setBounds(0, 0, 521, 528);
		contentPane.add(imageLabel);
		
		JLabel desriptionLabel = new JLabel("Please Enter Following Details..");
		desriptionLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		desriptionLabel.setBounds(545, 13, 531, 32);
		contentPane.add(desriptionLabel);
		
		JLabel departmentLabel = new JLabel("Choose Department");
		departmentLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		departmentLabel.setBounds(545, 93, 148, 16);
		contentPane.add(departmentLabel);
		
		String departmentList[] = {"MCA"};
		
		departmnetChooser = new JComboBox(departmentList);
		departmnetChooser.setFont(new Font("Tahoma", Font.BOLD, 14));
		departmnetChooser.setBounds(723, 91, 349, 22);
		contentPane.add(departmnetChooser);
		
		JLabel userNameLabel = new JLabel("Enter Your Name");
		userNameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		userNameLabel.setBounds(545, 175, 148, 16);
		contentPane.add(userNameLabel);
		
		userName = new JTextField();
		userName.setFont(new Font("Tahoma", Font.BOLD, 14));
		userName.setBounds(723, 172, 349, 22);
		contentPane.add(userName);
		userName.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(533, 260, 565, 16);
		contentPane.add(separator);
		
		ImageIcon teacherIcon = new ImageIcon("src/icons/teacher.png");
		faculty = new JButton(teacherIcon);
		faculty.setBackground(new Color(255, 250, 250));
		faculty.setBounds(616, 350, 128, 108);
		faculty.addActionListener(this);
		contentPane.add(faculty);
		
		ImageIcon studentIcon = new ImageIcon("src/icons/reading.png");
		student = new JButton(studentIcon);
		student.setBackground(new Color(255, 250, 250));
		student.setBounds(837, 350, 120, 108);
		student.addActionListener(this);
		contentPane.add(student);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
       if(e.getSource()==faculty) {
    	   System.out.println("Faculty");
    	   if(checkUserName()) {
   			JOptionPane.showMessageDialog(null, "Please Enter User Name", "User Name Error", JOptionPane.ERROR_MESSAGE);
    	   }
       }else{
    	   System.out.println("student");
    	   if(checkUserName()) {
   			JOptionPane.showMessageDialog(null, "Please Enter User Name", "User Name Error", JOptionPane.ERROR_MESSAGE);
    	   }else {
        	   quizUser = new Student();
        	   quizUser.initializeUser(departmnetChooser.getItemAt(departmnetChooser.getSelectedIndex()).toString(),
        			   userName.getText());
        	   this.setVisible(false);
        	   new StuentScreen(quizUser).setVisible(true);
    	   }
       }
	}
	
	private boolean checkUserName() {
		if(userName.getText().length()<=0) {
			return true;
		}
		return false;
	 }
}
