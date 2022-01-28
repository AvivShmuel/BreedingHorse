package utils;


import java.util.Date;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import content.Horse;
import content.Trainer;


/**
 * @author AvivS
 * init function connecting the project to database
 *
 */
/**
 * @author AvivS
 *
 */
public class mysqlConnection {
	static Connection conn;
	ArrayList<Trainer> trainers_list;
	ArrayList<Horse> horses_list;
    public void init(){
    	try 
		{
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            System.out.println("Driver definition succeed");
        } catch (Exception ex) {
        	/* handle the error*/
        	 System.out.println("Driver definition failed");
        	 }  
        try 
        {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/breedinghorse?serverTimezone=IST","root","password");
            System.out.println("SQL connection succeed");
        }
		catch(SQLException e){
			e.printStackTrace();
		}
        
    }
    
	/**
	 * AddTrainer - this function adding the trainer to the table on db.
	 */
	public static void AddTrainer(Trainer t)
	{
		String pattern = "MM/dd/yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String dateFormat = simpleDateFormat.format(t.getBithDate());
		Statement stmt;
		try 
		{
			stmt = conn.createStatement();
			stmt.executeUpdate("insert into Trainer values('"+t.getId() +"','"+t.getFullName()+"','"+dateFormat+"','"+t.getSerialId()+"',"+t.getSalary()+",'"+String.valueOf(t.getRank().name())+"');");
		} catch (SQLException e) {e.printStackTrace();}
	}
	/**
	 * AddHorse - this function adding the horse to the table on db.
	 */
	public static void AddHorse(Horse h) {
		
		String pattern = "MM/dd/yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String dateFormat = simpleDateFormat.format(h.getBirthDate());
		Statement stmt;
		try 
		{
			stmt = conn.createStatement();
			stmt.executeUpdate("insert into horse values('"+h.getIdentifierSerial() +"','"+h.getNickName()+"','"+dateFormat+"',"+h.getWeight()+",'"+h.getGender()+"','"+h.gethColor().toString()+ "'," + 
			 h.getPrice() +",'" + h.getGenre().name()+ "'," +h.getRevenue() + "," + h.getTotalParticipatesTimes()+ ",'');");
		} catch (SQLException e) {e.printStackTrace();}
	}
	/**
	 * AddTrainerToHorse - this function init the trainer variable on horse table database. .
	 */
	public static void AddTrainerToHorse(String hId,String tId) {
		Statement stmt;
		try 
		{ 
			stmt = conn.createStatement();
			stmt.executeUpdate("update Horse set trainer="+"'"+tId+"' WHERE horseid='" +hId+"';");
		} catch (SQLException e) {e.printStackTrace();}
	}
	
	/**
	 * PrintAllHorses - this function create string array with all the data from horse table.
	 */
	public static String [][] PrintAllHorses() {
		String data[][] = new String[20][11];
		   try 
	        {
			String query = "Select * from Horse";
			Statement st = conn.createStatement();
			ResultSet res = st.executeQuery(query);
			int i =0;
			int j=0;
			while(res.next()) {
				String horseid = res.getString("horseid");
				String nickname = res.getString("nickname");
				String birthdate = res.getString("birthdate");
				double weight = res.getDouble("weight");
				String gender = res.getString("gender");
				String color = res.getString("color");
				double price = res.getDouble("price");
				String genre = res.getString("genre");
				double revenue = res.getDouble("revenue");
				int totalparticipatetimes = res.getInt("totalparticipatetimes");
				String trainer = res.getString("trainer");
				
				data[i][j++]=horseid + "";
				data[i][j++]=nickname + "";
				data[i][j++]=birthdate + "";
				data[i][j++]=weight + "";
				data[i][j++]=gender + "";
				data[i][j++]=color + "";
				data[i][j++]=price + "";
				data[i][j++]=genre + "";
				data[i][j++]=revenue + "";
				data[i][j++]=totalparticipatetimes + "";
				data[i][j++]=trainer + "";
				i++;
				j=0;
			} 

			}
			catch(SQLException e){
				e.printStackTrace();
			}
	       return data;
		}
	/**
	 * getTrainers - get all the trainers from database
	 */
		public ArrayList<Trainer> getTrainers(){	
			trainers_list = new ArrayList<Trainer>();
			Trainer tr;
			
			Statement stmt;
			try {
				stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select * from trainer");
				while(rs.next()) {
					tr = new Trainer(rs.getString(1),rs.getString(2) , new Date(rs.getString(3)),
							rs.getString(4), rs.getDouble(5), Rank.valueOf(rs.getString(6)));
					trainers_list.add(tr);
				}
			}
			catch (SQLException e) { e.printStackTrace(); }
			return trainers_list;
		}
		/**
		 * getHorses - get all the horses from database
		 */
		public ArrayList<Horse> getHorses(){
			horses_list = new ArrayList<Horse>();
		
			Statement stmt;
			try {
				stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select * from horse");
				while(rs.next()) { 
					Horse hs = new Horse(rs.getString(1),rs.getString(2),new Date(rs.getString(3)),rs.getDouble(4),rs.getString(5).charAt(0),
							Double.valueOf(rs.getString(7)),Genre.valueOf(rs.getString(8)),Double.valueOf(rs.getString(9)),
							Integer.valueOf(rs.getString(10)));
					horses_list.add(hs);
					
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
				}
			return horses_list;
		}
}