/**
 * 
 */
package ams.model;

import java.util.List;
import java.util.ArrayList;
import ams.model.exception.EnrollmentException;

/**
 * @author Thomas Elder 
 * Student Number: 3375087
 */
public abstract class AbstractStudent implements Student {
	
	/**/
	private int studentID;
	private String name;
	private List<Result> results;
	private List<Course> courses;
	private int maxCourseLoad;
	
	/**
	 * @param studentID
	 * @param name
	 */
	public AbstractStudent(int studentID, String name, int maxCourseLoad) {
		
		/**/
		this.studentID = studentID;
		this.name = name;
		this.maxCourseLoad = maxCourseLoad;
		results = new ArrayList<Result>();
		courses = new ArrayList<Course>();
	}
	
	/**
	 * @return name
	 */
	public String getFullName() {
		
		/**/
		return name;
	}
	
	/**
	 * @return studentID
	 */
	public int getStudentID() {
		
		/**/
		return studentID;
	}
	
	/**
	 * @return results
	 */
	public List<Result> getResults() {
		
		/**/
		return results;	
	}
	
	/**
	 * @param result
	 */
	public void addResult(Result result) {
		
		/**/	
		int index = -1;
		
		/* If we already have a result for this course... */
		for (Result r : results) {
			if (r.getCourse().getCode() == result.getCourse().getCode()) {
				index = results.indexOf(r);
			}
		}
		
		/* ... remove that result and add the new result */
		if (index != -1) {
			results.remove(index);
			results.add(index, result);
		} else {
			results.add(result);
		}
		
		/* Remove the course from the list of currently enrolled courses */
		courses.remove(result.getCourse());
	}
	
	/**
	 * @return courses
	 */
	public List<Course> getCurrentEnrolment() {
		
		/**/
		return courses;
	}
	
	/**
	 * @return load
	 */
	public int calculateCurrentLoad() {
		
		/**/
		int load = 0;
		
		if (!courses.isEmpty()) {
			for (Course c : courses) {
				load += c.getCreditPoints();
			}
		}
		
		return load;
	}
	
	/**
	 * @return totalPoints
	 */
	public int calculateCareerPoints() {
		
		/**/
		int totalPoints = 0;
		
		if (!results.isEmpty()) {
			for (Result r : results) {
				if (r.toString().contains("PASS")) {
					totalPoints += r.getCourse().getCreditPoints();
				}
			}
		}
		
		return totalPoints;
	}
	
	/**
	 * @throws EnrollmentException
	 */
	public void enrollIntoCourse(Course newCourse) throws EnrollmentException{
		
		/* Check if it is a duplicate enrollment */
		if (courses.contains(newCourse)) {

			throw new EnrollmentException("Student is already enrolled in this course.");
		}
		
		/* All good, add student */
		courses.add(newCourse);
	}
	
	/**
	 * @throws EnrollmentException
	 */
	public void withdrawFromCourse(Course course) throws EnrollmentException {

		/* Check if student is currently enrolled in that course */
		if (!courses.contains(course)) {
			throw new EnrollmentException("Cannot withdraw from a course" +
		" which the student is not currently enrolled in.");
		}
		
		courses.remove(course);

	}
	
	/**
	 * @return String
	 */
	public String toString() {	
		
		/**/
		return studentID + ":" + name + ":" + maxCourseLoad;
	}
}
