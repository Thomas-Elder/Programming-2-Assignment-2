/**
 * 
 */
package ams.view;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import ams.model.Course;

/**
 * @author Thomas
 *
 */
@SuppressWarnings("serial")
public class ProgramPanel extends JPanel {

	private CoursePanel [] coursePanels;
	private JPanel defaultPanel;
	
	/**
	 * 
	 */
	public ProgramPanel() {
			
		resetProgramPanel();
		
		this.validate();
	}

	/**
	 * Removes all course panels and adds a label stating 
	 * no courses currently added.
	 */
	public void resetProgramPanel() {
		
		if (coursePanels != null) {
			for (JPanel jp: coursePanels) {
				this.remove(jp);
			}
		}
		
		this.setLayout(new GridLayout(0, 1));
		
		defaultPanel = new JPanel();
		
		defaultPanel.add(new JLabel("No courses currently loaded"));
		
		this.add(defaultPanel);
		
		this.validate();
	}
	
	/**
	 * 
	 * @param courses
	 * 
	 * Adds the array of courses passed to the programPanel. Should arrange
	 * the panels in rows of 4, unless there are less than 3, in which case
	 * it should be one row of 2. And if there is only 1 course, that course
	 * panel should take up the whole row. 
	 */
	public void addCourses(Course [] courses) {
			
		int numberOfCourses = courses.length;
		int numberOfPanels;
		
		if (numberOfCourses == 1) {
			
			this.setLayout(new GridLayout(0, 1));
			
			numberOfPanels = numberOfCourses;
			
		} else if (numberOfCourses == 2) {
			
			this.setLayout(new GridLayout(0, 2));
			
			numberOfPanels = numberOfCourses;
			
		} else if (numberOfCourses % 4 != 0) {
			
			this.setLayout(new GridLayout(0, 4));
			
			numberOfPanels = numberOfCourses + (4 - (numberOfCourses % 4));
			
		} else {
			
			this.setLayout(new GridLayout(0, 4));
			
			numberOfPanels = numberOfCourses;
		}
		
		coursePanels = new CoursePanel [numberOfPanels];
		
		for (int i = 0; i < numberOfCourses; i++) {
			
			coursePanels[i] = new CoursePanel(courses[i]);
		}
		
		for (int i = numberOfCourses; i < numberOfPanels; i++) {
			
			coursePanels[i] = new CoursePanel();
		}
		
		for (int i = 0; i < numberOfPanels; i++) {
			
			this.add(coursePanels[i]);
		}
		
		this.validate();
	}
	
	/**
	 * 
	 * @param courses
	 * 
	 * Removes all the course panels currently on the program panel and 
	 * adds all courses from the course array passed. 
	 */
	public void update(Course [] courses) {
		
		this.removeAll();
		
		if (courses != null) {
			addCourses(courses);
		}
	}
		
	/**
	 * 
	 * @return coursePanels
	 * 
	 * Returns an array of course panel objects.
	 */
	public CoursePanel [] getCoursePanels() {
		return coursePanels;
	}

}
