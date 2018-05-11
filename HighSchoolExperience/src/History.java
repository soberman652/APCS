import java.util.ArrayList;

public class History extends Course {

	private ArrayList<String> historyQuestions;
	
	public History(Grade grade, Teacher teacher) {
		super(grade, teacher);
	}
	
	public Teacher getHTeacher() {
		return getTeacher();
	}
	
	public Grade getHGrade() {
		return getGrade();
	}
	
	public void addHQuestions() {
		historyQuestions = new ArrayList<String>();
		//historyQuestions.add(e)
	}

}
