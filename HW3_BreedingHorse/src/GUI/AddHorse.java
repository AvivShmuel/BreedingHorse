package GUI;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import init.BreedingHorses;
import utils.Genre;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

public class AddHorse extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_4;
	private JTextField textField_9;

	/**
	 * Launch the application.
	 */
	public void Start(BreedingHorses sys) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddHorse frame = new AddHorse(sys);
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
	public AddHorse(BreedingHorses sys) {
		setTitle("Add Horse");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 493, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Identifier Serial");
		lblNewLabel.setBounds(31, 34, 119, 14);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("nickName");
		lblNewLabel_1.setBounds(31, 69, 119, 14);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("BirthDate");
		lblNewLabel_2.setBounds(31, 104, 119, 14);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Weight");
		lblNewLabel_3.setBounds(31, 144, 119, 14);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Gender");
		lblNewLabel_4.setBounds(31, 186, 119, 14);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Color");
		lblNewLabel_5.setBounds(31, 225, 119, 14);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Price");
		lblNewLabel_6.setBounds(31, 260, 119, 14);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Revenue");
		lblNewLabel_7.setBounds(31, 296, 119, 14);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Total Participates Times");
		lblNewLabel_8.setBounds(31, 332, 175, 14);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Genre");
		lblNewLabel_9.setBounds(31, 365, 119, 14);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel_9);
		
		textField = new JTextField();
		textField.setBounds(227, 34, 105, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(227, 69, 105, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(227, 104, 105, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(227, 144, 105, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(227, 225, 54, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(227, 260, 105, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(227, 296, 105, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(227, 332, 105, 20);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(227, 187, 105, 22);
		contentPane.add(comboBox);
		comboBox.addItem("M");
		comboBox.addItem("F");
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(227, 366, 105, 22);
		contentPane.add(comboBox_1);
		comboBox_1.addItem(Genre.APPALOOSA);
		comboBox_1.addItem(Genre.ARABIAN);
		comboBox_1.addItem(Genre.CANADIAN);
		comboBox_1.addItem(Genre.FRIESIAN);
		comboBox_1.addItem(Genre.HACKNEY);
		comboBox_1.addItem(Genre.HANOVERIAN);
		comboBox_1.addItem(Genre.IRISH_HUNTER);
		comboBox_1.addItem(Genre.PAINT);
		comboBox_1.addItem(Genre.PUREBRED_SPANISH);
		comboBox_1.addItem(Genre.QUARTER);
		comboBox_1.addItem(Genre.STANDARDBRED);
		comboBox_1.addItem(Genre.THOROUGHBRED);
		comboBox_1.addItem(Genre.UNKNOWN);
		
		
		JButton btnNewButton = new JButton("Add Horse");
		btnNewButton.setBounds(209, 422, 123, 23);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				String x= (String) comboBox.getSelectedItem();
				int a=JOptionPane.showConfirmDialog(contentPane,"Are you sure?");  
				if(a==JOptionPane.YES_OPTION){  
				    sys.addHorse(textField.getText(), textField_1.getText(), new Date(textField_2.getText()), Double.parseDouble(textField_3.getText()), x.charAt(0),
				    		new Color(Integer.parseInt(textField_5.getText()), Integer.parseInt(textField_4.getText()), Integer.parseInt(textField_9.getText())),Double.parseDouble(textField_6.getText()),
				    				(Genre) comboBox_1.getSelectedItem(),Double.parseDouble(textField_7.getText()),Integer.parseInt(textField_8.getText()));
				    	
			}
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(btnNewButton);
		

		
		textField_4 = new JTextField();
		textField_4.setBounds(301, 224, 54, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(380, 224, 54, 20);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
		
		
	}
}
