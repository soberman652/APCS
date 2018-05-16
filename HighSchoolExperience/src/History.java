import java.util.ArrayList;
import java.util.List;


/**
 * 
 * @author sashaoberman
 *
 */
public class History extends Course{

	private ArrayList<QuestionAnswers> historyQuestions;
	
	public History(Grade grade) {
		super(grade);
		historyQuestions = new ArrayList<QuestionAnswers>();
	}
	
	public History() {
		super(new Grade('C'));
		historyQuestions = new ArrayList<QuestionAnswers>();
	}
	
	
	public void addHQuestions() {
		
		
		String[] rawQuestions = {
		"Who discovered Penicillin?","Alexander Flemming","Marie Curie","Alfred Nobel","Louis Pasteur",
		"How many manned moon landings have there been?","6","1","3","7",
		"The idea of Socialism was articulated and advanced by whom?","Karl Marx","Vladimir Lenin","Joseph Stalin","Vladimir Putin",
		"Which of the following ancient peoples was NOT classified as Hellenic (Greek)?","Illyrians","Dorians","Achaeans","Ionians",
		"Which famous world leader is famed for the saying, Let them eat cake, yet is rumored that never said it at all?","Marie Antoinette","Czar Nicholas II","Elizabeth I","Henry VIII",
		"The original Roman alphabet lacked the following letters EXCEPT:","X","W","U","J",
		"Which of these countries remained neutral during World War II?","Switzerland","United Kingdom","France","Italy",
		"The collapse of the Soviet Union took place in which year?","1991","1992","1891","1990",
		"What was Manfred von Richthofens nickname?","The Red Baron","The High Flying Ace","The Blue Serpent ","The Germany Gunner",
		"When did the Battle of the Somme begin?","July 1st, 1916","August 1st, 1916","July 2nd, 1916","June 30th, 1916",
		"In 1720, England was in massive debt, and became in involved in the South Sea Bubble. Who was the main mastermind behind it?","John Blunt","Daniel Defoe","Robert Harley","John Churchill",
		"Who was the Prime Minister of Japan when Japan declared war on the US?","Hideki Tojo","Michinomiya Hirohito","Isoroku Yamamoto","Fumimaro Konoe",
		"What was the first sport to have been played on the moon?","Golf","Football","Tennis","Soccer",
		"Who was the first prime minister of Canada?","John Macdonald","John Abbott","Alexander Mackenzie","Robert Borden",
		"How was Socrates executed?","Poison","Decapitation","Firing squad","Crucifixion ",
		"How long did World War II last?","6 years","4 years","5 years","7 years",
		"Which of the following countries was not an axis power during World War II?"," Soviet Union","Italy","Germany","Japan",
		"The Trail of Tears was a result of which United States Presidents Indian Removal Policy?","Andrew Jackson","Harry S. Truman","Martin Van Buren","John Quincy Adams",
		"To what political party did Abraham Lincoln belong when elected POTUS?","Republican","Democrat","Independent","Whig",
		"How old was Adolf Hitler when he died?","56","43","65","47"};

		for (int i=0; i < 20; i++) {
			String question = rawQuestions[5*i+0];
			String correctAnswer = rawQuestions[5*i+1];
			ArrayList<String> incorrectAnswers = new ArrayList<String>();
			for (int j=0; j<2; j++) {
				incorrectAnswers.add(rawQuestions[5*i+2+j]);
			}
			historyQuestions.add(new QuestionAnswers(question, correctAnswer, incorrectAnswers));
			
		}
		
		
		
	}
	
	public ArrayList<QuestionAnswers> getHisQuestions(){
		return historyQuestions;
	}
	
	
	
}