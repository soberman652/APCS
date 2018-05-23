package Academic;
import java.util.ArrayList;

/**
 * 
 * @author sashaoberman
 *
 */
public class QuestionAnswers {
	
	private  String question;
    private  String correctAnswer;
    private  ArrayList<String> incorrectAnswers;
    private  ArrayList<String> answers;


/**
 * Creates a QuestionAnswers object with a question and different answers
 * @param question - question asked
 * @param correctAnswer
 * @param incorrectAnswers
 */
   public QuestionAnswers(String question, String correctAnswer, ArrayList<String> incorrectAnswers) {
	   this.question = question;
	   this.correctAnswer = correctAnswer;
	   this.incorrectAnswers = new ArrayList<String>();
	   this.incorrectAnswers = incorrectAnswers;
	   answers = new ArrayList<String>();
	   for (int i = 0; i < incorrectAnswers.size(); i++) {
		   answers.add(incorrectAnswers.get(i));
	   }
	   answers.add(correctAnswer);
    }

   /**
    * Returns a question
    * @return a question
    */
   public String getQuestion() {
	   return question;
   }
   
   /**
    * gets the correct answer selected
    * @return correct answer
    */
   public String getCorrectAnswer() {
	   return correctAnswer;
   }
   
   /**
    * gets all of the incorrect answers from the question
    * @return incorrect answers
    */
   public ArrayList<String> getIncorrectAnswers() {
	   
	   return incorrectAnswers;
   }
   
   /**
    * gets the answers from the question
    * @return the answers
    */
   public ArrayList<String> getAnswers() {
	   return answers;
   }

}
