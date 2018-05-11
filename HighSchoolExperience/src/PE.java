import java.util.ArrayList;

public class PE extends Course{

	private ArrayList<String> PEQuestions;
	
	public PE(Grade grade, Teacher teacher) {
		super(grade, teacher);
		// TODO Auto-generated constructor stub
	}

	public Teacher getPTeacher() {
		return getTeacher();
	}
	
	public Grade getPGrade() {
		return getGrade();
	}

	
}
