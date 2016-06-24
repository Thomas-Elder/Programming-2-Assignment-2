/**
 * 
 */
package ams.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.zip.DataFormatException;

import javax.swing.JOptionPane;

import ams.model.CoreCourse;
import ams.model.ElectiveCourse;
import ams.model.exception.ProgramException;
import ams.model.facade.AMSModel;
import ams.view.AMSMainView;
import ams.view.CoursePanel;

/**
 * @author Thomas
 *
 */
public class SubmitCourseListener implements ActionListener {

	private AMSMainView view;
	private AMSModel model;
	
	/**
	 * 
	 * @param view
	 * @param model
	 */
	public SubmitCourseListener(AMSMainView view, AMSModel model) {
		this.view = view;
		this.model = model;
	}

	/**
	 * Handles updating the model when submit is pressed on the add course panel in the 
	 * sidebar. Handles input exceptions and program exceptions by prompting the
	 * user with the exception message.
	 * 
	 * Then updates the view, updating the status bar, updating the programPanel and 
	 * adding listeners for the coursePanels on the programPanel.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			
			if (view.getCourseType() == "ELECTIVE") {
				model.addCourse(new ElectiveCourse(getCourseCode(), getCourseName(), getCreditPoints(), getPreReqs()));
				updateView();
			} else if (view.getCourseType() == "CORE") { 
				model.addCourse(new CoreCourse(getCourseCode(), getCourseName(), getPreReqs()));
				updateView();
			} else {
				JOptionPane.showMessageDialog(view, "Please select course type");
			}
	
		} catch (DataFormatException dfe) {
			
			JOptionPane.showMessageDialog(view, dfe.getMessage());
		} catch (ProgramException de) {
			
			JOptionPane.showMessageDialog(view, de.getMessage());
		} 
	}
	
	public void updateView() {
		
		view.updateStatusBar(model.getProgram().toString() + 
				", " + model.countCoreCourses() + " core courses and" + 
				", " + model.countElectiveCourses() + " elective courses.");

		view.getProgramPanel().update(model.getAllCourses());

		for (CoursePanel cp: view.getProgramPanel().getCoursePanels()) {
			
			if (!cp.isBlank()) {
				cp.addCoursePanelListener(new CoursePanelListener(view, model));
			}	
		}
		
		// Add the addCoursePanel again
		view.addNewCourseSideBar(new SubmitCourseListener(view, model),
				new ElectiveRadioListener(view),
				new AddPrereqsListener(view, model));
		
	}
	
	
	/**
	 * 
	 * @return programCode
	 * @throws DataFormatException
	 * 
	 * Gets the course code currently in the view, throws a DataFormatException
	 * if the code is not 8 characters in length, or it contains anything but
	 * alphanumeric characters.
	 */
	private String getCourseCode() throws DataFormatException {
		
		String courseCode = view.getCourseCode();
		
		if (courseCode.length() != 8) {
			throw new DataFormatException("Course code must be 8 characters.");
		}
		
		if (!courseCode.matches("^[a-zA-Z0-9]*$")) {
			throw new DataFormatException("Course code must alphanumeric.");
		}
		
		return courseCode;
	}
	
	/**
	 * 
	 * @return programName
	 * @throws DataFormatException
	 * 
	 * Gets the course name currently in the view, throws a DataFormatException
	 * if the string is less than 3 characters.
	 * 
	 */
	private String getCourseName() throws DataFormatException {
		
		String courseName = view.getCourseName();
		
		if (courseName.length() < 3) {
			throw new DataFormatException("Course name must be at least 3 characters.");
		}
		
		return courseName;
	}	
	
	/**
	 * 
	 * @return preReqs
	 * 
	 * Returns the prerequisite courses from the view, returns null if there 
	 * are no prerequisite courses currently.
	 */
	private String [] getPreReqs() {
		
		String [] prereqs = view.getPreReqs();
		
		if (prereqs != null) {
			return prereqs;
		}
		
		return null;
	}
	
	
	/**
	 * 
	 * @return creditPoints
	 * @throws NumberFormatException
	 * 
	 * Gets a string from the view and tries to parse it as an integer,
	 * if the string entered is not an integer, it throws a NumberFormatException
	 */
	private int getCreditPoints() throws NumberFormatException {
		
		int creditPoints = 0;
		
		try {
			creditPoints = Integer.parseInt(view.getCreditPoints());
		} catch (NumberFormatException nfe) {
			throw new NumberFormatException("Credit points must be an integer amount.");
		}
		
		return creditPoints;
		
	}
}
