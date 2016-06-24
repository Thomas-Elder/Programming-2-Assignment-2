/**
 * 
 */
package ams.model;
import ams.model.exception.EnrollmentException;

/**
 * @author Thomas Elder 
 * Student Number: 3375087
 */
public class PGStudent extends AbstractStudent {
	
	private int maxCourseLoad = 48;
	private int maxOverLoad = 54;
	
	/**
	 * @param studentID
	 * @param name
	 */
	public PGStudent(int studentID, String name) {
		super(studentID, name, 48);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param newCourse
	 * @throws EnrollmentException
	 */
	@Override
	public void enrollIntoCourse(Course newCourse) throws EnrollmentException {
		
		/* Prerequisite checks */
		boolean pass = false;
		
		if (newCourse.getPrereqs() != null) {
			
			for (String s : newCourse.getPrereqs()) {
				
				for (Result r : this.getResults()) {
					
					if (r.getCourse().getCode().contains(s)) {
						
						if (r.toString().contains("PASS")) {
							
							pass = true;
						}
					}
				}
			}
			
			/* If pass is still false it means none of the prereqs were passed so throw exception */
			if (!pass) {
				
				throw new EnrollmentException("Student has not passed at least one of " +
						"the prerequisites for this course.");
			}
		}
		
		/* Check loading */
		int currentLoad = this.calculateCurrentLoad();
		
		/* Check if new load exceeds max overload */
		if (newCourse.getCreditPoints() + currentLoad > maxOverLoad) {
				
			throw new EnrollmentException("Adding this course will exceded students maximum course overload.");
		} 
		
		/* Check if new load requires overloading and if so, check if student is eligible */
		if (newCourse.getCreditPoints() + currentLoad > maxCourseLoad) {
			
			if (checkForFailures()) {
				
				throw new EnrollmentException("This student is not eligible to be overloaded as they have failed a course.");
			}
		}
		
		/* Enroll into course */
		super.enrollIntoCourse(newCourse);
	}
	
	/**
	 * @return boolean
	 * Returns true if there is a result with a fail
	 */
	public boolean checkForFailures() {
		
		for (Result r : this.getResults()) {
			if (r.toString().contains("FAIL"))
				return true;
		}
		
		return false;	
	}
}
