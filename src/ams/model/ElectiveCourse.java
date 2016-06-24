/**
 * 
 */
package ams.model;

/**
 * @author Thomas Elder 
 * Student Number: 3375087
 */
public class ElectiveCourse extends AbstractCourse {
	
	/**
	 * @param courseCode
	 * @param name
	 * @param creditPoints
	 * @param prereqs
	 */
	public ElectiveCourse(String courseCode, String name, int creditPoints, String[] prereqs) {
		
		/**/
		super(courseCode, name, prereqs, creditPoints);
	}
	
	/**
	 * @return String
	 */
	@Override
	public String toString() {
		
		/**/
		return super.toString() + "ELECTIVE";
	}
}
