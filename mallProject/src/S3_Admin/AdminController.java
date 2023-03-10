package S3_Admin;


import S1_Member.MemberController;
import S2_Item.ItemController;
import S4_Cart.CartController;
import S_MyUtil.Util;

public class AdminController {
	private AdminController() {}
	static private AdminController instance = new AdminController();
	static public AdminController getInstance() {
		return instance;
	}	
	private MemberController memberController;
	private ItemController itemController;
	private CartController cartController;
	public void init() {
		itemController = ItemController.getInstance();
		cartController = CartController.getInstance();
		memberController= MemberController.getInstance();
	}
	public String menuAdmin() {
		while(true) {
			System.out.println("[1.회원관리] [2.상품관리] [3.장바구니관리] [0.뒤로가기]");
			int select = Util.getInt();
			if(select == 0) {
				return null;
			}else if(select == 1) {
				menuMemberAdmin();
			}else if(select == 2) {
				menuItemAdmin();
			}else if(select == 3) {
				menuCartAdmin();
			}else {
				System.err.println("입력 오류");
			}
		}
	}
	public void menuMemberAdmin() {
		while(true) {
			System.out.println("=== 회원 관리자 ===");
			System.out.println("[1.회원 목록] [2.주문목록] [0.뒤로가기]");
			int select = Util.getInt();
			if(select == 0) {
				break;
			}else if(select == 1) {
				memberController.getMemberDAO().printMemberList();
			}else if(select == 2) {
				memberController.getMemberDAO().printCartList(cartController);
			}else {
				System.err.println("입력 오류");
			}
		}
	}
	public void menuItemAdmin() {
		while(true) {		
			System.out.println("=== 아이템 관리자 ===");
			System.out.println("[1.상품전체출력 ] [2.아이템추가] [3.아이템삭제] [0.뒤로가기]");
			int select = Util.getInt();
			if(select == 0) {
				break;
			}else if(select == 1) {
				itemController.adminPrintItemList();				
			}else if(select == 2) {
				itemController.adminAddItem();
			}else if(select == 3) {
				itemController.adminRemoveItem();
			}
			else {
				System.err.println("입력 오류");
			}
		}
	}
	
	public void menuCartAdmin() {
		while(true) {		
			System.out.println("=== 장바구니 관리자 ===");
			System.out.println("[1.장바구니전체출력 ] [0.뒤로가기]");
				int select = Util.getInt();
				if(select == 0) {
					break;
				}else if(select == 1) {
					cartController.printAllCartList();
				}else {
					System.err.println("입력 오류");
				}
			}
	}
	
}
