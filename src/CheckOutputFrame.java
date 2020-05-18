

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class CheckOutputFrame extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	
	
	// Define properties to be used in this class
	private JButton buttonExit;
	private CheckInputFrame checkInputFrame;

	




	// Constructor
	public CheckOutputFrame(CheckInputFrame checkInputFrame, String nString)
	{
		// Instance object, set size and close operation.
		this.checkInputFrame = checkInputFrame;
		this.setSize(500,350);	
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		
		
		
		// Instance new panel object
		JPanel checkOutputPanel = new JPanel();

		
		
		
		// Define input number with output from CheckInput class
		Long inputNumber = CheckInput.inputNumber;
		// Define output
		String outputResult = nString;
		


		
		// sanity check: 
		System.out.println("input:");
		System.out.println(inputNumber);
		System.out.println("output:");
		System.out.println(outputResult);
		
		

		// instance object to show text and inputNumber
		JLabel InputTxt = new JLabel("You have entered: " + inputNumber);
		// Add to panel
		checkOutputPanel.add(InputTxt);
		
		
		
		
		
		// instance object to show text and outputResult
		JTextArea OutputCollatz = new JTextArea("Result: " + outputResult);
		// Set layout properties
		OutputCollatz.setEditable(false);
		OutputCollatz.setLineWrap(true);
		OutputCollatz.setWrapStyleWord(true);
		
		// Add textarea OutputCollatz to scollable pane
		JScrollPane areaScrollPane = new JScrollPane(OutputCollatz);
		// Set layout properties for scroll pane
		areaScrollPane.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );
		// Size of scollpane AND textarea is set here
		areaScrollPane.setPreferredSize(new Dimension(450, 250));
		
		
		
		// Add to panel
		checkOutputPanel.add(areaScrollPane);
		


		
		// Add listener to register click on exit button.
		addWindowListener
		(
			new WindowAdapter()
			{
				public void windowClosing(WindowEvent e)
				{
					buttonExit.doClick();
				}
			}
		); // Pay attention to closing bracket placement.



		
		// Exit button
		// Instance exit button object
		buttonExit = new JButton("Exit");
		// Add listener to exitbutton to register click
		buttonExit.addActionListener (e -> buttonExitClick());
		// Add button to panel
		checkOutputPanel.add(buttonExit);



		// Add panel to checklogout frame and set position in center of screen and visible.
		this.add(checkOutputPanel);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}


	
	
	

	// On exit
	public void buttonExitClick(){
		// Set the checkInputFrame to visible again
		checkInputFrame.setVisible(true);
		// Dispose this frame (delete)
		this.dispose();
		return;
	}
}