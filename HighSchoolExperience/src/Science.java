import java.util.ArrayList;

public class Science extends Course{

	private ArrayList<String> ScienceQuestions;
	
	public Science(Grade grade, Teacher teacher) {
		super(grade, teacher);
		// TODO Auto-generated constructor stub
	}

	public Teacher getSTeacher() {
		return getTeacher();
	}
	
	public Grade getSGrade() {
		return getGrade();
	}

	
}
