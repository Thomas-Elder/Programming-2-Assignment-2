package ams.controller;

import ams.model.facade.AMSModel;
import ams.view.AMSMainView;
import ams.view.CoursePanel;

public class AMSController {

	private AMSMainView view;
	private AMSModel model;
	
	/**
	 * 
	 * @param view
	 * @param model
	 */
	public AMSController(AMSMainView view, AMSModel model) {
		
		this.view = view;
		this.model = model;
		
		addSideBarButtonListeners();
		addMenuBarListeners();

	}
						
	/**
	 * Adds the listeners for the side bar header buttons
	 */
	public void addSideBarButtonListeners() {
		
		view.addSideBarButtonListeners(new SidebarButtonListener(view, model),
				new SidebarButtonListener(view, model),
				new SidebarButtonListener(view, model));
		
	}
	
	/**
	 * Adds the listeners for the menu bar components
	 */
	public void addMenuBarListeners() {
		view.getAMSMenuBar().addMenuListeners(new MenuBarListener(view, model));
	}
	
	/**
	 * Adds the listeners for the course panels in the program panel
	 */
	public void addCoursePanelListeners() {
		
		for (CoursePanel c: view.getProgramPanel().getCoursePanels()) {
			c.addCoursePanelListener(new CoursePanelListener(view, model));
		}	
	}
}
