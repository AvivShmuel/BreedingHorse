package utils;

import java.util.Comparator;

import content.*;

public class HorseComparator implements Comparator<Horse> {
	
	private double weightOfWiningTimes;
	private double weightOfTotalPoints;
	private double weightOfPopularityRate;

	/** The full constructor of Horse Comparator **/
	public HorseComparator(double weightOfWiningTimes,
			double weightOfTotalPoints, double weightOfPopularityRate) {
		this.setWeightOfPopularityRate(weightOfPopularityRate);
		this.setWeightOfTotalPoints(weightOfTotalPoints);
		this.setWeightOfWiningTimes(weightOfWiningTimes);
	}

	/**
	 * The method compare to Object by Given criteria: Amount of winnings *
	 * weightOfWiningTimes + total points * weightOf TotalPoints +
	 * PopularityRate * weightOfPopularityRate
	 **/
	@Override
	public int compare(Horse o1, Horse o2) {
		Double o2Calc = o2.calculateTotalPoints()
				* this.getWeightOfTotalPoints() + o2.calculateWiningTimes()
				* this.getWeightOfWiningTimes() + o2.getPopularityRate()
				* this.getWeightOfPopularityRate();
		return o2Calc.compareTo(o1.calculateTotalPoints()
				* this.getWeightOfTotalPoints() + o1.calculateWiningTimes()
				* this.getWeightOfWiningTimes() + o1.getPopularityRate()
				* this.getWeightOfPopularityRate());
	}

	public double getWeightOfWiningTimes() {
		return weightOfWiningTimes;
	}

	public void setWeightOfWiningTimes(double weightOfWiningTimes) {
		this.weightOfWiningTimes = weightOfWiningTimes;
	}

	public double getWeightOfTotalPoints() {
		return weightOfTotalPoints;
	}

	public void setWeightOfTotalPoints(double weightOfTotalPoints) {
		this.weightOfTotalPoints = weightOfTotalPoints;
	}

	public double getWeightOfPopularityRate() {
		return weightOfPopularityRate;
	}

	public void setWeightOfPopularityRate(double weightOfPopularityRate) {
		this.weightOfPopularityRate = weightOfPopularityRate;
	}

}
