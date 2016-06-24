/**
 * 
 */
package ams.main;

import ams.controller.AMSController;
import ams.model.facade.AMSFacade;
import ams.model.facade.AMSModel;
import ams.view.AMSMainView;

/**
 * @author Thomas
 *
 */
public class AMSDriver {

	public static void main(String[] args) {
		
		AMSModel model = new AMSFacade();
		AMSMainView mainView = new AMSMainView(model);
		@SuppressWarnings("unused")
		AMSController controller = new AMSController(mainView, model);
		
		mainView.setVisible(true);
	}

}
