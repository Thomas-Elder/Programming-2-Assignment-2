/**
 * 
 */
package ams.model;

import ams.model.exception.EnrollmentException;

/**
 * @author Thomas Elder 
 * Student Number: 3375087
 */
public interface Enrollable {
	
	/**
	 * @param course
	 * @throws EnrollmentException 
	 */
	public void enrollIntoCourse(Course course) throws EnrollmentException;
	
	/**
	 * @param course
	 * @throws EnrollmentException
	 */
	public void withdrawFromCourse(Course course) throws EnrollmentException;
}
