package S5_Borad;

import java.util.ArrayList;

import S_MyUtil.Util;


public class BoardDAO {
	
	private ArrayList<Board> boardList;

	
	public BoardDAO(){
		boardList = new ArrayList<Board>();
	}

	void addBoard(String userName) {
		System.out.print("���� �Է� : ");
		String title = Util.scan.next();
		System.out.print("���� �Է� : ");
		String content = Util.scan.next();
		boardList.add(new Board(title,content,userName));
	}

	void removeBoard(String userName) {
		for (int i = 0; i < boardList.size(); i++) {
			if (userName.equals(boardList.get(i).userName)) {
				System.out.printf("[%d] %s < ���� ����\n", i + 1, boardList.get(i).title);
			} else {
				System.out.printf("[%d] %s\n", i + 1, boardList.get(i).title);
			}
		}
		System.out.print("������ �Խù� ");
		int sel = Util.getInt()-1;
		if(sel<0||sel>=boardList.size()) {
			System.err.println("���� ����");
			return;
		}
		if(userName.equals(boardList.get(sel).userName)) {
			boardList.remove(sel);
			return;
		}
		System.err.println("������ �Խù��� �ƴմϴ�");
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
