package S_MyUtil;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Util {
	static public  Scanner scan = new Scanner(System.in);

	static public int getInt() {
		while (true) {
			int input = -1;
			System.out.print("입력 : ");
			try {
				input = scan.nextInt();
			} catch (InputMismatchException e) {
				System.err.println("문자 입력 불가");
				scan.nextLine();
				continue;
			}
			return input;
		}
	}
}
