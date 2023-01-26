package S5_Borad;

public class Board {	
	String title;
	String content;
	String userName;
	public Board(String title, String content, String userName) {
		super();
		this.title = title;
		this.content = content;
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "[" + title + "] [ÀÛ¼ºÀÚ]"+ userName+ "\n" + content+"\n";
	}
	
}
