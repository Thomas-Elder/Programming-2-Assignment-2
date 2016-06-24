/**
 * 
 */
package ams.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import ams.model.facade.AMSModel;

/**
 * @author Thomas
 * 
 * The main view for the system. 	
 */
@SuppressWarnings("serial")
public class AMSMainView extends JFrame {

	@SuppressWarnings("unused")
	private AMSModel model;

	private AMSMenuBar menuBar;
	private SideBar sideBar;
	private StatusBar statusBar;
	private ProgramPanel programPanel;
	
	/**
	 * @param title
	 * @throws HeadlessException
	 */
	public AMSMainView(AMSModel model) throws HeadlessException {
		super("Assignment Two - Academic Management System");
		
		this.model = model;
		
		Dimension preferredSize = new Dimension(800, 600);
		this.setSize(preferredSize);
		
		LayoutManager layout = new BorderLayout();
		this.setLayout(layout);
		
		menuBar = new AMSMenuBar();
		this.setJMenuBar(menuBar);
		
		sideBar = new SideBar();
		this.add(sideBar, BorderLayout.WEST);
		
		statusBar = new StatusBar();
		this.add(statusBar, BorderLayout.SOUTH);

		programPanel = new ProgramPanel();
		this.add(programPanel, BorderLayout.CENTER);
				
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * 
	 * @param addButtonListener
	 * @param initButtonListener
	 * @param resetButtonListener
	 * 
	 * Adds the actionListeners for the sidebar header buttons.
	 */
	public void addSideBarButtonListeners(ActionListener addButtonListener, 
			ActionListener initButtonListener,
			ActionListener resetButtonListener) {
		
			sideBar.addButtonListeners(addButtonListener, 
					initButtonListener, 
					resetButtonListener);
	}
	
	public void resetProgramPanel() {
		
		programPanel.resetProgramPanel();
		
		this.validate();
	}
		
	/**
	 * 
	 * @param status
	 * 
	 * Takes a string and passes it to the status bar to 
	 * update the status.
	 */
	public void updateStatusBar(String status) {
		statusBar.updateStatus(status);
	}
	
	
	
	
	
	
	/*************************************************************************
	 * INITIALISE PROGRAM PANEL METHODS
	 * 
	 * All the methods for initialising and getting values from the 
	 * initialiseProgramPanel.
	 *************************************************************************/
	
	/**
	 * 
	 * @param al
	 * 
	 * Creates a new InitialiseProgramSideBar and adds the 
	 * actionlistener for its submit button.
	 */
	public void addInitialiseProgramSideBar(ActionListener al) {
		
		sideBar.addInitialiseProgramSideBar();
		
		sideBar.getInitProgramPanel().addSubmitListener(al);
	}
	
	/*************************************************************************
	 * All the getters for the fields in the initialiseProgramPanel.                 
	 *************************************************************************/
	
	public String getProgramCode() {
		return sideBar.getInitProgramPanel().getProgramCode();
	}
	
	public String getProgramName() {
		return sideBar.getInitProgramPanel().getProgramName();
	}
	
	
	
	
	
	
	/*************************************************************************
	 * NEW COURSE PANEL METHODS
	 * 
	 * All the methods for initialising, getting values and updating 
	 * the subPanels of the newCoursePanel.
	 *************************************************************************/
	
	/**
	 * 
	 * @param submitCourseListener
	 * @param electiveRadioListener
	 * @param addPrereqsListener
	 * 
	 * Creates a new addNewCourseSideBar and adds the 
	 * SubmitCourseListener, ElectiveRadioListener and 
	 * AddPrereqsListener for its buttons.
	 */
	public void addNewCourseSideBar(ActionListener submitCourseListener,
			ActionListener elRadioListener,
			ActionListener addPrereqsListener){
		
		sideBar.newCourseSideBar();
		
		sideBar.getNewCoursePanel().addSubmitListener(submitCourseListener);
		sideBar.getNewCoursePanel().addElectiveRadioListener(elRadioListener);
		sideBar.getNewCoursePanel().addPrereqListener(addPrereqsListener);
	}
		
	public void updatePrequisitePanel(String [] prereqs) {
		
		sideBar.getNewCoursePanel().updatePrereqs(prereqs);
	}
	
	public void updateCreditPrompt() {
		
		sideBar.getNewCoursePanel().updateCreditPrompt();
	}
	
	
	
	
	
	
	/*************************************************************************
	 * All the getters for the fields in the newCoursePanel.                 
	 *************************************************************************/
	
	/**
	 * 
	 * @return course type
	 */
	public String getCourseType() {
		return sideBar.getNewCoursePanel().getCourseType();
	}
	
	public String getCourseCode() {
		return sideBar.getNewCoursePanel().getCourseCode();
	}
	
	public String getCourseName() {
		return sideBar.getNewCoursePanel().getCourseName();
	}
	
	public String getCreditPoints() {
		return sideBar.getNewCoursePanel().getCreditPoints();
	}
	
	public String [] getPreReqs() {
		return sideBar.getNewCoursePanel().getPreReqs();
	}
	
	
	
	/**
	 * 
	 * @return menuBar
	 */
	public AMSMenuBar getAMSMenuBar() {
		return menuBar;
	}
	
	/**
	 * 
	 * @return programPanel
	 */
	public ProgramPanel getProgramPanel() {
		return programPanel;
	}
}
