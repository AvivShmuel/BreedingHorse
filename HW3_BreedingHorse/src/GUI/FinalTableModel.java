package GUI;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import content.Trainer;
import utils.Rank;

public class FinalTableModel extends AbstractTableModel{
	 private List<Trainer> li =  new ArrayList<Trainer>();
	    private String[] columnNames = { "id", "name", "birthdate","worker id","salary","rank","Success rate","Total winner horses" };

	    public FinalTableModel(List<Trainer> list){
	         this.li = list;
	    }

	    @Override
	    public String getColumnName(int columnIndex){
	         return columnNames[columnIndex];
	    }

	    @Override     
	    public int getRowCount() {
	        return li.size();
	    }

	    @Override        
	    public int getColumnCount() {
	        return 8; 
	    }

	    @Override
	    public Object getValueAt(int rowIndex, int columnIndex) {
	    	Trainer si = li.get(rowIndex);
	        switch (columnIndex) {
	            case 0: 
	                return si.getId();
	            case 1:
	                return si.getFullName();
	            case 2:
	                return si.getBithDate();
	            case 3:
	                return si.getSerialId();
	            case 4:
	                return si.getSalary();
	            case 5:
	                return si.getRank();
	            case 6:
	                return si.getSuccessRate(); 
	            case 7:
	                return si.getTotalWinnerHorses(); 
	           }
	           return null;
	   }

	   @Override
	   public Class<?> getColumnClass(int columnIndex){
	          switch (columnIndex){
	             case 0:
	               return String.class;
	             case 1:
	               return String.class;
	             case 2:
	               return Date.class;
	             case 3:
	               return String.class;
	             case 4:
	               return Double.class;
	             case 5:
	               return Rank.class;
	             case 6:
	               return Double.class;
	             case 7:
		           return Integer.class;
		             
	             }
	          
	             return null;
	      }

}
