package S1_Member;

import java.util.ArrayList;
import S4_Cart.CartController;

public class MemberDAO {
	private ArrayList<Member> memberList;
	private int memberNumber;

	public MemberDAO() {
		memberNumber = 1000;
		memberList = new ArrayList<>();
		setSampleData();
	}
	public void addMember(Member member) {
		memberList.add(member);
	}
	public int getNextNumber() {
		memberNumber += 1;
		return memberNumber;
	}
	boolean checkMember(String id) {
		for (int i = 0; i < memberList.size(); i++) {
			if (id.equals(memberList.get(i).getMemberID())) {
				return true;
			}
		}
		return false;
	}
	boolean checkMemberLogin(String id, String pw) {
		for (int i = 0; i < memberList.size(); i++) {
			if (id.equals(memberList.get(i).getMemberID()) && 
					pw.equals(memberList.get(i).getMemberPW())) {
				return true;
			}
		}
		return false;
	}

	public void printMemberList() {
		for (int i = 0; i < memberList.size(); i++) {
			if (memberList.get(i).getMemberNumber() != 1) {
				System.out.println(memberList.get(i));
			}
		}
	}
	public void printCartList(CartController cartController) {
		cartController.getCartDAO().printAllCartList();
		
	}
	public void setSampleData() {

		Member member = new Member(getNextNumber(), "a", "a", "??ö??");
		addMember(member);
		member = new Member(getNextNumber(), "b", "b", "?̹ο?");
		addMember(member);
	}
}
