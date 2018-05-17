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

   public String getQuestion() {
	   return question;
   }
   
   public String getCorrectAnswer() {
	   return correctAnswer;
   }
   
   public ArrayList<String> getIncorrectAnswers() {
	   
	   return incorrectAnswers;
   }
   
   public ArrayList<String> getAnswers() {
	   return answers;
   }

}
