//package HelloWorldWindowBuilder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class HelloWorldSwing2 extends JFrame {

	private JPanel contentPane;
	private JTextField txtHelloWorld;
	private JPanel panel_1;
	private JRadioButton rdbtnPlain;
	private JRadioButton rdbtnItalic;
	private JRadioButton rdbtnBold;
	private JRadioButton rdbtnBoldItalic;
	private Box verticalBox;
	private JLabel lblText;
	private JLabel lblNewLabel_1;
	private JPanel panel_2;
	private JButton btnShow;
	private JButton btnCancel;
	private JPanel panel_3;
	
	private int size = 11;
	private int style = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HelloWorldSwing2 frame = new HelloWorldSwing2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HelloWorldSwing2() {
		setTitle("HelloWorldSwing");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 370, 220);
		JFrame frame = this;
		contentPane = new JPanel();
		contentPane.setAlignmentY(Component.TOP_ALIGNMENT);
		contentPane.setAlignmentX(Component.LEFT_ALIGNMENT);
		contentPane.setName("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel.setAlignmentX(Component.LEFT_ALIGNMENT);
		contentPane.add(panel, BorderLayout.NORTH);
		
		lblText = new JLabel("Text:      ");
		panel.add(lblText);
		
		txtHelloWorld = new JTextField();
		txtHelloWorld.setText("Hello World!");
		panel.add(txtHelloWorld);
		txtHelloWorld.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Tiny", "Small", "Medium", "Large"}));
		comboBox.setSelectedIndex(1);
		comboBox.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				switch (comboBox.getSelectedItem().toString()){
					case "Tiny":
						size = 8;
						break;
					case "Small":
						size = 12;
						break;
					case "Medium":
						size = 20;
						break;
					case "Large":
						size = 28;
						break;
				}
				lblNewLabel_1.setFont(new Font("Arial", style, size));
			}
			
		});
		panel.add(comboBox);
		
		panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.CENTER);
		
		lblNewLabel_1 = new JLabel(txtHelloWorld.getText());
		lblNewLabel_1.setFont(new Font("Arial", style, size));
		lblNewLabel_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel_3.add(lblNewLabel_1, BorderLayout.CENTER);
		txtHelloWorld.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				lblNewLabel_1.setText(txtHelloWorld.getText());
			}
		});
		
		panel_1 = new JPanel();
		panel_1.setAlignmentY(Component.TOP_ALIGNMENT);
		panel_1.setAlignmentX(Component.LEFT_ALIGNMENT);
		contentPane.add(panel_1, BorderLayout.WEST);
		
		verticalBox = Box.createVerticalBox();
		panel_1.add(verticalBox);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		rdbtnPlain = new JRadioButton("Plain");
		rdbtnPlain.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				style = Font.PLAIN;
				lblNewLabel_1.setFont(new Font("Arial", style, size));
			}
			
		});
		
		verticalBox.add(rdbtnPlain);
		buttonGroup.add(rdbtnPlain);
		rdbtnPlain.setSelected(true);
		
		rdbtnBold = new JRadioButton("Bold");
		rdbtnBold.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				style = Font.BOLD;
				lblNewLabel_1.setFont(new Font("Arial", style, size));
			}
			
		});
		verticalBox.add(rdbtnBold);
		buttonGroup.add(rdbtnBold);
		
		rdbtnItalic = new JRadioButton("Italic");
		rdbtnItalic.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				style = Font.ITALIC;
				lblNewLabel_1.setFont(new Font("Arial", style, size));
			}
			
		});
		
		verticalBox.add(rdbtnItalic);
		buttonGroup.add(rdbtnItalic);
		
		rdbtnBoldItalic = new JRadioButton("Bold Italic");
		rdbtnBoldItalic.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				style = Font.BOLD | Font.ITALIC;
				lblNewLabel_1.setFont(new Font("Arial", style, size));
			}
			
		});
		verticalBox.add(rdbtnBoldItalic);
		buttonGroup.add(rdbtnBoldItalic);
		
		panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		btnShow = new JButton("Show");
		btnShow.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(lblNewLabel_1.getForeground() == Color.RED)
					lblNewLabel_1.setForeground(Color.BLACK);
				else 
					lblNewLabel_1.setForeground(Color.RED);
			}
			
		});
		panel_2.add(btnShow);
		
		btnCancel = new JButton("Exit");
		btnCancel.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e){
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(false);
				frame.dispose();
			}
			
		});
		panel_2.add(btnCancel);
		
	}

}
