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
			System.out.println("===[��ٱ��ϰ���]===");
			System.out.println("1)��ٱ������ 2)���� 3)���� 0)�ڷΰ���");
			int sel = Util.getInt();
			if (sel == 0) {
				break;
			} else if (sel == 1) {
				ArrayList<Cart> oneCartList = cartDAO.getOneCartList(mallController.getMemberLoginID());
				cartDAO.printOneCartList(oneCartList);
			} else if (sel == 2) {
				
			} else if (sel == 3) {
				
			} else {
				System.err.println("�Է� ����");
			}
		}
	}
	
	public void printAllCartList() {
		cartDAO.printAllCartList();
	}
	
	
	
}
