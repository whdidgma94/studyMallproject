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
			Member member = new Member( 1,"admin","admin","관리자");		
			getMemberDAO().addMember(member);
		}	
	}
	public String memberLogin() {
		System.out.println("===[ 로그인 ]===");
		System.out.println("[로그인] 아이디 입력 : ");
		String id = scan.next();
		System.out.println("[로그인] 비밀번호 입력 : ");
		String pw = scan.next();
		boolean check = getMemberDAO().checkMemberLogin(id, pw);
		if(check == true) {
			System.out.println("["+id+" 로그인]");
			return id;
		}
		return null;
	}
	public void memberJoin() {		
		System.out.println("===[ 회원가입 ]===");
		System.out.println("[회원가입] 아이디 입력 : ");
		String id = scan.next();
		boolean check = getMemberDAO().checkMember(id);
		if(check == true) {
			System.out.println("[중복아이디]");
		}
		else {
			System.out.println("[회원가입] 비밀번호 입력 : ");
			String pw = scan.next();
			System.out.println("[회원가입] 이름 입력 : ");
			String name = scan.next();		
			int memberNumber = getMemberDAO().getNextNumber();
			Member member = new Member(memberNumber , id , pw , name);		
			getMemberDAO().addMember(member);
			System.out.println("[회원가입 성공]");
		}
	}
	public String menuMember() {
		while(true) {
			System.out.println("[1.쇼핑] [2.장바구니] [3.게시판] [0.뒤로가기] ");
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
				System.err.println("입력 오류");
			}
		}	
	}
	public MemberDAO getMemberDAO() {
		return memberDAO;
	}
}
