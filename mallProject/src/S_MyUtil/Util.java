package S_MyUtil;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Util {
	static public  Scanner scan = new Scanner(System.in);

	static public int getInt() {
		while (true) {
			int input = -1;
			System.out.print("�Է� : ");
			try {
				input = scan.nextInt();
			} catch (InputMismatchException e) {
				System.err.println("���� �Է� �Ұ�");
				scan.nextLine();
				continue;
			}
			return input;
		}
	}
}
