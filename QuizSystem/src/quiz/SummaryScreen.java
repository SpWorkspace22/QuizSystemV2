package quiz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class SummaryScreen extends JFrame {

	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public SummaryScreen(String userName, int score, int total ) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 605, 357);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(248, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Summary Of Quiz");
		lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 21));
		lblNewLabel.setBounds(12, 13, 431, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("You Got "+score+" out of "+total+" Correct !!!!");
		lblNewLabel_1.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_1.setForeground(new Color(0, 139, 139));
		lblNewLabel_1.setBounds(12, 84, 493, 50);
		contentPane.add(lblNewLabel_1);
	}
}
