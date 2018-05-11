import java.util.ArrayList;

public class Literature extends Course{

	private ArrayList<String> litQuestions;
	
	public Literature(Grade grade, Teacher teacher) {
		super(grade, teacher);

	}
	public Teacher getLTeacher() {
		return getTeacher();
	}
	
	public Grade getLGrade() {
		return getGrade();
	}

	
	
}
