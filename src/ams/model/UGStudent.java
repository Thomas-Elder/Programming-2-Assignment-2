/**
 * 
 */
package ams.model;

import ams.model.exception.EnrollmentException;

/**
 * @author Thomas Elder 
 * Student Number: 3375087
 */
public class UGStudent extends AbstractStudent {
	
	private int maxCourseLoad = 60;
	
	/**
	 * @param studentID
	 * @param name
	 */
	public UGStudent(int studentID, String name) {
		super(studentID, name, 60);
		// TODO Auto-generated constructor stub
	}

	/** 
	 * @param newCourse
	 * @throws EnrollmentException
	 */
	@Override
	public void enrollIntoCourse(Course newCourse) throws EnrollmentException{
		
		/* Prerequisite checks */
		if (newCourse.getPrereqs() != null) {
			
			for (String s : newCourse.getPrereqs()) {
				
				if (!this.getResults().toString().contains(s)) {
					
					throw new EnrollmentException("Student has no result for at least one of " +
					"the prerequisite courses for this course.");
				}
				
				for (Result r : this.getResults()) {
					
					if (r.getCourse().getCode().contains(s)) {
						
						if (r.toString().contains("FAIL")) {
							
							throw new EnrollmentException("Student has failed at least one of " +
							"the prerequisites for this course.");
						}
					}
				}
			}
		}
		
		/* Check if we are overloading the student */
		
		int currentLoad = calculateCurrentLoad();
		
		if (currentLoad + newCourse.getCreditPoints() > maxCourseLoad) {
			
			throw new EnrollmentException("Adding this course will exceded students" +
						" maximum course load.");
		}
		
		super.enrollIntoCourse(newCourse);	
	}
}
