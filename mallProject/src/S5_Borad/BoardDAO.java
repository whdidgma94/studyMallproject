package S5_Borad;

import java.util.ArrayList;

import S_MyUtil.Util;


public class BoardDAO {
	
	private ArrayList<Board> boardList;

	
	public BoardDAO(){
		boardList = new ArrayList<Board>();
	}

	void addBoard(String userName) {
		System.out.print("제목 입력 : ");
		String title = Util.scan.next();
		System.out.print("내용 입력 : ");
		String content = Util.scan.next();
		boardList.add(new Board(title,content,userName));
	}

	void removeBoard(String userName) {
		for (int i = 0; i < boardList.size(); i++) {
			if (userName.equals(boardList.get(i).userName)) {
				System.out.printf("[%d] %s < 삭제 가능\n", i + 1, boardList.get(i).title);
			} else {
				System.out.printf("[%d] %s\n", i + 1, boardList.get(i).title);
			}
		}
		System.out.print("삭제할 게시물 ");
		int sel = Util.getInt()-1;
		if(sel<0||sel>=boardList.size()) {
			System.err.println("범위 오류");
			return;
		}
		if(userName.equals(boardList.get(sel).userName)) {
			boardList.remove(sel);
			return;
		}
		System.err.println("본인의 게시물이 아닙니다");
	}

	void printBoard() {
		if(boardList.size()==0) {
			System.out.println("게시글이 없습니다.");
			 return;
		}
		for(int i = 0 ; i < boardList.size();i++) {
			System.out.printf("[%d] %s\n",i+1,boardList.get(i).title);
		}
		System.out.print("게시글 번호 ");
		readBoard(Util.getInt()-1);
	}
	
	void readBoard(int sel) {
		if(sel<0||sel>=boardList.size()) {
			System.err.println("범위 오류");
			return;
		}
		System.out.println(boardList.get(sel));
	}
}
