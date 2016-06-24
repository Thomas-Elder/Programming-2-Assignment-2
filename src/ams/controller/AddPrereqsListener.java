/**
 * 
 */
package ams.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import ams.model.Course;
import ams.model.facade.AMSModel;
import ams.view.AMSMainView;

/**
 * @author Thomas
 *
 */
public class AddPrereqsListener implements ActionListener {

	private AMSMainView view;
	private AMSModel model;
	
	/**
	 * 
	 * @param view
	 * @param model
	 */
	public AddPrereqsListener(AMSMainView view, AMSModel model) {
		this.view = view;
		this.model = model;
	}

	/**
	 * Handles updating the model and view when the addPrerequisiteButton is 
	 * pressed. Prompts the user to select from courses already loaded in the
	 * system. If there are no courses, tells the user they must add the 
	 * prerequisite courses to the system first. 
	 * 
	 * Updates the view with all the selected prerequisite courses once 
	 * selection is complete. 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		ArrayList <String> preReqs = new ArrayList <String>();
		ArrayList <String> possibleCourseCodes = new ArrayList <String>();
		
		// If there are any courses loaded
		if (model.getAllCourses() != null) {

			Course [] currentCourses = model.getAllCourses();
					
			int addPreReqs = JOptionPane.showConfirmDialog(view, 
					"Does this course have any prerequisites?", 
					"Prerequisite Prompt",
					JOptionPane.YES_NO_OPTION);
			
			if (addPreReqs == 0) {
					
				// create array of loaded course codes
				for (Course c : currentCourses) 
					possibleCourseCodes.add(c.getCode());
				
				int addMorePreReqs = 0;
				
				// While there are courses in loaded which haven't been chosen
				// as prerequisites, and the user wants to continue adding prereqs
				while (!possibleCourseCodes.isEmpty() && addMorePreReqs == 0) {	
					
					String [] codes = new String [possibleCourseCodes.size()];
					
					int i = 0;
					
					for (String s : possibleCourseCodes) {
						codes[i] = s;
						i++;
					}
					
					String code = prereqPrompt(codes);
					
					preReqs.add(code);
					possibleCourseCodes.remove(code);
					
					if (!possibleCourseCodes.isEmpty()) {
						addMorePreReqs = JOptionPane.showConfirmDialog(view, 
								"Does this course have any more prerequisites?", 
								"Prerequisite Prompt",
								JOptionPane.YES_NO_OPTION);
					}
				}
			}
		} else {
			
			// There are no courses loaded, you won't be able to add a course which 
			// has a non-loaded course as a prerequisite.
			JOptionPane.showMessageDialog(view, 
					"There are currently no courses loaded into the program." + 
					"Please add the prerequisite courses before any dependent courses.");
		}
		
		// Convert the prereqs to a string array and update the view
		String [] codes = new String [preReqs.size()];
		
		int i = 0;
		
		for (String s : preReqs) {
			codes[i] = s;
			i++;
		}
		
		view.updatePrequisitePanel(codes);
	}

	/**
	 * 
	 * @param loadedCourses
	 * @return String
	 * 
	 * Takes an array of currently loaded courses, and prompts the user to 
	 * select one as a prerequisite course.
	 */
	private String prereqPrompt(String [] loadedCourses) {
		
		String s = (String)JOptionPane.showInputDialog(
                view,
                "Please choose from the courses currently loaded in the program: ",
                "Enter Prerequisite Courses",
                JOptionPane.PLAIN_MESSAGE,
                null,
                loadedCourses,
                loadedCourses[0]);
		
		return s;
	}
}
