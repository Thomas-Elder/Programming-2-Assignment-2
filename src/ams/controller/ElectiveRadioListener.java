/**
 * 
 */
package ams.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ams.view.AMSMainView;

/**
 * @author Thomas
 *
 */
public class ElectiveRadioListener implements ActionListener {

	private AMSMainView view;
	
	/**
	 * 
	 */
	public ElectiveRadioListener(AMSMainView view) {
		
		this.view = view;
	}

	/**
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		view.updateCreditPrompt();
	}

}
