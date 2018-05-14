
public class QuestionAnswers {
	
	private  String question;
    private  String correctAnswer;
    private  String[] incorrectAnswers;



   public QuestionAnswers(String question, String correctAnswer, String[] incorrectAnswers) {
	   this.question = question;
	   this.correctAnswer = correctAnswer;
	   this.incorrectAnswers = new String[3];
	   this.incorrectAnswers = incorrectAnswers;
	   
    }

   public String getQuestion() {
	   return question;
   }
   
   public String getCorrectAnswer() {
	   return correctAnswer;
   }
   
   public String[] getIncorrectAnswers() {
	   return incorrectAnswers;
   }

}
