package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import init.BreedingHorses;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Application {
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public  void Start(BreedingHorses sys) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Application window = new Application(sys);
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Application(BreedingHorses sys) {
		initialize(sys);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(BreedingHorses sys) {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 434, 22);
		frame.getContentPane().add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Add");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Add Person");
		mntmNewMenuItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				AddPerson ap = new AddPerson(sys);
				ap.Start(sys);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Add Horse");
		mntmNewMenuItem_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				AddHorse ap = new AddHorse(sys);
				ap.Start(sys);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Add Trainer To Horse");
		mntmNewMenuItem_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				AddTrainerToHorse ap = new AddTrainerToHorse(sys);
				ap.Start(sys);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Add Equestrian To Horse");
		mntmNewMenuItem_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				AddEquestrianToHorse ap = new AddEquestrianToHorse(sys);
				ap.Start(sys);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Add Horse To Competition");
		mntmNewMenuItem_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				AddHorseToCompetition ap = new AddHorseToCompetition(sys);
				ap.Start(sys);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Add Gambling Bets For Competition");
		mntmNewMenuItem_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				AddGamblingBetForCompetition ap = new AddGamblingBetForCompetition(sys);
				ap.Start(sys);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_5);
		
		JMenu mnNewMenu_1 = new JMenu("Remove");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Remove Horse");
		mntmNewMenuItem_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				RemoveHorse ap = new RemoveHorse(sys);
				ap.Start(sys);
			}
			}
		);
		mnNewMenu_1.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Remove Trainer From Horse");
		mntmNewMenuItem_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				RemoveHorseFromCompetition ap = new RemoveHorseFromCompetition(sys);
				ap.Start(sys);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_7);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Remove Equestrian From Horse");
		mntmNewMenuItem_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				RemoveEquestrianFromHorse ap = new RemoveEquestrianFromHorse(sys);
				ap.Start(sys);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_8);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Remove Veterinarian From Horse");
		mntmNewMenuItem_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				RemoveVeterinarianFromHorse ap = new RemoveVeterinarianFromHorse(sys);
				ap.Start(sys);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_9);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("Remove Horse From Competition");
		mntmNewMenuItem_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				RemoveHorseFromCompetition ap = new RemoveHorseFromCompetition(sys);
			ap.Start(sys);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_10);
		
		JMenuItem mntmNewMenuItem_11 = new JMenuItem("Remove Gambling Bets For Competition");
		mntmNewMenuItem_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				RemoveGamblingBetsForCompetition ap = new RemoveGamblingBetsForCompetition(sys);
				ap.Start(sys);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_11);
		
		JMenu mnNewMenu_3 = new JMenu("Find / Calc");
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_16 = new JMenuItem("printTop10TrainersRankedReport");
		mntmNewMenuItem_16.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				sys.printAllPersons();
				printTop10TrainersRankedReport ap = new printTop10TrainersRankedReport(sys);
				ap.main(sys);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_16);
		
		JMenuItem mntmNewMenuItem_17 = new JMenuItem("printAllPersons");
		mntmNewMenuItem_17.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				printAllPersons ap = new printAllPersons(sys);
			ap.Start(sys);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_17);
		
		JMenuItem mntmNewMenuItem_18 = new JMenuItem("printAllHorses");
		mntmNewMenuItem_18.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				printAllHorses ap = new printAllHorses(sys);
				ap.Start(sys);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_18);
	}
}
