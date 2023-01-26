package S1_Member;

import java.util.Scanner;

import S2_Item.ItemController;
import S4_Cart.CartController;
import S5_Borad.BoardController;
import S_MyUtil.Util;

public class MemberController {
	private MemberController() {}
	static private MemberController instance = new MemberController();
	static public MemberController getInstance() {
		return instance;
	}
	private MemberDAO memberDAO;
	private ItemController itemController;
	private CartController cartController;
	private BoardController boardController;
	private Scanner scan;
	public void init(MemberDAO memberDAO){
		this.memberDAO = memberDAO;
		itemController = ItemController.getInstance();
		cartController = CartController.getInstance();
		boardController = BoardController.getInstance();
		scan = Util.scan;
		managerSetting();
	}
	public void managerSetting() {
		if(getMemberDAO().checkMember("admin") == false) {
			Member member = new Member( 1,"admin","admin","������");		
			getMemberDAO().addMember(member);
		}	
	}
	public String memberLogin() {
		System.out.println("===[ �α��� ]===");
		System.out.println("[�α���] ���̵� �Է� : ");
		String id = scan.next();
		System.out.println("[�α���] ��й�ȣ �Է� : ");
		String pw = scan.next();
		boolean check = getMemberDAO().checkMemberLogin(id, pw);
		if(check == true) {
			System.out.println("["+id+" �α���]");
			return id;
		}
		return null;
	}
	public void memberJoin() {		
		System.out.println("===[ ȸ������ ]===");
		System.out.println("[ȸ������] ���̵� �Է� : ");
		String id = scan.next();
		boolean check = getMemberDAO().checkMember(id);
		if(check == true) {
			System.out.println("[�ߺ����̵�]");
		}
		else {
			System.out.println("[ȸ������] ��й�ȣ �Է� : ");
			String pw = scan.next();
			System.out.println("[ȸ������] �̸� �Է� : ");
			String name = scan.next();		
			int memberNumber = getMemberDAO().getNextNumber();
			Member member = new Member(memberNumber , id , pw , name);		
			getMemberDAO().addMember(member);
			System.out.println("[ȸ������ ����]");
		}
	}
	public String menuMember() {
		while(true) {
			System.out.println("[1.����] [2.��ٱ���] [3.�Խ���] [0.�ڷΰ���] ");
			int select = Util.getInt();
			if(select == 0) {
				return null;
			}else if(select == 1) {
				itemController.menuShop();
			}else if(select == 2) {
				cartController.menuCart();
			}else if(select == 3) {
				boardController.menuBoard();
			}else {
				System.err.println("�Է� ����");
			}
		}	
	}
	public MemberDAO getMemberDAO() {
		return memberDAO;
	}
}
