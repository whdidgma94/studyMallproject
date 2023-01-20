package S4_Cart;

import java.util.ArrayList;

import S0_MALL.MallController;
import S2_Item.Item;
import S_MyUtil.Util;

public class CartController {
	private CartController() {}
	static private CartController instance = new CartController();
	static public CartController getInstance() {
		return instance;
	}
	private CartDAO cartDAO;
	public CartDAO getCartDAO() {
		return cartDAO;
	}
	
	private MallController mallController;	
	public void init(CartDAO cartDAO) {
		this.cartDAO = cartDAO;
		mallController = MallController.getInstance();
	}
	
	public void insertCart(Item item) {
		Cart cart = new Cart();
		cart.setNumber(cartDAO.getCartNumber());
		cart.setMemberID(mallController.getMemberLoginID());
		cart.setItemName(item.getItemName());
		cart.setItemPrice(item.getPrice());
		cartDAO.insertCart(cart);
	}
	
	public void menuCart() {
		
		while(true) {
			System.out.println("===[장바구니관리]===");
			System.out.println("1)장바구니출력 2)구입 3)삭제 0)뒤로가기");
			ArrayList<Cart> oneCartList = cartDAO.getOneCartList(mallController.getMemberLoginID());
			int sel = Util.getInt();
			if (sel == 0) {
				break;
			} else if (sel == 1) {
				cartDAO.printOneCartList(oneCartList);
			} else if (sel == 2) {
				cartDAO.clearOneCartList(oneCartList,mallController.getMemberLoginID());
			} else if (sel == 3) {
				cartDAO.printOneCartList(oneCartList);
				cartDAO.removeOneCartList(oneCartList,mallController.getMemberLoginID());
			} else {
				System.err.println("입력 오류");
			}
		}
	}
	
	public void printAllCartList() {
		cartDAO.printAllCartList();
	}
	
	
	
}
