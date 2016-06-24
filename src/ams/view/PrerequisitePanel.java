/**
 * 
 */
package ams.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Thomas
 *
 */
@SuppressWarnings("serial")
public class PrerequisitePanel extends JPanel {

	private ArrayList <JLabel> prereqs;
	private JButton addPrereqs;
	
	private Dimension lineDim;
	private float align;
	
	/**
	 * 
	 * @param align
	 * @param lineDim
	 * 
	 * Constructs the Prerequisite Panel, which holds information about
	 * the prerequisite courses.
	 */
	public PrerequisitePanel(float align, Dimension lineDim) {
	
		this.align = align;
		this.lineDim = lineDim;
		
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		prereqs = new ArrayList <JLabel>();
		
		addPrereqs = new JButton("Add prerequisite Courses");
		addPrereqs.setMaximumSize(lineDim);
		addPrereqs.setAlignmentX(align);
		
		this.add(addPrereqs);
		this.validate();
		
	}

	/**
	 * 
	 * @param prereqs
	 * 
	 * Takes an array of strings, the course codes for the prerequisite 
	 * courses, and creates a new JLabel for each code, adds that to the
	 * PrerequisitePanel and the arraylist of prerequisite JLabels.
	 */
	public void addPrereqs(String [] prereqs) {
				
		JLabel prereqListHead = new JLabel("Prerequisite courses: ");
		prereqListHead.setMaximumSize(lineDim);
		prereqListHead.setAlignmentX(align);
		prereqListHead.setBorder(BorderFactory.createRaisedBevelBorder());
		prereqListHead.setBackground(Color.GRAY);
		
		this.add(prereqListHead);
		
		for (String s: prereqs) {
			JLabel p = new JLabel(s);
			p.setMaximumSize(lineDim);
			p.setAlignmentX(align);
			p.setBorder(BorderFactory.createRaisedBevelBorder());
			p.setBackground(Color.GRAY);
			
			this.prereqs.add(p);
			this.add(p);
		}
		
		this.validate();
	}
	
	/**
	 * 
	 * @return prereqString
	 * 
	 * Returns an array of strings, the course codes which have been 
	 * added as prerequisites for this course.
	 */
	public String [] getPrereqs() {
		
		if (prereqs != null) {
			String [] prereqString = new String [prereqs.size()];
			
			int i = 0;
			
			for (JLabel j : prereqs) {
				prereqString[i] = j.getText();
				i++;
			}
			
			return prereqString;
		}
		
		return null;
	}
	
	/**
	 * 
	 * @param al
	 * 
	 * Adds the passed actionlistener to the addPrereqs JButton.
	 */
	public void addPrereqListener(ActionListener al) {
		addPrereqs.addActionListener(al);
	}
}
