/**
 * 
 */
package ams.model;

import java.util.Map;
import java.util.List;
import ams.model.exception.ProgramException;
import ams.model.exception.EnrollmentException;

/**
 * @author Thomas Elder 
 * Student Number: 3375087
 */
public class University {
	
	/**/
	private Student student;
	private Program program;
	
	public University() {
		
		/**/
		student = new UGStudent(0000000, "Darryl Default");
	}
	
	/**
	 * @return student
	 */
	public Student getStudent() {
		
		/**/
		return student;
	}
	
	/**
	 * @param student
	 */
	public void setStudent(Student student) {
		
		/**/
		this.student = student;
	}
	
	/**
	 * @return program
	 */
	public Program getProgram() {
		
		/**/
		return program;
	}
	
	/**
	 * @param program
	 */
	public void setProgram(Program program) {
		
		/**/
		this.program = program;
	}
	
	/**
	 * @param newCourse
	 * @throws ProgramException
	 */
	public void addCourse(Course newCourse) throws ProgramException {
		
		/**/
		program.addCourse(newCourse.getCode(), newCourse);
	}
	
	/**
	 * @param courseCode
	 * @throws ProgramException
	 */
	public void removeCourse(String courseCode) throws ProgramException {
		
		/**/
		program.removeCourse(courseCode);
	}
	
	/**
	 * @param courseCode
	 * @return
	 */
	public Course getCourse(String courseCode) {
		
		/**/
		return program.getCourse(courseCode);
	}
	
	/**
	 * @return program courses
	 */
	public Map<String, Course> getProgramCourses() {
		
		/**/
		return program.getAllCourses();
	}
	
	/**
	 * @param courseCode
	 * @throws EnrollmentException
	 */
	public void enrollStudentIntoCourse(String courseCode) throws EnrollmentException {
		
		/**/
		student.enrollIntoCourse(program.getCourse(courseCode));
	}
	
	/**
	 * @param courseCode
	 * @throws EnrollmentException
	 */
	public void withdrawStudentFromCourse(String courseCode) throws EnrollmentException {
		
		/**/
		student.withdrawFromCourse(program.getCourse(courseCode));
	}
	
	/**
	 * @param result
	 */
	public void addStudentResult(Result result) {
		
		/**/
		student.addResult(result);
	}
	
	/**
	 * @return student results
	 */
	public List<Result> getStudentResults() {
		
		/**/
		return student.getResults();
	}
	
	/**
	 * @return student courses
	 */
	public List<Course> getCurrentStudentEnrollment() {
		
		/**/
		return student.getCurrentEnrolment();
	}
	
	/**
	 * @return student load
	 */
	public int calculateCurrentStudentLoad() {
		return student.calculateCurrentLoad();
	}
	
	/**
	 * @return student career points
	 */
	public int calculateTotalCareerPoints() {
		return student.calculateCareerPoints();
	}
}
