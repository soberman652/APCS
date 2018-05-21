package Academic;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author sashaoberman
 *
 */
public class Mathematics extends Course{

	private ArrayList<QuestionAnswers> mathQuestions;

	
	public Mathematics() {

		mathQuestions = new ArrayList<QuestionAnswers>();
		
		String[] rawQuestions = {
				"In a complete graph G, which has 12 vertices, how many edges are there?","66","67","34","11",
				"In base 2, what is 1 + 1?","10","Two (2)","01","11",
				"In the hexadecimal system, what number comes after 9?","The Letter A","10","The Number 0","16",
				"What is the derivative of Acceleration with respect to time?","Jerk","Shift","Bump","Slide",
				"How many zeros are there in a googol?","100","10","1,000","1,000,000",
				"What is the area of a circle with a diameter of 20 inches if pi;= 3.1415?","314.15 Inches","380.1215 Inches","3141.5 Inches","1256.6 Inches",
				"What are the first 6 digits of the number Pi?","3.14159","3.14169","3.12423","3.25812",
				"In Roman Numerals, what does XL equate to?","40","60","15","90",
				"What is the Roman numeral for 500?","D","L","C","X",
				"What is the square root of 49?","7","4","12","9",
				"How many zeptometres are inside one femtometre?","1,000,000","10","1,000,000,000","1000",
				"What is the first Mersenne prime over 1000?","1279","2203","1009","1069",
				"What prime number comes next after 19?","23","25","21","27",
				"What is the alphanumeric representation of the imaginary number?","i","e","n","x",
				"What Greek letter is used to signify summation?","Sigma","Delta","Alpha","Omega",
				"The decimal number 31 in hexadecimal would be what?","1F","3D","2E","1B",
				"What is the 100th digit of Pi?","9","4","7","2",
				"The metric prefix atto- makes a measurement how much smaller than the base unit?","One Quintillionth","One Billionth","One Quadrillionth","One Septillionth",
				"How many sides does a heptagon have?","7","8","6","5",
				"The French mathematician Galois is primarily known for his work in which?","Galois Theory","Galois Continued Fractions","Galois Method for PDEs","Abelian Integration"		
		};

		for (int i=0; i < 20; i++) {
			String question = rawQuestions[5*i+0];
			String correctAnswer = rawQuestions[5*i+1];
			ArrayList<String> incorrectAnswers = new ArrayList<String>();
			for (int j=0; j<3; j++) {
				incorrectAnswers.add(rawQuestions[5*i+2+j]);
			}
			mathQuestions.add(new QuestionAnswers(question, correctAnswer, incorrectAnswers));
			
		}

	}
	
	public ArrayList<QuestionAnswers> getQuestions(){
		return mathQuestions;
	}
}
