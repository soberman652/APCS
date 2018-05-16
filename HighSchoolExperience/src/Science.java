import java.util.ArrayList;
import java.util.List;


public class Science{

	private ArrayList<QuestionAnswers> ScienceQuestions;
	
	public Science() {
		ScienceQuestions = new ArrayList<QuestionAnswers>();
	}
	
	
	public void addSQuestions() {
		
		String[] rawQuestions = {
				"Which of the following bones is not in the leg?","Radius","Patella","Tibia","Fibula ",
				"Which of these bones is hardest to break?","Femur","Cranium","Humerus","Tibia",
				"What is the largest animal currently on Earth?","Blue Whale","Orca","Colossal Squid","Giraffe",
				"Which element has the chemical symbol Fe?","Iron","Gold","Silver","Tin",
				"Rhinoplasty is a surgical procedure on what part of the human body?","Nose","Ears","Chin","Neck",
				"What is the powerhouse of the Eukaryotic animal cell?","Mitochondria","Nucleus","Chloroplast","Endoplasmic Reticulum",
				"This element, when overcome with extreme heat and pressure, creates diamonds.","Carbon","Nitrogen","Oxygen","Hydrogen",
				"What is the elemental symbol for mercury?","Hg","Me","Mc","Hy",
				"How many planets are in our Solar System?","Eight","Nine","Seven","Ten",
				"What is the first element on the periodic table?","Hydrogen","Helium","Oxygen","Lithium",
				"What is the standard SI unit for temperature?","Kelvin","Fahrenheit","Celsius","Rankine",
				"Which of the following blood vessels carries deoxygenated blood?","Pulmonary Artery","Pulmonary Vein","Aorta","Coronary Artery",
				"What was the name of the first artificial Earth satellite, launched by the Soviet Union in 1957?","Sputnik 1","Soyuz 7K-OK","Zenit-2","Voskhod 3KV",
				"What does DNA stand for?","Deoxyribonucleic Acid","Deoxyribogenetic Acid","Deoxyribogenetic Atoms","Detoxic Acid",
				"The asteroid belt is located between which two planets?","Mars and Jupiter","Jupiter and Saturn","Mercury and Venus","Earth and Mars",
				"Human cells typically have how many copies of each gene?","2","1","4","3",
				"Which is the most abundant element in the universe?","Hydrogen","Helium","Lithium","Oxygen",
				"The medical term for the belly button is which of the following?","Umbilicus","Nevus","Nares","Paxillus",
				"What is the standard atomic weight of a Plutonium nucleus?","244","94","481","128",
				"71 percent of the Earths surface is made up of","Water","Deserts","Continents","Forests"
		};

		for (int i=0; i < 20; i++) {
			String question = rawQuestions[5*i+0];
			String correctAnswer = rawQuestions[5*i+1];
			ArrayList<String> incorrectAnswers = new ArrayList<String>();
			for (int j=0; j<2; j++) {
				incorrectAnswers.add(rawQuestions[5*i+2+j]);
			}
			ScienceQuestions.add(new QuestionAnswers(question, correctAnswer, incorrectAnswers));
			
		}
		
		
		
	}
	
	public ArrayList<QuestionAnswers> getSciQuestions(){
		return ScienceQuestions;
	}
	
}
