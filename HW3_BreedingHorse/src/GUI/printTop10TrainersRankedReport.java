package GUI;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import init.BreedingHorses;

public class printTop10TrainersRankedReport {
	// frame
	JFrame f;
	// Table
	JTable j;
	//Application app=new Application();
	// Constructor
	printTop10TrainersRankedReport(BreedingHorses sys)
	{
		// Frame initialization
		f = new JFrame();

		// Frame Title
		f.setTitle("JTable Example");

		// Data to be displayed in the JTable
	
		// Column Names
		String[] columnNames = { "id", "name", "birthdate","worker id","salary","rank" };
		// Initializing the JTable
		j = new JTable();
		j.setBounds(30, 40, 200, 300);
		j.setModel(new FinalTableModel(sys.printTop10TrainersRankedReport()));
		// adding it to JScrollPane
		JScrollPane sp = new JScrollPane(j);
		sp.setViewportView(j);
		f.getContentPane().add(sp);
		// Frame Size
		f.setSize(836, 271);
		// Frame Visible = true
		
	}

	// Driver method
	public  void main(BreedingHorses sys)
	{
		new printTop10TrainersRankedReport(sys);
		f.setVisible(true);
	}
}
