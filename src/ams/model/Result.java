/**
 * 
 */
package ams.model;

/**
 * @author Thomas Elder 
 * Student Number: 3375087
 */
public class Result {
	
	/**/
	private Course course;
	private String pass;
	private double grade;
	
	/**
	 * @param course
	 * @param pass
	 */
	public Result(Course course, boolean pass) {
		
		/**/
		this.course = course;
	    
		if (pass)
			this.pass = "PASS";
		else
			this.pass = "FAIL";
	}
	
	/**
	 * @return course
	 */
	public Course getCourse() {
		
		/**/
		return course;
	}
	
	/**
	 * @param course
	 */
	public void setCourse(Course course) {
		
		/**/
		this.course = course;
	}
	
	/**
	 * @return grade
	 */
	public double getGrade() {
		
		/**/
		return grade;
	}
	
	/**
	 * @param grade
	 */
	public void setGrade(double grade) {
		
		/**/
		this.grade = grade;
	}
	
	/**  
	 * @return resultString 
	 */
	@Override
	public String toString() {
		
		/**/
		String resultString = course.getCode() + ":" + pass;
		
		return resultString;
	}
	
	/**
	 * @return
	 */
	public boolean equals() {
		return true;
	}
}
