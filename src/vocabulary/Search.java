package vocabulary;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Search extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnNewButton;
	public static database db = new database();

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 * @throws FileNotFoundException 
	 */
	public Search() throws FileNotFoundException {
		setTitle("Search");
		File file = new File("database.txt");
		Scanner fileIn = new Scanner(file);  //for console input	
		//go over each line of the input file
		//add movies to the database first
		//then add actor to movies that belong to that actor
			while(fileIn.hasNextLine())
			{	
				String[] line = fileIn.nextLine().split(",");
				int index = Integer.parseInt(line[0]);
				word word = new word(index, line[1], line[2]);
				db.addWord(word);
			}
		fileIn.close();
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		btnNewButton = new JButton("Search");
		
		final JTextPane textPane = new JTextPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(14)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addComponent(textPane))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 286, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnNewButton)))
					.addGap(43))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(28, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//when the button is clicked, the word will be translate
				String input = textField.getText();
				ArrayList<word> output = db.searchWord(input.toLowerCase());
				for (int i=0; i< output.size(); i++){
					textPane.setText(output.get(i).getChinese());
				}
				if (output.size() ==0){
					textPane.setText("the word does not exist");
				}
			}
		});
	}
}
