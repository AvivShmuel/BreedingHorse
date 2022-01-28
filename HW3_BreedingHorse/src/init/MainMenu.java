package init;

import java.text.ParseException;

import GUI.Application;
import utils.mysqlConnection;

public class MainMenu {

	static mysqlConnection mysqlCon = new mysqlConnection(); 
	public static void main(String[] args) {
		BreedingHorses sys=new BreedingHorses();
		Application app=new Application(sys);
		mysqlCon.init(); // CONNECT TO MYSQL 
		sys.getdatafromdb(); // LOAD THE DATA FROM DATA BASE
		app.Start(sys);	
		}

}
