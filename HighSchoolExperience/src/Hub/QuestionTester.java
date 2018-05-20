package Hub;

import java.util.Scanner;

public class QuestionTester {
	
	private static QuestionManager q;
	private static Course c;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		q = new QuestionManager();
		c = new Course();
		c.setScience();
		
		int numCorrect = 0;
		boolean choseCorrect;
		
		for (int i=0; i<20; i++) {
			System.out.println("\nQuestion "+(i+1)+":\n");
			choseCorrect = q.askQuestion(c, i);
			if (choseCorrect)
				numCorrect++;
		}
		
		System.out.println("You answered "+numCorrect+ "/20 correctly.");
	}

}
