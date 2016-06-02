package vocabulary;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class quiz extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private static database db = new database();
	private int score = 0;
	private int i =0;
	private JTextField textField_2;
	private int answerIndex;
	private String quizSize;
	int questionNumber;
	ArrayList<Integer> questionIndex;

	/**
	 * Create the frame.
	 * @throws FileNotFoundException 
	 */
	public quiz() throws FileNotFoundException {
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
		
		setTitle("Quiz");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(254, 6, 57, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblHowManyQuestions = new JLabel("How many questions fo you want?");
		lblHowManyQuestions.setBounds(16, 12, 274, 16);
		contentPane.add(lblHowManyQuestions);
		
		final JTextPane textPane = new JTextPane();
		textPane.setBounds(26, 40, 380, 193);
		contentPane.add(textPane);
		textPane.setDisabledTextColor(Color.GRAY);
		textPane.setEnabled(false);
		
		final JButton btnStart = new JButton("Start");
		btnStart.setBounds(310, 7, 117, 29);
		contentPane.add(btnStart);
		
		final JButton btnContinue = new JButton("Continue");
		btnContinue.setBounds(310, 245, 117, 29);
		contentPane.add(btnContinue);
		btnContinue.setEnabled(false);
		
		btnStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//if question number is not zero, start quiz
				i= 0;
				score = 0;
				quizSize = textField.getText();
				questionNumber = Integer.parseInt(quizSize);
				questionIndex = db.generateQuestionIndex(questionNumber);
				if (questionNumber == 0){}
				else {
					//shut donw the textField
					btnStart.setEnabled(false);
					textField.setDisabledTextColor(Color.GRAY);
					textField.setEnabled(false);
					textPane.setEnabled(true);
					btnContinue.setEnabled(true);
					i++;
					String result = (i + ". ");
					result = result + generateQuestion(questionIndex.get(i-1));
					textPane.setText(result);
					textField_2.setEnabled(true);
				}
			}
		});
		
		btnContinue.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (i< questionIndex.size()){
					if (textField_2.getText() == ""){}
					else {
						String answer = textField_2.getText();
						textField_2.setEnabled(false);
						if (checkAnswer(answer) == true){
							textField_1.setText("Correct");
						}
						else {
							textField_1.setText("Incorrect");
						}
						i++;
						String result = i + ". ";
						result = result + generateQuestion(questionIndex.get(i-1));
						textPane.setText(result);
						textField_2.setEnabled(true);
					}
				}
				else if (i== questionIndex.size()){
					if (textField_2.getText() == ""){}
					else {
						String answer = textField_2.getText();
						textField_2.setEnabled(false);
						if (checkAnswer(answer) == true){
							textField_1.setText("Correct");
						}
						else {
							textField_1.setText("Incorrect");
						}
						i++;
					}
				}
				else {
					textField_1.setText("Your score for this quiz is " + score + "/" + questionNumber);
					textField.setEnabled(true);
					btnStart.setEnabled(true);
					btnContinue.setEnabled(false);
					textField_1.setEnabled(false);
					textField_2.setEnabled(false);
				}
			}
		});
		
		textField_1 = new JTextField();
		textField_1.setBounds(80, 245, 210, 28);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setEnabled(false);
		
		textField_2 = new JTextField();
		textField_2.setBounds(36, 245, 38, 28);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		textField_2.setEnabled(false);
		
		
	}
	
	public String generateQuestion(int input){
		String result = "";
		word question = db.db.get(input-1);
		result = (question.getEnglish()) + "\n";
		Random random = new Random();
		answerIndex = random.nextInt(4) ;
		ArrayList<String> fourChoice = new ArrayList<String>();
		int j=0;
		while(j != 3){
			int wrongAnswerIndex = random.nextInt(999) + 1;
			if (wrongAnswerIndex != answerIndex){
				fourChoice.add(db.db.get(wrongAnswerIndex).getChinese());
				j++;
			}
		}
		fourChoice.add(answerIndex, db.db.get(input-1).getChinese());
		
		result  = result  + ("         A."+ fourChoice.get(0)) + "\n"
		+ ("         B."+ fourChoice.get(1)) +"\n"
		+ ("         C."+ fourChoice.get(2)) + "\n"
		+ ("         D."+ fourChoice.get(3)) + "\n";
		return result;
	}
	
	//check the answer given by the student
	public boolean checkAnswer(String input){
		input = input.toUpperCase();
		if (input.equals("A") && answerIndex == 0){
			score++;
			return true;
		}
		else if (input.equals("B") && answerIndex == 1){
			score++;
			return true;
		}
		else if (input.equals("C") && answerIndex == 2){
			score++;
			return true;
		}
		else if (input.equals("D") && answerIndex == 3){
			score++;
			return true;
		}
		else {
			return false;
		}
	}
}
