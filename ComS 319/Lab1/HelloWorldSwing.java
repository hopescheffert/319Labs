//package HelloWorldWindowBuilder;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class HelloWorldSwing {
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("HelloWorldSwing!");
		
		frame.setSize(new Dimension(370, 220));
		frame.setContentPane(createContainers());
		
		frame.setVisible(true);
	}
	
	static JPanel createContainers() {
		
		JLabel statusMessage = new JLabel("Hello World!");
		
		// Main Panel
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout (mainPanel, BoxLayout.Y_AXIS));
		
		// Top Panel
		JPanel topPanel = new JPanel();
		//topPanel.setLayout(new BoxLayout (topPanel, BoxLayout.X_AXIS));
		topPanel.add(new JLabel("Text:"));
		JTextField text1 = new JTextField("Hello World!");
		text1.addActionListener(
	    		new ActionListener() {
	    				@Override
					public void actionPerformed(ActionEvent e) {
						statusMessage.setText(e.getActionCommand());
					}
	    		}
	    	);
		topPanel.add(text1);
		String[] textStrings = { "Tiny", "Small", "Medium", "Large" };
	    JComboBox combo1 = new JComboBox(textStrings);
	    Font comboFont1 = new Font("Arial", Font.PLAIN, 8);
	    Font comboFont2 = new Font("Arial", Font.PLAIN, 12);
	    Font comboFont3 = new Font("Arial", Font.PLAIN, 20);
	    Font comboFont4 = new Font("Arial", Font.PLAIN, 28);
	    combo1.addItemListener(
	    		new ItemListener() {
	    			public void itemStateChanged(ItemEvent e) {
	    			    if ((e.getStateChange() == ItemEvent.SELECTED)) {
	    			       int selection = combo1.getSelectedIndex();
	    			            switch (selection){
	    			            case 0:  statusMessage.setFont(comboFont1); break;
	    			            case 1:  statusMessage.setFont(comboFont2); break;
	    			            case 2:  statusMessage.setFont(comboFont3); break;
	    			            case 3:  statusMessage.setFont(comboFont4); break;
	    			     }
	    		}
	    			}
	    		}
	    		
	    		);
	    topPanel.add(combo1);
		mainPanel.add(topPanel);
		
	    // Middle Panel
		JPanel middlePanel = new JPanel();
		middlePanel.setLayout(new BoxLayout (middlePanel, BoxLayout.X_AXIS));
		// Left Middle
		JPanel leftMiddlePanel = new JPanel();
		leftMiddlePanel.setLayout(new BoxLayout (leftMiddlePanel, BoxLayout.Y_AXIS));
		JRadioButton radioButton1 = new JRadioButton("Plain");
		JRadioButton radioButton2 = new JRadioButton("Bold");
		JRadioButton radioButton3 = new JRadioButton("Italic");
		JRadioButton radioButton4 = new JRadioButton("Bold Italic");
		Font font1 = new Font("Arial", Font.PLAIN, 12);
		Font font2 = new Font("Arial", Font.BOLD, 12);
		Font font3 = new Font("Arial", Font.ITALIC, 12);
		Font font4 = new Font("Arial", Font.BOLD + Font.ITALIC, 12);
		radioButton1.addActionListener(
	    		// This is an ANONYMOUS class
	    		new ActionListener() {
	    				@Override
					public void actionPerformed(ActionEvent e) {
						statusMessage.setFont(font1);
					}
	    		}
	    	);
		radioButton2.addActionListener(
	    		// This is an ANONYMOUS class
	    		new ActionListener() {
	    				@Override
					public void actionPerformed(ActionEvent e) {
						statusMessage.setFont(font2);
					}
	    		}
	    	);
		radioButton3.addActionListener(
	    		// This is an ANONYMOUS class
	    		new ActionListener() {
	    				@Override
					public void actionPerformed(ActionEvent e) {
						statusMessage.setFont(font3);
					}
	    		}
	    	);
		radioButton4.addActionListener(
	    		// This is an ANONYMOUS class
	    		new ActionListener() {
	    				@Override
					public void actionPerformed(ActionEvent e) {
						statusMessage.setFont(font4);
					}
	    		}
	    	);
	    leftMiddlePanel.add(radioButton1);
	    leftMiddlePanel.add(radioButton2);
	    leftMiddlePanel.add(radioButton3);
	    leftMiddlePanel.add(radioButton4);
	    // Right Middle
	    JPanel rightMiddlePanel = new JPanel();
	    rightMiddlePanel.setLayout(new BoxLayout (rightMiddlePanel, BoxLayout.Y_AXIS));
	    rightMiddlePanel.add(statusMessage);
	    // Adding Panels
	    middlePanel.add(leftMiddlePanel);
	    middlePanel.add(rightMiddlePanel);
		mainPanel.add(middlePanel);
		
		// Bottom Panel
		JPanel bottomPanel = new JPanel();
		// Left Bottom
		JPanel leftBottomPanel = new JPanel();
		JButton button1 = new JButton("Show!");
		button1.addActionListener(
	    		// This is an ANONYMOUS class
	    		new ActionListener() {
	    				@Override
					public void actionPerformed(ActionEvent e) {
	    					if(statusMessage.getForeground() == Color.RED){
	    						statusMessage.setForeground(Color.BLACK);
	    					} else {
	    						statusMessage.setForeground(Color.RED);
	    					}
					}
	    		}
	    	);
		leftBottomPanel.add(button1);
		// Right Bottom
		JPanel rightBottomPanel = new JPanel();
		JButton button2 = new JButton("Exit");
		button2.addActionListener(
	    		// This is an ANONYMOUS class
	    		new ActionListener() {
	    				@Override
					public void actionPerformed(ActionEvent e) {
						System.exit(0);
					}
	    		}
	    	);
		rightBottomPanel.add(button2);
		// Adding Panels
		bottomPanel.add(leftBottomPanel);
		bottomPanel.add(rightBottomPanel);
		mainPanel.add(bottomPanel);
	    
		return mainPanel;
	}
	
}