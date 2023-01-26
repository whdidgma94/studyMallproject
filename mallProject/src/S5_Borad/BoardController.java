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

	public void menuBoard() {
		while (true) {
			System.out.println("[1]�Խñ� ��� [2]�Խñ� �ۼ� [3]�Խñ� ���� [0]�ڷ� ����");
			int sel = Util.getInt();
			if (sel == 1) {
				boardDAO.printBoard();
			} else if (sel == 2) {
				boardDAO.addBoard(mallController.getMemberLoginID());
			} else if (sel == 3) {
				boardDAO.removeBoard(mallController.getMemberLoginID());
			} else if (sel == 0) {
				break;
			} else {
				System.err.println("�Է� ����");
			}
		}
	}


}
