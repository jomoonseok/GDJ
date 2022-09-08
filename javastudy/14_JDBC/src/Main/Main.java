package Main;

import controller.ContactController;

public class Main {

	public static void main(String[] args) {

		// Controller -> Service -> DAO -> DB

		// DAO -> Service -> Controller순으로 개발
		
		new ContactController().play();
		
	}

}
