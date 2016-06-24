/**
 * 
 */
package ams.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * @author Thomas
 *
 */
@SuppressWarnings("serial")
public class NewCoursePanel extends JPanel {

	private boolean electiveCreditInput;
	
	// Add Course Side Bar Components 
	private JLabel newCourse;
	private JLabel courseCodePrompt;	
	private JLabel courseNamePrompt;
	private JLabel courseTypePrompt;
	
	private JTextField courseCodeTF;
	private JTextField courseNameTF;
	
	private JRadioButton courseTypeElective;
	private JRadioButton courseTypeCore;

	private ElectiveCreditPanel electiveCreditPanel;
	private PrerequisitePanel prerequisitePanel;
	
	private JButton submitCourse;
	
	private JPanel space;
	
	private float align = CENTER_ALIGNMENT;
	
	/**
	 * 
	 */
	public NewCoursePanel(Dimension lineDim) {

		electiveCreditInput = false;
		
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		newCourse = new JLabel("Add new Course");
		newCourse.setBackground(Color.GRAY);
		newCourse.setBorder(BorderFactory.createRaisedBevelBorder());
		newCourse.setAlignmentX(align);
		newCourse.setMaximumSize(lineDim);
		
		courseTypePrompt = new JLabel("Please select course type: ");
		courseTypePrompt.setBackground(Color.GRAY);
		courseTypePrompt.setBorder(BorderFactory.createRaisedBevelBorder());
		courseTypePrompt.setAlignmentX(align);
		courseTypePrompt.setMaximumSize(lineDim);
		
		courseTypeElective = new JRadioButton("Elective");
		courseTypeCore = new JRadioButton("Core");
		ButtonGroup group = new ButtonGroup();
		
		group.add(courseTypeCore);
		group.add(courseTypeElective);
		
		courseCodePrompt = new JLabel("Please enter Course code: ");
		courseCodePrompt.setBackground(Color.GRAY);
		courseCodePrompt.setBorder(BorderFactory.createRaisedBevelBorder());
		courseCodePrompt.setAlignmentX(align);
		courseCodePrompt.setMaximumSize(lineDim);
		
		courseCodeTF = new JTextField(30);
		courseCodeTF.setMaximumSize(lineDim);
		courseCodeTF.setAlignmentX(align);
		
		courseNamePrompt = new JLabel("Please enter Course name: ");
		courseNamePrompt.setBackground(Color.GRAY);
		courseNamePrompt.setBorder(BorderFactory.createRaisedBevelBorder());		
		courseNamePrompt.setAlignmentX(align);
		courseNamePrompt.setMaximumSize(lineDim);
		
		courseNameTF = new JTextField(30);
		courseNameTF.setMaximumSize(lineDim);
		courseNameTF.setAlignmentX(align);
		
		electiveCreditPanel = new ElectiveCreditPanel(align, lineDim);
		prerequisitePanel = new PrerequisitePanel(align, lineDim);
		
		submitCourse = new JButton("Submit");
		submitCourse.setMaximumSize(lineDim);
		submitCourse.setAlignmentX(align);
		
		space = new JPanel();
		space.setBackground(Color.DARK_GRAY);
		
		this.add(newCourse);
		this.add(courseCodePrompt);
		this.add(courseCodeTF);
		this.add(courseNamePrompt);
		this.add(courseNameTF);
		this.add(courseTypePrompt);
		this.add(courseTypeElective);
		this.add(courseTypeCore);
		
		this.add(electiveCreditPanel);
		this.add(prerequisitePanel);
		
		this.add(submitCourse);
		this.add(space);
		
		this.validate();
	}
	
	public void updatePrereqs(String [] preReqs) {
		
		prerequisitePanel.addPrereqs(preReqs);
		
		this.validate();
	}
		
	/**
	 * 
	 */
	public void updateCreditPrompt() {

		if (courseTypeElective.isSelected() && !electiveCreditInput) {
			addCreditPrompt();
		}
		
		if (courseTypeCore.isSelected() && electiveCreditInput) {
			removeCreditPrompt();
		}
		
		this.validate();
	}
	
	/**
	 * 
	 */
	public void addCreditPrompt() {
		
		electiveCreditInput = true;
		
		electiveCreditPanel.addCreditPrompt();
	}
	
	/**
	 * 
	 */
	public void removeCreditPrompt() {
		
		electiveCreditInput = false;
		
		electiveCreditPanel.removeCreditPrompt();
	}
			
	/**
	 * 
	 * @return courseName
	 */
	public String getCourseName() {
		return courseNameTF.getText();
	}
	
	/**
	 * 
	 * @return courseCode
	 */
	public String getCourseCode() {
		return courseCodeTF.getText();
	}
	

	/**
	 * 
	 * @return course type
	 */
	public String getCourseType() {
		
		if (courseTypeElective.isSelected()) {
			return "ELECTIVE";
		}
		
		if (courseTypeCore.isSelected()) {
			return "CORE";
		}
		
		return null;
	}
	
	/**
	 * Clears the text from the input fields for after 
	 * successful submission.
	 */
	public void clear() {
		courseCodeTF.setText("");
		courseNameTF.setText("");
	}
	
	/**
	 * 
	 * @return creditPoints as String
	 */
	public String getCreditPoints() {
		return electiveCreditPanel.getCreditPoints();
	}
	
	/**
	 * 
	 * @return prerequisite courses as a string
	 */
	public String [] getPreReqs() {
		return prerequisitePanel.getPrereqs();
	}
	
	/**
	 * 
	 * @param al
	 */
	public void addSubmitListener(ActionListener al) {
		submitCourse.addActionListener(al);
	}

	/**
	 * 
	 * @param al
	 */
	public void addElectiveRadioListener(ActionListener al) {
		courseTypeCore.addActionListener(al);
		courseTypeElective.addActionListener(al);
	}
	
	/**
	 * 
	 * @param al
	 */
	public void addPrereqListener(ActionListener al) {
		prerequisitePanel.addPrereqListener(al);
	}
}
