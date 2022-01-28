package utils;


import java.util.Comparator;

import content.Trainer;

public class TrainerComparatorBySuccessRate implements Comparator<Trainer>{
/**The Comparator for trainer that use trainers success rate
 * for sorting them descending**/
	@Override
	public int compare(Trainer o1, Trainer o2) {
		Double o2Sr=o2.getSuccessRate();
		return o2Sr.compareTo(o1.getSuccessRate());
	}

}
