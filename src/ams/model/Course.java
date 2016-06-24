/**
 * 
 */
package ams.model;

/**
 * @author Thomas Elder 
 * Student Number: 3375087
 */
public interface Course {
	
	/**
	 * @return code
	 */
	public String getCode();
	
	/**
	 * @return title
	 */
	public String getTitle();
	
	/**
	 * @return creditPoints
	 */
	public int getCreditPoints();
	
	/**
	 * @return preReqs
	 */
	public String [] getPrereqs();
}
