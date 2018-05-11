/**
 * 
 * @author sashaoberman
 *
 */
public class Course {


	private Teacher teacher;
	private Grade grade;


	public Course(Grade grade, Teacher teacher) {
		this.grade = grade;
		this.teacher = teacher;
	}
	
	//uses grade method to set grade = to nothing
	
	public Course(Teacher teacher) {
		
		this.teacher = teacher;
	}
	
	
	public Teacher getTeacher() {
		return teacher;
	}
	
	public Grade getGrade() {
		return grade;
	}

	
}
