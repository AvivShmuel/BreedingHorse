package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import content.Person;
import init.BreedingHorses;

public class printAllPersons extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public  void Start(BreedingHorses sys) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					printAllPersons frame = new printAllPersons(sys);
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

	public printAllPersons(BreedingHorses sys) {
	    Map<String, Person> persons;
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		persons=sys.printAllPersons();
		JTable table=new JTable(persons.size(),1);
		 int row=0;
		 for(Map.Entry<String,Person> entry: persons.entrySet()){
		      table.setValueAt(entry.getKey(),row,0);
		      table.setValueAt(entry.getValue(),row,0);
		      row++;
		 }
		 contentPane.add(table);
	}

}
