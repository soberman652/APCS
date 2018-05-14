import java.util.ArrayList;

public class QuestionAnswers {
	
	private  String question;
    private  String correctAnswer;
    private  ArrayList<String> incorrectAnswers;



   public QuestionAnswers(String question, String correctAnswer, ArrayList<String> incorrectAnswers) {
	   this.question = question;
	   this.correctAnswer = correctAnswer;
	   this.incorrectAnswers = new ArrayList<String>();
	   this.incorrectAnswers = incorrectAnswers;
	   
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

}
