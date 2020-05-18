
// Java.swing API runs on top of java.awt and offers more functionality, is platform independent and lighter.
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;




// creates a checkinputframe class that uses JFrame class from API to work and extends its functionality.
public class CheckInputFrame extends JFrame 
{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	// define JFrame properties that can only be used in this class.
	private JButton buttonOK;
	private JButton buttonExit;
	private JTextField inputValue;
	private JLabel message;
	// define checkinput property from checkinput class.
	CheckInput checkInput;
	

	// Constructor
	public CheckInputFrame()
	{
		// make new instance of checkInput object.
		checkInput = new CheckInput();
		// set size of window and bg color.
		this.setSize(250,125);
		this.setBackground(Color.white);
		// best practice to set EXIT_ON_CLOSE to avoid unnessecary memory usage and unexpected behavior.
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //EXIT_ON_CLOSE, because will be set later to buttonExit
		


		// Panel is instanced.
		// Panel is the simplest container class and provides space to attach components such as buttons.
		JPanel checkInputPanel = new JPanel();
		


		// Label is instanced.
		JLabel idTxt = new JLabel("Enter start number please: ");
		// Label placed inside Panel by way of -.add-.
		checkInputPanel.add(idTxt);
		


		// TextField for the input value
		inputValue = new JTextField(10);
		// input textfield is placed inside panel.
		checkInputPanel.add(inputValue);
		


		// Listener for when the windows is closed.
		// WindowListener is used to control behavior of window when you click on exit for example.
		addWindowListener
		(
			new WindowAdapter()
			{
				public void windowClosing(WindowEvent e)
				{
					// Go to the buttonExit is clicked
					buttonExit.doClick();
				}
			}
		); // Pay attention to closing bracket placement!


		
		// The Start button
		// instance net buttonOK object
		buttonOK = new JButton("Start");
		// Add listerner action to register button click to go to buttonOKClick function.
		buttonOK.addActionListener (e -> buttonOKClick());
		// add button to panel
		checkInputPanel.add(buttonOK);
		


		// The exit button
		// instance buttonExit object
		buttonExit = new JButton("Exit");
		// Add actionlistener to register click and forward to buttonExitClick function.
		buttonExit.addActionListener (e -> buttonExitClick());
		// Add button to panel
		checkInputPanel.add(buttonExit);
		


		// Label for messages
		// Instance object
		message = new JLabel("");
		// Add to panel
		checkInputPanel.add(message);


		
		// Panel added to frame
		this.add(checkInputPanel);
		// Set Frame in middle of screen
		this.setLocationRelativeTo(null);
		// Make frame visible (default is invisible)
		this.setVisible(true);
	}




	// Function for when Start button is clicked
	public void buttonOKClick()
	{

		// GET INPUT!!
		// Get input from the textField and assign it to personIdString object.
		String startNumberString = inputValue.getText();
	 
		

		// If empty, change label message to the text
		if(startNumberString.length() == 0)
		{
			message.setText("You didn't input a number. Fill in a number please");
			//why is this return without any instruction of what to return? or after the set text?
			return;
		}
		else
		{
			
			Long longInput = checkInput.checkInputString(startNumberString);
			
			
			// Check the input validity of input value with true or false return.
			// Check input is done by calling upon the checkinputstring method from checkinput class.
			// Given parameter for method is: startNumberString
			if(longInput != null)
			{
				
				Collatz collatz = new Collatz(longInput);
				
				
				// Create new checkOutputFrame
				CheckOutputFrame checkOutputFrame = new CheckOutputFrame(this, collatz.nString);
				 
				
				
				
				// RESET INPUT
				// Reset input text field and label message text
				inputValue.setText("");
				message.setText("");
				// Hide the frame
				this.setVisible(false);
				return;
			}
			else
			{
				// If input value not valid, change message to text
				message.setText("Your input is not valid. Fill in a whole numberplease");
				return;
			}	
		}
	}
	


	// If Exit button is clicked, this function will be executed.
	public void buttonExitClick()
	{
		System.exit(0);
		return;
	}


}