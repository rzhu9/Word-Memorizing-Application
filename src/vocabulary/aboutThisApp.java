package vocabulary;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class aboutThisApp extends JFrame {

	private JPanel contentPane;
	private JButton btnNewButton_2;
	/**
	 * Create the frame.
	 */
	public aboutThisApp() {
		setTitle("About This Application");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("关于公司");
		btnNewButton.setBounds(165, 24, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("关于我");
		btnNewButton_1.setBounds(307, 24, 117, 29);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("关于孙周");
		btnNewButton_2.setBounds(29, 24, 117, 29);
		contentPane.add(btnNewButton_2);
		
		final JTextPane textPane = new JTextPane();
		textPane.setBounds(29, 65, 395, 188);
		contentPane.add(textPane);
		
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textPane.setText("0");
			}
		});
		
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textPane.setText("My name is Ruihao Zhu(朱睿豪), and I am an undergraduate student"
				+ " at University of Wisconsin-Madison, double majoring in Computer Engineering, and Computer Science "
				+ "This application is designed to support my friend Kuanyuan Sunzhou's personal business, which is used "
				+ "to help high school students prepare for their TOEFL exam. One can use this as an e-dictionary to search "
				+ "for words and test his or her  TOEFL vocabulary. "
				+ "Any further questions about me or this app, please send an email to me. My email address is rzhu9@wisc.edu");
			}
		});
		
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textPane.setText("2");
			}
		});
	}
}
