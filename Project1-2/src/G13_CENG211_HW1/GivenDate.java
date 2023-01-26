package G13_CENG211_HW1;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class GivenDate {
	private int[][] day;
	
	public static final String[] MONTHS = {"Jan", 
			"Feb", "Mar", "Apr", "May",
			"Jun", "Jul", "Aug", "Sep",
			"Oct", "Nov", "Dec"};
	
	
	public GivenDate(String issue, String returnDate) {
		String[] date1 = issue.split("-");
		String[] date2 = returnDate.split("-");
		day = new int[2][3];
		day[0][0] = Integer.parseInt(date1[0]);
		day[0][1] = getMonth(date1[1]);
		day[0][2] = Integer.parseInt("20" + date1[2]);
		day[1][0] = Integer.parseInt(date2[0]);
		day[1][1] = getMonth(date2[1]);
		day[1][2] = Integer.parseInt("20" + date2[2]);
	}
	
	public GivenDate(GivenDate original) {
		if(original == null) {
			System.out.println("Fatal error.");
			System.exit(0);
		}
		day = original.getDayCopy(); 
	}
	
	public int[][] getDayCopy() {
		int[][] temp = new int[day.length][];
		for(int row = 0; row < temp.length; row++) {
			temp[row] = new int[day[row].length];
			for(int col = 0; col < temp[row].length; col++) {
				temp[row][col] = day[row][col];
			}
		}
		return temp;
	}
	
	public int getDifference() {
		LocalDate localDate1 = LocalDate.of(day[0][2],
				day[0][1], day[0][0]);
		LocalDate localDate2 = LocalDate.of(day[1][2],
				day[1][1], day[1][0]);
		return Math.abs((int) (localDate1.toEpochDay() - localDate2.toEpochDay()));
	}
	
	private final int getMonth(String month) {
		int result = 0; 
		int index = 1;
		while(index - 1 < MONTHS.length) {
			if(month.equals(MONTHS[index - 1])) {
				result = index;
				break;
			}
			index++;
		}
		return result;
	}
}
