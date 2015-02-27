/*
 * Get a date (mon/day/year) from user. Print exact the week of dates 
 * (Sun to Sat). ex) input: 2/20/2001 if the day isWednesday 
 * output: Sunday 2/17/2001 
 * Monday 2/18/2001
 * Tuesday 2/19/2001 
 * Wednesday 2/20/2001
 * Thursday 2/21/2001 
 * Friday 2/22/2001 
 * Saturday 2/23/2001
 */

public class calendar {
	public static int[] days = {0,31,28,31,30,31,30,31,31,30,31,30,31};
	
	public static void main(String[] args) {
		doTests();
	}
	
	public static boolean isLeapYear(int year) {
		return (year % 400 == 0 || year % 4 == 0);
	}
	
	public static int numberOfDaysInMonthAndYear(int month, int year) {
		if (isLeapYear(year) && month == 2) {
			return 29;
		} else {
			return days[month];
		}
	}
	
	public static void printDay(int month, int day, int year, int whichDay) {
		String d = new String();
		switch(whichDay) {
			case 0:
				d = "Sunday";
				break;
			case 1:
				d = "Monday";
				break;
			case 2:
				d = "Tuesday";
				break;
			case 3:
				d = "Wednesday";
				break;
			case 4:
				d = "Thursday";
				break;
			case 5:
				d = "Friday";
				break;
			case 6:
				d = "Saturday";
				break;
			default:
				break;
		}
		System.out.println(d + " " + month + "/" + day + "/" + year);
	}
	
	public static void findWeek(int month, int day, int year, int whichDay) {
		for (int i = whichDay; i > 0; --i) {
			if (day == 1) {
				if (month == 1) {
					year--;
					month = 12;
					day = numberOfDaysInMonthAndYear(month, year);
				} else {
					month--;
					day = numberOfDaysInMonthAndYear(month, year);
				}
			} else {
				day--;
			}
		}
		
		for (int i = 0; i < 7; ++i) {
			printDay(month, day, year, i);
			day++;
			if (day > numberOfDaysInMonthAndYear(month, year)) {
				day = 1;
				month++;
				if (month > 12) {
					month = 1;
					year++;
				}
			}
		}
	}
	
	public static void doTests() {
		findWeek(2, 20, 2001, 3);
	}
}
