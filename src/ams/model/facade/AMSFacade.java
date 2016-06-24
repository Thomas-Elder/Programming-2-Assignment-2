package ams.model.facade;

import ams.model.*;
import ams.model.exception.*;
/*import ams.model.visitor.CourseVisitor;*/

/**
 * @author Mikhail Perepletchikov
 */
public class AMSFacade implements AMSModel {
	
	/**/
	private University university;
	
	public AMSFacade (){
		university = new University();
	}
	
	/**
	 * @param newStudent
	 */
	public void addStudent(Student newStudent) {
		university.setStudent(newStudent);
	}

	/**
	 * @return student
	 */
	public Student getStudent() {
		return university.getStudent();
	}

	/**
	 * @param program
	 */
	public void addProgram(Program program) {
		university.setProgram(program);	
	}

	/**
	 * @return program
	 */
	public Program getProgram() {
		return university.getProgram();
	}

	/**
	 * @param newCourse
	 * @throws ProgramException
	 */
	public void addCourse(Course newCourse) throws ProgramException {
		university.addCourse(newCourse);	
	}

	/**
	 * @param courseId
	 */
	public void removeCourse(String courseID) throws ProgramException {
		university.removeCourse(courseID);
	}

	/**
	 * @param courseCode
	 */
	public Course getCourse(String courseCode) {
		return university.getCourse(courseCode);
	}

	/**
	 * @return program courses
	 */
	public Course[] getAllCourses() {
		
		/**/
		int size = university.getProgramCourses().size();
		
		Course [] coursesArray;
		
		if (size == 0)
			coursesArray = null;
		else
			coursesArray = university.getProgramCourses().values().toArray(new Course[size]);
		
		return coursesArray;
	}

	/**
	 * @param courseID
	 */
	public void enrollIntoCourse(String courseID) throws EnrollmentException {
		
		university.enrollStudentIntoCourse(courseID);
	}

	/**
	 * @param courseID
	 */
	public void withdrawFromCourse(String courseID) throws EnrollmentException {
		/**/
		university.withdrawStudentFromCourse(courseID);
		
	}

	/**
	 * @return result
	 */
	public boolean addResult(Result result) {
		
		/**/
		if (university.getCurrentStudentEnrollment().contains(result.getCourse())) {
			university.addStudentResult(result);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @return student results
	 */
	public Result[] getResults() {
		
		/**/
		int size = university.getStudentResults().size();
		
		Result [] resultsArray;
		
		resultsArray = university.getStudentResults().toArray(new Result[size]);
		
		for (Result r : resultsArray) {
			System.out.print(r.toString());
		}
		
		if (resultsArray.length == 0) {
			return null;
		}
		
		return resultsArray;
	}

	/**
	 * @return student courses
	 */
	public Course[] getCurrentEnrollment() {
		
		/**/
		int size = university.getCurrentStudentEnrollment().size();
		
		Course [] coursesArray;
		
		coursesArray = university.getCurrentStudentEnrollment().toArray(new Course[size]);
		
		if (coursesArray.length == 0) {
			return null;
		}
		
		return coursesArray;
	}

	/**
	 * @return student load
	 */
	public int calculateCurrentLoad() {
		
		/**/
		return university.calculateCurrentStudentLoad();
	}

	/**
	 * @return student career points
	 */
	public int calculateCareerPoints() {
		
		/**/
		return university.calculateTotalCareerPoints();
	}

	/**
	 * @return core course count
	 */
	public int countCoreCourses() {
		
		/**/
		int count = 0;
		
		for (Course c : university.getProgramCourses().values()) {
			if (c.toString().contains("CORE"))
				count++;
		}
		
		return count;
	}

	/**
	 * @return elective course count
	 */
	public int countElectiveCourses() {
		
		/**/
		int count = 0;
		
		for (Course c : university.getProgramCourses().values()) {
			if (c.toString().contains("ELECTIVE"))
				count++;
		}
		
		return count;
	}
}