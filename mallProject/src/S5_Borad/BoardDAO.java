package S5_Borad;

import java.util.ArrayList;

import S_MyUtil.Util;


public class BoardDAO {
	
	private ArrayList<Board> boardList;

	
	public BoardDAO(){
		boardList = new ArrayList<Board>();
	}

	void addBoard(Board board) {		
		boardList.add(board);
	}

	public ArrayList<Board> getBoardList() {
		return boardList;
	}


	void removeBoard(int sel) {
		boardList.remove(sel);
	}

	void printBoard() {
		if(boardList.size()==0) {
			System.out.println("�Խñ��� �����ϴ�.");
			 return;
		}
		for(int i = 0 ; i < boardList.size();i++) {
			System.out.printf("[%d] %s\n",i+1,boardList.get(i).title);
		}
		System.out.print("�Խñ� ��ȣ ");
		readBoard(Util.getInt()-1);
	}
	
	void readBoard(int sel) {
		if(sel<0||sel>=boardList.size()) {
			System.err.println("���� ����");
			return;
		}
		System.out.println(boardList.get(sel));
	}
}
