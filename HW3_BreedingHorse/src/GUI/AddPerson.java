package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import content.BookMaker;
import content.Equestrian;
import content.Gambler;
import content.Trainer;
import content.Veterinarian;
import init.BreedingHorses;

import utils.Rank;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Time;


import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddPerson extends JFrame {
//	Application app=new Application();
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTextField textField_22;
	private JTextField textField_23;

	/**
	 * Launch the application.
	 */
	public  void Start(BreedingHorses sys) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPerson frame = new AddPerson(sys);
					
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
	public AddPerson(BreedingHorses sys) {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 594, 404);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, -1, 578, 367);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Add Trainer", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(34, 34, 46, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Full Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(33, 73, 81, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("BirthDate");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(34, 111, 80, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("WorkerID");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(34, 150, 80, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Salary");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(34, 184, 46, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Rank");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setBounds(34, 224, 46, 14);
		panel.add(lblNewLabel_5);
		
		textField = new JTextField();
		textField.setBounds(167, 34, 105, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(167, 71, 105, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(167, 110, 105, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(167, 148, 105, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(167, 185, 105, 20);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setBounds(167, 220, 105, 22);
		panel.add(comboBox);
		comboBox.addItem(Rank.BEGGINER);
		comboBox.addItem(Rank.EXPERT);
		comboBox.addItem(Rank.JUNIOR);
		comboBox.addItem(Rank.MASTER);
		comboBox.addItem(Rank.PUNK);
		
		JButton btnNewButton = new JButton("Add Trainer");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int a=JOptionPane.showConfirmDialog(contentPane,"Are you sure?");  
				if(a==JOptionPane.YES_OPTION){ 
					sys.addPerson(new Trainer(textField.getText(), textField_1.getText(),
							new Date(textField_2.getText()), textField_3.getText(), Double.parseDouble(textField_4.getText()),
							 (Rank) comboBox.getSelectedItem()));
			}else setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(167, 277, 118, 23);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Add Equestrian", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("ID");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6.setBounds(65, 27, 46, 14);
		panel_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Full Name");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_7.setBounds(65, 68, 74, 14);
		panel_1.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("BirthDate");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_8.setBounds(65, 110, 66, 14);
		panel_1.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Rank");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_9.setBounds(65, 152, 46, 14);
		panel_1.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Equest Hours");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_10.setBounds(65, 196, 108, 14);
		panel_1.add(lblNewLabel_10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(191, 26, 86, 20);
		panel_1.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(191, 67, 86, 20);
		panel_1.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(191, 109, 86, 20);
		panel_1.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(191, 195, 86, 20);
		panel_1.add(textField_8);
		textField_8.setColumns(10);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(191, 150, 86, 22);
		panel_1.add(comboBox_1);
		comboBox_1.addItem(Rank.BEGGINER);
		comboBox_1.addItem(Rank.EXPERT);
		comboBox_1.addItem(Rank.JUNIOR);
		comboBox_1.addItem(Rank.MASTER);
		comboBox_1.addItem(Rank.PUNK);
		
		JButton btnNewButton_1 = new JButton("Add Equestrian");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int a=JOptionPane.showConfirmDialog(contentPane,"Are you sure?");  
				if(a==JOptionPane.YES_OPTION){ 
					 sys.addPerson(new Equestrian(textField_5.getText(), textField_6.getText(),
							 new Date(textField_7.getText()), (Rank) comboBox_1.getSelectedItem(),Time.valueOf(textField_8.getText()))
								);
			}else setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(191, 257, 139, 23);
		panel_1.add(btnNewButton_1);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Add Veterinarian", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_11 = new JLabel("ID");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_11.setBounds(35, 24, 46, 14);
		panel_2.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Full Name");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_12.setBounds(35, 66, 94, 14);
		panel_2.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("BirthDate");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_13.setBounds(35, 109, 94, 14);
		panel_2.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("Serial ID");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_14.setBounds(35, 156, 94, 14);
		panel_2.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("Salary");
		lblNewLabel_15.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_15.setBounds(35, 203, 46, 14);
		panel_2.add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("Total Treatment Hours");
		lblNewLabel_16.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_16.setBounds(35, 250, 184, 14);
		panel_2.add(lblNewLabel_16);
		
		JButton btnNewButton_2 = new JButton("Add Veterinarian");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int a=JOptionPane.showConfirmDialog(contentPane,"Are you sure?");  
				if(a==JOptionPane.YES_OPTION){ 
					sys.addPerson(new Veterinarian(textField_9.getText(),
							textField_10.getText(), new Date(textField_11.getText()), textField_12.getText(),
							Double.parseDouble(textField_13.getText()), Integer.parseInt(textField_14.getText())));
				    
			}else setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_2.setBounds(169, 290, 184, 23);
		panel_2.add(btnNewButton_2);
		
		textField_9 = new JTextField();
		textField_9.setBounds(267, 23, 105, 20);
		panel_2.add(textField_9);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setBounds(267, 65, 105, 20);
		panel_2.add(textField_10);
		textField_10.setColumns(10);
		
		textField_11 = new JTextField();
		textField_11.setBounds(267, 108, 105, 20);
		panel_2.add(textField_11);
		textField_11.setColumns(10);
		
		textField_12 = new JTextField();
		textField_12.setBounds(267, 155, 105, 20);
		panel_2.add(textField_12);
		textField_12.setColumns(10);
		
		textField_13 = new JTextField();
		textField_13.setBounds(267, 202, 105, 20);
		panel_2.add(textField_13);
		textField_13.setColumns(10);
		
		textField_14 = new JTextField();
		textField_14.setBounds(267, 249, 105, 20);
		panel_2.add(textField_14);
		textField_14.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Add Gambler", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_17 = new JLabel("ID");
		lblNewLabel_17.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_17.setBounds(42, 36, 46, 14);
		panel_3.add(lblNewLabel_17);
		
		JLabel lblNewLabel_18 = new JLabel("Full Name");
		lblNewLabel_18.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_18.setBounds(42, 76, 75, 14);
		panel_3.add(lblNewLabel_18);
		
		JLabel lblNewLabel_19 = new JLabel("BirthDate");
		lblNewLabel_19.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_19.setBounds(42, 119, 75, 14);
		panel_3.add(lblNewLabel_19);
		
		JLabel lblNewLabel_20 = new JLabel("Account");
		lblNewLabel_20.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_20.setBounds(42, 168, 75, 14);
		panel_3.add(lblNewLabel_20);
		
		JButton btnNewButton_3 = new JButton("Add Gambler");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int a=JOptionPane.showConfirmDialog(contentPane,"Are you sure?");  
				if(a==JOptionPane.YES_OPTION){
					sys.addPerson(new Gambler(textField_15.getText(), textField_16.getText(),
						new Date(textField_17.getText()),Double.parseDouble(textField_18.getText()))); 
				    
			}else setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}});
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_3.setBounds(130, 229, 121, 23);
		panel_3.add(btnNewButton_3);
		
		textField_15 = new JTextField();
		textField_15.setBounds(181, 35, 105, 20);
		panel_3.add(textField_15);
		textField_15.setColumns(10);
		
		textField_16 = new JTextField();
		textField_16.setBounds(181, 75, 105, 20);
		panel_3.add(textField_16);
		textField_16.setColumns(10);
		
		textField_17 = new JTextField();
		textField_17.setBounds(181, 118, 105, 20);
		panel_3.add(textField_17);
		textField_17.setColumns(10);
		
		textField_18 = new JTextField();
		textField_18.setBounds(181, 167, 105, 20);
		panel_3.add(textField_18);
		textField_18.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Add BookMaker", null, panel_4, null);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_21 = new JLabel("ID");
		lblNewLabel_21.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_21.setBounds(32, 35, 46, 14);
		panel_4.add(lblNewLabel_21);
		
		JLabel lblNewLabel_22 = new JLabel("Full Name");
		lblNewLabel_22.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_22.setBounds(32, 73, 86, 14);
		panel_4.add(lblNewLabel_22);
		
		JLabel lblNewLabel_23 = new JLabel("BirthDate");
		lblNewLabel_23.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_23.setBounds(32, 116, 86, 14);
		panel_4.add(lblNewLabel_23);
		
		JLabel lblNewLabel_24 = new JLabel("License Number");
		lblNewLabel_24.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_24.setBounds(32, 162, 116, 14);
		panel_4.add(lblNewLabel_24);
		
		JLabel lblNewLabel_25 = new JLabel("Percent To Bet");
		lblNewLabel_25.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_25.setBounds(32, 206, 116, 14);
		panel_4.add(lblNewLabel_25);
		
		textField_19 = new JTextField();
		textField_19.setBounds(177, 32, 105, 20);
		panel_4.add(textField_19);
		textField_19.setColumns(10);
		
		textField_20 = new JTextField();
		textField_20.setBounds(177, 73, 105, 20);
		panel_4.add(textField_20);
		textField_20.setColumns(10);
		
		textField_21 = new JTextField();
		textField_21.setBounds(177, 113, 105, 20);
		panel_4.add(textField_21);
		textField_21.setColumns(10);
		
		textField_22 = new JTextField();
		textField_22.setBounds(177, 159, 105, 20);
		panel_4.add(textField_22);
		textField_22.setColumns(10);
		
		textField_23 = new JTextField();
		textField_23.setBounds(177, 203, 105, 20);
		panel_4.add(textField_23);
		textField_23.setColumns(10);
		
		JButton btnNewButton_4 = new JButton("Add BookMaker");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int a=JOptionPane.showConfirmDialog(contentPane,"Are you sure?");  
				if(a==JOptionPane.YES_OPTION){  
					sys.addPerson(new BookMaker(textField_19.getText(), textField_20.getText(), textField_21.getText(),
							new Date(textField_22.getText()),Double.parseDouble(textField_23.getText())));
			}else setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}});
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_4.setBounds(158, 262, 151, 23);
		panel_4.add(btnNewButton_4);
	}
}
