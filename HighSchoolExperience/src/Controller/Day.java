package Controller;

public class Day {

	int day;

	public Day() {
		day = 1;
	}
	
	public Day(int day) {
		this.day = day;
	}
	
	public void addDay() {
		day++;
	}

	public int getDay() {
		return day;
	}
	
}
