package vocabulary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class MyFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		//Scanner stdin = new Scanner (System.in);
		File file = new File(args[2]);
		//check the size of command line argument
		if (args.length != 3){
			System.out.println("Usage: java vocabularyAPP FileName");
			System.exit(0);
		}
		//check whether the input file exists and readable
		if (!(file.exists() && file.canRead())){
			System.out.println("Error: Cannot access input file");
			System.exit(0);
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyFrame frame = new MyFrame();
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
	public MyFrame() {
		setTitle("Sunzhou's Vocabulary Application");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//when mouse click on the search button
				//a new window will be displayed
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Search frame = new Search();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnNewButton.setForeground(Color.RED);
		contentPane.add(btnNewButton, BorderLayout.WEST);
		
		JButton btnNewButton_1 = new JButton("Advanced Search");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//System.out.println("Advanced Search");
				//when mouse click on the search button
				//a new window will be displayed
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							advancedSearch frame = new advancedSearch();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnNewButton_1.setForeground(Color.GREEN);
		contentPane.add(btnNewButton_1, BorderLayout.CENTER);
		
		JButton btnNewButton_2 = new JButton("Quiz");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//System.out.println("Quiz");
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							quiz frame = new quiz();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnNewButton_2.setForeground(Color.CYAN);
		btnNewButton_2.setBackground(Color.WHITE);
		contentPane.add(btnNewButton_2, BorderLayout.EAST);
		
		JButton btnAbout = new JButton("About This Application");
		btnAbout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//System.out.println("About this application");
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							aboutThisApp frame = new aboutThisApp();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		contentPane.add(btnAbout, BorderLayout.SOUTH);
	}
}
