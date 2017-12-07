package owoMachine;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.datatransfer.*;
import java.awt.Toolkit;

public abstract class OwOer extends JFrame implements ActionListener {
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
	
	
	
	static JTextArea text;
	static JButton convert;
	static JTextArea output;
	static JButton clipboard;
	
    private static void createAndShowGUI() {
        //Create and set up the window.
    	
    	
    	JFrame frame = new JFrame("OwO text converter");
    	frame.setLayout(new GridLayout(0,1));
    	JPanel pane = new JPanel(new GridLayout(0,1));
    	JPanel clipboardPane = new JPanel();
    	pane.setBorder(new EmptyBorder(20,20,20,20));
    	pane.setPreferredSize(new Dimension(500, 500));
    	
    	clipboardPane.setPreferredSize(new Dimension(70, 30));
    	frame.setPreferredSize(new Dimension(600, 600));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTextArea text = new JTextArea("Insert Text", 1, 5);
        frame.add(pane);
        frame.add(clipboardPane);
        JTextArea output = new JTextArea("", 15, 30);
        pane.add(text);
        JScrollPane scroll = new JScrollPane(text);
        pane.add(scroll);
        JButton convert = new JButton("OwO'ify");
        pane.add(convert);
        pane.add(output);
        JScrollPane outscroll = new JScrollPane(output);
        pane.add(outscroll);
        JButton clipboard = new JButton("copy to clipboard");
        clipboard.setPreferredSize(new Dimension(300, 30));
        clipboardPane.add(clipboard);
        output.setEditable(false);
        //Display the window.
        frame.pack();
        frame.setVisible(true);
        convert.addActionListener(new ActionListener()
        {
        	
          public void actionPerformed(ActionEvent e)
          {
        	  
        	  char[] outputChars = text.getText().toCharArray();
    		  
        	  for (int x = 0; x < outputChars.length; x++)
        	  {
        		  switch (outputChars[x]) {
        		  case 'r':
        		  case 'l': outputChars[x] = 'w';
        		  break;
        		  case 'R':
        		  case 'L': outputChars[x] = 'W';
        		  break;
        		  case 'n' :outputChars[x] = 'n';
        		  	if (outputChars[x+1]!= ' ')
        		  		{
        		  		outputChars[x+1] = 'y';
        		  		}
        		  	break;
        		  case 'N': outputChars[x] = 'N';
		  		if (outputChars[x+1]!= ' ')
		  		{
		  		outputChars[x+1] = 'y';
		  		}
		  		break;
			case 'k':
		  		if (outputChars[x+1] == 'e')
		  		{
				outputChars[x] = 'e';
		  		outputChars[x+1] = 'k';
				}
				break;
			case 'K':
		  		if (outputChars[x+1] == 'e')
		  		{
				outputChars[x] = 'E';
		  		outputChars[x+1] = 'k';
				}
				if (outputChars[x+1] == 'E')
		  		{
				outputChars[x] = 'E';
		  		outputChars[x+1] = 'K';
				}
				break;
        		  default: 
        			  break;
        		  }
        		  
        	  }
        	 
        	  String outputString = new String (outputChars);
        	  output.setText(outputString);
           
          }
        });
        
        clipboard.addActionListener(new ActionListener()
        {
        	
          public void actionPerformed(ActionEvent e)
          { 
           
        	 SystemClipboard.copy(output.getText());
        	
          }
        });
        
    }
 
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
                
                text.getText();
              
            }
        });
    }
}
