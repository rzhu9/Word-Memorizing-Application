package vocabulary;

public class word {
	public String english;
	public String chinese;
	public int index;
	public word(int index, String english, String chinese){
		this.index = index;
		this.english = english;
		this.chinese = chinese;
	}
	public int getIndex(){
		return this.index;
	}
	public void setEnglish(String input){
		this.english = input;
	}
	public String getEnglish(){
		return this.english;
	}
	public void setChinese(String input){
		this.chinese = input;
	}
	public String getChinese(){
		return this.chinese;
	}
}
