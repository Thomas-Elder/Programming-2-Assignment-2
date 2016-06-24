/**
 * 
 */
package ams.model;

import java.util.List;

/**
 * @author Thomas Elder 
 * Student Number: 3375087
 */
public interface Student extends Enrollable {
	
	/**
	 * @return name
	 */
	public String getFullName();
	
	/**
	 * @return studentID
	 */
	public int getStudentID();
	
	/**
	 * @return results	
	 */
	public List<Result> getResults();
	
	/**
	 * @param result
	 */
	public void addResult(Result result);
	
	/**
	 * @return courses
	 */
	public List<Course> getCurrentEnrolment();
	
	/**
	 * @return load
	 */
	public int calculateCurrentLoad();
	
	/**
	 * @return points
	 */
	public int calculateCareerPoints();
	
}
