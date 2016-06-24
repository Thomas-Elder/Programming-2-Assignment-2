/**
 * 
 */
package ams.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.zip.DataFormatException;

import javax.swing.JOptionPane;

import ams.model.Program;
import ams.model.facade.AMSModel;
import ams.view.AMSMainView;

/**
 * @author Thomas
 *
 */
public class SubmitProgramListener implements ActionListener {

	private AMSMainView view;
	private AMSModel model;
	
	/**
	 * 
	 * @param view
	 * @param model
	 */
	public SubmitProgramListener(AMSMainView view, AMSModel model) {
		this.view = view;
		this.model = model;
	}

	/**
	 * Handles updating the model when submit is pressed on the init program 
	 * panel in the sidebar. Handles input exceptions by prompting the user.
	 * 
	 * Then updates the view, updating the status bar, and reinitialising the
	 * initProgramPanel and its listeners.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		int n = 0;
		
		if (model.getProgram() != null) {
			n = JOptionPane.showConfirmDialog(view, 
					"Creating a new program will remove all data " + 
					"currently in the system for this program." +
					"Are you sure you want to create a new program?", 
					null, 
					JOptionPane.YES_NO_OPTION);
		} 
		
		if (n == 0) {
		
			try {
				
				model.addProgram(new Program(getProgramCode(), getProgramName()));
				
				// Update view
				view.updateStatusBar(model.getProgram().toString() + 
						", " + model.countCoreCourses() + " core courses and" + 
						", " + model.countElectiveCourses() + " elective courses.");
	
				view.getProgramPanel().update(model.getAllCourses());
				
				// Add the new initProgramPanel
				view.addInitialiseProgramSideBar(new SubmitProgramListener(view, model));
				
				// Reinitialise the programPanel
				view.resetProgramPanel();
				
			} catch (DataFormatException d) {
				JOptionPane.showMessageDialog(view, d.getMessage());
			}
		}
	}
	
	/**
	 * 
	 * @return programCode
	 * @throws DataFormatException
	 * 
	 * Gets the program code from the initprogrampanel and checks if it meets 
	 * requirements, must be 6 chars and alphanumeric. Else it throws a
	 * dataformatexception.
	 */
	private String getProgramCode() throws DataFormatException {
		
		String programCode = view.getProgramCode();
		
		if (programCode.length() != 6) {
			throw new DataFormatException("Program code must be 6 characters.");
		}
		
		if (!programCode.matches("^[a-zA-Z0-9_]*$")) {
			throw new DataFormatException("Program code must alphanumeric.");
		}
		
		return programCode;
	}
	
	/**
	 * 
	 * @return programName
	 * @throws DataFormatException
	 * 
	 * Gets the programname from the initprogrampanel and checks it meets the
	 * requirements, must be at least 3 chars, else throws a 
	 * dataformatexception.
	 */
	private String getProgramName() throws DataFormatException {
		
		String programName = view.getProgramName();
		
		if (programName.length() <= 3) {
			throw new DataFormatException("Program code must be at least 3 characters.");
		}
		
		return programName;
	}

}
