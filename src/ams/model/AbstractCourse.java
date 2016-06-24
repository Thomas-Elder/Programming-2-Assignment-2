/**
 * 
 */
package ams.model;

/**
 * @author Thomas Elder 
 * Student Number: 3375087
 */
public abstract class AbstractCourse implements Course {
	
	/**/
	private String courseCode;
	private String title;
	private String [] preReqs;
	private int creditPoints;
	
	/**
	 * 
	 * @param courseCode
	 * @param title
	 * @param preReqs
	 */
	public AbstractCourse(String courseCode, String title, String [] preReqs) {
		this.courseCode = courseCode;
		this.title = title;
		this.preReqs = preReqs;
		this.creditPoints = 12;
	}
	
	/**
	 * 
	 * @param code
	 * @param title
	 * @param preReqs
	 * @param creditPoints
	 */
	public AbstractCourse(String courseCode, String title, String [] preReqs, int creditPoints) {
		this.courseCode = courseCode;
		this.title = title;
		this.preReqs = preReqs;
		this.creditPoints = creditPoints;
	}
	
	/**
	 * @return courseCode
	 */
	public String getCode() {
		
		/**/
		return courseCode;
	}
	
	/**
	 * @return title
	 */
	public String getTitle() {
		
		/**/
		return title;
	}
	
	/**
	 * @return creditPoints
	 */
	public int getCreditPoints() {
		
		/**/
		return creditPoints;
	}
	
	/**
	 * @return preReqs
	 */
	public String [] getPrereqs() {
		
		/**/
		return preReqs;
	}
	
	/**
	 * @return toString
	 */
	@Override
	public String toString() {
		
		/**/
		String toString;
		
		if (getPrereqs() == null){		
			
			toString = courseCode + ":" + title + ":" + creditPoints + ":";
		} else {
			
			toString = courseCode + ":" + title + ":" + creditPoints + ":";
			
			for (int i = 0; i < getPrereqs().length; i++) {
				
				/* if more than one prereq, need to delimit with commas */
				if (i == 0) 
					toString += getPrereqs()[i];
				else 
					toString += "," + getPrereqs()[i];
			}
			
			toString += ":";
		}
		
		return toString;
	}
	
	/**
	 * @param course
	 * @return boolean
	 */
	public boolean equals(Course course) {
		
		/**/
		if (this.courseCode.equals(course.getCode()))
			return true;
		else
			return false;
	}
}
