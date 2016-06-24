/**
 * 
 */
package ams.model;

/**
 * @author Thomas Elder 
 * Student Number: 3375087
 */
public class CoreCourse extends AbstractCourse {
	
	/**
	 * @param courseCode
	 * @param name
	 * @param prereqs
	 */
	public CoreCourse(String courseCode, String name, String[] prereqs) {
		
		/**/
		super(courseCode, name, prereqs);
	}
	
	/**
	 * @return String
	 */
	@Override 
	public String toString() {
		
		/**/
		return super.toString() + "CORE";
	}	
}
