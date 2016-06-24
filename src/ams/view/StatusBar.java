/**
 * 
 */
package ams.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Thomas
 *
 */
@SuppressWarnings("serial")
public class StatusBar extends JPanel {

	private JLabel status;
	
	/**
	 * 
	 */
	public StatusBar() {
		super();
		
		Dimension preferredSize = new Dimension(0, 20);
		status = new JLabel("No program has been initialised.");
		
		this.setLayout(new BorderLayout());
		this.setBorder(BorderFactory.createLoweredBevelBorder());
		this.setPreferredSize(preferredSize);
		this.add(status, BorderLayout.WEST);
	}

	/**
	 * 
	 * @param status
	 * 
	 * Sets the text of the status label in the status bar to the string
	 * passed.
	 */
	public void updateStatus(String status) {
		this.status.setText(status);
	}
}
