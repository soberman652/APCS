import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


import java.lang.Object;
import processing.data.*;
import processing.core.PApplet;




public class History{

	private ArrayList<QuestionAnswers> historyQuestions;
	
	public History() {
		historyQuestions = new ArrayList<QuestionAnswers>();
	}
	
	
	public void addHQuestions() {
		
	/*	
	{"category":"History","type":"multiple","difficulty":"easy","question":"What was William Frederick Cody better known as?","correct_answer":"Buffalo Bill","incorrect_answers":["Billy the Kid","Wild Bill Hickok","Pawnee Bill"]},
		                              {"category":"History","type":"multiple","difficulty":"easy","question":"Which famous world leader is famed for the saying, &quot;Let them eat cake&quot;, yet is rumored that he\/she never said it at all?","correct_answer":"Marie Antoinette","incorrect_answers":["Czar Nicholas II","Elizabeth I","Henry VIII"]},
		                              {"category":"History","type":"multiple","difficulty":"easy","question":"What was Manfred von Richthofen&#039;s nickname?","correct_answer":"The Red Baron","incorrect_answers":["The High Flying Ace","The Blue Serpent ","The Germany Gunner"]},
		                              {"category":"History","type":"multiple","difficulty":"easy","question":"Which modern day country is the region that was known as Phrygia in ancient times?","correct_answer":"Turkey","incorrect_answers":["Syria","Greece","Egypt"]},
		                              {"category":"History","type":"multiple","difficulty":"easy","question":"In which year did the Invasion of Kuwait by Iraq occur?","correct_answer":"1990","incorrect_answers":["1992","1988","1986"]},
		                              {"category":"History","type":"multiple","difficulty":"easy","question":"When did the Battle of the Somme begin?","correct_answer":"July 1st, 1916","incorrect_answers":["August 1st, 1916","July 2nd, 1916","June 30th, 1916"]},
		                              {"category":"History","type":"multiple","difficulty":"easy","question":"Who was the Prime Minister of Japan when Japan declared war on the US?","correct_answer":"Hideki Tojo","incorrect_answers":["Michinomiya Hirohito","Isoroku Yamamoto","Fumimaro Konoe"]},
		                              {"category":"History","type":"multiple","difficulty":"easy","question":"What was the first sport to have been played on the moon?","correct_answer":"Golf","incorrect_answers":["Football","Tennis","Soccer"]},
		                              {"category":"History","type":"multiple","difficulty":"easy","question":"How was Socrates executed?","correct_answer":"Poison","incorrect_answers":["Decapitation","Firing squad","Crucifixion "]},
		                              {"category":"History","type":"multiple","difficulty":"easy","question":"Who was among those killed in the 2010 Smolensk, Russia plane crash tragedy?","correct_answer":"The Polish President","incorrect_answers":["Pope John Paul II","Bang-Ding Ow","Albert Putin"]}]}
		*/
		String[] questions = {"What was William Frederick Cody better known as?",
							"Which famous world leader is famed for the saying, Let them eat cake?"};

		String[] correctAnswers = {"Buffalo Bill", "Marie Antoinette"};
		
		String[][] incorrectAnswers = {{"Billy the Kid","Wild Bill Hickok","Pawnee Bill"},{"The High Flying Ace","The Blue Serpent ","The Germany Gunner"}};
		
		for (int i=0; i<questions.length; i++) {
			historyQuestions.add(new QuestionAnswers(questions[i], correctAnswers[i], incorrectAnswers[i]));
		}
	}
}