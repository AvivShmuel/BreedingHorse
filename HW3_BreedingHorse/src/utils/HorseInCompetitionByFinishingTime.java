package utils;

import java.sql.Time;
import java.util.*;

import content.*;

public class HorseInCompetitionByFinishingTime implements Comparator<HorseInCompetition>{

	/**Comparator of Competition that using Finishing time to sort
	 * Horses in Competition from the 1 to the last*/
	@Override
	public int compare(HorseInCompetition o1, HorseInCompetition o2) {
		Time o2Hic=o2.getFinishingTime();
		return o2Hic.compareTo(o1.getFinishingTime());
	}

}
