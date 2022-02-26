package quiz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import quizUtility.Faculty;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;

public class FacultyQuestionPaper extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;


	private Faculty fac;
	/**
	 * Create the frame.
	 */
	public FacultyQuestionPaper(Faculty faculty) {
		this.fac =  faculty;
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
		lblNewLabel.setBounds(12, 0, 945, 60);
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
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setLineWrap(true);
		textArea.setText("");
		textArea.setFont(new Font("Monospaced", Font.BOLD, 16));
		
		JLabel lblNewLabel_1_1 = new JLabel("Question");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_1_1.setBounds(12, 267, 175, 36);
		contentPane.add(lblNewLabel_1_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField.setBounds(108, 402, 284, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Option A");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(12, 404, 96, 16);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(575, 403, 324, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
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
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_2.setColumns(10);
		textField_2.setBounds(108, 464, 284, 22);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_3.setColumns(10);
		textField_3.setBounds(575, 463, 324, 22);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_4.setColumns(10);
		textField_4.setBounds(108, 524, 284, 22);
		contentPane.add(textField_4);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Answer");
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_2_1.setBounds(12, 527, 82, 16);
		contentPane.add(lblNewLabel_2_2_1);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(794, 576, 175, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Clear");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_1.setBounds(605, 576, 175, 25);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Add & Continue");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnNewButton_2.setBounds(403, 576, 184, 25);
		contentPane.add(btnNewButton_2);
	}
}
