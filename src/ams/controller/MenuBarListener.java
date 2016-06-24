/**
 * 
 */
package ams.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import ams.model.facade.AMSModel;
import ams.view.AMSMainView;

/**
 * @author Thomas
 *
 */
public class MenuBarListener implements ActionListener {

	private AMSMainView view;
	private AMSModel model;
		
	/**
	 * 
	 * @param view
	 * @param model
	 */
	public MenuBarListener(AMSMainView view, AMSModel model) {
		this.view = view;
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource().toString().contains("Quit")) {
			int n = JOptionPane.showConfirmDialog(view, 
					"Are you sure you want to quit?", 
					null, 
					JOptionPane.YES_NO_OPTION);
			
			if (n == 0) {
				System.exit(0);
			}
		}
		
		if (e.getSource().toString().contains("Add")) {
			
			// add the addCourseSideBar to the view
			view.addNewCourseSideBar(new SubmitCourseListener(view, model), 
					new ElectiveRadioListener(view),
					new AddPrereqsListener(view, model));
			
		}
		
		if (e.getSource().toString().contains("Initialise") || 
				e.getSource().toString().contains("Reset")) {
			
			// Initialise and add the listener for its submit button
			view.addInitialiseProgramSideBar(new SubmitProgramListener(view, model));
		}
	}	

}
