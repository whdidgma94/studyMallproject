package S5_Borad;

import S0_MALL.MallController;
import S_MyUtil.Util;

public class BoardController {
	
	private MallController mallController;
	private BoardController() {
		
	}

	static private BoardController instance = new BoardController();

	static public BoardController getInstance() {
		return instance;
	}

	private BoardDAO boardDAO;

	public BoardDAO getBoardDAO() {
		return boardDAO;
	}
	public void init(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
		mallController = MallController.getInstance();		
	}
	
	void addBoard(String userName) {
		System.out.print("제목 입력 : ");
		String title = Util.scan.next();
		System.out.print("내용 입력 : ");
		String content = Util.scan.next();
		Board board =new Board(title,content,userName);
		boardDAO.addBoard(board);
	}
	
	void removeBoard(String userName) {
		for (int i = 0; i < boardDAO.getBoardList().size(); i++) {
			if (userName.equals(boardDAO.getBoardList().get(i).userName)) {
				System.out.printf("[%d] %s < 삭제 가능\n", i + 1, boardDAO.getBoardList().get(i).title);
			} else {
				System.out.printf("[%d] %s\n", i + 1, boardDAO.getBoardList().get(i).title);
			}
		}
		System.out.print("삭제할 게시물 ");
		int sel = Util.getInt()-1;
		if(sel<0||sel>=boardDAO.getBoardList().size()) {
			System.err.println("범위 오류");
			return;
		}
		if(userName.equals(boardDAO.getBoardList().get(sel).userName)) {
			boardDAO.removeBoard(sel);
			return;
		}
		System.err.println("본인의 게시물이 아닙니다");
	}
	
	public void menuBoard() {
		while (true) {
			System.out.println("[1]게시글 목록 [2]게시글 작성 [3]게시글 삭제 [0]뒤로 가기");
			int sel = Util.getInt();
			if (sel == 1) {
				boardDAO.printBoard();
			} else if (sel == 2) {
				addBoard(mallController.getMemberLoginID());
			} else if (sel == 3) {
				removeBoard(mallController.getMemberLoginID());
			} else if (sel == 0) {
				break;
			} else {
				System.err.println("입력 오류");
			}
		}
	}


}
