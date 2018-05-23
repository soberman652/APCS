package Hub;

public class Day {

	int day;

	/**
	 * creates a day object
	 */
	public Day() {
		day = 1;
	}
	
	/**
	 * creates a Day object with a given day
	 * @param day
	 */
	public Day(int day) {
		this.day = day;
	}
	
	/**
	 * adds a day to the Day object
	 */
	public void addDay() {
		day++;
	}

	/**
	 * get the day
	 * @return the day
	 */
	public int getDay() {
		return day;
	}
	
	/**
	 * Checks to see if it is the first day
	 * @return whether it is the first day
	 */
	public boolean isFirstDay() {
		if(day == 1) {
			return true;
		}
		return false;
	}
}
