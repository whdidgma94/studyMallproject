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
		System.out.print("���� �Է� : ");
		String title = Util.scan.next();
		System.out.print("���� �Է� : ");
		String content = Util.scan.next();
		Board board =new Board(title,content,userName);
		boardDAO.addBoard(board);
	}
	
	void removeBoard(String userName) {
		for (int i = 0; i < boardDAO.getBoardList().size(); i++) {
			if (userName.equals(boardDAO.getBoardList().get(i).userName)) {
				System.out.printf("[%d] %s < ���� ����\n", i + 1, boardDAO.getBoardList().get(i).title);
			} else {
				System.out.printf("[%d] %s\n", i + 1, boardDAO.getBoardList().get(i).title);
			}
		}
		System.out.print("������ �Խù� ");
		int sel = Util.getInt()-1;
		if(sel<0||sel>=boardDAO.getBoardList().size()) {
			System.err.println("���� ����");
			return;
		}
		if(userName.equals(boardDAO.getBoardList().get(sel).userName)) {
			boardDAO.removeBoard(sel);
			return;
		}
		System.err.println("������ �Խù��� �ƴմϴ�");
	}
	
	public void menuBoard() {
		while (true) {
			System.out.println("[1]�Խñ� ��� [2]�Խñ� �ۼ� [3]�Խñ� ���� [0]�ڷ� ����");
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
				System.err.println("�Է� ����");
			}
		}
	}


}
