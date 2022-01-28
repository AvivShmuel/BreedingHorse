package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import init.BreedingHorses;

public class printAllHorses extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public  void Start(BreedingHorses sys) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					printAllHorses frame = new printAllHorses(sys);
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
	public printAllHorses(BreedingHorses sys) {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		String [][] data=sys.printAllHorses();
		String cols[] = {"horseid" , "nickname" , "birthdate" , "weight", "gender" , "color" , "price" , "genre" , "revenue" , "totalparticipatetimes" , "trainer"};
		DefaultTableModel model = new DefaultTableModel(data,cols);
		JTable table = new JTable(model);
		table.setShowGrid(true);
		contentPane.add(table);

	
	}

}
