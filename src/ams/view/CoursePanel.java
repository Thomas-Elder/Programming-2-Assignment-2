/**
 * 
 */
package ams.view;

import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ams.model.Course;

/**
 * @author Thomas
 *
 */
@SuppressWarnings("serial")
public class CoursePanel extends JPanel {

	private boolean isBlank = false;
	
	private Course course;
	private String courseCode;
	private String title;
	private String [] preReqs;
	private int creditPoints;
	
	private ArrayList<JLabel> labels = new ArrayList<JLabel>();
	
	/**
	 * 
	 */
	public CoursePanel() {
		
		isBlank = true;
		
		this.setBorder(BorderFactory.createRaisedBevelBorder());
		course = null;
	}
	
	
	/**
	 * @param course
	 */
	public CoursePanel(Course course) {
		
		this.course = course;
		
		courseCode = course.getCode();
		title = course.getTitle();
		preReqs = course.getPrereqs();
		creditPoints = course.getCreditPoints();
		
		addLabels();
		
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		this.setBorder(BorderFactory.createRaisedBevelBorder());

		for (JLabel j : labels) {
			this.add(j);
		}
	}
	
	public void addLabels() {
		
		labels.add(new JLabel("Code : " + courseCode));
		labels.add(new JLabel("Title : " + title));
		labels.add(new JLabel("Credit Points : " + creditPoints));
		
		if (preReqs == null) {
			labels.add(new JLabel("Prerequisite Courses: None"));
		} else {
			labels.add(new JLabel("Prerequisite Courses:"));
			
			for (String s: preReqs) {
				labels.add(new JLabel(s));
			}
			
		}	
	}
	
	public boolean isBlank() {
		return isBlank;
	}
	
	public Course getCourse() {
		return course;
	}
	
	public void clicked() {
		this.setBorder(BorderFactory.createLoweredBevelBorder());
	}
	
	public void unClicked() {
		this.setBorder(BorderFactory.createRaisedBevelBorder());
	}
	
	public void addCoursePanelListener(MouseListener ml) {
		this.addMouseListener(ml);
	}
}
