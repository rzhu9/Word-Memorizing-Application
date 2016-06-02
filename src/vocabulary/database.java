package vocabulary;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class database {
	List <word> db = new ArrayList<word>();
	int score = 0;
	
	public database(){
		db = new ArrayList<word>();
		score = 0;
	}
	public void addWord(word input){
		db.add(input);
	}
	public ArrayList<word> searchWord(String input){
		ArrayList<word> output = new ArrayList<word>();
		for (int i=0; i<db.size(); i++){
			if (db.get(i).getEnglish().equals(input)){
				output.add(db.get(i));
			}
		}
		return output;
	}
	
	public ArrayList<word> searchWord2(String input){
		boolean stop = false;
		ArrayList<word> output = new ArrayList<word>();
		int i=0;
		while (stop == false){
			String sub = input.substring(0, input.length() -i);
			for (int k =0; k<db.size(); k++){
				if (db.get(k).getEnglish().contains(sub)){
					output.add(db.get(k));
					stop = true;
				}
			}
			i++;
		}
		return output;
	}
	//generate a list of number that has the size 'input'
	public ArrayList<Integer> generateQuestionIndex(int input){
		ArrayList<Integer> output = new ArrayList<Integer>();
		while (output.size() != input){
			Random random = new Random();
			int result = random.nextInt(499) + 1;
			if (output.contains(result) == false){
				output.add(result);
			}
		}
		return output;
	}
	
	public word getWord(int i){
		return db.get(i);
	}
}
