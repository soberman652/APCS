import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author sashaoberman
 *
 */
public class Literature{

	private ArrayList<QuestionAnswers> LiteratureQuestions;
	
	public Literature() {
		LiteratureQuestions = new ArrayList<QuestionAnswers>();
	}
	
	
	public void addLQuestions() {
		
		String[] rawQuestions = {
				"In the Beatrix Potter books, what type of animal is Tommy Brock?","Badger","Fox","Frog","Rabbit",
				"Which famous book is sub-titled The Modern Prometheus?","Frankenstein","Dracula","The Strange Case of Dr. Jekyll and Mr. Hyde ","The Legend of Sleepy Hollow",
				"How many books are in the Chronicles of Narnia series?","7","6","8","5",
				"Which of the following is the worlds best-selling book?","The Lord of the Rings","The Little Prince","Harry Potter and the Philosophers Stone","The Da Vinci Code",
				"In the Harry Potter universe, what is Cornelius Fudges middle name?","Oswald","James","Harold","Christopher",
				"What is Hermione Grangers middle name?","Jean","Jane","Emma","Jo",
				"Who wrote the novel Fear And Loathing In Las Vegas?","Hunter S. Thompson","F. Scott Fitzgerald","Henry Miller","William S. Burroughs",
				"Green Eggs And Ham is a book by which author?","Dr. Seuss","Beatrix Potter","Roald Dahl","A.A. Milne",
				"Who wrote the childrens story The Little Match Girl?","Hans Christian Andersen","Charles Dickens","Lewis Carroll","Oscar Wilde",
				"How many Harry Potter books are there?","7","8","5","6",
				"Who wrote the young adult novel The Fault in Our Stars?","John Green","Stephenie Meyer","Suzanne Collins","Stephen Chbosky",
				"Which of these does Charlie NOT read in The Perks of Being a Wallflower?","The Grapes of Wrath","Hamlet","The Great Gatsby","Peter Pan",
				"Who was the author of the 1954 novel, Lord of the Flies?","William Golding","Stephen King","F. Scott Fitzgerald","Hunter Fox",
				"Which American author was also a budding travel writer and wrote of his adventures with his dog Charley?","John Steinbeck","F. Scott Fitzgerald","Ernest Hemingway","William Faulkner",
				"According to The Hitchhikers Guide to the Galaxy book, the answer to life, the universe and everything else is...","42","Loving everyone around you","Chocolate","Death",
				"The book The Little Prince was written by...","Antoine de Saint-Exupery","Miguel de Cervantes Saavedra","Jane Austen","F. Scott Fitzgerald",
				"Where does the book The Silence of the Lambs get its title from?","The main characters trauma in childhood","The relation it has with killing the innocents","The villains favourite meal","The voice of innocent people being shut by the powerful",
				"What book series published by Jim Butcher follows a wizard in modern day Chicago?","The Dresden Files","A Hat in Time","The Cinder Spires","My Life as a Teenage Wizard",
				"What is the make and model of the tour vehicles in Jurassic Park?","1992 Toyota Land Cruiser","1992 Jeep Wrangler YJ Sahar","1992 Ford Explorer XLT","Mercedes M-Class",
				"In the book series Odd Thomas, Danny Jessup has what genetic disease?","Osteogenesis Imperfecta","Spinocerebellar ataxia","Adrenoleukodystrophy","Cystic Fibrosis"
		};

		for (int i=0; i < 20; i++) {
			String question = rawQuestions[5*i+0];
			String correctAnswer = rawQuestions[5*i+1];
			ArrayList<String> incorrectAnswers = new ArrayList<String>();
			for (int j=0; j<2; j++) {
				incorrectAnswers.add(rawQuestions[5*i+2+j]);
			}
			LiteratureQuestions.add(new QuestionAnswers(question, correctAnswer, incorrectAnswers));
			
		}
		
		
		
	}
	
	public ArrayList<QuestionAnswers> getLitQuestions(){
		return LiteratureQuestions;
	}
	
}
