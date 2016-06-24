/**
 * 
 */
package ams.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import ams.controller.AMSController;
import ams.model.CoreCourse;
import ams.model.Course;
import ams.model.ElectiveCourse;
import ams.model.Program;
import ams.model.exception.ProgramException;
import ams.model.facade.AMSFacade;
import ams.model.facade.AMSModel;
import ams.view.AMSMainView;

/**
 * @author Thomas
 *
 */
public class AMSDriverTest {

	private static final String P1 = "COSC1073";
	private static final String P2 = "COSC2136";
	private static final String MATHS = "MATH1074";
	private static final String COMP_THEORY = "COSC1107";
	private static final String MAD = "COSC2309";
	private static final String DISTRIBUTED = "COSC1197";
	private static final String ADV_DISTRIBUTED = "ISYS2403";
	private static final String ADV_DISTRIBUTED2 = "ISYS2222";

	private static AMSModel model;

	private static Course coreCourse1, coreCourse2, coreCourse3, coreCourse4;
	private static Course electiveCourse1, electiveCourse2, electiveCourse3, electiveCourse4;
	
	public static void initialiseEngine() {
		model = new AMSFacade();
		model.addProgram(new Program("BP062", "Bachelor of Computer Science"));
		System.out.println("Initialised AMS engine with Program "
				+ model.getProgram().toString());
	}
	
	public static void initialiseCourses() {
		// create sample courses
		coreCourse1 = new CoreCourse(P1, "Programming 1", null);
		coreCourse2 = new CoreCourse(MATHS, "Mathematics for Computing", null);
		coreCourse3 = new CoreCourse(P2, "Programming 2", new String[] { P1 });
		coreCourse4 = new CoreCourse(COMP_THEORY, "Computing Theory",
				new String[] { P2, MATHS });

		electiveCourse1 = new ElectiveCourse(MAD,
				"Mobile Application Development", 6, new String[] { P2 });
		electiveCourse2 = new ElectiveCourse(DISTRIBUTED,
				"Distributed Systems", 12, new String[] { COMP_THEORY, MAD });
		electiveCourse3 = new ElectiveCourse(ADV_DISTRIBUTED,
				"Advanced Topics in Distributed Systems", 12,
				new String[] { DISTRIBUTED });
		electiveCourse4 = new ElectiveCourse(ADV_DISTRIBUTED2,
				"Advanced Topics in Distributed Systems 2", 6,
				new String[] { ADV_DISTRIBUTED });
	}
	
	public static void addCourses() {
		
		try {
			model.addCourse(coreCourse1);
			model.addCourse(coreCourse2);
			model.addCourse(coreCourse3);
			model.addCourse(coreCourse4);
			model.addCourse(electiveCourse1);
		} catch (ProgramException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		initialiseEngine();
		initialiseCourses();
		addCourses();
		
		AMSMainView mainView = new AMSMainView(model);
		
		@SuppressWarnings("unused")
		AMSController controller = new AMSController(mainView, model);
		
		mainView.setVisible(true);
	}

}
