/**
 * 
 */
package ams.view;

import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * @author Thomas
 *
 */
@SuppressWarnings("serial")
public class AMSMenuBar extends JMenuBar {

	private JMenu file, edit;
	
	private JMenuItem quit, add, reset, initialise;
	
	/**
	 * 
	 */
	public AMSMenuBar() {
		super();
		
		init();
		
		this.add(file);
		this.add(edit);
	}
	
	private void init() {
		file = new JMenu("File");
		edit = new JMenu("Edit");
		
		quit = new JMenuItem("Quit");  
		
		file.add(quit);
		
		add = new JMenuItem("Add"); 
		reset = new JMenuItem("Reset");
		initialise = new JMenuItem("Initialise");
		
		edit.add(add);
		edit.add(reset);
		edit.add(initialise);
	}
	
	public void addMenuListeners(ActionListener al) {

		quit.addActionListener(al);
		add.addActionListener(al);
		reset.addActionListener(al);
		initialise.addActionListener(al);
	}
}
