/**
 * 
 */
package ams.model;

import java.util.Map;
import java.util.HashMap;
import ams.model.exception.ProgramException;

/**
 * @author Thomas Elder 
 * Student Number: 3375087
 */
public class Program {
	
	/**/
	private String courseCode;
	private String name;
	private Map<String, Course> courses = new HashMap<String, Course>();
	
	/**
	 * @param courseCode
	 * @param name
	 */
	public Program(String courseCode, String name) {
		
		this.courseCode = courseCode;
		this.name = name;
	}

	/**
	 * @param courseCode
	 * @param course
	 */
	public void addCourse(String courseCode, Course course) throws ProgramException {
		
		/**/
		if (course.getPrereqs() != null) {

			for (String s : course.getPrereqs()) {
				
				if (!courses.containsKey(s)) {
					
					throw new ProgramException();
				}
			}
		}
		
		courses.put(courseCode, course);
	}
	
	/**
	 * @param code
	 */
	public void removeCourse(String courseCode) throws ProgramException {

		/* for each course */
		for (Course c : courses.values()) {
			
			/* if there that course contains a prerequisite(s) */
			if (c.getPrereqs() != null) {
				
				/* for each of those prerequisites */
				for (String s : c.getPrereqs()) {
					
					/* see if they are the courseCode we are trying to remove */
					if (s.equals(courseCode)) {
						
						throw new ProgramException("This course is a prerequisite for " + 
								"another course/courses in the program and cannot be removed.");
					}
				}
			}
		}
		
		courses.remove(courseCode);
	}
	
	/**
	 * @param code
	 * @return returns a Course object
	 */
	public Course getCourse(String courseCode) {
		
		return courses.get(courseCode);
	}
	
	/**
	 * @return returns a Map<String, Course>
	 */
	public Map<String, Course> getAllCourses() {
		
		return courses;
	}
	
	/**
	 * @return String
	 */
	public String toString() {
		
		String programString = courseCode + ":" + name;
		
		return programString;
	}
}
