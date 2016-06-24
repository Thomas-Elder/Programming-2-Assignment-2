/**
 * 
 */
package ams.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Thomas
 *
 */
@SuppressWarnings("serial")
public class ElectiveCreditPanel extends JPanel {

	private boolean hasPrompt;
	private JLabel electiveCreditPrompt;
	private JTextField electiveCreditTF;
	
	private Dimension lineDim;
	private float align;
	
	/**
	 * 
	 */
	public ElectiveCreditPanel(float align, Dimension lineDim) {
		this.lineDim = lineDim;
		this.align = align;
		
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		hasPrompt = false;
	}

	public void addCreditPrompt() {
		
		hasPrompt = true;
		
		electiveCreditPrompt = new JLabel("Please enter credit units: ");
		electiveCreditPrompt.setBackground(Color.GRAY);
		electiveCreditPrompt.setBorder(BorderFactory.createRaisedBevelBorder());		
		electiveCreditPrompt.setAlignmentX(align);
		electiveCreditPrompt.setMaximumSize(lineDim);
		
		electiveCreditTF = new JTextField(30);
		electiveCreditTF.setMaximumSize(lineDim);
		electiveCreditTF.setAlignmentX(align);
	
		this.add(electiveCreditPrompt);
		this.add(electiveCreditTF);
		
		this.validate();
	}

	public void removeCreditPrompt() {
		hasPrompt = false;
		
		this.remove(electiveCreditPrompt);
		this.remove(electiveCreditTF);
		
		this.validate();
	}
	
	public boolean hasPrompt() {
		return hasPrompt;
	}
	
	public String getCreditPoints() {
		return electiveCreditTF.getText();
	}
}
