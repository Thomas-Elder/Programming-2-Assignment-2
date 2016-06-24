/**
 * 
 */
package ams.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import ams.model.exception.AMSException;
import ams.model.facade.AMSModel;
import ams.view.AMSMainView;
import ams.view.CoursePanel;

/**
 * @author Thomas
 *
 */
public class CoursePanelListener implements MouseListener {

	private AMSMainView view;
	private AMSModel model;
	
	/**
	 * 
	 */
	public CoursePanelListener(AMSMainView view, AMSModel model) {
		this.view = view;
		this.model = model;
	}

	/**
	 * Handles mouseClicked events from the course panels. Asks user if 
	 * they would like to remove this course, and will not allow removal if 
	 * the course is a prerequisite for another currently loaded course. 
	 * 
	 * If ok to remove, updates the model and the view.
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		
		if(((CoursePanel) e.getSource()).getCourse() != null) {
		
			int n = JOptionPane.showConfirmDialog(view, "Would you like to remove this course?", null, JOptionPane.YES_NO_OPTION);
			
			if (n == 0) {
				try {
					
					// remove course from the model
					model.removeCourse(((CoursePanel) e.getComponent()).getCourse().getCode());
					
					// update the view
					if (model.getAllCourses() == null) {
						view.getProgramPanel().resetProgramPanel();
					} else {
						view.getProgramPanel().update(model.getAllCourses());
					}
					view.updateStatusBar(model.getProgram().toString() + 
							", " + model.countCoreCourses() + " core courses and" + 
							", " + model.countElectiveCourses() + " elective courses.");
					
					// add course panel listeners
					for (CoursePanel cp: view.getProgramPanel().getCoursePanels()) {
						if (!cp.isBlank()) {
							cp.addCoursePanelListener(new CoursePanelListener(view, model));
						}	
					}
					
				} catch (AMSException a) {
					JOptionPane.showMessageDialog(view, a.getMessage());
				}
			}
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		((CoursePanel) e.getComponent()).clicked();	
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		((CoursePanel) e.getComponent()).unClicked();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
	