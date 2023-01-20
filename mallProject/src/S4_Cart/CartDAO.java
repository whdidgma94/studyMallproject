package S4_Cart;

import java.util.ArrayList;

import S_MyUtil.Util;


public class CartDAO {

	private ArrayList<Cart> cartList;
	private int cartNumber;

	public CartDAO() {
		cartList = new ArrayList<Cart>();
		cartNumber = 1000;
	}

	public int getCartNumber() {
		cartNumber += 1;
		return cartNumber;
	}

	public void insertCart(Cart cart) {
		cartList.add(cart);
	}

	public ArrayList<Cart> getOneCartList(String memberLoginID) {
		ArrayList<Cart> oneCartList = new ArrayList<Cart>();
		for (int i = 0; i < cartList.size(); i++) {
			if(cartList.get(i).getMemberID().equals(memberLoginID)) {
				oneCartList.add(cartList.get(i));
			}
		}
	
		return oneCartList;
	}
	
	public void printOneCartList(ArrayList<Cart> oneCartList) {
		for (int i = 0; i < oneCartList.size(); i++) {
			System.out.println(i + 1 + ")" + oneCartList.get(i));
		}
	}
	
	public void removeOneCartList(ArrayList<Cart> oneCartList,String name) {
		if(oneCartList.size()==0) {
			System.err.println("장바구니가 비었습니다.");
			return;
		}
		int sel = Util.getInt()-1;
		if(sel<0||sel>=oneCartList.size()) {
			System.err.println("입력 오류");
			return;
		}
		int cnt=0;
		for (int i = 0; i < cartList.size(); i++) {
			if (cartList.get(i).getMemberID().equals(name)) {
				if (cnt == sel) {
					cartList.remove(i);
					break;
				}
				cnt++;
			}
		}
	}
	
	public void clearOneCartList(ArrayList<Cart> oneCartList,String name) {
		if(oneCartList.size()==0) {
			System.err.println("장바구니가 비었습니다.");
			return;
		}
		for (int i = 0; i < cartList.size(); i++) {
			if(cartList.get(i).getMemberID().equals(name)) {
				cartList.remove(cartList.get(i));
				i--;
			}
		}
		
	}
	
	public void printAllCartList() {
		for (int i = 0; i < cartList.size(); i++) {
			System.out.println(i + 1 + ")" + cartList.get(i));
		}
	}
	
	
	
}
