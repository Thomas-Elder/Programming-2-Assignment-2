/**
 * 
 */
package ams.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;


import javax.swing.BorderFactory;
//import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Thomas
 *
 */
@SuppressWarnings("serial")
public class InitialiseProgramPanel extends JPanel {

	// Initialise Program Side Bar Components
	private JLabel initialiseProgram;
	private JLabel programCodePrompt;
	private JTextField programCodeTF;
	private JLabel programNamePrompt;
	private JTextField programNameTF;
	private JPanel space;
	private JButton submitProgram;
	
	private float align = CENTER_ALIGNMENT;
	
	/**
	 * 
	 */
	public InitialiseProgramPanel(Dimension lineDim) {
				
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		initialiseProgram = new JLabel("Initialise new Program");
		initialiseProgram.setBackground(Color.GRAY);
		initialiseProgram.setBorder(BorderFactory.createRaisedBevelBorder());
		initialiseProgram.setAlignmentX(align);
		initialiseProgram.setMaximumSize(lineDim);
		
		programCodePrompt = new JLabel("Please enter Program code: ");
		programCodePrompt.setBackground(Color.GRAY);
		programCodePrompt.setBorder(BorderFactory.createRaisedBevelBorder());
		programCodePrompt.setAlignmentX(align);
		programCodePrompt.setMaximumSize(lineDim);
		
		programCodeTF = new JTextField(30);
		programCodeTF.setMaximumSize(lineDim);
		programCodeTF.setAlignmentX(align);
		
		programNamePrompt = new JLabel("Please enter Program name: ");
		programNamePrompt.setBackground(Color.GRAY);
		programNamePrompt.setBorder(BorderFactory.createRaisedBevelBorder());		
		programNamePrompt.setAlignmentX(align);
		programNamePrompt.setMaximumSize(lineDim);
		
		programNameTF = new JTextField(30);
		programNameTF.setMaximumSize(lineDim);
		programNameTF.setAlignmentX(align);
		
		submitProgram = new JButton("Submit");
		submitProgram.setMaximumSize(lineDim);
		submitProgram.setAlignmentX(align);
		
		space = new JPanel();
		space.setBackground(Color.DARK_GRAY);
		
		this.add(initialiseProgram);
		this.add(programCodePrompt);
		this.add(programCodeTF);
		this.add(programNamePrompt);
		this.add(programNameTF);
		this.add(submitProgram);
		this.add(space);
		
		this.validate();
	}

	public String getProgramName() {
		return programNameTF.getText();
	}
	
	public String getProgramCode() {
		return programCodeTF.getText();
	}
	
	public void addSubmitListener(ActionListener al) {
		submitProgram.addActionListener(al);
	}
}
