package S2_Item;


import java.util.ArrayList;
import java.util.Scanner;
import S4_Cart.CartController;
import S_MyUtil.Util;

public class ItemController {
	private ItemController() {}
	static private ItemController instance = new ItemController();
	static public ItemController getInstance() {
		return instance;
	}
	
	Scanner scan;
	ItemDAO itemDAO;
	CartController cartController;
	
	public void init(ItemDAO itemDAO) {
		this.itemDAO = itemDAO;
		scan = Util.scan;
		cartController = CartController.getInstance();
	}
	
	public void adminAddItem() {
		System.out.println("[�������߰�] ī�װ� �Է� : ");
		String categoryName = scan.next();
	
		System.out.println("[�������߰�] �������̸� �Է� :  ");
		String itemName = scan.next();
		boolean check = itemDAO.checkItemName(itemName);
		if(check == true) {
			System.out.println("[�ߺ� ������ �̸�]");
			return;
		}
		
		System.out.println("[�������߰�] �����Է� : ");
		int price = scan.nextInt();
		int number = itemDAO.getNextItemNumber();
		
		Item item = new Item(number, itemName, categoryName, price);
		itemDAO.addItem(item);
		System.out.println("[�������߰� ����]");
		adminPrintItemList();
	}
	public void adminRemoveItem() {		
		adminPrintItemList();
		System.out.println("[�����ۻ���] �������̸� �Է� :  ");
		String itemName = scan.next();		
		Item item=null;
		for(Item name : itemDAO.getItemList()) {
			if(itemName.equals(name.getItemName())) {
				item=name;
			}
		}	
		if(item == null) {
			System.out.println("[�������� �ʴ� ������]");
			return;
		}			
		itemDAO.removeItem(item);
		System.out.println("[�����ۻ��� ����]");
		adminPrintItemList();
	}
	
	public void adminPrintItemList() {
		itemDAO.printItemList();
	}
	
	public void adminPrintOneCategoryItemList(ArrayList<Item> categoryList) {
		itemDAO.printItemList(categoryList);
	}
	
	public void menuShop() {
		ArrayList<String> categoryList = itemDAO.getCategoryList();
		while(true) {
			System.out.println("===[ ī�װ� ]===");
			printCategoryList(categoryList);
			System.out.println("0) �ڷΰ���");
			int select = Util.getInt();
			if(select == 0) {
				break;
			}else if (select==-1) {
				System.err.println("�Է� ����");
				continue;
			}
			select -= 1;
			menuItemList(categoryList.get(select));
		}
	}
	public void printCategoryList(ArrayList<String> categoryList) {
		for(int i = 0; i < categoryList.size(); i++) {
			System.out.println(i + 1 + ")" + categoryList.get(i));
		}
	}
	
	public void menuItemList(String category) {
		ArrayList<Item> categoryList = itemDAO.getCategoryItemList(category);		
		while(true) {				
			System.out.println("===["+ category +"]===");
			adminPrintOneCategoryItemList(categoryList);
			System.out.println("0) �ڷΰ���");
			int select = Util.getInt();
			if(select == 0) {
				break;
			}else if (select==-1) {
				System.err.println("�Է� ����");
				continue;
			}
			Item item = categoryList.get(select -1);
			cartController.insertCart(item);
		}
	}
	
}
