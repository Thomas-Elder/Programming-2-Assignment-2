/**
 * 
 */
package ams.view;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * @author Thomas
 *
 */
@SuppressWarnings("serial")
public class SideBar extends JPanel {

	private int sidePanelWidth = 210;
	private Dimension lineDim = new Dimension(sidePanelWidth, 20);
	
	// Side Panel Header JButtons
	private JButton add;
	private JButton init;
	private JButton reset;
	
	private JPanel sideBarHeader;
	
	private InitialiseProgramPanel initProgram;
	private NewCoursePanel newCourse;
	
	/**
	 * 
	 */
	public SideBar() {
		
		super();
		
		Dimension preferredSize = new Dimension(sidePanelWidth, 600);
		
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.setBorder(BorderFactory.createLoweredBevelBorder());
		this.setPreferredSize(preferredSize);
		
		this.addSideBarHeader();
	}
	
	public void addSideBarHeader() {
		
		sideBarHeader = new JPanel();
		
		add = new JButton("Add");
		init = new JButton("Initialise");
		reset = new JButton("Reset");
		
		sideBarHeader.setLayout(new BoxLayout(sideBarHeader, BoxLayout.LINE_AXIS));
		
		sideBarHeader.add(add);
		sideBarHeader.add(init);
		sideBarHeader.add(reset);
		
		sideBarHeader.setMinimumSize(lineDim);
		
		sideBarHeader.setAlignmentX(CENTER_ALIGNMENT);
		
		this.add(sideBarHeader);
	}

	public void addInitialiseProgramSideBar() {
		
		if (newCourse != null) {
			this.remove(newCourse);
		}
		
		if (initProgram != null) {
			this.remove(initProgram);
		}
		
		initProgram = new InitialiseProgramPanel(lineDim);
		this.add(initProgram);
		this.validate();
	}
	
	public void newCourseSideBar() {
		
		if (initProgram != null) {
			this.remove(initProgram);
		}
		
		if (newCourse != null) {
			this.remove(newCourse);
		}
		
		newCourse = new NewCoursePanel(lineDim);
		this.add(newCourse);
		this.validate();
	}
	
	public void addButtonListeners(ActionListener addButtonListener, 
			ActionListener initButtonListener,
			ActionListener resetButtonListener) {
		
		add.addActionListener(addButtonListener);
		init.addActionListener(initButtonListener);
		reset.addActionListener(resetButtonListener);
	}
		
	public InitialiseProgramPanel getInitProgramPanel() {
		return initProgram;
	}
	
	public NewCoursePanel getNewCoursePanel() {
		return newCourse;
	}
}
