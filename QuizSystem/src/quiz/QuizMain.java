package quiz;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

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

import quizUtility.Faculty;
import quizUtility.FileOperations;
import quizUtility.Student;

import javax.swing.SwingConstants;

// Main Home page from where flow will divide
public class QuizMain extends JFrame  implements ActionListener{

	private JPanel contentPane;
	private JTextField userName;
	private JComboBox departmnetChooser;
	private JButton student;
	private JButton faculty;
	private Student stu;
	private Faculty fac;
	
	private String departmentList[];
	//Launching the main frame
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

	//Configuring the screen
	public QuizMain() {
		
		departmentList = new String[] {"MCA","BTECH","ENTC"};
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1116, 575);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ImageIcon icon = new ImageIcon("src/quiz/icons/quiz-img.png");
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
		
		ImageIcon teacherIcon = new ImageIcon("src/quiz/icons/teacher.png");
		faculty = new JButton(teacherIcon);
		faculty.setHorizontalAlignment(SwingConstants.LEFT);
		faculty.setVerticalAlignment(SwingConstants.BOTTOM);
		faculty.setText("Faculty");
		faculty.setBackground(new Color(255, 250, 250));
		faculty.setBounds(578, 359, 222, 129);
		faculty.addActionListener(this);
		contentPane.add(faculty);
		
		ImageIcon studentIcon = new ImageIcon("src/quiz/icons/reading.png");
		student = new JButton(studentIcon);
		student.setHorizontalAlignment(SwingConstants.LEFT);
		student.setVerticalAlignment(SwingConstants.BOTTOM);
		student.setText("Student");
		student.setBackground(new Color(255, 250, 250));
		student.setBounds(831, 359, 222, 129);
		student.addActionListener(this);
		contentPane.add(student);
		
		initiateProjectDirectory();
	}

	//Handling button operations
	public void actionPerformed(ActionEvent e) {
      // Launching Faculty Screen 
		if(e.getSource()==faculty) {

    	   if(checkUserName()) {
   			JOptionPane.showMessageDialog(null, "Please Enter User Name", "User Name Error", JOptionPane.ERROR_MESSAGE);
    	   }else {
    		   fac = new Faculty();
    		   fac.initializeUser(departmnetChooser.getItemAt(departmnetChooser.getSelectedIndex()).toString(),
        			   userName.getText());
        	   this.setVisible(false);
        	   new FacultyQuestionPaper(fac, new FileOperations()).setVisible(true);
    	   }
		}else{
		// Launching Student Screen
    	   if(checkUserName()) {
   			JOptionPane.showMessageDialog(null, "Please Enter User Name", "User Name Error", JOptionPane.ERROR_MESSAGE);
    	   }else {
        	   stu = new Student();
        	   stu.initializeUser(departmnetChooser.getItemAt(departmnetChooser.getSelectedIndex()).toString(),
        			   userName.getText());
        	   this.setVisible(false);
        	   new StuentScreen(stu).setVisible(true);
    	   }
       }
	}
	
	// initiate the directiry structure depending on the drive present
	private void initiateProjectDirectory() {
		File f = null;
		String path = null;
		if(new File("D:/").exists()) {
			path = "D:/QuizSystem";
			subDirectoryCreate(path);
		}else if(new File("F:/").exists()) {
			path = "F:/QuizSystem";
			subDirectoryCreate(path);
		}else {
			path = "E:/QuizSystem";
			subDirectoryCreate(path);
		}
	}
	
	// Create a sub folders  for different department
	private void subDirectoryCreate(String path) {
		File f = new File(path);
		if(!f.exists()) {
			f.mkdirs();
			FileOperations.mainDir=path;
		}
		
		FileOperations.mainDir=path;
		
		String[] fileList = f.list();
		
		if(fileList.length<1) {
			for(int i = 0; i<departmentList.length; i++) {
				new File(path+"/"+departmentList[i]).mkdir();
			}
		}else {
			for(int i = 0; i<departmentList.length; i++) {
				for(int j  = 0; j<fileList.length; j++) {
					if(!departmentList[i].equalsIgnoreCase(fileList[j])) {
						new File(path+"/"+departmentList[i]).mkdir();
					}
					break;
				}
			}
		}
	}
	//Validating user name field
	private boolean checkUserName() {
		if(userName.getText().length()<=0) {
			return true;
		}
		return false;
	 }
}
